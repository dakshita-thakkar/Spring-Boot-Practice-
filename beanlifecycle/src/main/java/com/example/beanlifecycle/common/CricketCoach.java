package com.example.beanlifecycle.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component

public class CricketCoach implements Coach{

    @Override
    public String makeWorkout() {
        return "Cricket...........";
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("In postConstruct of class: " + getClass().getSimpleName());
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("In preDestroy method of class: " + getClass().getSimpleName());
    }
}