package com.reuven.svechin.winnipegmosquitoes.objects.responses;

import com.reuven.svechin.winnipegmosquitoes.enums.Sectors;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
public class ResultIndividually extends Result {
    Map<Sectors,Integer> individualSummary;

}
