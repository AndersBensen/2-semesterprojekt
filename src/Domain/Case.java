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
    private boolean citizenIsInformed;
    private String citizenRepresentation;
    private String nextAppointment;
    private String guardianship;
    private String personalHelper;
    private boolean personalHelperPowerOfAttorney;
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
//getters

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public int getCaseRequestID() {
        return caseRequestID;

    }

    @Override
    public boolean isCitizenIsInformed() {
        return this.citizenIsInformed;
    }

    @Override
    public String getCitizenRepresentation() {
        return this.citizenRepresentation;
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

    public boolean isPersonalHelperPowerOfAttorney() {
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
//setters

    public void setCaseRequestID(int caseRequestID) {
        this.caseRequestID = caseRequestID;
    }

    public void setCitizenIsInformed(boolean citizenIsInformed) {
        this.citizenIsInformed = citizenIsInformed;
    }

    public void setCitizenRepresentation(String citizenRepresentation) {
        this.citizenRepresentation = citizenRepresentation;
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

    public void setPersonalHelperPowerOfAttorney(boolean personalHelperPowerOfAttorney) {
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
