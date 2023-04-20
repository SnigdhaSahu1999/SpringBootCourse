package com.snigdha.springcoredemo.rest;

import com.snigdha.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //define a private field for the dependency
    private Coach myCoach;

    //define a constructor for Dependency Injection
    @Autowired
    //@Qualifier here will help to refer BaseballCoach class
    public DemoController(@Qualifier("aquatic") Coach theCoach){
        System.out.println("In constructor: "+ getClass().getSimpleName());
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){

        return myCoach.getDailyWorkout();
    }


}
