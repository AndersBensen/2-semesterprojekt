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
public class Case {
    private int ID;
    private CaseRequest caseReq;
    private boolean patientIsInformed;
    private String patientRepresentation;
    private String nextAppointment;
    private String guardianship;
    private String personalHelper;
    private boolean personalHelperPowerOfAttorney;
    private String citizenRights;
    private boolean citizenInformedElectronic;
    private boolean consent;
    private String consentType; // can be oral or written
    private String[] collectPatientInfo;
    private String specialCircumstances;
    private String differentCommune;
    
    
Case(int caseReq){
this.caseReq = caseReq;

}


public int getID() {
  return ID;
}


public CaseRequest getCaseReq() {
    return caseReq;
}

public Case getEditCase(){
  return this;
}

public boolean isPatientIsInformed(){
    return this.patientIsInformed;
}

public String getPatientRepresentation(){
    return this.patientRepresentation;
}


public String getNextAppointment() {
    return nextAppointment;
}

public String getGuardianship() {
    return guardianship;
}

public String getPersonalHelper() {
    return personalHelper;
}

public boolean isPersonalHelperPowerOfAttorney() {
    return personalHelperPowerOfAttorney;
}

public String getCitizenRights() {
    return citizenRights;
}

public boolean isCitizenInformedElectronic() {
    return citizenInformedElectronic;
}

public boolean hasConsent() {
    return consent;
}

public String getConsentType() {
    return consentType;
}

public String[] getCollectPatientInfo() {
    return collectPatientInfo;
}

public String getSpecialCircumstances() {
    return specialCircumstances;
}

public String getDifferentCommune() {
    return differentCommune;
}

public void setID(int ID) {
    this.ID = ID;
}

public void setCaseReq(CaseRequest caseReq) {
    this.caseReq = caseReq;
}

public void setPatientIsInformed(boolean patientIsInformed) {
    this.patientIsInformed = patientIsInformed;
}

public void setPatientRepresentation(String patientRepresentation) {
    this.patientRepresentation = patientRepresentation;
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

public void setCollectPatientInfo(String[] collectPatientInfo) {
    this.collectPatientInfo = collectPatientInfo;
}

public void setSpecialCircumstances(String specialCircumstances) {
    this.specialCircumstances = specialCircumstances;
}

public void setDifferentCommune(String differentCommune) {
    this.differentCommune = differentCommune;
}





}

