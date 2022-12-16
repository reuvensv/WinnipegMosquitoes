package com.reuven.svechin.winnipegmosquitoes.objects;

import lombok.Getter;
import lombok.Setter;
import com.reuven.svechin.winnipegmosquitoes.dto.Mosquito;

import java.util.List;

@Getter
@Setter
public class Result {
    List<Mosquito> returnedData;
}
