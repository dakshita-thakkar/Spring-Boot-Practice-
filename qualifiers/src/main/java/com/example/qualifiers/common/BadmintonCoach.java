package com.example.qualifiers.common;


import org.springframework.stereotype.Component;

@Component
public class BadmintonCoach implements Coach{

    @Override
    public String designWorkout() {
        return "Racket Practice for 3 hrs each day.......";
    }
}
