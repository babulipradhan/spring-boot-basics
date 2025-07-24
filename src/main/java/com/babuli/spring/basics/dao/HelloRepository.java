package com.babuli.spring.basics.dao;

import com.babuli.spring.basics.entity.HelloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
public interface HelloRepository extends JpaRepository<HelloEntity, Integer> {
}
