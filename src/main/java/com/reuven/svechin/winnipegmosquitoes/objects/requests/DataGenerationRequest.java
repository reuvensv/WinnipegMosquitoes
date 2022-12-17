package com.reuven.svechin.winnipegmosquitoes.objects.requests;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * Data generation request
 */
@Getter
@Setter
public class DataGenerationRequest {
    private Timestamp startDate;
    private Timestamp endDate;
    private int records;
}
