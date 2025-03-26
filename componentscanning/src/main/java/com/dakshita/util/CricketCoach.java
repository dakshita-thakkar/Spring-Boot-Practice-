package com.dakshita.util;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    @Override
    public String getWorkout() {
        return "I recommend you to push beyond your limits";
    }
}
