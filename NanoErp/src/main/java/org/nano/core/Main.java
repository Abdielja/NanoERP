/**
 * 
 */

package org.nano.core;

import org.nano.accounting.service.AccountingService;
import org.nano.ui.console.Console;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Abdiel Jaramillo Ojedis
 *
 */
public class Main
{

  private ApplicationContext context;  
  private Console console;
  
  // *** Application Entry Point ***
  
  /**
   * @param args
   */
  public static void main(String[] args)
  {
    new Main();
  }

  // *** Constructors ***
  
  public Main()
  {
    context = loadContext();
    AccountingService accountingService = getAccountingService();           
    console = new Console(accountingService);
    console.start();
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
