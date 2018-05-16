package Domain;

import Acquaintance.ILog;
import java.util.Date;

public class Log implements ILog {

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
