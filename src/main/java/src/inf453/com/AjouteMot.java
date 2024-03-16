package uga.inf453.com;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AjouteMot {

    PreparedStatement preparedStatement;
    Connect connect;

    public AjouteMot() {
        connect = new Connect();
    }

    public void dictionnaire(String motFrancais, String motAnglais, String motSynonyme, String type,
            String definition) {
        int execute = 0;
        String query = "INSERT INTO Dictionnaire (mot_francais,mot_anglais,mot_synonyme,type,definition) VALUES (?,?,?,?,?)";
        try {

            preparedStatement = connect.getConnection().prepareStatement(query);
            preparedStatement.setString(1, motFrancais);
            preparedStatement.setString(2, motAnglais);
            preparedStatement.setString(3, motSynonyme);
            preparedStatement.setString(4, type);
            preparedStatement.setString(5, definition);
            execute = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    public int ajouteType(String type) {
        String querytype = "INSERT INTO Type(type) VALUES (?)";
        int execute = 0;
        try {
            preparedStatement = connect.getConnection().prepareStatement(querytype);
            preparedStatement.setString(1, type);
            execute = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return execute;
    }

    public int ajouteEquivalence(String motFrancais, String motAnglais) {
        String queryEqui = "INSERT INTO Equivalence(mot_francais,mot_anglais) VALUES (?,?)";
        int execute = 0;
        try {
            preparedStatement = connect.getConnection().prepareStatement(queryEqui);
            preparedStatement.setString(1, motFrancais);
            preparedStatement.setString(2, motAnglais);
            execute = preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return execute;
    }

    public int verbeIrregulier(String preterit, String participe_passe, String mot_anglais, String mot_francais) {
        String queryVerbeIrregulier = "INSERT INTO VerbeIrregulier VALUES (?,?,?,?)";
        int execute = 0;
        try {
            preparedStatement = connect.getConnection().prepareStatement(queryVerbeIrregulier);
            preparedStatement.setString(1, preterit);
            preparedStatement.setString(2, participe_passe);
            preparedStatement.setString(3, mot_anglais);
            preparedStatement.setString(4, mot_francais);

            execute = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return execute;
    }
}
