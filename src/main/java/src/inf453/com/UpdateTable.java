package uga.inf453.com;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author
 */
public class UpdateTable {

    PreparedStatement preparedStatement;
    Connect connect;

    public UpdateTable() {
        connect = new Connect();

    }

    public int updateDictionnaire(String motFrancais, String motAnglais, String motSynonyme, String type,
            String definition, int idDictionnaire) {
        int execute = 0;
        String queryUpdate = "UPDATE Dictionnaire SET mot_francais = ?,mot_anglais = ?,mot_synonyme = ?,type = ?,definition = ? WHERE id = ?";
        try {
            preparedStatement = connect.getConnection().prepareStatement(queryUpdate);
            preparedStatement.setString(1, motFrancais);
            preparedStatement.setString(2, motAnglais);
            preparedStatement.setString(3, motSynonyme);
            preparedStatement.setString(4, type);
            preparedStatement.setString(5, definition);
            preparedStatement.setInt(6, idDictionnaire);
            execute = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
        return execute;
    }

    public int updateVerbeIrregulier(String preterit, String pastParticiple) {
        int execute = 0;
        String queryUpdate = "UPDATE VerbeIrregulier SET preterit = ?, participe_passe = ? WHERE  = ?;";
        try {
            preparedStatement = connect.getConnection().prepareStatement(queryUpdate);
            preparedStatement.setString(1, preterit);
            preparedStatement.setString(2, pastParticiple);
            execute = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
        return execute;
    }

}
