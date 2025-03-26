package com.example.beanscope.common;

import org.springframework.stereotype.Component;

@Component
public class BadmintonCoach implements Coach{

    @Override
    public String makeWorkout() {
        return "Badminton........";
    }
}
