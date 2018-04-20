/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Domain.ICase;
import Domain.IEmployee;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

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
     public void writeCase(ICase cases) {
        
        try  {
            FileOutputStream fos = new FileOutputStream(caseFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(cases);
            oos.close();
            fos.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WriteTXT.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WriteTXT.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    
}
   
}