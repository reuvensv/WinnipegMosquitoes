package com.reuven.svechin.winnipegmosquitoes.objects.responses;

import lombok.Getter;
import lombok.Setter;
import com.reuven.svechin.winnipegmosquitoes.dto.Mosquito;

import java.util.List;

@Getter
@Setter
public abstract class Result implements IResult {
    List<Mosquito> returnedData;
}
