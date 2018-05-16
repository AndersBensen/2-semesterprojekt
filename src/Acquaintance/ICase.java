package Acquaintance;

import java.util.Date;

public interface ICase {

    int getID();

    int getEmployeeID();

    ICaseRequest getCaseRequest();

    String getNextAppointment();

    String getGuardianship();

    String getPersonalHelper();

    String getPersonalHelperPowerOfAttorney();

    String getCitizenRights();

    boolean isCitizenInformedElectronic();

    boolean hasConsent();

    String getConsentType();

    String[] getCollectCitizenInfo();

    String getSpecialCircumstances();

    String getDifferentCommune();
    
    Date getDateCreated();
    
    Date getDateModified();
}
