package com.reuven.svechin.winnipegmosquitoes.controller;

import com.reuven.svechin.winnipegmosquitoes.objects.requests.DataGenerationRequest;
import com.reuven.svechin.winnipegmosquitoes.services.RandomDataGenerationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/winnipeg/city/generator")
public class DataGeneratorController {
    private final RandomDataGenerationService randomDataGenerationService;

    /**
     * An API Endpoint to generate a public data
     */
    @PutMapping
    public ResponseEntity<String> getByConditions(@RequestBody DataGenerationRequest request) {
        randomDataGenerationService.proceedDataGenerationRequest(request);
        return ResponseEntity.ok("OK");
    }
}
