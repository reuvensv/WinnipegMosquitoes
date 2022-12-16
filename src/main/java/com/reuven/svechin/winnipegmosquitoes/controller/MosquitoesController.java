package com.reuven.svechin.winnipegmosquitoes.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import com.reuven.svechin.winnipegmosquitoes.dto.Mosquito;
import com.reuven.svechin.winnipegmosquitoes.enums.Sectors;
import com.reuven.svechin.winnipegmosquitoes.objects.MosquitoesRequest;
import com.reuven.svechin.winnipegmosquitoes.objects.Result;
import com.reuven.svechin.winnipegmosquitoes.servers.MosquitoesService;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.reuven.svechin.winnipegmosquitoes.enums.Sectors.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/winnipeg/city/mosquitoes")
public class MosquitoesController {
    private final MosquitoesService mosquitoesService;
    
    @GetMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Result> getByConditions (@RequestBody MosquitoesRequest request) throws ParseException {
    
        Timestamp startDate = getStartDate(request.getStartDate());
        Timestamp endDate = getStopDate(request.getStopDate());
        List<Sectors> sectors = request.getSectors() == null
                ? new ArrayList<>(Arrays.asList(NORTH_EAST, NORTH_WEST, SOUTH_EAST, SOUTH_WEST, RURAL))
                : request.getSectors();
        
        
        List<Mosquito> returnedList = mosquitoesService.findByCreatedAtGreaterThanEqualAndLessThanEqualAndSectorIn(startDate, endDate, sectors);
        
        Result result = new Result();
        result.setReturnedData(returnedList);
        return ResponseEntity.ok(result);
    }
    
    private static Timestamp getStartDate (Long timestamp) throws ParseException {
        if (timestamp != null) {
            return new Timestamp(timestamp);
        }
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse("1/1/" + String.valueOf(getPreviousYear()));
        long time = date.getTime();
        return new Timestamp(time);
    }
    
    private static Timestamp getStopDate (Long timestamp) throws ParseException {
        if (timestamp != null) {
            return new Timestamp(timestamp);
        }
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse("31/12/" + String.valueOf(getPreviousYear()));
        long time = date.getTime();
        return new Timestamp(time);
    }
    
    private static int getPreviousYear() {
        Calendar prevYear = Calendar.getInstance();
        prevYear.add(Calendar.YEAR, -1);
        return prevYear.get(Calendar.YEAR);
    }

}
