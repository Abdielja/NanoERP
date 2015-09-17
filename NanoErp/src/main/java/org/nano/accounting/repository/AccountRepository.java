/**
 * 
 */
package org.nano.accounting.repository;

import java.util.ArrayList;

import org.nano.accounting.model.Account;

/**
 * @author Abdiel Jaramilo Ojedis
 *
 */
public class AccountRepository implements IAccountRepository
{

  private ArrayList<Account> accounts;
  
    
  public AccountRepository()
  {
    
  }
  
  public AccountRepository(String fileName)
  {
    loadAccountsFromXML(fileName);
  }
  

  
  @Override
  public ArrayList<Account> getAllAccounts()
  {
    return accounts;
  }
  
  @Override
  public long createAccount(Account account)
  {
    accounts.add(account);
    return 0;
  }
  
  @Override
  public Account getAccount(String number)
  {
    return null;
  }
  
  
  
  private void loadAccountsFromXML(String fileName)
  {
    accounts = new ArrayList<Account>();

  }
  
}
