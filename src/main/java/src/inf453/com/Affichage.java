package uga.inf453.com;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author
 */
public class Affichage {
    PreparedStatement preparedStatement;
    Connect connect;
    DefaultTableModel defaultTableModel;
    ResultSet resultSet;

    public Affichage() {
        connect = new Connect();
    }

    public void afficher(DefaultTableModel jTableAfficher) {
        try {
            defaultTableModel = jTableAfficher;
            defaultTableModel.setNumRows(0);
            preparedStatement = connect.getConnection().prepareStatement(
                    "SELECT * FROM Dictionnaire;");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String affiche[] = {
                        resultSet.getString("mot_francais"),
                        resultSet.getString("mot_anglais"),
                        resultSet.getString("mot_synonyme"),
                        resultSet.getString("type"),
                        resultSet.getString("definition"),
                        resultSet.getString("id")
                };
                defaultTableModel.addRow(affiche);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void afficherType(JComboBox jComboBoxType) {
        try {
            preparedStatement = connect.getConnection().prepareStatement("SELECT * FROM Type;");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                jComboBoxType.addItem(resultSet.getString(1));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void clearAffiche(DefaultTableModel jTableAfficher) {
        try {
            defaultTableModel = jTableAfficher;
            defaultTableModel.setNumRows(0);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void afficherVerbeIrregulier(DefaultTableModel jTableIrregulier) {
        try {

            defaultTableModel = (DefaultTableModel) jTableIrregulier;
            defaultTableModel.setNumRows(0);
            preparedStatement = connect.getConnection().prepareStatement(
                    "SELECT vi.preterit,vi.participe_passe,vi.mot_francais,vi.mot_anglais FROM VerbeIrregulier vi JOIN Equivalence eq on (vi.mot_anglais = eq.mot_anglais);");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String afficheVI[] = {
                        resultSet.getString("mot_francais"),
                        resultSet.getString("mot_anglais"),
                        resultSet.getString("preterit"),
                        resultSet.getString("participe_passe")
                };
                defaultTableModel.addRow(afficheVI);
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void clearAffichageVerbeIrregulier(DefaultTableModel jTableIrregulier) {
        try {
            defaultTableModel = jTableIrregulier;
            defaultTableModel.setNumRows(0);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
