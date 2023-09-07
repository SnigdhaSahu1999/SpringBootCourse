package com.snigdha.aopdemo;

import com.snigdha.aopdemo.dao.AccountDAO;
import com.snigdha.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO){

		//default method of CommandLineRunner
		return runner -> {

			demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		Account myAccount = new Account();
		// call the business method
		theAccountDAO.addAccount(myAccount);
		theAccountDAO.doWork();

		// call the membership business method
		theMembershipDAO.addSillyMembers();
		theMembershipDAO.goToSleep();

	}

}
