package com.example.beanlifecycle.common;

import org.springframework.stereotype.Component;

public class BadmintonCoach implements Coach{
    @Override
    public String makeWorkout() {
        return "Badminton........";
    }
}
