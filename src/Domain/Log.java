package Domain;

import Acquaintance.ILog;
import java.util.Date;

public class Log implements ILog {

    // Information stored in a Log
    private int employeeID;
    private LogAction action;
    private String desc;
    private Date date;

    // *******************************
    // ********* Constructors ********
    // *******************************
    public Log(int employeeID, LogAction action, String desc) {
        this.employeeID = employeeID;
        this.action = action;
        this.desc = desc;
        date = new Date();
    }

    // *******************************
    // *********   Getters   *********
    // *******************************
    @Override
    public int getEmployeeID() {
        return employeeID;
    }

    @Override
    public LogAction getAction() {
        return action;
    }

    @Override
    public String getDesc() {
        return desc;
    }

    @Override
    public Date getDate() {
        return date;
    }
    
    // *******************************
    // *********    Misc    **********
    // *******************************
    @Override
    public String toString ()
    {
        return "employeeID: " + employeeID + " action: " + action + " description: " + desc + " date: " + date;
    }

}
