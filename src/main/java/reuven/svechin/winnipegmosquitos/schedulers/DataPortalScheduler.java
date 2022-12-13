package reuven.svechin.winnipegmosquitos.schedulers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import reuven.svechin.winnipegmosquitos.dto.DataPortal;
import reuven.svechin.winnipegmosquitos.dto.Mosquito;
import reuven.svechin.winnipegmosquitos.servers.DataPortalService;
import reuven.svechin.winnipegmosquitos.servers.DataPortalServiceImpl;
import reuven.svechin.winnipegmosquitos.servers.MosquitoesService;
import reuven.svechin.winnipegmosquitos.servers.MosquitoesServiceImpl;

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
    
    @Scheduled(fixedRate = 3000)
    public void getUpdateScheduledTask() {
        List<DataPortal> fetchedData = dataPortalService.fetchDataGreaterThanId(keepedId);
        if (CollectionUtils.isEmpty(fetchedData)) {
            log.info("Empty data");
            return;
        }
        keepedId = getLastPortalDataRecord(fetchedData).getId();
        log.info("Fetched data from Data Portal: {}", fetchedData);
        List<Mosquito> moscitoData = convertData(fetchedData);
        mosquitoesService.saveAll(moscitoData);
    }
    
    private List<Mosquito> convertData(List<DataPortal> fetchedData) {
        List<Mosquito> mosquitosData = new ArrayList<>();
        fetchedData.forEach(entity -> {
            mosquitosData.add(Mosquito.builder()
                    .trapid(entity.getTrapid())
                    .sector(entity.getLocation())
                    .mosquitoes(entity.getMosquitoes())
                    .createdAt(entity.getTimestamp())
                    .build());
        });
        return mosquitosData;
    }
    
    protected DataPortal getLastPortalDataRecord(List<DataPortal> fetchedData) {
        return fetchedData.stream().max(Comparator.comparing(DataPortal::getId)).orElseThrow(NoSuchElementException::new);
        
    }
}
