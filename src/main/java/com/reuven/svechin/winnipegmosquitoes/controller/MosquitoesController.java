package com.reuven.svechin.winnipegmosquitoes.controller;

import com.reuven.svechin.winnipegmosquitoes.dto.Mosquito;
import com.reuven.svechin.winnipegmosquitoes.objects.MosquitoesRequest;
import com.reuven.svechin.winnipegmosquitoes.objects.Result;
import com.reuven.svechin.winnipegmosquitoes.servers.MosquitoesService;
import com.reuven.svechin.winnipegmosquitoes.utils.JsonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/winnipeg/city/mosquitoes")
public class MosquitoesController {
    private final MosquitoesService mosquitoesService;

    @GetMapping( )
    public ResponseEntity<Result> getByConditions (@RequestBody MosquitoesRequest request) throws ParseException {

        log.info("Get data request received: {}", request);
        Timestamp startDate = getStartDate(request.getStartDate());
        Timestamp endDate = getStopDate(request.getEndDate());

        List<Mosquito> returnedList = mosquitoesService.getData(startDate, endDate, request.getSectors());
        
        Result result = new Result();
        result.setReturnedData(returnedList);
        System.out.println(JsonUtils.toJson(result));
        return ResponseEntity.ok(result);
    }
    
    private static Timestamp getStartDate (Long timestamp) throws ParseException {
        if (timestamp != null) {
            return new Timestamp(timestamp);
        }
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse("1/1/" + getPreviousYear());
        long time = date.getTime();
        return new Timestamp(time);
    }
    
    private static Timestamp getStopDate (Long timestamp) throws ParseException {
        if (timestamp != null) {
            return new Timestamp(timestamp);
        }
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = dateFormat.parse("31/12/" + getPreviousYear());
        long time = date.getTime();
        return new Timestamp(time);
    }
    
    private static int getPreviousYear() {
        Calendar prevYear = Calendar.getInstance();
        prevYear.add(Calendar.YEAR, -1);
        return prevYear.get(Calendar.YEAR);
    }

}
