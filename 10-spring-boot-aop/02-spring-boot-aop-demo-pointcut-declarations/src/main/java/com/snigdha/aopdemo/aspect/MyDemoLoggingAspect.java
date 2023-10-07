package com.snigdha.aopdemo.aspect;

import com.snigdha.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    // this is where we add all our related advices for logging

    // let's start with an @Before advice



    /* pointcut expression (run this code BEFORE the declared method)
   // @Before("execution(public void addAccount()))")

     @Before("execution(public void com.snigdha.aopdemo.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdvice(){

        System.out.println("\n====>> Executing @Before advice on addAccount()");
    }*/




    /* this pointcut expression is for
    // any method return type in com.snigdha.aopdemo.dao package with any class name, any method name with any
    // nos of parameters
    @Before("execution(* com.snigdha.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice(){

        System.out.println("\n====>> Executing @Before advice on method()");
    }*/



    // Create pointcut declaration (the below three pointcuts are declared in LuvAopExpressions class)
    // to use pointcuts from diff class we need to provide the entire path name of the method
    @Pointcut("execution(* com.snigdha.aopdemo.dao.*.*(..))")
    private void forDaoPackage(){}

   /* //Apply pointcut declaration to advice
    // Advice 1
    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n====>> Executing @Before advice on method()");
    }

    //Advice 2
    @Before("forDaoPackage()")
    public void performApiAnalytics() {
        System.out.println("\n====>> Perform API analytics");
    }*/

    // create a pointcut for getter methods
    @Pointcut("execution(* com.snigdha.aopdemo.dao.*.get*(..))")
    private void getter() {}

    // create a pointcut for setter methods
    @Pointcut("execution(* com.snigdha.aopdemo.dao.*.set*(..))")
    private void setter() {}

    // create pointcut: include package... exclude getter/setter methods
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter() {}


    // add a new advice for @AfterReturning on the findAccounts method

    @AfterReturning(
            pointcut = "execution(* com.snigdha.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturning(JoinPoint theJoinPoint, List<Account> result){

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n======>>> Executing @AfterReturning on method" + method);

        //print out the results of the method call
        System.out.println("\n=====>>> Executing @AfterReturning on method" + result);

        // let's post-process the data... let's modify it :-)

        //convert the account names to uppercase
        convertAccountNamesToUppeCase(result);
        System.out.println("\n====>>. result is: "+result);
    }

    private void convertAccountNamesToUppeCase(List<Account> result) {

        // loop through accounts
        for(Account tempAccount: result) {

            // get uppercase version of name
            String theUpperNme = tempAccount.getName().toUpperCase();

            // upadate the name on the account
            tempAccount.setName(theUpperNme);
        }
    }


    //@Before Advice
    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n====>>Executing @Before advice");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        // prints the entire method before which the advices are executed
        System.out.println("Method: "+methodSignature);

        //display method arguments

        // get args
        Object[] args = theJoinPoint.getArgs();

        //loop thru args
        for(Object tempArg : args){
            System.out.println(tempArg);

            if(tempArg instanceof Account){

                // downcast and print specific stuff
                Account theAccount = (Account) tempArg;
                System.out.println("Account name :"+ theAccount.getName());
                System.out.println("Account level :"+ theAccount.getLevel());
            }
        }
    }

    //@AfterThrowing Advice
    @AfterThrowing(
            pointcut="execution(* com.snigdha.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(
        JoinPoint theJoinPoint, Throwable theExc){

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n======>>> Executing @AfterThrowing on method " + method);

        //log the exception
        System.out.println("\n======>>> The exception is: " + theExc);
    }

    @After("execution(* com.snigdha.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint){

        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n======>>> Executing @After(finally) on method " + method);
    }

    @Around("execution(* com.snigdha.aopdemo.service.*.getFortune(..))")
    public Object aroundFortune(
            ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

        // print out method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n======>>> Executing @Around on method " + method);

        // get begin timestamp
        long begin = System.currentTimeMillis();

        //now, let's execute the method , proceed() is of ProceedingJoinPoint classd
        Object result = null;

        try{
            result = theProceedingJoinPoint.proceed();
        }
        catch (Exception exc){
            // log the exception
            System.out.println(exc.getMessage());

         /*   //give user a custom message
            result = "Major accident! But no worries, your private AOP helicopter is on the way!";*/

            // rethrow exception
            throw exc;
        }

        //get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        System.out.println("\n ===> Duration: " + duration/1000 + "seconds");

        return result;

    }




}
