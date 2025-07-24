package com.babuli.spring.basics.service;

import com.babuli.spring.basics.dao.HelloRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HelloService {

    @Autowired
    private HelloRepository helloRepository;

    @PostConstruct
    public void init() {
        log.info("HelloService: init method called : {}", this.hashCode());
    }

    public String getName(int id) {
        return helloRepository.getById(id).toString();
    }

    @PreDestroy
    public void destroy() {
        log.info("HelloService: destroy method called : {}", this.hashCode());
    }
}
