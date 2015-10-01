/**
 * 
 */
package org.nano.ui.console;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
  }

  public void start()
  {
    
    scan = new Scanner(System.in);
 
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
          System.out.println("\nBye.");
          break;
          
        case "add entry":  
          addEntry();
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

    String strHeader  = String.format("%-10s  %-30s  %-50s  %-12s  %-12s  %-12s", "Date", "Nombre Cuenta", "Descripcion", "Debito", "Credito", "Saldo");
    System.out.println(strHeader);
    strHeader = String.format("%10s  %30s  %50s  %12s  %12s  %12s", "----------", "------------------------------", "--------------------------------------------------", "------------", "------------", "------------");
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
        strEntry   = String.format("%-10s  %-30s  %-50s  %12.2f  %12s  %12.2f", entry.getCreationDate(), entry.getAccount().getName(), entry.getDescription(), entry.getAmount(), "", saldo);
        
      }
      else
      {
        saldo += entry.getAmount();
        strEntry   = String.format("%-10s  %-30s  %-50s  %12s  %12.2f  %12.2f", entry.getCreationDate(), entry.getAccount().getName(), entry.getDescription(), "", entry.getAmount(), saldo);
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
  
  private void addEntry()
  {

    Date creationDate = new Date();
    int trxType = 0;
    Account account;
    double amount = 0;
    String description = "";
    
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    System.out.println("\n --- Type new entry information --- \n");
    
    // *** Date ***
    System.out.print("Date (dd/MM/yyyy): ");
    String strDate = scan.next();
    
    if (!strDate.isEmpty())
    {
      try
      {
        creationDate = formatter.parse(strDate);
      } 
      catch (ParseException e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
    }

    
    // *** Transaction Type ***
    System.out.print("Transaction Type (1 - Credit, 2 - Debit): ");
    trxType = scan.nextInt();
    
    // *** Account Oid ***
    System.out.print("Account Number: ");
    String accountNumber = scan.next();
    account = accountingService.getAccountByNumber(accountNumber);
    
    // *** Amount ***
    System.out.print("Amount (0.00): ");
    amount = scan.nextDouble();
    
    // *** Description ***
    System.out.print("Description: ");
    description = scan.nextLine();
    
    
    // ***** Save Entry to Database *****
    Entry newEntry = new Entry();
    newEntry.setCreationDate(creationDate);
    newEntry.setTrxType(trxType);
    newEntry.setAccount(account);
    newEntry.setAmount(amount);
    newEntry.setDescription(description);
    
    accountingService.saveEntry(newEntry);
    
    System.out.println("\nNew Entry was successfully created in the database.\n");
    
  }
}
