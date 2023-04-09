package com.snigdha.springcoredemo.common;

import com.snigdha.springcoredemo.common.Coach;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component //marks the class as a Spring bean and makes it available for Dependency Injection
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout(){
        return "Practice fast bowling for 15 minutes!";
    }
}
