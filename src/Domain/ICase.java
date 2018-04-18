/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author vlocn
 */
public interface ICase {

    CaseRequest getCaseReq();

    String getCitizenRights();

    String[] getCollectPatientInfo();

    String getConsentType();

    String getDifferentCommune();

    String getGuardianship();

    int getID();

    String getNextAppointment();

    String getPatientRepresentation();

    String getPersonalHelper();

    String getSpecialCircumstances();
    
}
