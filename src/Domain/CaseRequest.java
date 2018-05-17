package Domain;

import Acquaintance.ICaseRequest;
import java.util.Date;

public class CaseRequest implements ICaseRequest {

    //CaseAttributes
    private int ID;
    private int employeeID;
    private Person citizen;
    private String description;
    private boolean MessageClear;
    private String[] carePackageRequested;
    private String rehousingPackageRequested;
    private String requestPerson;
    private boolean CitizenInformed;
    private Date dateCreated;
    private Date dateModified;
    
    public CaseRequest(int ID, int employeeID, Person citizen) {
        this(ID, employeeID, citizen, new Date(), new Date());
    }

    public CaseRequest(int ID, int employeeID, Person citizen, Date dateCreated, Date dateModified)
    {
        this.ID = ID;
        this.employeeID = employeeID;
        this.citizen = citizen;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
    }

    //Getter methods
    @Override
    public int getID() {
        return ID;
    }

    @Override
    public int getEmployeeID() {
        return employeeID;
    }
    
    @Override
    public Person getCitizen()
    {
        return citizen;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean isMessageClear() {
        return MessageClear;
    }

    @Override
    public String[] getCarePackageRequested() {
        return carePackageRequested;
    }

    @Override
    public String getRehousingPackageRequested() {
        return rehousingPackageRequested;
    }

    @Override
    public String getRequestPerson() {
        return requestPerson;
    }

    @Override
    public boolean isCitizenInformed() {
        return CitizenInformed;
    }

    @Override
    public Date getDateCreated()
    {
        return dateCreated;
    }

    @Override
    public Date getDateModified()
    {
        return dateModified;
    }
    
    //Setter methods
    public void setDescription(String description) {
        this.description = description;
        updateDateModified();
    }

    public void setMessageClear(boolean MessageClear) {
        this.MessageClear = MessageClear;
        updateDateModified();
    }

    public void setCarePackageRequested(String[] carePackageRequested) {
        this.carePackageRequested = carePackageRequested;
        updateDateModified();
    }

    public void setRehousingPackageRequested(String rehousingPackageRequested) {
        this.rehousingPackageRequested = rehousingPackageRequested;
        updateDateModified();
    }

    public void setRequestPerson(String requestPerson) {
        this.requestPerson = requestPerson;
        updateDateModified();
    }

    public void setCitizenInformed(boolean CitizenInformed) {
        this.CitizenInformed = CitizenInformed;
        updateDateModified();
    }
    
    public void setCitizenPhoneNr(Integer number) {
        this.citizen.setPhoneNumber(number);
        updateDateModified();
    }

    public void setCitizenMail(String mail) {
        this.citizen.setMail(mail);
        updateDateModified();
    }
    
    private void updateDateModified ()
    {
        dateModified = new Date();
    }
}
