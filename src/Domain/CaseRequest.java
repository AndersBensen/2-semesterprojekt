package Domain;

import Acquaintance.ICaseRequest;
import java.util.Date;

public class CaseRequest implements ICaseRequest {

    //CaseAttributes
    private int ID;
    private int employeeID;
    private String description;
    private boolean MessageClear;
    private boolean CarePackageRequested;
    private boolean RehousingPackageRequested;
    private String requestPerson;
    private boolean CitizenInformed;
    private Date dateCreated;
    private Date dateModified;
    //CitizenAttributes
    private String citizenCPR;
    private String citizenName;
    private char citizenGender;
    private String citizenBirthdate;
    private String citizenAddress;
    private Integer citizenPhoneNr;
    private String citizenMail;

    public CaseRequest(int ID, int employeeID, String citizenCPR) {
        this(ID, employeeID, citizenCPR, new Date(), new Date());
    }

    public CaseRequest(int ID, int employeeID, String citizenCPR, Date dateCreated, Date dateModified)
    {
        this.ID = ID;
        this.employeeID = employeeID;
        this.citizenCPR = citizenCPR;
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
    public String getDescription() {
        return description;
    }

    @Override
    public boolean isMessageClear() {
        return MessageClear;
    }

    @Override
    public boolean isCarePackageRequested() {
        return CarePackageRequested;
    }

    @Override
    public boolean isRehousingPackageRequested() {
        return RehousingPackageRequested;
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
    public String getCitizenCPR() {
        return citizenCPR;
    }

    @Override
    public String getCitizenName() {
        return citizenName;
    }

    @Override
    public char getCitizenGender() {
        return citizenGender;
    }

    @Override
    public String getCitizenBirthdate() {
        return citizenBirthdate;
    }

    @Override
    public String getCitizenAddress() {
        return citizenAddress;
    }

    @Override
    public Integer getCitizenPhoneNr() {
        return citizenPhoneNr;
    }

    @Override
    public String getCitizenMail() {
        return citizenMail;
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

    public void setCarePackageRequested(boolean CarePackageRequested) {
        this.CarePackageRequested = CarePackageRequested;
        updateDateModified();
    }

    public void setRehousingPackageRequested(boolean RehousingPackageRequested) {
        this.RehousingPackageRequested = RehousingPackageRequested;
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

    public void connectCitizen(String CPR, String name, char gender, String birthdate, String address) {
        if (CPR.equalsIgnoreCase(this.citizenCPR)) {
            this.citizenName = name;
            this.citizenGender = gender;
            this.citizenBirthdate = birthdate;
            this.citizenAddress = address;
            updateDateModified();
        }
    }

    public void setCitizenPhoneNr(Integer number) {
        this.citizenPhoneNr = number;
        updateDateModified();
    }

    public void setCitizenMail(String mail) {
        this.citizenMail = mail;
        updateDateModified();
    }
    
    private void updateDateModified ()
    {
        dateModified = new Date();
    }
}
