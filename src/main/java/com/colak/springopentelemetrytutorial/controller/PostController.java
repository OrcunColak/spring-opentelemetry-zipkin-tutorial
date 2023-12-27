package com.colak.springopentelemetrytutorial.controller;

import com.colak.springopentelemetrytutorial.service.Service1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/service1")
public class PostController {

    private final Service1 service1;

    @GetMapping(path = "/method1")
    public String method1() {
        return service1.service1();
    }

    @GetMapping(path = "/method2")
    public String method2() {
        return "method2";
    }
}
