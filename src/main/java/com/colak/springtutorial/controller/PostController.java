package com.colak.springtutorial.controller;

import com.colak.springtutorial.service.Service1;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/service1")
@Slf4j
public class PostController {

    private final Service1 service1;

    // http://localhost:8080/api/v1/service1/method1
    @GetMapping(path = "/method1")
    public String method1() {
        log.info("method1 is called");
        return service1.service1();
    }

    @GetMapping(path = "/method2")
    public String method2() {
        log.info("method2 is called");
        return "method2";
    }
}
