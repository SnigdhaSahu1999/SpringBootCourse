package com.snigdha.springcoredemo.config;

import com.snigdha.springcoredemo.common.Coach;
import com.snigdha.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    //creating a bean manually and giving the bean name "aquatic"
    //by default the bean name is the function name i.e. swimCoach
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
