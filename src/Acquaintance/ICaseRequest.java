package Acquaintance;

import java.util.Date;

public interface ICaseRequest {

    public int getID();

    public int getEmployeeID();
    
    public IPerson getCitizen();
    
    public String getDescription();

    public boolean isMessageClear();

    public boolean isCarePackageRequested();

    public boolean isRehousingPackageRequested();

    public String getRequestPerson();

    public boolean isCitizenInformed();
    
    Date getDateCreated();
    
    Date getDateModified();
}
