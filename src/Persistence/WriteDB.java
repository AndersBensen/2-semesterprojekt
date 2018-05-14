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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ander
 */
public class WriteDB extends AbstractDB implements IWriter {

    @Override
    public void writeEmployee(IEmployee employee, int position) {
        try {
            Connection db = getDBConnection();
            Statement st = db.createStatement();
            String query = "INSERT INTO Employee"
                    + " Values('" + employee.getCpr() + "', '" + employee.getName() + "', '" + employee.getGender() + "', '" + employee.getBirthDate()
                    + "', '" + employee.getAddress() + "', " + employee.getPhoneNumber() + ", '" + employee.getMail() + "', " + employee.getId()
                    + ", '" + employee.getUserName() + "', '" + employee.getPassWord() + "', " + position + ")";
            ResultSet rs = st.executeQuery(query);
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("SQL error in writeEmployee()");
        }
    }

    @Override
    public void deleteEmployee(int id) {
        try {
            Connection db = getDBConnection();
            Statement st = db.createStatement();
            String query = "DELETE FROM Employee " + 
                           "WHERE id = " + id;
            ResultSet rs = st.executeQuery(query);
            System.out.println("Before RS close");
            rs.close();
            System.out.println("After RS close");
            st.close();
            System.out.println("After ST close");
        } catch (SQLException e) {
            System.out.println("SQL error in deleteEmployee()");
        } 
    }

    @Override
    public void writeCase(ICase cases) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeCaseRequest(ICaseRequest ICR) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeLog(ILog log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeIDs(int currentCaseID, int currentCaseRequestID, int currentEmployeeID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    public static void main(String[] args) {
////        WriteDB writedb = new WriteDB();
////        Employee emp = new Employee(1205820009L, "Sigurd Espersen", 'M', "08-05-1982", "Vestergade 29, 5000 Odense C", 22334455, "jss@mail.dk", 3, "sigurdespersen", "megethemmeligt3");
////        writedb.writeEmployee(emp, 2);
////        writedb.deleteEmployee(3);
//    }

}
