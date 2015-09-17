/**
 * 
 */
package org.nano.accounting.repository;

import java.util.ArrayList;
import java.util.Date;

import org.nano.accounting.model.Entry;

/**
 * @author Abdiel Jaramillo Ojedis 
 *
 */
public class EntryRepository implements IEntryRepository
{

  private ArrayList<Entry> entries;

    
  public EntryRepository()
  {
    
  }
  
  public EntryRepository(String fileName)
  {
    loadEntriesFromXML(fileName);
  }
 

  private void loadEntriesFromXML(String fileName)
  {
    entries = new ArrayList<Entry>();    
  }
  
  
  @Override
  public ArrayList<Entry> getAllEntries()
  {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public long createEntry(Entry entry)
  {
    entries.add(entry);
    return 0;
  }

  @Override
  public ArrayList<Entry> getEntriesByDateRange(Date fromDate, Date toDate)
  {
    // TODO Auto-generated method stub
    return null;
  }
     

}
