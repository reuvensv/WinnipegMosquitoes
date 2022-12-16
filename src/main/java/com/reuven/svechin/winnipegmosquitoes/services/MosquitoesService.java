package com.reuven.svechin.winnipegmosquitoes.services;

import com.reuven.svechin.winnipegmosquitoes.dto.Mosquito;
import com.reuven.svechin.winnipegmosquitoes.exception.MosquitoesException;
import com.reuven.svechin.winnipegmosquitoes.objects.responses.IResult;
import com.reuven.svechin.winnipegmosquitoes.objects.requests.MosquitoesRequest;

import java.util.List;

public interface MosquitoesService {
    List<Mosquito> saveAll(List<Mosquito> mosquitoesData) ;

    IResult proceedRequest(MosquitoesRequest request) throws MosquitoesException;
}
