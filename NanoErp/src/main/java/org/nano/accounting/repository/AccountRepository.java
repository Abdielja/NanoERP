/**
 * 
 */
package org.nano.accounting.repository;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.nano.accounting.model.Account;

/**
 * @author Abdiel Jaramilo Ojedis
 *
 */
public class AccountRepository implements IAccountRepository
{

  // ********** properties **********
  
  private SessionFactory sessionFactory;
	  

  public void setSessionFactory(SessionFactory sessionFactory) 
  {
    this.sessionFactory = sessionFactory;
  } 

  private Session currentSession() 
  {
    return sessionFactory.getCurrentSession();
  }

  
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
  	Query query = currentSession().createQuery("FROM Account");
      
    @SuppressWarnings("unchecked")
  	ArrayList<Account> accounts = (ArrayList<Account>)query.list();

    return accounts;
  }
  
  @Override
  public long createAccount(Account account)
  {
    return 0;
  }
  
  @Override
  public Account getAccount(String number)
  {

    Account account = null;
    
    Query query = currentSession().createQuery("FROM Account WHERE number = '" + number + "'");
    @SuppressWarnings("unchecked")
    ArrayList<Account> accounts = (ArrayList<Account>)query.list();

    if (accounts.size() > 0)
    {
      account = accounts.get(0);
    }
    
    return account;
    
  }
  
  private void loadAccountsFromXML(String fileName)
  {
            
  }
  
}
