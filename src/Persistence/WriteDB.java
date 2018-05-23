package Persistence;

import Acquaintance.ICase;
import Acquaintance.ICaseRequest;
import Acquaintance.IEmployee;
import Acquaintance.ILog;
import Acquaintance.IWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WriteDB extends AbstractDB implements IWriter {

    /**
     * This method writes a caserequest to the database. The sql query
     * is a simple insert into, where it uses a preparedstatment to
     * put all the information in from the caserequest, which the method
     * takes as an argument. 
     * @param ICR ICaseRequest
     * @return caserequest id
     */
    @Override
    public int writeCaseRequest(ICaseRequest ICR) {
        try {
            int phoneNr = ICR.getCitizen().getPhoneNumber() == null? -1 : ICR.getCitizen().getPhoneNumber();
            
            String carePackageRequested = "";
            for (String string : ICR.getCarePackageRequested()) {
                carePackageRequested += string;
                carePackageRequested += "#";
            }
            carePackageRequested = carePackageRequested.substring(0, carePackageRequested.length()-1);
            
            String query = "INSERT INTO Caserequest "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = db.prepareStatement(query);
            ps.setInt(1, ICR.getID());
            ps.setInt(2, ICR.getEmployeeID());
            ps.setString(3, ICR.getDescription());
            ps.setBoolean(4, ICR.isMessageClear());
            ps.setString(5, carePackageRequested);
            ps.setString(6, ICR.getRehousingPackageRequested());
            ps.setString(7, ICR.getRequestPerson());
            ps.setBoolean(8, ICR.isCitizenInformed());
            ps.setString(9, ICR.getCitizen().getCpr());
            ps.setString(10, ICR.getCitizen().getName());
            ps.setString(11, Character.toString(ICR.getCitizen().getGender()));
            ps.setString(12, ICR.getCitizen().getBirthDate());
            ps.setString(13, ICR.getCitizen().getAddress());
            ps.setInt(14, phoneNr);
            ps.setString(15, ICR.getCitizen().getMail());
            ps.setString(16, Long.toString(ICR.getDateCreated().getTime()));
            ps.setString(17, Long.toString(ICR.getDateModified().getTime()));
            ps.execute();
            ps.close();
            return ICR.getID();
        } catch (SQLException ex) {
            System.out.println("WriteDB: SQL error in writeCaseRequest()");
        }
        return -1;
    }

    /**
     * This method starts by deleting a case with the id from the case
     * that is given with the method as an argument. This is because 
     * this method also works as an edit case method. It then inserts
     * all the information from the case with an sql query, 
     * @param cases ICase
     * @return case id
     */
    @Override
    public int writeCase(ICase cases) {
        try {
            String citizenInfo = "";
            for (String string : cases.getCollectCitizenInfo()) {
                citizenInfo += string;
                citizenInfo += "#";
            }
            citizenInfo = citizenInfo.substring(0, citizenInfo.length()-1);
            
            String query1 = "DELETE FROM Cases " + 
                            "WHERE ID = " + cases.getID();
            PreparedStatement ps = db.prepareStatement(query1);
            ps.execute();
            
            String query2 = "INSERT INTO Cases "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = db.prepareStatement(query2);
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
            ps.setString(15, cases.getState());
            ps.setString(16, Long.toString(cases.getDateCreated().getTime()));
            ps.setString(17, Long.toString(cases.getDateModified().getTime()));
            ps.execute();
            ps.close();
            return cases.getID();
        } catch (SQLException ex) {
            System.out.println("WriteDB: SQL error in writeCase()");
        }
        return -1;
    }

    /**
     * This method writes all the information about an employee to the database.
     * The method takes an Iemployee as argument and sends all the information
     * to the database.
     * @param employee IEmployee
     * @param position int
     * @return employee id
     */
    @Override
    public int writeEmployee(IEmployee employee, int position) {
        try {
            int phoneNr = employee.getPhoneNumber() == null? -1 : employee.getPhoneNumber();
            
            String query = "INSERT INTO Employee "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = db.prepareStatement(query);
            ps.setString(1, employee.getCpr());
            ps.setString(2, employee.getName());
            ps.setString(3, Character.toString(employee.getGender()));
            ps.setString(4, employee.getBirthDate());
            ps.setString(5, employee.getAddress());
            ps.setInt(6, phoneNr);
            ps.setString(7, employee.getMail());
            ps.setInt(8, employee.getId());
            ps.setString(9, employee.getUserName());
            ps.setString(10, employee.getPassWord());
            ps.setInt(11, position);
            ps.execute();
            ps.close();
            return employee.getId();
        } catch (SQLException e) {
            System.out.println("WriteDB: SQL error in writeEmployee()");
        }
        return -1;
    }

    /**
     * This method deletes an employee from the database. Because there is
     * a foreign key between the Log table and the Employee table then it is
     * not possible to simply delete an employee. All the logs in the database 
     * with the employee id must be deleted first. 
     * @param id int
     * @return emplyoee id 
     */
    @Override
    public int deleteEmployee(int id) {
        try {
            int empID = id;
            String query1 = "DELETE FROM Log " 
                    + "WHERE employeeID = " + empID; 
            PreparedStatement ps = db.prepareStatement(query1);
            ps.execute();
                    
            String query2 = "DELETE FROM Employee "
                    + "WHERE id = " + empID;
            ps = db.prepareStatement(query2);
            ps.execute();
            ps.close();
            return id;
        } catch (SQLException e) {
            System.out.println("WriteDB: SQL error in deleteEmployee()");
        }
        return -1;
    }

    /**
     * This method takes all the information about a log and writes it to the
     * database. 
     * @param log ILog 
     */
    @Override
    public void writeLog(ILog log) {
        try {
            String query = "INSERT INTO Log "
                    + "VALUES(?, ?, ?, ?)";
            PreparedStatement ps = db.prepareStatement(query);
            ps.setInt(1, log.getEmployeeID());
            ps.setString(2, log.getAction().toString());
            ps.setString(3, log.getDesc());
            ps.setString(4, log.getDate().toString());
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("WriteDB: SQL error in writeLog()");
        }
    }
}
