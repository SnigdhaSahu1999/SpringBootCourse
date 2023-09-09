package com.snigdha.aopdemo.dao;

import com.snigdha.aopdemo.Account;

public interface AccountDAO {

    //Before addition of Account class
   // void addAccount();

    //after adding AccountDAO class
    // passing Account object in parameter
    void addAccount(Account theAccount);

    boolean doWork();
}
