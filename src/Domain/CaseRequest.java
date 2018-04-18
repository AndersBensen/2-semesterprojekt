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
    private String requestCreator;
    private boolean CitizenInformed;
    //PatientAttributes
    private final long patientCPR;
    private String patientName;
    private char patientGender;
    private Date patientBirthdate;
    private String patientAddress;
    private int patientPhoneNr;
    private String patientMail;
    
    CaseRequest(int ID, int employeeID, long patientCPR) {
        this.ID = ID;
        this.employeeID = employeeID;
        this.patientCPR = patientCPR;
    }

    public void connectPatient(long CPR, String name, char gender, Date birthdate, String address) {
        if(CPR == this.patientCPR) {
        this.patientName = name;
        this.patientGender = gender;
        this.patientBirthdate = birthdate;
        this.patientAddress = address;    
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

    public void setRequestCreator(String requestCreator) {
        this.requestCreator = requestCreator;
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
    public String getRequestCreator() {
        return requestCreator;
    }

    @Override
    public boolean isCitizenInformed() {
        return CitizenInformed;
    }

    @Override
    public long getPatientCPR() {
        return patientCPR;
    }

    @Override
    public String getPatientName() {
        return patientName;
    }

    @Override
    public char getPatientGender() {
        return patientGender;
    }

    @Override
    public Date getPatientBirthdate() {
        return patientBirthdate;
    }

    @Override
    public String getPatientAddress() {
        return patientAddress;
    }

    @Override
    public int getPatientPhoneNr() {
        return patientPhoneNr;
    }

    @Override
    public String getPatientMail() {
        return patientMail;
    }
}