/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Acquaintance.ILog;
import java.util.Date;

/**
 *
 * @author ander
 */
public class Log implements ILog{
    private int employeeID;
    private LogAction action;
    private String desc;
    private Date date;
   
    public Log(int employeeID, LogAction action, String desc) {
        this.employeeID = employeeID;
        this.action = action;
        this.desc = desc;
        date = new Date();
    }
    
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
    
}
