/**
 * 
 */
package org.nano.accounting.model;

import java.util.ArrayList;

/**
 * @author Abdiel
 *
 */
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
  
  public long getOid()
  {
    return oid;
  }

  public void setOid(long oid)
  {
    this.oid = oid;
  }

  public String getNumber()
  {
    return number;
  }

  public void setNumber(String number)
  {
    this.number = number;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }
  
  
  public int getAccType()
  {
    return accType;
  }

  public void setAccType(int accType)
  {
    this.accType = accType;
  }

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
