package com.example.lazyInitialization.common;


import org.springframework.stereotype.Component;

@Component
public class BadmintonCoach implements Coach{

    public BadmintonCoach(){
        System.out.println("In Constructor: " + getClass().getName() );
    }
    @Override
    public String dailyWorkout() {
        return "Badminton........";
    }
}
