package com.snigdha.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all our related advices for logging

    // let's start with an @Before advice

    // pointcut expression (run this code BEFORE the declared method)
   // @Before("execution(public void addAccount()))")

     /*@Before("execution(public void com.snigdha.aopdemo.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdvice(){

        System.out.println("\n====>> Executing @Before advice on addAccount()");
    }*/

    // this pointcut expression is for
    // any method return type in com.snigdha.aopdemo.dao package with any class name, any method name with any
    // nos of parameters
    @Before("execution(* com.snigdha.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice(){

        System.out.println("\n====>> Executing @Before advice on method()");
    }

}
