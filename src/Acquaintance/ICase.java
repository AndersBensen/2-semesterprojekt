package Acquaintance;

public interface ICase {

    int getID();

    int getEmployeeID();

    ICaseRequest getCaseRequest();

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
