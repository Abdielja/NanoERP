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

  // *** Properties ***
  
  private String name;
  private String className;
  private String methodName;
  
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

  public String getClassName()
  {
    return className;
  }

  public void setClassName(String className)
  {
    this.className = className;
  }

  public String getMethodName()
  {
    return methodName;
  }

  public void setMethodName(String methodName)
  {
    this.methodName = methodName;
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
