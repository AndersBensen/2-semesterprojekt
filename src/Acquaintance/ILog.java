package Acquaintance;

import Domain.LogAction;
import java.util.Date;

public interface ILog {

    public int getEmployeeID();

    public LogAction getAction();

    public String getDesc();

    public Date getDate();
}
