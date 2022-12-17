package com.reuven.svechin.winnipegmosquitoes.objects.responses;

import com.reuven.svechin.winnipegmosquitoes.enums.Sectors;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * The class represents data to display if "INDIVIDUALLY" option chosen.
 */
@Setter
@Getter
public class ResultIndividually extends Result {
    Map<Sectors,Integer> individualSummary;

}
