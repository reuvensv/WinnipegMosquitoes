package com.reuven.svechin.winnipegmosquitoes.objects;

import lombok.Setter;
import com.reuven.svechin.winnipegmosquitoes.dto.Mosquito;

import java.util.List;

@Setter
public class Result {
    List<Mosquito> returnedData;
}
