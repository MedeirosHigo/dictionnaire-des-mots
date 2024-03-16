package uga.inf453.com;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ubuntu-uga
 */
public class Player {
    
    Connect connect;
    PreparedStatement preparedStatement;
    
    
    public Player() {
        connect = new Connect();
    }
    
    public void enregistrePlayer(String nomPlayer, int scorePlayer) throws SQLException{
        String queryPlayer = "INSERT INTO Player (nom,socre) valuer (?,?)";
        preparedStatement = connect.getConnection().prepareStatement(queryPlayer);
        preparedStatement.executeQuery();
    }
    
     
}
