package Persistence;

import Acquaintance.IWriter;
import Acquaintance.ICase;
import Acquaintance.ICaseRequest;
import Acquaintance.IEmployee;
import Acquaintance.ILog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteTXT implements IWriter {

    private File logFile = new File("log.txt");
    private File employeeFile = new File("Employees.txt");
    private File caseFile = new File("Cases.txt");
    private File caseRequestsFile = new File("CaseRequests.txt");
    private File currentIDs = new File("IDfile.txt");

    /*
    *Writes information to a log file.
    *The information logged is employee, action, description and a date
    *for when changes were made.
     */
    @Override
    public void writeLog(ILog log) {
        String employeeID = Integer.toString(log.getEmployeeID());
        String action = log.getAction().toString();
        String desc = log.getDesc();
        String date = log.getDate().toString();

        StringBuilder sb = new StringBuilder();
        sb.append(employeeID);
        sb.append(";");
        sb.append(action);
        sb.append(";");
        sb.append(desc);
        sb.append(";");
        sb.append(date);

        PrintWriter outputStream = null;
        try {
            //outputStream = new PrintWriter(fileName);
            outputStream = new PrintWriter(new FileOutputStream(logFile, true));
        } catch (FileNotFoundException e) {
            System.out.println("Error loading the file: " + logFile);
            System.exit(0);
        }
        outputStream.println("\n" + sb);
        outputStream.close();
        System.out.println("log was written to: " + logFile);
    }

    /*
    * Writes an employee to a employee file.
    * Stores all the relevant information about an employee.
    * cpr, name gender, date, address, phonenumber, mail, id, username, password
    * @param employee, position
    * @return employee id
     */
    @Override
    public int writeEmployee(IEmployee employee, int position) {
        String cpr = employee.getCpr();
        String name = employee.getName();
        String gender = Character.toString(employee.getGender());
        String date = employee.getBirthDate();
        String address = employee.getAddress();
        String phoneNumber = employee.getPhoneNumber() == null ? "-1" : Integer.toString(employee.getPhoneNumber());
        String mail = employee.getMail();
        String id = Integer.toString(employee.getId());
        String userName = employee.getUserName();
        String password = employee.getPassWord();

        StringBuilder sb = new StringBuilder();
        sb.append(cpr);
        sb.append(";");
        sb.append(name);
        sb.append(";");
        sb.append(gender);
        sb.append(";");
        sb.append(date);
        sb.append(";");
        sb.append(address);
        sb.append(";");
        sb.append(phoneNumber);
        sb.append(";");
        sb.append(mail);
        sb.append(";");
        sb.append(id);
        sb.append(";");
        sb.append(userName);
        sb.append(";");
        sb.append(password);
        sb.append(";");
        sb.append(Integer.toString(position));

        PrintWriter outputStream = null;
        try {
            //outputStream = new PrintWriter(fileName);
            outputStream = new PrintWriter(new FileOutputStream(employeeFile, true));
        } catch (FileNotFoundException e) {
            System.out.println("Error loading the file: " + employeeFile);
            System.exit(0);
        }
        outputStream.println("\n" + sb);
        outputStream.close();
        System.out.println("employee was written to: " + employeeFile);
        return employee.getId();
    }

    /*
    * Deletes an employee to a employee file.
    * removes all the information about an employee.
    * cpr, name gender, date, address, phonenumber, mail, id, username, password
    * @param id
     */
    @Override
    public int deleteEmployee(int id) {
        try {
            BufferedReader brFile = new BufferedReader(new FileReader(employeeFile));
            String line;
            String input = "";
            while ((line = brFile.readLine()) != null) {
                if (line.contains(";" + id + ";")) {
                    line = "";
                } else {
                    line = line + '\n';
                }
                input += line;
            }
            FileOutputStream fosFile = new FileOutputStream(employeeFile);
            fosFile.write(input.getBytes());
            brFile.close();
            fosFile.close();
        } catch (IOException e) {
            System.out.println("Problems reading");
        }
        return id;
    }

    /*
    * Writes a case to a case file.
    * Stores all the relevant information about a case.
    * @param cases
    * @return case id
     */
    @Override
    public int writeCase(ICase cases) {
        String ID = Integer.toString(cases.getID());
        String employeeID = Integer.toString(cases.getEmployeeID());
        String caseRequestID = Integer.toString(cases.getCaseRequest().getID());
        String nextAppointment = cases.getNextAppointment();
        String guardianship = cases.getGuardianship();
        String personalHelper = cases.getPersonalHelper();
        String personalHelperPowerOfAttorney = cases.getPersonalHelperPowerOfAttorney();
        String citizenRights = cases.getCitizenRights();
        String citizenInformedElectronic = Boolean.toString(cases.isCitizenInformedElectronic());
        String consent = Boolean.toString(cases.hasConsent());
        String consentType = cases.getConsentType(); // can be oral or written
        String[] collectCitizenInfo = cases.getCollectCitizenInfo();
        String specialCircumstances = cases.getSpecialCircumstances();
        String differentCommune = cases.getDifferentCommune();
        String dateCreated = Long.toString(cases.getDateCreated().getTime());
        String dateModified = Long.toString(cases.getDateModified().getTime());

        try {
            BufferedReader brFile = new BufferedReader(new FileReader(caseFile));
            String line;
            String input = "";
            while ((line = brFile.readLine()) != null) {
                if (line.contains(cases.getID() + ";")) {
                    line = "";
                } else {
                    line = line + '\n';
                }
                input += line;
            }
            FileOutputStream fosFile = new FileOutputStream(caseFile);
            fosFile.write(input.getBytes());
            brFile.close();
            fosFile.close();
        } catch (Exception e) {
            System.out.println("Problems reading");
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ID);
        sb.append(";");
        sb.append(employeeID);
        sb.append(";");
        sb.append(caseRequestID);
        sb.append(";");
        sb.append(nextAppointment);
        sb.append(";");
        sb.append(guardianship);
        sb.append(";");
        sb.append(personalHelper);
        sb.append(";");
        sb.append(personalHelperPowerOfAttorney);
        sb.append(";");
        sb.append(citizenRights);
        sb.append(";");
        sb.append(citizenInformedElectronic);
        sb.append(";");
        sb.append(consent);
        sb.append(";");
        sb.append(consentType);
        sb.append(";");
        for (String string : collectCitizenInfo) {
            sb.append(string);
            sb.append("#");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(";");
        sb.append(specialCircumstances);
        sb.append(";");
        sb.append(differentCommune);
        sb.append(";");
        sb.append(dateCreated);
        sb.append(";");
        sb.append(dateModified);

        PrintWriter outputStream = null;
        try {
            //outputStream = new PrintWriter(fileName);
            outputStream = new PrintWriter(new FileOutputStream(caseFile, true));
        } catch (FileNotFoundException e) {
            System.out.println("Error loading the file: " + caseFile);
            System.exit(0);
        }
        outputStream.println("\n" + sb);
        outputStream.close();
        System.out.println("case was written to: " + caseFile);
        return cases.getID();
    }

    /**
    * Writes a case request to a case requests file.
    * Stores all the relevant information about a case request.
    * @param caseRequests
    * @return caserequest id
    **/
    @Override
    public int writeCaseRequest(ICaseRequest caseRequests) {
        String ID = Integer.toString(caseRequests.getID());
        String employeeID = Integer.toString(caseRequests.getEmployeeID());
        String description = caseRequests.getDescription();
        String MessageClear = Boolean.toString(caseRequests.isMessageClear());
        String[] CarePackageRequested = caseRequests.getCarePackageRequested();
        String RehousingPackageRequested = caseRequests.getRehousingPackageRequested();
        String requestPerson = caseRequests.getRequestPerson();
        String CitizenInformed = Boolean.toString(caseRequests.isCitizenInformed());
        //CitizenAttributes
        Integer phoneNr = caseRequests.getCitizen().getPhoneNumber() == null? -1 : caseRequests.getCitizen().getPhoneNumber();
        String citizenCPR = caseRequests.getCitizen().getCpr();
        String citizenName = caseRequests.getCitizen().getName();
        String citizenGender = caseRequests.getCitizen().getGender() + "";
        String citizenBirthdate = caseRequests.getCitizen().getBirthDate();
        String citizenAddress = caseRequests.getCitizen().getAddress();
        String citizenPhoneNr = Integer.toString(phoneNr);
        String citizenMail = caseRequests.getCitizen().getMail();
        String dateCreated = Long.toString(caseRequests.getDateCreated().getTime());
        String dateModified = Long.toString(caseRequests.getDateModified().getTime());

        try {
            BufferedReader brFile = new BufferedReader(new FileReader(caseRequestsFile));
            String line;
            String input = "";
            while ((line = brFile.readLine()) != null) {
                if (line.contains(caseRequests.getID() + ";")) {
                    line = "";
                } else {
                    line = line + '\n';
                }
                input += line;
            }
            FileOutputStream fosFile = new FileOutputStream(caseRequestsFile);
            fosFile.write(input.getBytes());
            brFile.close();
            fosFile.close();
        } catch (Exception e) {
            System.out.println("Problems reading");
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ID);
        sb.append(";");
        sb.append(employeeID);
        sb.append(";");
        sb.append(description);
        sb.append(";");
        sb.append(MessageClear);
        sb.append(";");
        for (String string : CarePackageRequested) {
            sb.append(string);
            sb.append("#");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(";");
        sb.append(RehousingPackageRequested);
        sb.append(";");
        sb.append(requestPerson);
        sb.append(";");
        sb.append(CitizenInformed);
        sb.append(";");
        sb.append(citizenCPR);
        sb.append(";");
        sb.append(citizenName);
        sb.append(";");
        sb.append(citizenGender);
        sb.append(";");
        sb.append(citizenBirthdate);
        sb.append(";");
        sb.append(citizenAddress);
        sb.append(";");
        sb.append(citizenPhoneNr);
        sb.append(";");
        sb.append(citizenMail);
        sb.append(";");
        sb.append(dateCreated);
        sb.append(";");
        sb.append(dateModified);

        PrintWriter outputStream = null;
        try {
            //outputStream = new PrintWriter(fileName);
            outputStream = new PrintWriter(new FileOutputStream(caseRequestsFile, true));
        } catch (FileNotFoundException e) {
            System.out.println("Error loading the file: " + caseRequestsFile);
            System.exit(0);
        }
        outputStream.println("\n" + sb);
        outputStream.close();
        System.out.println("Case request was written to: " + caseRequestsFile);
        return caseRequests.getID();
    }

    /*
    * Writes all ID's to a id file.
    * Stores ID's for cases, caserequests, employees
    * @param currentCaseID, currentCaseRequestID, currentEmployeeID
     */
    //@Override
    public void writeIDs(int currentCaseID, int currentCaseRequestID, int currentEmployeeID) {
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(currentCaseID));
        sb.append(";");
        sb.append(Integer.toString(currentCaseRequestID));
        sb.append(";");
        sb.append(Integer.toString(currentEmployeeID));

        PrintWriter outputStream = null;
        try {
            //outputStream = new PrintWriter(fileName);
            outputStream = new PrintWriter(new FileOutputStream(currentIDs, false));
        } catch (FileNotFoundException e) {
            System.out.println("Error loading the file: " + currentIDs);
            System.exit(0);
        }
        outputStream.println("\n" + sb);
        outputStream.close();
        System.out.println("new IDs were written to: " + currentIDs);

    }
}
