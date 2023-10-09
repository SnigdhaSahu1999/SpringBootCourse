package com.snigdha.aopdemo.dao;

import com.snigdha.aopdemo.Account;

import java.util.List;

public interface AccountDAO {

    //Before addition of Account class
    // void addAccount();

    //after adding AccountDAO class
    // passing Account object in parameter
    void addAccount(Account theAccount);

    //add a new method: findAccounts(List<Account> findAccounts(boolean tripWire);)
    List<Account> findAccounts();

    List<Account> findAccounts(boolean tripWire);

    boolean doWork();

    public String getName();

    public void setName(String name);

    public String getServiceCode();

    public void setServiceCode(String serviceCode);


}
