/**
 * 
 */
package org.nano.accounting.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;

import org.nano.accounting.model.Entry;

/**
 * @author Abdiel Jaramillo Ojedis 
 *
 */
public class EntryRepository implements IEntryRepository
{

  // ********** properties **********
  
  private SessionFactory sessionFactory;
		  
  public void setSessionFactory(SessionFactory sessionFactory) 
  {
    this.sessionFactory = sessionFactory;
  } 
    
  private Session currentSession() 
  {
    return sessionFactory.getCurrentSession();
  }

    
  public EntryRepository()
  {
    
  }
  
  public EntryRepository(String fileName)
  {
    loadEntriesFromXML(fileName);
  }
 

  private void loadEntriesFromXML(String fileName)
  {
  }
  
  
  @Override
  public ArrayList<Entry> getAllEntries()
  {

	Query query = currentSession().createQuery("FROM Entry");
    
    @SuppressWarnings("unchecked")
	ArrayList<Entry> entries = (ArrayList<Entry>)query.list();

    return entries;
  }

  public ArrayList<Entry> getByUserOidWithinDateRange(long userOid, Date startDate, Date endDate)
  {
    
    Query query = currentSession().createQuery("FROM Entry WHERE creationDate >= :startDate AND creationDate <= :endDate");
    
    query.setParameter("startDate", startDate);
    query.setParameter("endDate", endDate);
    
    @SuppressWarnings("unchecked")
	ArrayList<Entry> entries = (ArrayList<Entry>)query.list();

    return entries;
  }
  
  @Override
  public long createEntry(Entry entry)
  {
    //entries.add(entry);
    return 0;
  }

  @Override
  public ArrayList<Entry> getEntriesByDateRange(Date fromDate, Date toDate)
  {
    // TODO Auto-generated method stub
    return null;
  }

@Override
public void save(Entry entry) {
	// TODO Auto-generated method stub
	
}
     

}
