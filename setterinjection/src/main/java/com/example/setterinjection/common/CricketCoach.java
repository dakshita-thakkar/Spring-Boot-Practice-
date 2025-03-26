package com.example.setterinjection.common;


import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    @Override
    public String getWorkout() {
        return "Just Do It.";
    }
}
