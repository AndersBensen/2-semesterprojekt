package Domain;

import java.util.Date;


public interface ICaseRequest {
    
    public int getID();
    public int getEmployeeID();
    public String getDescription();
    public boolean isMessageClear();
    public boolean isCarePackageRequested();
    public boolean isRehousingPackageRequested();
    public String getRequestCreator();
    public boolean isCitizenInformed();
    public long getPatientCPR();
    public String getPatientName();
    public char getPatientGender();
    public Date getPatientBirthdate();
    public String getPatientAddress();
    public int getPatientPhoneNr();
    public String getPatientMail();
}
