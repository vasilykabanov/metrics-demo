package com.example.metricsdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Controller {

    @GetMapping("test_1")
    public ResponseEntity<?> test1() {
        log.debug("Start test1 processing");
        return ResponseEntity.ok().body("response_1");
    }

    @GetMapping("test_2")
    public ResponseEntity<?> test2() throws InterruptedException {
        log.debug("Start test2 processing");
        Thread.sleep(2000);
        return ResponseEntity.ok().body("response_2");
    }
}
