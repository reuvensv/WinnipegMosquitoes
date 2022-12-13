package reuven.svechin.winnipegmosquitos.schedulers;

import org.junit.jupiter.api.Test;
import reuven.svechin.winnipegmosquitos.dto.DataPortal;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataPortalSchedulerTest {
    
    @Test
    void getLastPortalDataRecord() throws Exception {
        DataPortal dp1 = DataPortal.builder()
                .id(1)
                .trapid("trap1")
                .location("SOUTH")
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();
        List<DataPortal> dataportal = Arrays.asList(dp1);
        
        DataPortal maxId = dataportal.stream().max(Comparator.comparing(DataPortal :: getId))
                .orElseThrow(Exception::new);
        assertEquals(dp1, maxId);
        
    }
}