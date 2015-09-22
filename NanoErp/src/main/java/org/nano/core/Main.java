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

    String strHeader  = String.format("%-30s  %-50s  %-12s  %-12s  %-12s", "Nombre Cuenta", "Descripcion", "Debito", "Credito", "Saldo");
    System.out.println(strHeader);
    strHeader = String.format("%30s  %50s  %12s  %12s  %12s", "------------------------------", "--------------------------------------------------", "------------", "------------", "------------");
    System.out.println(strHeader);
    System.out.println();

    double saldo = 0;
   
    for(int i=0; i < accountingService.getAllEntries().size(); i++)
    {
      
      Entry entry = accountingService.getAllEntries().get(i);
      String strEntry = "";
      
      if (entry.getTrxType() == Entry.TYPE_DEBIT)
      {
        saldo -= entry.getAmount();
        strEntry   = String.format("%-30s  %-50s  %12.2f  %12s  %12.2f", entry.getAccount().getName(), entry.getDescription(), entry.getAmount(), "", saldo);
        
      }
      else
      {
        saldo += entry.getAmount();
        strEntry   = String.format("%-30s  %-50s  %12s  %12.2f  %12.2f", entry.getAccount().getName(), entry.getDescription(), "", entry.getAmount(), saldo);
      }
      
      System.out.println(strEntry);
      
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
