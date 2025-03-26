package com.example.lazyInitialization.common;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class CricketCoach implements Coach{

    public CricketCoach(){
        System.out.println("In Constructor: " + getClass().getName() );
    }

    @Override
    public String dailyWorkout() {
        return "Cricket........";
    }
}
