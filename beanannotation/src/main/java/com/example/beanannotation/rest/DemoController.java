package com.example.beanannotation.rest;

import com.example.beanannotation.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


    @RestController

    public class DemoController {
        private Coach myCoach;


        @Autowired
        public DemoController(@Qualifier("aquatic")Coach myCoach){
            this.myCoach = myCoach;
        }

        @GetMapping("/getWorkout")
        public String getWorkout(){
            return myCoach.makeWorkout();

        }

        
    }

