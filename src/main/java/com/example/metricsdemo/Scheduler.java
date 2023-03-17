package com.example.metricsdemo;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Component
public class Scheduler {

    private final AtomicInteger testGauge;

    private final Counter testCounter;

    public Scheduler(MeterRegistry meterRegistry) {
        // Counter vs. gauge, summary vs. histogram
        // https://prometheus.io/docs/practices/instrumentation/#counter-vs-gauge-summary-vs-histogram
        testGauge = meterRegistry.gauge("custom_gauge", new AtomicInteger(0));
        testCounter = meterRegistry.counter("custom_counter");
    }

    @Scheduled(fixedRateString = "1000", initialDelayString = "0")
    public void schedulingTask() {
        testGauge.set(getRandomNumberInRange(0, 100));
        testCounter.increment();
    }

    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        int number = new Random().nextInt((max - min) + 1) + min;
        log.info("Got {} number", number);

        return number;
    }
}
