package Persistence;

import Acquaintance.IReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class ReadDB extends AbstractDB implements IReader {

    @Override
    public String[] getCaseRequest(int id) {
        String[] caseRequestInfo = new String[17];
        try {
            Connection db = getDBConnection();
            Statement st = db.createStatement();
            String query = "SELECT * FROM CaseRequest WHERE id = '" + Integer.toString(id) + "'";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                caseRequestInfo[0] = rs.getString(1);
                caseRequestInfo[1] = rs.getString(2);
                caseRequestInfo[2] = rs.getString(3);
                caseRequestInfo[3] = rs.getString(4);
                caseRequestInfo[4] = rs.getString(5);
                caseRequestInfo[5] = rs.getString(6);
                caseRequestInfo[6] = rs.getString(7);
                caseRequestInfo[7] = rs.getString(8);
                caseRequestInfo[8] = rs.getString(9);
                caseRequestInfo[9] = rs.getString(10);
                caseRequestInfo[10] = rs.getString(11);
                caseRequestInfo[11] = rs.getString(12);
                caseRequestInfo[12] = rs.getString(13);
                caseRequestInfo[13] = rs.getString(14);
                caseRequestInfo[14] = rs.getString(15);
                caseRequestInfo[15] = rs.getString(16);
                caseRequestInfo[16] = rs.getString(17);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("SQL error in getCaseRequest()");
        }
        return caseRequestInfo;
    }

    @Override
    public String[] getCase(int id) {
        String[] caseInfo = new String[16];
        try {
            Connection db = getDBConnection();
            Statement st = db.createStatement();
            String query = "SELECT * FROM Cases WHERE id = '" + Integer.toString(id) + "'";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                caseInfo[0] = rs.getString(1);
                caseInfo[1] = rs.getString(2);
                caseInfo[2] = rs.getString(3);
                caseInfo[3] = rs.getString(4);
                caseInfo[4] = rs.getString(5);
                caseInfo[5] = rs.getString(6);
                caseInfo[6] = rs.getString(7);
                caseInfo[7] = rs.getString(8);
                caseInfo[8] = rs.getString(9);
                caseInfo[9] = rs.getString(10);
                caseInfo[10] = rs.getString(11);
                caseInfo[11] = rs.getString(12);
                caseInfo[12] = rs.getString(13);
                caseInfo[13] = rs.getString(14);
                caseInfo[14] = rs.getString(15);
                caseInfo[15] = rs.getString(16);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("SQL error in getCase()");
        }
        return caseInfo;
    }

    @Override
    public String[] login(String username, String password) {
        String[] EmployeeInfo = new String[11];
        try {
            Connection db = getDBConnection();
            Statement st = db.createStatement();
            String query = "SELECT * FROM Employee WHERE username = '" + username + "' AND password = '" + password + "'";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                EmployeeInfo[0] = rs.getString(1);
                EmployeeInfo[1] = rs.getString(2);
                EmployeeInfo[2] = rs.getString(3);
                EmployeeInfo[3] = rs.getString(4);
                EmployeeInfo[4] = rs.getString(5);
                EmployeeInfo[5] = rs.getString(6);
                EmployeeInfo[6] = rs.getString(7);
                EmployeeInfo[7] = rs.getString(8);
                EmployeeInfo[8] = rs.getString(9);
                EmployeeInfo[9] = rs.getString(10);
                EmployeeInfo[10] = rs.getString(11);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("SQL error in login()");
        }
        return EmployeeInfo;
    }

    @Override
    public String[] getPerson(long cpr) {
        String[] personInfo = new String[5];
        try {
            Connection db = getDBConnection();
            Statement st = db.createStatement();
            String query = "SELECT * FROM Person WHERE cpr = '" + Long.toString(cpr) + "'";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                personInfo[0] = rs.getString(1);
                personInfo[1] = rs.getString(2);
                personInfo[2] = rs.getString(3);
                personInfo[3] = rs.getString(4);
                personInfo[4] = rs.getString(5);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("SQL error in getPerson()");
        }
        return personInfo;
    }

    @Override
    public String[] getEmployee(int id) {
        String[] EmployeeInfo = new String[11];
        try {
            Connection db = getDBConnection();
            Statement st = db.createStatement();
            String query = "SELECT * FROM Employee WHERE id = '" + Integer.toString(id) + "'";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                EmployeeInfo[0] = rs.getString(1);
                EmployeeInfo[1] = rs.getString(2);
                EmployeeInfo[2] = rs.getString(3);
                EmployeeInfo[3] = rs.getString(4);
                EmployeeInfo[4] = rs.getString(5);
                EmployeeInfo[5] = rs.getString(6);
                EmployeeInfo[6] = rs.getString(7);
                EmployeeInfo[7] = rs.getString(8);
                EmployeeInfo[8] = rs.getString(9);
                EmployeeInfo[9] = rs.getString(10);
                EmployeeInfo[10] = rs.getString(11);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("SQL error in getEmployee()");
        }
        return EmployeeInfo;
    }

    @Override
    public int[] getCurrentIDs() {
        int[] idArray = new int[3];
        try {
            Connection db = getDBConnection();
            Statement st = db.createStatement();
            String query = "SELECT MAX(Cases.id), MAX(CaseRequest.id), MAX(Employee.id)\n"
                    + "FROM CaseRequest, Cases, Employee";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                idArray[0] = Integer.parseInt(rs.getString(1));
                idArray[1] = Integer.parseInt(rs.getString(2));
                idArray[2] = Integer.parseInt(rs.getString(3));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("SQL error in getCurrentIDs()");
        }
        return idArray;
    }
    
//    public static void main(String[] args) {
//        ReadDB rdb = new ReadDB();
//        System.out.println(Arrays.toString(rdb.getCase(1)));
//        System.out.println(Arrays.toString(rdb.getCaseRequest(1)));
//    }
}
