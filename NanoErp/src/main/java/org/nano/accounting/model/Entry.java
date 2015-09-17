package org.nano.accounting.model;

import java.util.Date;

public class Entry
{

  /*
   * Constants
   */
  public static final int TYPE_CREDIT = 1;
  public static final int TYPE_DEBIT = 2;
  
  /*
   * Properties
   */
  private long oid;
  private Date creationDate;
  private int trxType;
  private Account account;
  private double amount;
  private String description;
  
  /*
   * Getters and Setters
   */
  public long getOid()
  {
    return oid;
  }
  
  public void setOid(long oid)
  {
    this.oid = oid;
  }

  public Date getCreationDate()
  {
    return creationDate;
  }

  public void setCreationDate(Date creationDate)
  {
    this.creationDate = creationDate;
  }

  public int getTrxType()
  {
    return trxType;
  }

  public void setTrxType(int trxType)
  {
    this.trxType = trxType;
  }

  public Account getAccount()
  {
    return account;
  }

  public void setAccount(Account account)
  {
    this.account = account;
  }

  public double getAmount()
  {
    return amount;
  }

  public void setAmount(double amount)
  {
    this.amount = amount;
  }
  
  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  /*
   * Constructors
   */
  
  public Entry()
  {
    
  }
  
  public Entry(Date creationDate, int trxType, Account account, double amount)
  {
    this.creationDate = creationDate;
    this.trxType = trxType;
    this.account = account;
    this.amount = amount;
  }
  
}
