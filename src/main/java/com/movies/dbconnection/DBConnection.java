package com.movies.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() {
        final String username = "saawan02";
        final String password = "123456";
        final String host = "revolt.evolution-host.com/zsaawan021";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://"+host,username,password); 
            return con;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static void closeConnection(Connection con){
        try {
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
