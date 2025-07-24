package com.babuli.spring.basics.controller;

import com.babuli.spring.basics.service.HelloService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
@Slf4j
@Scope("request")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @PostConstruct
    public void init() {
        log.info("HelloController : init method called : {}", this.hashCode());
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(required = false, name = "id") int id) {
        return "Hello " + helloService.getName(id);
    }

    @PreDestroy
    public void destroy() {
        log.info("HelloController : destroy method called : {}", this.hashCode());
    }
}
