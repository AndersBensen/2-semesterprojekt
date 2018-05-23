package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDB {
    protected Connection db; 

    public AbstractDB() {
        db = getDBConnection();
    }
    
    /**
     * This method connects to the postgresql database, through the website
     * elephantsql. It connects with a specific username and password to make
     * sure that it connects to tables that were made. 
     * @return Connection to the database website
     */
    private Connection getDBConnection() {
        db = null;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e);
        }

        String url = "jdbc:postgresql://horton.elephantsql.com:5432/vojxahth";
        String username = "vojxahth";
        String password = "2AaRD453-Lm37Z5wgI4SBdXANa7jycpC";
        try {
            db = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("SQL error in getDBConnection()");
        }
        return db;
    }
}
