package com.reuven.svechin.winnipegmosquitoes.objects.requests;

import com.reuven.svechin.winnipegmosquitoes.enums.Sectors;
import lombok.Getter;
import com.reuven.svechin.winnipegmosquitoes.enums.DisplaySummary;

import java.util.List;

/**
 * Represents a request to summary mosquitoes
 */
@Getter
public class MosquitoesRequest {
    
    Long startDate ;
    Long endDate;
    List<Sectors> sectors;
    DisplaySummary displaySummary;

}
