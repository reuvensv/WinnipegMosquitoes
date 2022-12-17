package com.reuven.svechin.winnipegmosquitoes.controller;

import com.reuven.svechin.winnipegmosquitoes.exception.MosquitoesException;
import com.reuven.svechin.winnipegmosquitoes.objects.responses.IResult;
import com.reuven.svechin.winnipegmosquitoes.objects.requests.MosquitoesRequest;
import com.reuven.svechin.winnipegmosquitoes.services.MosquitoesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/winnipeg/city/mosquitoes")
public class MosquitoesController {
    private final MosquitoesService mosquitoesService;

    /**
     * An API endpoint to get mosquitoes summary
     */
    @GetMapping()
    public ResponseEntity<IResult> getByConditions(@RequestBody MosquitoesRequest request) throws MosquitoesException {

        log.info("Get data request received: {}", request);
        return ResponseEntity.ok(mosquitoesService.proceedRequest(request));
    }
}
