package com.reuven.svechin.winnipegmosquitoes.objects.responses;

import com.reuven.svechin.winnipegmosquitoes.enums.Sectors;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
public class ResultBoth extends Result {

    private Map<Sectors, Integer> individualSummary;
    private int total;
}
