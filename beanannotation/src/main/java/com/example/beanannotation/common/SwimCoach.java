package com.example.beanannotation.common;

public class SwimCoach implements Coach{
    @Override
    public String makeWorkout() {
        return "Swimming.........";
    }

    public SwimCoach(){
        System.out.println("In Constructor" + getClass().getSimpleName() );
    }


}
