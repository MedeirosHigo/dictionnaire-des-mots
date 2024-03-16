package uga.inf453.com;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create {
    
    private String url;
    private String fichier;
    String text = "";
    Statement statement;        
    FileReader fileReader;
    File file;
    int charLu;  
    
    public Create(){
        fichier = "scriptSql/CREATE.sql";
        url = "jdbc:sqlite:stockage/Dictionnaire.db";
        
        try {
            
            file = new File(fichier);
            fileReader = new FileReader(file);
            charLu = fileReader.read();

            while(charLu != -1){
                text += (char) charLu;
                charLu = fileReader.read();
            }      
        } 
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
        
    }
    
    public void createNewTable(String sql) throws IOException {
        try{
            Connection conn = DriverManager.getConnection(url);
            statement = conn.createStatement();
            statement.execute(sql);
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void executeQuery() throws IOException{
        String querys[];
        
        try{ 
            querys = text.split(";");            
            for (String query : querys) {
               createNewTable(query);
            }
        } 
        catch (IOException e) {
            System.err.println(e.getMessage());
        } 
    }
}
