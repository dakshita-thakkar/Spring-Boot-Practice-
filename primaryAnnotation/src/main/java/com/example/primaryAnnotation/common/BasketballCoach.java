package com.example.primaryAnnotation.common;


import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements Coach{

    @Override
    public String dailyWorkout() {
        return "Basketball......";
    }
}
