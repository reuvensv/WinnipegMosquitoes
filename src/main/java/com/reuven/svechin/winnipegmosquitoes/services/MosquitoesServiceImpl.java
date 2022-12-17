package com.reuven.svechin.winnipegmosquitoes.services;

import com.reuven.svechin.winnipegmosquitoes.dto.Mosquito;
import com.reuven.svechin.winnipegmosquitoes.enums.Sectors;
import com.reuven.svechin.winnipegmosquitoes.exception.MosquitoesException;
import com.reuven.svechin.winnipegmosquitoes.objects.responses.IResult;
import com.reuven.svechin.winnipegmosquitoes.objects.requests.MosquitoesRequest;
import com.reuven.svechin.winnipegmosquitoes.objects.responses.ResultBoth;
import com.reuven.svechin.winnipegmosquitoes.objects.responses.ResultCollectively;
import com.reuven.svechin.winnipegmosquitoes.objects.responses.ResultIndividually;
import com.reuven.svechin.winnipegmosquitoes.repo.MosquitoesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MosquitoesServiceImpl implements MosquitoesService {
    private final MosquitoesRepository mosquitoesRepository;


    /**
     * {@link MosquitoesService#saveAll(List)}
     */
    public List<Mosquito> saveAll(List<Mosquito> mosquitoesData) {
        return mosquitoesRepository.saveAll(mosquitoesData);
    }

    /**
     * {@link MosquitoesService#proceedRequest(MosquitoesRequest)}
     */
    @Override
    public IResult proceedRequest(MosquitoesRequest request) throws MosquitoesException {
        try {
            Timestamp startDate = getStartDate(request.getStartDate());
            Timestamp endDate = getStopDate(request.getEndDate());
            List<Sectors> sectors = request.getSectors();

            // According to the requested behaviour, in case the sectors is not specified, we should get data for ALL sectors.
            List<Sectors> sectorsToQuery = CollectionUtils.isEmpty(sectors) ? Arrays.asList(Sectors.values()) : sectors;
            List<Mosquito> mosquitoesData = mosquitoesRepository.findByCreatedAtGreaterThanEqualAndCreatedAtLessThanEqualAndSectorIn(startDate, endDate, sectorsToQuery);

            switch (request.getDisplaySummary()) {
                case INDIVIDUALLY:
                    return getResultsIndividually(mosquitoesData);
                case COLLECTIVELY:
                    return getResultsCollectively(mosquitoesData);
                case BOTH:
                    return getResultsBoth(mosquitoesData);
                default:
                    log.error("Unknown DisplaySummary type");
                    throw new UnsupportedOperationException("Unknown DisplaySummary type");
            }
        } catch (ParseException e) {
            log.error("ParseException: Unable to parse dates");
            throw new MosquitoesException("Internal Error in parsing dates");
        }

    }

    private static Timestamp getStartDate(Long timestamp) throws ParseException {
        if (timestamp != null) {
            return new Timestamp(timestamp);
        }

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse("1/1/" + getPreviousYear());
        long time = date.getTime();
        return new Timestamp(time);
    }

    private static Timestamp getStopDate(Long timestamp) throws ParseException {
        if (timestamp != null) {
            return new Timestamp(timestamp);
        }

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse("31/12/" + getPreviousYear());
        long time = date.getTime();
        return new Timestamp(time);
    }

    private static int getPreviousYear() {
        Calendar prevYear = Calendar.getInstance();
        prevYear.add(Calendar.YEAR, -1);
        return prevYear.get(Calendar.YEAR);
    }

    private IResult getResultsBoth(List<Mosquito> mosquitoesData) {
        ResultBoth result = new ResultBoth();
        result.setReturnedData(mosquitoesData);
        result.setIndividualSummary(getIndividualSummary(mosquitoesData));
        result.setTotal(getCollectivelySummary(mosquitoesData));
        return result;
    }

    private IResult getResultsIndividually(List<Mosquito> mosquitoesData) {
        ResultIndividually result = new ResultIndividually();
        result.setReturnedData(mosquitoesData);
        result.setIndividualSummary(getIndividualSummary(mosquitoesData));
        return result;
    }


    private IResult getResultsCollectively(List<Mosquito> mosquitoesData) {
        ResultCollectively result = new ResultCollectively();
        result.setReturnedData(mosquitoesData);
        result.setTotal(getCollectivelySummary(mosquitoesData));
        return result;
    }

    private int getCollectivelySummary(List<Mosquito> mosquitoesData) {
        return mosquitoesData.stream().mapToInt(Mosquito::getMosquitoes).sum();
    }

    private Map<Sectors, Integer> getIndividualSummary(List<Mosquito> mosquitoesData) {
        return mosquitoesData
                .stream()
                .collect(Collectors.groupingBy(Mosquito::getSector, Collectors.summingInt(Mosquito::getMosquitoes)));
    }
}
