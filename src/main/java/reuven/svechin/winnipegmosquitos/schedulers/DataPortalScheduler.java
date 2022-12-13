package reuven.svechin.winnipegmosquitos.schedulers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import reuven.svechin.winnipegmosquitos.dto.DataPortalDto;
import reuven.svechin.winnipegmosquitos.servers.DataPortalServiceImpl;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class DataPortalScheduler {
    private final DataPortalServiceImpl dataPortalService ;
    @Scheduled( fixedRate = 3000)
    public void getUpdateScheduledTask (){
        List<DataPortalDto> fetchedData = dataPortalService.fetchData();
       log.info("Fetched data from Data Portal: {}", fetchedData);
    }
}
