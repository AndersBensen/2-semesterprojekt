/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author Peter
 */
public class Case implements ICase {   // Mangler at logge

    private int ID;
    private int caseRequestID;
    private String nextAppointment;
    private String guardianship;
    private String personalHelper;
    private String personalHelperPowerOfAttorney;
    private String citizenRights;
    private boolean citizenInformedElectronic;
    private boolean consent;
    private String consentType; // can be oral or written
    private String collectCitizenInfo;
    private String specialCircumstances;
    private String differentCommune;

    public Case(int caseID, int caseRequestID) {
        this.ID = caseID;
        this.caseRequestID = caseRequestID;

    }
    
    //Getter methods
    @Override
    public int getID() {
        return ID;
    }

    @Override
    public int getCaseRequestID() {
        return caseRequestID;

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
    public String getCollectCitizenInfo() {
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
    public void setCaseRequestID(int caseRequestID) {
        this.caseRequestID = caseRequestID;
    }

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

    public void setCollectCitizenInfo(String collectCitizenInfo) {
        this.collectCitizenInfo = collectCitizenInfo;
    }

    public void setSpecialCircumstances(String specialCircumstances) {
        this.specialCircumstances = specialCircumstances;
    }

    public void setDifferentCommune(String differentCommune) {
        this.differentCommune = differentCommune;
    }
}
