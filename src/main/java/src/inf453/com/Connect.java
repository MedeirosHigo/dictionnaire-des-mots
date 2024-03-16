package uga.inf453.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This programm allows the connection with sqlite
 * 
 * author: quentinROTOLO
 */

public class Connect {
    
    private Connection connection;
    private String url;
    
    public Connection getConnection(){
        
        url = "jdbc:sqlite:stockage/Dictionnaire.db";
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return connection;
    }
    
}