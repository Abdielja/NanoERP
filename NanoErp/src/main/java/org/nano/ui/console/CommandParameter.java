/**
 * 
 */
package org.nano.ui.console;


/**
 * @author Abdiel Jaramillo
 *
 */
public class CommandParameter
{

  public final static int TYPE_STRING   = 1;
  public final static int TYPE_INTEGER  = 2;
  public final static int TYPE_DOUBLE   = 3;
  public final static int TYPE_DATE     = 4;

  
  private String name;
  private int type;
  
  // *** Get/Set Methods ***
  
  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  
  public int getType()
  {
    return type;
  }

  public void setType(int type)
  {
    this.type = type;
  }

  /**
   * 
   */
  public CommandParameter()
  {
    // TODO Auto-generated constructor stub
  }

  public CommandParameter(String name, int type)
  {
    this.name = name;
    this.type  = type;
  }

}
