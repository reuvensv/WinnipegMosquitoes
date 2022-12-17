package com.reuven.svechin.winnipegmosquitoes.services;

import com.reuven.svechin.winnipegmosquitoes.dto.Mosquito;
import com.reuven.svechin.winnipegmosquitoes.exception.MosquitoesException;
import com.reuven.svechin.winnipegmosquitoes.objects.responses.IResult;
import com.reuven.svechin.winnipegmosquitoes.objects.requests.MosquitoesRequest;

import java.util.List;

public interface MosquitoesService {
    /**
     * Save all data received from public data portal to local DB.
     * @param mosquitoesData mosquitoes data
     * @return saved data.
     */
    List<Mosquito> saveAll(List<Mosquito> mosquitoesData) ;

    /**
     * Handles summary request
     * @param request Mosquitoes Summary request
     * @return response to a client
     * @throws MosquitoesException general exception in case of failure.
     */
    IResult proceedRequest(MosquitoesRequest request) throws MosquitoesException;
}
