/**
 * 
 */
package org.nano.accounting.service;

import java.util.ArrayList;

import org.nano.accounting.model.Account;
import org.nano.accounting.model.Entry;
import org.nano.accounting.repository.IAccountRepository;
import org.nano.accounting.repository.IEntryRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Abdiel
 *
 */
public class AccountingService
{

  private IAccountRepository accountRepository;
  private IEntryRepository entryRepository;
  
  public void setAccountRepository(IAccountRepository accountRepository)
  {
    this.accountRepository = accountRepository;
  }
  
  public void setEntryRepository(IEntryRepository entryRepository)
  {
    this.entryRepository = entryRepository;
  }
  
  
  
  @Transactional
  public long createAccount(Account account)
  {
    return accountRepository.createAccount(account);
  }

  @Transactional
  public ArrayList<Account> getAllAccounts()
  {
    return accountRepository.getAllAccounts();
  }
    
  @Transactional
  public ArrayList<Entry> getAllEntries()
  {
    return entryRepository.getAllEntries();
  }
    
}
