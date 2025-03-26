package com.example.lazyInitialization.rest;

import com.example.lazyInitialization.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;

    @Autowired
    public DemoController(@Qualifier("badmintonCoach") Coach myCoach){
        this.myCoach = myCoach;

    }

    @GetMapping("/getWorkout")
    public String getWorkout(){
        return myCoach.dailyWorkout();
    }
}
