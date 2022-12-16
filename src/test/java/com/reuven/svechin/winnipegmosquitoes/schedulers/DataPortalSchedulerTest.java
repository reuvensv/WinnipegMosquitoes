package com.reuven.svechin.winnipegmosquitoes.schedulers;

import com.reuven.svechin.winnipegmosquitoes.enums.Sectors;
import org.junit.jupiter.api.Test;
import com.reuven.svechin.winnipegmosquitoes.dto.DataPortal;

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
                .location(Sectors.NORTH_WEST)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build();
        List<DataPortal> dataportal = Arrays.asList(dp1);
        
        DataPortal maxId = dataportal.stream().max(Comparator.comparing(DataPortal :: getId))
                .orElseThrow(Exception::new);
        assertEquals(dp1, maxId);
        
    }
}