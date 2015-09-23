/**
 * 
 */
package org.nano.ui.console;

import java.util.ArrayList;

/**
 * @author Abdiel Jaramillo
 *
 */
public class Command
{

  private String name;
  private ArrayList<CommandParameter> parameters = new ArrayList<CommandParameter>();
  
  // *** Get/Set Methods ***
  
  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public ArrayList<CommandParameter> getParameters()
  {
    return parameters;
  }

  public void setParameters(ArrayList<CommandParameter> parameters)
  {
    this.parameters = parameters;
  }

  // *** Class methods definitions ***
  
  public void execute()
  {
  }

}
