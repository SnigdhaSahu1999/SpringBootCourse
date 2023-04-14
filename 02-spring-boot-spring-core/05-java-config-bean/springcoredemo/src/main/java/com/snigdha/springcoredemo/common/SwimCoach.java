package com.snigdha.springcoredemo.common;

import org.springframework.stereotype.Component;


//We will not use @Component here
public class SwimCoach implements Coach {

    public SwimCoach(){
        System.out.println("In constructor: "+ getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout(){
        return "Swim 1000 metres qa a warm up";
    }
}
