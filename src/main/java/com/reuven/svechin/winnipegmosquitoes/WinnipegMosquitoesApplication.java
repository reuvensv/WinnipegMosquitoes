package com.reuven.svechin.winnipegmosquitoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication ()

@EnableScheduling
public class WinnipegMosquitoesApplication {

    public static void main(String[] args) {
        SpringApplication.run(WinnipegMosquitoesApplication.class, args);
        System.out.println("UP");
    }

}
