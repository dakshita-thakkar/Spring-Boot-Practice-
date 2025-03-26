package com.example.beanlifecycle.common;

import org.springframework.stereotype.Component;

@Component
public class HockeyCoach implements Coach{
    @Override
    public String makeWorkout() {
        return "Hockey.......";
    }
}
