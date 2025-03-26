package com.example.constructorinjection;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "I say you should bat & ball for at least 5 hrs in a day";
    }
}
