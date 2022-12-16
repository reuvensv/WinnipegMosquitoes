package com.reuven.svechin.winnipegmosquitoes.services;

import com.reuven.svechin.winnipegmosquitoes.dto.DataPortal;
import com.reuven.svechin.winnipegmosquitoes.enums.Sectors;
import com.reuven.svechin.winnipegmosquitoes.exception.MosquitoesException;
import com.reuven.svechin.winnipegmosquitoes.objects.requests.DataGenerationRequest;
import com.reuven.svechin.winnipegmosquitoes.repo.DataPortalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RandomDataGenerationService {
    private final DataPortalRepository dataPortalRepository;

    private static final Random RANDOM = new Random();

    public void proceedDataGenerationRequest(DataGenerationRequest request) throws MosquitoesException {

        int records = request.getRecords();


        List<DataPortal> data = new ArrayList<>();
        for (int i = 0; i <= records; i++) {

            DataPortal record = DataPortal.builder()
                    .location(Sectors.randomSector())
                    .trapid(UUID.randomUUID().toString())
                    .mosquitoes(generateRandomMosquitoesNumber())
                    .timestamp(generateRundomTimestamp(request.getStartDate(), request.getEntDate()))
                    .build();
            data.add(record);
            if (i % 200 == 0) {
                dataPortalRepository.saveAll(data);
                data = new ArrayList<>();
            }
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
