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
    
    
    
     public void writeCase(ICase cases) {
    int ID;
    CaseRequest caseRequest = cases.getCaseRequest();
    boolean citizenIsInformed = cases.isCitizenIsInformed();
    String citizenRepresentation = cases.getCitizenRepresentation();
    String nextAppointment = cases.getNextAppointment();
    String guardianship = cases.getGuardianship();
    String personalHelper = cases.getPersonalHelper();
    boolean personalHelperPowerOfAttorney;
    String citizenRights;
    boolean citizenInformedElectronic;
    boolean consent;
    String consentType; // can be oral or written
    String[] collectCitizenInfo;
    String specialCircumstances;
    String differentCommune;
   
        
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
}
