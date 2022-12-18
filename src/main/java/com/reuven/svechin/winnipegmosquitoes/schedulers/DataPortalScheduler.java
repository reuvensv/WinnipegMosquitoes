package com.reuven.svechin.winnipegmosquitoes.schedulers;

import com.reuven.svechin.winnipegmosquitoes.dto.DataPortal;
import com.reuven.svechin.winnipegmosquitoes.dto.Mosquito;
import com.reuven.svechin.winnipegmosquitoes.exception.MosquitoesException;
import com.reuven.svechin.winnipegmosquitoes.services.DataPortalService;
import com.reuven.svechin.winnipegmosquitoes.services.MosquitoesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
@RequiredArgsConstructor
public class DataPortalScheduler {
    private final DataPortalService dataPortalService;
    private final MosquitoesService mosquitoesService;
    private long keepedId = 0;
    private static final File file = new File("counter.mosquito");

    /**
     * Scheduled task to get mosquitoes info from public data
     */
    @Scheduled(fixedRate = 1000 * 60 * 3) // every 3 minutes.
    public void getUpdateScheduledTask() throws MosquitoesException {
        List<DataPortal> fetchedData = null;
        try {
            fetchedData = dataPortalService.fetchDataGreaterThanId(getCounter());

            if (CollectionUtils.isEmpty(fetchedData)) {
                log.info("Empty data");
                return;
            }
            setCounter(getLastPortalDataRecord(fetchedData).getId());
            log.info("Fetched data from Data Portal: {}", fetchedData);
            List<Mosquito> mosquitoesData = convertData(fetchedData);
            mosquitoesService.saveAll(mosquitoesData);
        } catch (IOException e) {
            log.error("IO Exception threw");
            throw new MosquitoesException("Unable to parse counter.");
        }
    }

    private List<Mosquito> convertData(List<DataPortal> fetchedData) {
        List<Mosquito> mosquitosData = new ArrayList<>();
        fetchedData.forEach(entity -> mosquitosData.add(Mosquito.builder()
                .trapid(entity.getTrapid())
                .sector(entity.getLocation())
                .mosquitoes(entity.getMosquitoes())
                .createdAt(entity.getTimestamp())
                .build()));
        return mosquitosData;
    }

    private DataPortal getLastPortalDataRecord(List<DataPortal> fetchedData) {
        return fetchedData.stream().max(Comparator.comparing(DataPortal::getId)).orElseThrow(NoSuchElementException::new);
    }

    private long getCounter() throws IOException {
        if(!Files.exists(Paths.get(file.getAbsolutePath()))) {
            FileUtils.touch(file);
            long counter = 0;
            setCounter(counter);
            return counter;
        }
        String str = FileUtils.readFileToString(file);
        return Long.parseLong(str);
    }

    private void setCounter(long counter) throws IOException {
        FileUtils.writeStringToFile(file, String.valueOf(counter));
    }
}
