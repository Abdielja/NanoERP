/**
 * 
 */
package org.nano.ui.console;

import java.util.ArrayList;
import java.util.Scanner;

import org.nano.accounting.model.Account;
import org.nano.accounting.model.Entry;
import org.nano.accounting.service.AccountingService;

/**
 * @author Abdiel Jaramillo
 *
 */
public class Console
{

  AccountingService accountingService;
  Scanner scan;
  
  public Console(AccountingService accountingService)
  {
    this.accountingService = accountingService;
    
    start();
    
  }

  private void start()
  {
    
    Scanner scan = new Scanner(System.in);
 
    boolean quit = false;
    
    while(!quit)
    {
      
      printToConsole("");
      
      String command = scan.nextLine();
      
      switch(command.toLowerCase())
      {
      
        case "print chart of accounts":
          printChartOfAccounts();
          break;
      
        case "print general ledger":
          printGeneralLedger();
          break;
        
        case "quit":
          quit = true;
          System.out.println("Bye.");
          break;
          
        default:
          printToConsole("Invalid Command: " + command);     
          break;
      }
    }
    
    scan.close();
    
  
  }
  
  private void printToConsole(String text)
  {
    if(text.isEmpty())
    {
      System.out.print("NanoERP>");
    }
    else
    {
      System.out.println("NanoERP>" + text);
    }
    
  }
  
  private void printGeneralLedger()
  {
    
    System.out.println("\n----- General Ledger -----\n");

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

    System.out.println();
  }

  private void printChartOfAccounts()
  {
    
    System.out.println("\n----- Chart of Accounts -----\n");
    for(int i=0; i < accountingService.getAllAccounts().size(); i++)
    {
      Account acc = accountingService.getAllAccounts().get(i);
      System.out.println("Account: " + acc.getNumber() + " - " + acc.getName());
    }
  
    System.out.println();
 }
  
}
