package com.example.qualifiers.common;


import org.springframework.stereotype.Component;

@Component
public class ShootingCoach implements Coach{

    @Override
    public String designWorkout() {
        return "10m range practice with rifle for 1 hr every day......";
    }
}
