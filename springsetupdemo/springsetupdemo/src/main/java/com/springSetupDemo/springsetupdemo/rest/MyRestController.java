package com.springSetupDemo.springsetupdemo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
    @GetMapping("/")
    public String sayHello(){
        return "Helllooooo This is my First Spring Boot Application.........";
    }

    @GetMapping("/workout")
    public String workout(){
        return "Congratulations on running 5kms!!!!!!";
    }

//    Accessing the values from Application.properties
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/teamInfo")
    private String getTeamInfo(){
        return "Team: " + teamName + " " + "Coach: "+ coachName;
    }
}
