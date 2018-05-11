/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

/**
 *
 * @author vlocn
 */
public interface ICase {

    int getID();
    
    int getEmployeeID();

    int getCaseRequestID();

    String getCitizenRights();

    String[] getCollectCitizenInfo();

    String getConsentType();

    String getDifferentCommune();

    String getGuardianship();

    String getNextAppointment();

    String getPersonalHelper();

    String getSpecialCircumstances();
    
    boolean hasConsent();
    
    boolean isCitizenInformedElectronic();
    
    String getPersonalHelperPowerOfAttorney();
}
