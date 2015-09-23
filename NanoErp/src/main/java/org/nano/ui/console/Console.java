/**
 * 
 */
package org.nano.ui.console;

import java.util.ArrayList;

/**
 * @author Abdiel Jaramillo
 *
 */
public class Console
{

  ArrayList<Command> commands = new ArrayList<Command>();
  
  /**
   * 
   */
  public Console()
  {
    
    loadCommands();
  }

  private void loadCommands()
  {
    
    Command cmdPrintGL = new Command();
    cmdPrintGL.setName("Print GL");
    cmdPrintGL.getParameters().add(new CommandParameter("From", CommandParameter.TYPE_DATE));
    cmdPrintGL.getParameters().add(new CommandParameter("To", CommandParameter.TYPE_DATE));
  }
  
}
