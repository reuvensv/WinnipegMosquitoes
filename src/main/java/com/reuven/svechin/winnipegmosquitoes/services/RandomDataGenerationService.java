package com.reuven.svechin.winnipegmosquitoes.services;

import com.reuven.svechin.winnipegmosquitoes.dto.DataPortal;
import com.reuven.svechin.winnipegmosquitoes.enums.Sectors;
import com.reuven.svechin.winnipegmosquitoes.objects.requests.DataGenerationRequest;
import com.reuven.svechin.winnipegmosquitoes.repo.DataPortalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Service to generate random mosquitoes data
 */
@Service
@RequiredArgsConstructor
public class RandomDataGenerationService {
    private final DataPortalRepository dataPortalRepository;

    private static final Random RANDOM = new Random();

    /**
     * Handles request to generate data
     * @param request data generation request.
     */
    public void proceedDataGenerationRequest(DataGenerationRequest request) {

        int records = request.getRecords();


        List<DataPortal> data = new ArrayList<>();
        for (int i = 0; i <= records; i++) {

            DataPortal record = DataPortal.builder()
                    .location(Sectors.randomSector())
                    .trapid(UUID.randomUUID().toString())
                    .mosquitoes(generateRandomMosquitoesNumber())
                    .timestamp(generateRundomTimestamp(request.getStartDate(), request.getEndDate()))
                    .build();
            data.add(record);
            dataPortalRepository.saveAll(data);
        }
    }

    private Timestamp generateRundomTimestamp(Timestamp startDate, Timestamp endDate) {
        long startDateLong = startDate.getTime();
        long endDataLong = endDate.getTime();
        return new Timestamp(startDateLong + (long) (Math.random() * (endDataLong - startDateLong)));

    }

    private int generateRandomMosquitoesNumber() {
        return RANDOM.nextInt(100 - 1) + 1;
    }


}
