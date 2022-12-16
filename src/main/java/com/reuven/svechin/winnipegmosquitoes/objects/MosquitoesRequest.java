package com.reuven.svechin.winnipegmosquitoes.objects;

import com.reuven.svechin.winnipegmosquitoes.enums.Sectors;
import lombok.Getter;
import com.reuven.svechin.winnipegmosquitoes.enums.DisplaySummary;

import java.util.List;
@Getter
public class MosquitoesRequest {
    
    Long startDate ;
    Long endDate;
    List<Sectors> sectors;
    DisplaySummary displaySummary;

}
