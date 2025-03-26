package com.example.qualifiers.rest;

import com.example.qualifiers.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;

    @Autowired
    DemoController(@Qualifier("badmintonCoach") Coach myCoach){
        this.myCoach=myCoach;
    }

    @GetMapping("/getDesignedWorkout")
    public String getDesignedWorkout(){
        return myCoach.designWorkout();
    }
}
