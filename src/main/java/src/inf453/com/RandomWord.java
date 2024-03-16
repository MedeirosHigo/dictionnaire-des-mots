package uga.inf453.com;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author 
 */
public class RandomWord {
    
    PreparedStatement preparedStatement;
    Connect connect;
    ResultSet resultSet;
    ArrayList<String> motAnglais;
    String choix;

    public RandomWord() {
        connect = new Connect();
        motAnglais = new ArrayList<String>();
    }
    
    public void creerListMot(){
        
        String motFrancais;

        String query = "SELECT mot_francais,mot_anglais FROM Equivalence";
        try {
            preparedStatement = connect.getConnection().prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                motAnglais.add(resultSet.getString("mot_anglais"));
            }         
        
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    public void generateRandomMot(){
        choix = motAnglais.get((int) (Math.random() * motAnglais.size()));
        System.out.println(choix);        
    }

    public void removeMotList(){
        motAnglais.remove(choix);
    }
    
    public String randomMot(){
        return choix;
    }
    
    
}
