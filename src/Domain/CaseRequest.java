package Domain;


import java.util.Date;


public class CaseRequest implements ICaseRequest {
    //CaseAttributes
    private final int ID;
    private final int employeeID;
    private String description;
    private boolean MessageClear;
    private boolean CarePackageRequested;
    private boolean RehousingPackageRequested;
    private String requestPerson;
    private boolean CitizenInformed;
    //CitizenAttributes
    private final long citizenCPR;
    private String citizenName;
    private char citizenGender;
    private String citizenBirthdate;
    private String citizenAddress;
    private int citizenPhoneNr;
    private String citizenMail;
    
    CaseRequest(int ID, int employeeID, long citizenCPR) {
        this.ID = ID;
        this.employeeID = employeeID;
        this.citizenCPR = citizenCPR;
    }

    public void connectCitizen(long CPR, String name, char gender, String birthdate, String address) {
        if(CPR == this.citizenCPR) {
        this.citizenName = name;
        this.citizenGender = gender;
        this.citizenBirthdate = birthdate;
        this.citizenAddress = address;    
        }
    }
    
    //Setter methods
    public void setDescription(String description) {
        this.description = description;
    }

    public void setMessageClear(boolean MessageClear) {
        this.MessageClear = MessageClear;
    }

    public void setCarePackageRequested(boolean CarePackageRequested) {
        this.CarePackageRequested = CarePackageRequested;
    }

    public void setRehousingPackageRequested(boolean RehousingPackageRequested) {
        this.RehousingPackageRequested = RehousingPackageRequested;
    }

    public void setRequestPerson(String requestPerson) {
        this.requestPerson = requestPerson;
    }

    public void setCitizenInformed(boolean CitizenInformed) {
        this.CitizenInformed = CitizenInformed;
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
    public long getCitizenCPR() {
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
    public int getCitizenPhoneNr() {
        return citizenPhoneNr;
    }

    @Override
    public String getCitizenMail() {
        return citizenMail;
    }
}