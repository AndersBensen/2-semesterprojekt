package Acquaintance;

import java.util.Date;

public interface ICaseRequest {

    public int getID();

    public int getEmployeeID();

    public String getDescription();

    public boolean isMessageClear();

    public boolean isCarePackageRequested();

    public boolean isRehousingPackageRequested();

    public String getRequestPerson();

    public boolean isCitizenInformed();

    public long getCitizenCPR();

    public String getCitizenName();

    public char getCitizenGender();

    public String getCitizenBirthdate();

    public String getCitizenAddress();

    public Integer getCitizenPhoneNr();

    public String getCitizenMail();
    
    Date getDateCreated();
    
    Date getDateModified();
}
