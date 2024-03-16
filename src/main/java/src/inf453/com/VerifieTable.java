package uga.inf453.com;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author
 */
public class VerifieTable {
    Connect connect;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Main main;

    public VerifieTable() {
        connect = new Connect();
    }

    public boolean verifieDictionnaire(String motFrancais, String motAnglais, String motSynonyme, String type,
            String definition) throws SQLException {

        try {

            String sql = ("SELECT * FROM Dictionnaire WHERE mot_francais = ? and mot_anglais = ? and mot_synonyme = ? and type = ? and definition = ? ");
            preparedStatement = connect.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, motFrancais);
            preparedStatement.setString(2, motAnglais);
            preparedStatement.setString(3, motSynonyme);
            preparedStatement.setString(4, type);
            preparedStatement.setString(5, definition);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if (resultSet.next() == true) {
            preparedStatement.close();
            return true;
        } else {
            return false;
        }
    }

    public boolean verifieVerbeIrregulier(String preterit, String participe_passe, String motFrancais,
            String motAnglais) throws SQLException {

        try {

            String sql = ("SELECT * FROM VerbeIrregulier WHERE preterit = ?, participe_passe = ?, mot_anglais = ? and mot_francais = ?");
            preparedStatement = connect.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, preterit);
            preparedStatement.setString(2, participe_passe);
            preparedStatement.setString(3, motAnglais);
            preparedStatement.setString(4, motFrancais);
            resultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if (resultSet.next() == true) {
            preparedStatement.close();
            return true;
        } else {
            return false;
        }
    }

    public boolean verifieType(String type) throws SQLException {

        try {

            String sql = ("SELECT type FROM Type WHERE type = ?");
            preparedStatement = connect.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, type);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        if (resultSet.next() == true) {
            preparedStatement.close();
            return true;
        } else {
            return false;
        }
    }

    public boolean verifieEquivalence(String motAnglais, String motFrancais) throws SQLException {

        try {

            String sql = ("SELECT mot_anglais FROM Equivalence WHERE mot_anglais = ? and mot_francais = ?");
            preparedStatement = connect.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, motAnglais);
            preparedStatement.setString(2, motFrancais);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        if (resultSet.next() == true) {
            preparedStatement.close();
            return true;
        } else {
            return false;
        }
    }

    public boolean verifieRandomMot(String motAnglais, String motFrancais) throws SQLException {

        try {

            String sql = ("SELECT mot_anglais,mot_francais FROM Equivalence WHERE mot_anglais = ? and mot_francais = ?");
            preparedStatement = connect.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, motAnglais);
            preparedStatement.setString(2, motFrancais);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        if (resultSet.next() == true) {
            preparedStatement.close();
            return true;
        } else {
            return false;
        }
    }
}
