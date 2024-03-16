package uga.inf453.com;

import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author 
 */
public class SupprimeLigne {
    PreparedStatement preparedStatement;
    Connect connect;
    
    public SupprimeLigne() {
        connect = new Connect();
    }   
        
    public int delete(int id) {
        String queryDel = "DELETE FROM Dictionnaire WHERE id = ?";
        int execute = 0;
        try {
            preparedStatement = connect.getConnection().prepareStatement(queryDel);
            preparedStatement.setInt(1, id);
            execute = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return execute;
    }    
}
