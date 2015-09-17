package org.nano.accounting.repository;

import java.util.ArrayList;

import org.nano.accounting.model.Account;

public interface IAccountRepository
{

  public ArrayList<Account> getAllAccounts();
  
  public long createAccount(Account account);
  
  public Account getAccount(String number);
  
  
  
}
