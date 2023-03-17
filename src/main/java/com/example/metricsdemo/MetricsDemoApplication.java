package com.example.metricsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MetricsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MetricsDemoApplication.class, args);
    }

}
