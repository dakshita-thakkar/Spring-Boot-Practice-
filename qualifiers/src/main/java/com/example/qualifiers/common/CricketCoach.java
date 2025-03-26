package com.example.qualifiers.common;


import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{


    @Override
    public String designWorkout() {
        return "Cricket Net practice 5 hrs each day....";
    }
}
