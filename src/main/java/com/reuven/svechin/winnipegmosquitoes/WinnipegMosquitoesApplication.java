package com.reuven.svechin.winnipegmosquitoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication ()

@ComponentScan(basePackages ={
        "com.reuven.svechin.winnipegmosquitoes"
})
@EnableScheduling
public class WinnipegMosquitoesApplication {

    public static void main(String[] args) {
        SpringApplication.run(WinnipegMosquitoesApplication.class, args);
        System.out.println("UP");
    }

}
