/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Domain.CaseRequest;
import Domain.ICase;
import Domain.IEmployee;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

/**
 *
 * @author ander
 */
public class WriteTXT implements IWriter{
    private File file = new File("Employees.txt");
    private File caseFile = new File("Cases.txt");
    
    @Override
    public void writeEmployee(IEmployee employee) {
        String cpr = Long.toString(employee.getCpr());
        String name = employee.getName();
        String gender = Character.toString(employee.getGender());
        String date = employee.getBirthDate();
        String address = employee.getAddress();
        String phoneNumber = Integer.toString(employee.getPhoneNumber());
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
        System.out.println(sb);  
        
        PrintWriter outputStream = null;
        try { 
            //outputStream = new PrintWriter(fileName);
            outputStream = new PrintWriter(new FileOutputStream(file, true));
        } 
        catch (FileNotFoundException e) {
            System.out.println("Error loading the file: " + file);
            System.exit(0);
        }
        outputStream.println("\n" + sb);
        outputStream.close();
        System.out.println("employee was written to: " + file);
    }
    
    @Override
    public void deleteEmployee(int id) {
        try {
            BufferedReader brFile = new BufferedReader(new FileReader(file));
            String line;
            String input = ""; 
            while ((line = brFile.readLine()) != null) {
                if (line.contains(";" + id + ";")) {
                    line = "";
                    System.out.println("Line deleteed");
                }
                else {
                    line = line + '\n';
                }
                input += line;
            }
            FileOutputStream fosFile = new FileOutputStream(file);
            fosFile.write(input.getBytes());
            brFile.close();
            fosFile.close();
        } catch (Exception e) {
            System.out.println("Problems reading");
        }
    }
    
    
    
    @Override
     public void writeCase(ICase cases) {
    String ID = Integer.toString(cases.getID());
    String caseRequestID = Integer.toString(cases.getCaseRequestID());
    String citizenIsInformed = Boolean.toString(cases.isCitizenIsInformed());
    String citizenRepresentation = cases.getCitizenRepresentation();
    String nextAppointment = cases.getNextAppointment();
    String guardianship = cases.getGuardianship();
    String personalHelper = cases.getPersonalHelper();
    String personalHelperPowerOfAttorney = Boolean.toString(cases.isPersonalHelperPowerOfAttorney());
    String citizenRights = cases.getCitizenRights();
    String citizenInformedElectronic = Boolean.toString(cases.isCitizenInformedElectronic());
    String consent = Boolean.toString(cases.hasConsent());
    String consentType = cases.getConsentType(); // can be oral or written
    String[] collectCitizenInfo = cases.getCollectCitizenInfo();
    String specialCircumstances = cases.getSpecialCircumstances();
    String differentCommune = cases.getDifferentCommune();
   
        
        StringBuilder sb = new StringBuilder();
        sb.append(ID+"");
        sb.append(";");
        sb.append(caseRequestID);
        sb.append(";");
        sb.append(citizenIsInformed);
        sb.append(";");
        sb.append(citizenRepresentation);
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
        sb.append(collectCitizenInfo);
        sb.append(";");
        sb.append(specialCircumstances);
        sb.append(";");
        sb.append(differentCommune);
        System.out.println(sb);  
        
        PrintWriter outputStream = null;
        try { 
            //outputStream = new PrintWriter(fileName);
            outputStream = new PrintWriter(new FileOutputStream(caseFile, true));
        } 
        catch (FileNotFoundException e) {
            System.out.println("Error loading the file: " + caseFile);
            System.exit(0);
        }
        outputStream.println("\n" + sb);
        outputStream.close();
        System.out.println("employee was written to: " + caseFile);
    }
}
