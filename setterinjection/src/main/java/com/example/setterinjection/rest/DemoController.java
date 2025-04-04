package com.example.setterinjection.rest;


import com.example.setterinjection.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;

    @Autowired
    public void setMyCoach(Coach theCoach){
        this.myCoach = theCoach;
    }

    @GetMapping("/getWorkout")
    public String getWorkout(){
        return myCoach.getWorkout();
    }
}
