package Persistence;

import Acquaintance.ICase;
import Acquaintance.ICaseRequest;
import Acquaintance.IEmployee;
import Acquaintance.ILog;
import Acquaintance.IWriter;
import Domain.Case;
import Domain.CaseRequest;
import Domain.Log;
import Domain.LogAction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class WriteDB extends AbstractDB implements IWriter {

    @Override
    public void writeEmployee(IEmployee employee, int position) {
        try {
            Connection db = getDBConnection();
            String query = "INSERT INTO Employee "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            String query = "DELETE FROM Employee "
                    + "WHERE id = " + id;
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
            String citizenInfo = "";
            for (String string : cases.getCollectCitizenInfo()) {
                citizenInfo += string;
                citizenInfo += "#";
            }
            citizenInfo = citizenInfo.substring(0, citizenInfo.length()-1);
            
            Connection db = getDBConnection();
            String query = "INSERT INTO Cases "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = db.prepareStatement(query);
            ps.setInt(1, cases.getID());
            ps.setInt(2, cases.getEmployeeID());
            ps.setInt(3, cases.getCaseRequest().getID());
            ps.setString(4, cases.getNextAppointment());
            ps.setString(5, cases.getGuardianship());
            ps.setString(6, cases.getPersonalHelper());
            ps.setString(7, cases.getPersonalHelperPowerOfAttorney());
            ps.setString(8, cases.getCitizenRights());
            ps.setBoolean(9, cases.isCitizenInformedElectronic());
            ps.setBoolean(10, cases.hasConsent());
            ps.setString(11, cases.getConsentType());
            ps.setString(12, citizenInfo);
            ps.setString(13, cases.getSpecialCircumstances());
            ps.setString(14, cases.getDifferentCommune());
            ps.setString(15, Long.toString(cases.getDateCreated().getTime()));
            ps.setString(16, Long.toString(cases.getDateModified().getTime()));
            ps.execute();

            String query2 = "INSERT INTO Becomes "
                    + "VALUES(?, ?)";
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
            String query = "INSERT INTO Caserequest "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            ps.setString(16, Long.toString(ICR.getDateCreated().getTime()));
            ps.setString(17, Long.toString(ICR.getDateModified().getTime()));
            ps.execute();

            String query2 = "INSERT INTO Makes "
                    + "VALUES(?, ?)";
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
            String query = "INSERT INTO Log "
                    + "VALUES(?, ?, ?, ?)";
            PreparedStatement ps = db.prepareStatement(query);
            ps.setInt(1, log.getEmployeeID());
            ps.setString(2, log.getAction().toString());
            ps.setString(3, log.getDesc());
            ps.setString(4, log.getDate().toString());
            ps.execute();

            String query2 = "INSERT INTO Logs "
                    + "VALUES(?, ?)";
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
//        public static void main(String[] args) {
//        WriteDB writedb = new WriteDB();
////        //Employee emp = new Employee(1205820009L, "Sigurd Espersen", 'M', "08-05-1982", "Vestergade 29, 5000 Odense C", 22334455, "jss@mail.dk", 1, "sigurdespersen", "megethemmeligt3");
////        //Employee emp = new Employee(1205820009L, "Sigurd Espersen", 'M', "08-05-1982", "Vestergade 29, 5000 Odense C", 22334455, "jss@mail.dk", 1, "sigurdespersen", "megethemmeligt3");
////        Employee emp = new Employee(2504770005L, "Loc Nguyen", 'M', "25-04-1977", "Middelfartvej 143, 5200 Odense V", 20151515, "loc@mail.dk", 2, "locnguyen", "megethemmeligt4");
////        writedb.writeEmployee(emp, 2);
////        writedb.deleteEmployee(1);
////        Case c = new Case(2, 2, new CaseRequest(1, 2, 3));
////        c.setNextAppointment("test1");
////        c.setGuardianship("test2");
////        c.setPersonalHelper("test3");
////        c.setPersonalHelperPowerOfAttorney("test4");
////        c.setCitizenRights("test5");
////        c.setCitizenInformedElectronic(true);
////        c.setConsent(true);
////        c.setConsentType("test6");
////        c.setCollectCitizenInfo(new String[] {"test7", "test8", "test9"});
////        c.setSpecialCircumstances("test10");
////        c.setDifferentCommune("test11");
////        writedb.writeCase(c);
//
////        CaseRequest CR = new CaseRequest(1, 2, 0212122005L);
////        CR.setDescription("test1");
////        CR.setMessageClear(true);
////        CR.setCarePackageRequested(true);
////        CR.setRehousingPackageRequested(true);
////        CR.setRequestPerson("test2");
////        CR.setCitizenInformed(true);
////        CR.connectCitizen(0212122005L, "test3", 'm', "test4", "test5");
////        CR.setCitizenPhoneNr(22334455);
////        CR.setCitizenMail("tes6");
////        writedb.writeCaseRequest(CR);
////        Log log = new Log(1, LogAction.LOG_IN, "Logged in test");
////        writedb.writeLog(log);
//    }




}
