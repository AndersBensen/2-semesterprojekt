package Persistence;

import Acquaintance.IReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReadDB extends AbstractDB implements IReader {
    
    /**
     * This method consist of a sql query that returns a caserequest from the
     * database. The caserequest that is chosen is selected with a specific
     * id that the method takes as a argument. All the information that is
     * in the database about the caserequest is returned as a string array.
     * @param id int
     * @return string array with caserequest information
     */
    @Override
    public String[] getCaseRequest(int id) {
        String[] caseRequestInfo = new String[17];
        try {
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
    
    /**
     * This method consist of a sql query that returns a case from the
     * database. The case that is chosen is selected with a specific
     * id that the method takes as a argument. All the information that is
     * in the database about the case is returned as a string array.
     * @param id int
     * @return string array with case information
     */
    @Override
    public String[] getCase(int id) {
        String[] caseInfo = new String[17];
        try {
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
                caseInfo[16] = rs.getString(17);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("SQL error in getCase()");
        }
        return caseInfo;
    }

    /**
     * This method returns all the information about a specific employee in the
     * database. The sql query searches for a specific username and password
     * that is taken as arguments in the method. 
     * @param username String
     * @param password String
     * @return string array with employee information 
     */
    @Override
    public String[] login(String username, String password) {
        String[] EmployeeInfo = new String[11];
        try {
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

    /**
     * This method searches for all the information about a  specific person in the 
     * database. The sql query searches for a specific cpr and returns all the
     * information found in a string array.
     * @param cpr String
     * @return string array with person information. 
     */
    @Override
    public String[] getPerson(String cpr) {
        String[] personInfo = new String[5];
        try {
            Statement st = db.createStatement();
            String query = "SELECT * FROM Person WHERE cpr = '" + cpr + "'";
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

    /**
     * This method searches for all the information about a  specific employee in the 
     * database. The sql query searches for a specific id and returns all the
     * information found in a string array.
     * @param id int
     * @return string array with employee information. 
     */
    @Override
    public String[] getEmployee(int id) {
        String[] EmployeeInfo = new String[11];
        try {
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

    /**
     * This method finds the biggest id in the tables cases, caserequest and 
     * employee. The sql query uses the max keyword, therefore finding
     * the biggest id's. If the database returns null then the string
     * array will return 0 instead.
     * @return string array with the biggest ids
     */
    @Override
    public int[] getCurrentIDs() {
        int[] idArray = new int[3];
        try {
            Statement st = db.createStatement();
            String query = "SELECT MAX(Cases.id), MAX(CaseRequest.id), MAX(Employee.id)\n"
                    + "FROM CaseRequest, Cases, Employee";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                idArray[0] = rs.getString(1) == null? 0 : Integer.parseInt(rs.getString(1));
                idArray[1] = rs.getString(2) == null? 0 : Integer.parseInt(rs.getString(2));
                idArray[2] = rs.getString(3) == null? 0 : Integer.parseInt(rs.getString(3));
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("SQL error in getCurrentIDs()");
        }
        return idArray;
    }
    
    /**
     * This method returns some of the information from a caserequest
     * depending on the citizencpr that is connected to the caserequest.
     * @param citizenCPR String
     * @return List with the type of string array with some of the information
     * about a specific caserequest. 
     */
    @Override
    public List<String[]> getSimpleCaseRequests(String citizenCPR) {
        List<String[]> simpleCasesList = new ArrayList<>();
        String[] caseObject = new String[4];
        
        try {
            Statement st = db.createStatement();
            String query = "SELECT id, employeeid, description, datecreated " +
                           "FROM caserequest " +
                           "WHERE caserequest.citizencpr = '" + citizenCPR + "';";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                caseObject[0] = rs.getString(1);
                caseObject[1] = rs.getString(2);
                caseObject[2] = rs.getString(3);
                caseObject[3] = rs.getString(4);
                simpleCasesList.add(caseObject);
                caseObject = new String[4];
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("SQL error in getSimpleCaseRequests()");
        }
        return simpleCasesList;
    }

     /**
     * This method returns some of the information from a case. The sql query
     * matches the information depending on which caserequest id the case 
     * has. If the id's are the same as the id that the cpr number belongs to,
     * then the information is returned. 
     * @param citizenCPR String
     * @return List with the type of string array with some of the information
     * about a specific case. 
     */
    @Override
    public List<String[]> getSimpleCases(String citizenCPR) {
        List<String[]> simpleCasesList = new ArrayList<>();
        String[] caseObject = new String[4];
        
        try {
            Statement st = db.createStatement();
            String query = "SELECT cases.id, cases.employeeid, caserequest.description, cases.datecreated " +
                           "FROM cases, caserequest " +
                           "WHERE cases.caserequestid = caserequest.id AND caserequest.citizencpr = '" + citizenCPR + "';";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                caseObject[0] = rs.getString(1);
                caseObject[1] = rs.getString(2);
                caseObject[2] = rs.getString(3);
                caseObject[3] = rs.getString(4);
                simpleCasesList.add(caseObject);
                caseObject = new String[4];
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("SQL error in getSimpleCases()");
        }
        return simpleCasesList;
    }
}
