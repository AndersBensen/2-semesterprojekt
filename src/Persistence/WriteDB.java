/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import Acquaintance.ICase;
import Acquaintance.ICaseRequest;
import Acquaintance.IEmployee;
import Acquaintance.ILog;
import Acquaintance.IWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

/**
 *
 * @author ander
 */
public class WriteDB extends AbstractDB implements IWriter {

    @Override
    public void writeEmployee(IEmployee employee, int position) {
        try {
            Connection db = getDBConnection();
            String query = "INSERT INTO Employee " + 
                           "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = db.prepareStatement(query);
            ps.setString(1, Long.toString(employee.getCpr()));
            ps.setString(2, employee.getName());
            ps.setString(3, Character.toString(employee.getGender()));
            ps.setString(4, employee.getBirthDate());
            ps.setString(5, employee.getAddress());
            ps.setInt(6, employee.getPhoneNumber());
            ps.setString(7, employee.getMail());
            ps.setInt(8, employee.getId());
            ps.setString(9, employee.getUserName());
            ps.setString(10, employee.getPassWord());
            ps.setInt(11, position);
            ps.execute();
            ps.close();
            db.close();
        } catch (SQLException e) {
            System.out.println("SQL error in writeEmployee()");
        }
    }

    @Override
    public void deleteEmployee(int id) {
        try {
            Connection db = getDBConnection();
            String query = "DELETE FROM Employee " + 
                           "WHERE id = " + id;
            PreparedStatement ps = db.prepareStatement(query);
            ps.execute();
            ps.close();
            db.close();
        } catch (SQLException e) {
            System.out.println("SQL error in deleteEmployee()");
        }
    }

    @Override
    public void writeCase(ICase cases) {
        try {
            Connection db = getDBConnection();
            String query = "INSERT INTO Cases " + 
                           "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = db.prepareStatement(query);
            ps.setInt(1, cases.getID());
            ps.setInt(2, cases.getCaseRequest().getID());
            ps.setString(3, cases.getNextAppointment());
            ps.setString(4, cases.getGuardianship());
            ps.setString(5, cases.getPersonalHelper());
            ps.setString(6, cases.getPersonalHelperPowerOfAttorney());
            ps.setString(7, cases.getCitizenRights());
            ps.setBoolean(8, cases.isCitizenInformedElectronic());
            ps.setBoolean(9, cases.hasConsent());
            ps.setString(10, cases.getConsentType());
            ps.setString(11, Arrays.toString(cases.getCollectCitizenInfo()));
            ps.setString(12, cases.getSpecialCircumstances());
            ps.setString(13, cases.getDifferentCommune());
            ps.execute();
            
            String query2 = "INSERT INTO Becomes " + 
                            "VALUES(?, ?)";
            ps = db.prepareStatement(query2);
            ps.setInt(1, cases.getCaseRequest().getID());
            ps.setInt(2, cases.getID());
            ps.execute();
            ps.close();
            db.close();
        } catch (SQLException ex) {
            System.out.println("SQL error in writeCase()");
        }
    }

    @Override
    public void writeCaseRequest(ICaseRequest ICR) {
        try {
            Connection db = getDBConnection();
            String query = "INSERT INTO Caserequest " + 
                           "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = db.prepareStatement(query);
            ps.setInt(1, ICR.getID());
            ps.setInt(2, ICR.getEmployeeID());
            ps.setString(3, ICR.getDescription());
            ps.setBoolean(4, ICR.isMessageClear());
            ps.setBoolean(5, ICR.isCarePackageRequested());
            ps.setBoolean(6, ICR.isRehousingPackageRequested());
            ps.setString(7, ICR.getRequestPerson());
            ps.setBoolean(8, ICR.isCitizenInformed());
            ps.setString(9, Long.toString(ICR.getCitizenCPR()));
            ps.setString(10, ICR.getCitizenName());
            ps.setString(11, Character.toString(ICR.getCitizenGender()));
            ps.setString(12, ICR.getCitizenBirthdate());
            ps.setString(13, ICR.getCitizenAddress());
            ps.setInt(14, ICR.getCitizenPhoneNr());
            ps.setString(15, ICR.getCitizenMail());
            ps.execute();
            
            String query2 = "INSERT INTO Makes " +
                            "VALUES(?, ?)";
            ps = db.prepareStatement(query2);
            ps.setInt(1, ICR.getEmployeeID());
            ps.setInt(2, ICR.getID());
            ps.execute();
            ps.close();
            db.close();
        } catch (SQLException ex) {
            System.out.println("SQL error in writeCaseRequest()");
        }
    }

    @Override
    public void writeLog(ILog log) {
        try {
            Connection db = getDBConnection();
            String query = "INSERT INTO Log " +
                           "VALUES(?, ?, ?, ?)";
            PreparedStatement ps = db.prepareStatement(query);
            ps.setInt(1, log.getEmployeeID());
            ps.setString(2, log.getAction().toString());
            ps.setString(3, log.getDesc());
            ps.setString(4, log.getDate().toString());
            ps.execute();
            
            String query2 = "INSERT INTO Logs " + 
                            "VALUES(?, ?)";
            ps = db.prepareStatement(query2);
            ps.setInt(1, log.getEmployeeID());
            ps.setString(2, log.getDate().toString());
            ps.execute();
            ps.close();
            db.close();
        } catch (SQLException ex) {
            System.out.println("SQL error in writeLog");
        }
    }
}
