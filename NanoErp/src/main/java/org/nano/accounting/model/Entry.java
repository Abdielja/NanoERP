package org.nano.accounting.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="entry")
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

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="oid")
  public long getOid()
  {
    return oid;
  }
  
  public void setOid(long oid)
  {
    this.oid = oid;
  }

  @Column(name="creation_date")
  public Date getCreationDate()
  {
    return creationDate;
  }

  public void setCreationDate(Date creationDate)
  {
    this.creationDate = creationDate;
  }

  @Column(name="entry_type")
  public int getTrxType()
  {
    return trxType;
  }

  public void setTrxType(int trxType)
  {
    this.trxType = trxType;
  }

  @ManyToOne
  @JoinColumn(name = "account_oid")
  public Account getAccount()
  {
    return account;
  }

  public void setAccount(Account account)
  {
    this.account = account;
  }

  @Column(name="amount")
  public double getAmount()
  {
    return amount;
  }

  public void setAmount(double amount)
  {
    this.amount = amount;
  }
  
  @Column(name="description")
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
  
  public Entry(Date creationDate, int trxType, Account account, double amount, String description)
  {
    this.creationDate = creationDate;
    this.trxType = trxType;
    this.account = account;
    this.amount = amount;
    this.description = description;
  }
  
}
