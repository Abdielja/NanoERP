/**
 * 
 */

package org.nano.core;

import org.nano.accounting.model.Account;
import org.nano.accounting.model.Entry;
import org.nano.accounting.service.AccountingService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Abdiel Jaramillo Ojedis
 *
 */
public class Main
{

  private ApplicationContext context;
  
  /**
   * @param args
   */
  public static void main(String[] args)
  {
    Main app = new Main();
  }

  public Main()
  {
    
    context = loadContext();
    AccountingService accountingService = getAccountingService();           
    
    System.out.println("\n----- Accounts -----\n");
    for(int i=0; i < accountingService.getAllAccounts().size(); i++)
    {
      Account acc = accountingService.getAllAccounts().get(i);
      System.out.println("Account: " + acc.getNumber() + " - " + acc.getName());
    }
   
    System.out.println("\n----- Entries -----\n");
    for(int i=0; i < accountingService.getAllEntries().size(); i++)
    {
      Entry entry = accountingService.getAllEntries().get(i);
      System.out.println("Entry: " + entry.getAccount().getName() + " - " + entry.getTrxType() + " " + entry.getAmount() + " " + entry.getDescription());
    }
   
  }
  
  public ApplicationContext loadContext()
  {
    ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"database-context.xml"});
    return context;
  }

  public AccountingService getAccountingService()
  {
    return (AccountingService) context.getBean("accountingService", AccountingService.class);
  }
  
}
