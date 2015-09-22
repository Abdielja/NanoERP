/**
 * 
 */
package org.nano.accounting.repository;

import java.util.ArrayList;
import java.util.Date;

import org.nano.accounting.model.Account;
import org.nano.accounting.model.Entry;

/**
 * @author Abdiel
 *
 */
public interface IEntryRepository
{

  public ArrayList<Entry> getAllEntries();
  
  public long createEntry(Entry transaction);
  
  public ArrayList<Entry> getEntriesByDateRange(Date fromDate, Date toDate);
  
  public void save(Entry entry);
}
