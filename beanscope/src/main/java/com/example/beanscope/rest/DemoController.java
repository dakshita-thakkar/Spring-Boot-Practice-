package com.example.beanscope.rest;

import com.example.beanscope.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DemoController {
    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    public DemoController(@Qualifier("cricketCoach")Coach myCoach,
                          @Qualifier("cricketCoach")Coach anotherCoach){
        this.myCoach = myCoach;
        this.anotherCoach = anotherCoach;
    }

    @GetMapping("/getWorkout")
    public String getWorkout(){
        return myCoach.makeWorkout();

    }

    @GetMapping("/check")
        public String checkScope(){
            return "Comparing Beans: myCoach==anotherCoach: " + (myCoach==anotherCoach);
        }

}
