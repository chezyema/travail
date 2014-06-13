/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.db;

import be.isfce.tfe.metier.Chauffeur;
import be.isfce.tfe.metier.UtilisationCarte;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yema
 */
public class UtilisationCarteDao {

    public static boolean addUtilisationCarte(UtilisationCarte carte) {
        try {
            System.out.println(carte.toString());
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("Insert into utilisationcarte (idutilisation,dateutilisation,litrecarburant,kmutilisation,id,idcarte) values (? , ?, ?, ?,?,?)");
            preparedStatement.setInt(1, carte.getIdutilisationcarte());
            preparedStatement.setDate(2, new Date(carte.getDateUtilisation().getTime()));
            preparedStatement.setInt(3,carte.getLitrecarburant());
            preparedStatement.setInt(4,carte.getKmutilisation());
            preparedStatement.setString(5, carte.getIdvehicule());
            preparedStatement.setInt(6, carte.getIdcartecarburant());

            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<UtilisationCarte> getTousLesUtilisationCarte() {
        return getTousLesUtilisationCarte(false);
    }

    public static List<UtilisationCarte> getTousLesUtilisationCartearchives() {
        return getTousLesUtilisationCarte(true);
    }

    public static List<UtilisationCarte> getTousLesUtilisationCarte(boolean utilisationSupprimes) {

        try {
            String supprimesutilisationcarte = utilisationSupprimes ? "1" : "0";
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select * from utilisationcarte where supprimeutilisationcarte = " + supprimesutilisationcarte);

            ResultSet resultSet = preparedStatement.executeQuery();
            List<UtilisationCarte> allUtilisationCarte = new ArrayList<UtilisationCarte>();
            while (resultSet.next()) {
                UtilisationCarte heure = new UtilisationCarte();
                heure.setIdutilisationcarte(resultSet.getInt("idutilisation"));
                heure.setDateutilisation(resultSet.getDate("dateutilisation"));
                heure.setLitrecarburant(resultSet.getInt("litrecarburant"));
                heure.setKmutilisation(resultSet.getInt("kmutilisation"));
                heure.setIdvehicule(resultSet.getString("id"));
                heure.setIdcartecarburant(resultSet.getInt("idcarte"));

                allUtilisationCarte.add(heure);
            }
            System.out.println(allUtilisationCarte);
            return allUtilisationCarte;
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean updateUtilisationCarte(UtilisationCarte utilisation) {
        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("update utilisationcarte set dateutilisation = ?,set litrecarburant = ? ,set kmutilisation = ? where utilisationcarte.idutilisation = ?");

            preparedStatement.setDate(1, new Date(utilisation.getDateUtilisation().getTime()));
            preparedStatement.setInt(2, utilisation.getLitrecarburant());
            preparedStatement.setInt(3,utilisation.getKmutilisation());
            preparedStatement.setInt(4, utilisation.getIdutilisationcarte());
            

            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean deleteUtilisationCarte(UtilisationCarte idutilisation) {
        try {

            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("update utilisationcarte set supprimeutilisationcarte = 1 where utilisationcarte.idutilisation = ?");
            preparedStatement.setInt(1, idutilisation.getIdutilisationcarte());
            preparedStatement.executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
