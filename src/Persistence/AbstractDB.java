/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ander
 */
public abstract class AbstractDB {
    
    protected Connection getDBConnection() {
        Connection db = null;
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
