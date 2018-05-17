package Acquaintance;

import java.util.Date;

public interface ICaseRequest {

    public int getID();

    public int getEmployeeID();
    
    public IPerson getCitizen();
    
    public String getDescription();

    public boolean isMessageClear();

    public String[] getCarePackageRequested();

    public String getRehousingPackageRequested();

    public String getRequestPerson();

    public boolean isCitizenInformed();
    
    Date getDateCreated();
    
    Date getDateModified();
}
