package com.reuven.svechin.winnipegmosquitoes.servers;

import com.reuven.svechin.winnipegmosquitoes.dto.Mosquito;
import com.reuven.svechin.winnipegmosquitoes.enums.Sectors;
import com.reuven.svechin.winnipegmosquitoes.repo.MosquitoesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MosquitoesServiceImpl implements MosquitoesService{
    private final MosquitoesRepository mosquitoesRepository;

    
    public List<Mosquito> saveAll(List<Mosquito> mosquitoesData) {
        return mosquitoesRepository.saveAll(mosquitoesData);
    }
    
    @Override
    public List<Mosquito> getData(Timestamp startDate, Timestamp endDate, List<Sectors> sectors) {

        // According to the requested behaviour, in case the sectors is not specified, we should get data for ALL sectors.
        List<Sectors> sectorsToQuery = CollectionUtils.isEmpty(sectors) ? Arrays.asList(Sectors.values()) : sectors;

        return mosquitoesRepository.findByCreatedAtGreaterThanEqualAndCreatedAtLessThanEqualAndSectorIn(startDate,endDate,sectorsToQuery);
    }
    
}
