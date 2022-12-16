package com.reuven.svechin.winnipegmosquitoes.objects.requests;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class DataGenerationRequest {
    Timestamp startDate;
    Timestamp entDate;
    int records;
}
