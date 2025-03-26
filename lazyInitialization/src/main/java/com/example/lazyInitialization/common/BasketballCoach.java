package com.example.lazyInitialization.common;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BasketballCoach implements Coach{

    public BasketballCoach(){
        System.out.println("In Constructor: " + getClass().getName() );
    }

    @Override
    public String dailyWorkout() {
        return "Basketball......";
    }
}
