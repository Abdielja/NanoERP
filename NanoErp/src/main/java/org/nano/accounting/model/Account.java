/**
 * 
 */
package org.nano.accounting.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Abdiel Jaramillo
 *
 */

@Entity
@Table(name="account")
public class Account
{

  /*
   * Constants
   */
  public static final int TYPE_ASSET = 1;
  public static final int TYPE_LIABILITY = 2;
  public static final int TYPE_EQUITY = 3;
  public static final int TYPE_REVENUE = 4;
  public static final int TYPE_EXPENSE = 5;
  
  /*
   * Properties
   */
  private long oid;
  private String number;
  private String name;
  private int accType;
  

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

  @Column(name="number")
  public String getNumber()
  {
    return number;
  }

  public void setNumber(String number)
  {
    this.number = number;
  }

  @Column(name="name")
  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }
  
  
  @Column(name="acc_type")
  public int getAccType()
  {
    return accType;
  }

  public void setAccType(int accType)
  {
    this.accType = accType;
  }


  /*
   * Constructors
   */

  public Account()
  {
    
  }
  
  public Account(String number, int accType, String name)
  {
    this.number = number;
    this.name = name;
    this.accType = accType;
  }
  
}
