package Domain;

import Acquaintance.ICase;
import Acquaintance.ICaseRequest;
import java.util.Arrays;

public class Case implements ICase {   // Mangler at logge

    private int ID;
    private int employeeID;
    private CaseRequest caseRequest;
    private String nextAppointment;
    private String guardianship;
    private String personalHelper;
    private String personalHelperPowerOfAttorney;
    private String citizenRights;
    private boolean citizenInformedElectronic;
    private boolean consent;
    private String consentType; // can be oral or written
    private String[] collectCitizenInfo;
    private String specialCircumstances;
    private String differentCommune;

    public Case(int caseID, int employeeID, CaseRequest caseRequest) {
        this.ID = caseID;
        this.employeeID = employeeID;

        if (caseRequest == null) {
            throw new IllegalArgumentException("Cannot create a Case without a CaseRequest!");
        }

        this.caseRequest = caseRequest;

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
    public ICaseRequest getCaseRequest() {
        return caseRequest;

    }

    @Override
    public String getNextAppointment() {
        return nextAppointment;
    }

    @Override
    public String getGuardianship() {
        return guardianship;
    }

    @Override
    public String getPersonalHelper() {
        return personalHelper;
    }

    @Override
    public String getPersonalHelperPowerOfAttorney() {
        return personalHelperPowerOfAttorney;
    }

    @Override
    public String getCitizenRights() {
        return citizenRights;
    }

    @Override
    public boolean isCitizenInformedElectronic() {
        return citizenInformedElectronic;
    }

    @Override
    public boolean hasConsent() {
        return consent;
    }

    @Override
    public String getConsentType() {
        return consentType;
    }

    @Override
    public String[] getCollectCitizenInfo() {
        return collectCitizenInfo;
    }

    @Override
    public String getSpecialCircumstances() {
        return specialCircumstances;
    }

    @Override
    public String getDifferentCommune() {
        return differentCommune;
    }

    //Setter methods
    public void setNextAppointment(String nextAppointment) {
        this.nextAppointment = nextAppointment;
    }

    public void setGuardianship(String guardianship) {
        this.guardianship = guardianship;
    }

    public void setPersonalHelper(String personalHelper) {
        this.personalHelper = personalHelper;
    }

    public void setPersonalHelperPowerOfAttorney(String personalHelperPowerOfAttorney) {
        this.personalHelperPowerOfAttorney = personalHelperPowerOfAttorney;
    }

    public void setCitizenRights(String citizenRights) {
        this.citizenRights = citizenRights;
    }

    public void setCitizenInformedElectronic(boolean citizenInformedElectronic) {
        this.citizenInformedElectronic = citizenInformedElectronic;
    }

    public void setConsent(boolean consent) {
        this.consent = consent;
    }

    public void setConsentType(String consentType) {
        this.consentType = consentType;
    }

    public void setCollectCitizenInfo(String[] collectCitizenInfo) {
        this.collectCitizenInfo = collectCitizenInfo;
    }

    public void setSpecialCircumstances(String specialCircumstances) {
        this.specialCircumstances = specialCircumstances;
    }

    public void setDifferentCommune(String differentCommune) {
        this.differentCommune = differentCommune;
    }

    @Override
    public String toString() {
        return "ID: " + ID + "\nEmployeeID: " + employeeID + "\nCase request ID: " + caseRequest.getID() + "\n1. Next Appointment: "
                + nextAppointment + "\n2. Guardianship: " + guardianship + "\n3. Personal helper: "
                + personalHelper + "\n4. PHPOA: " + personalHelperPowerOfAttorney + "\n5. Citizen rights: "
                + citizenRights + "\n6. Citizen informed electronic: " + citizenInformedElectronic
                + "\n7. Consent: " + consent + "\n8. Consent type: " + consentType + "\n9. Collect citizen info: "
                + Arrays.toString(collectCitizenInfo) + "\n10. Special circumstances: " + specialCircumstances
                + "\n11. Different commune: " + differentCommune;
    }
}
