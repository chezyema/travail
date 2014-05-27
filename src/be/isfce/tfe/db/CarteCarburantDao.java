/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.db;

import be.isfce.tfe.metier.CarteCarburant;
import be.isfce.tfe.metier.UtilisationCarte;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yema
 */
public class CarteCarburantDao {

    public static boolean addCarteCarburant(CarteCarburant cartecarburant) {
        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("Insert into cartecarburant (idcarte,kmutilisation,litrecarburant) values (? , ?, ?)");
            preparedStatement.setInt(1, cartecarburant.getId());
            preparedStatement.setInt(2, cartecarburant.getKmUtilisation());
            preparedStatement.setInt(3, cartecarburant.getLitreCarburant());

            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static List<CarteCarburant> getTousLesCartesCarburant() {
        return getTousLesCartesCarburant(false);
    }

    public static List<CarteCarburant> getTousLesCartesCarburantarchives() {
        return getTousLesCartesCarburant(true);
    }

    public static List<CarteCarburant> getTousLesCartesCarburant(boolean carteSupprimes) {
        try {
            String supprimes = carteSupprimes ? "1" : "0";
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select * from cartecarburant where supprimecartecarburant = " + supprimes);

            ResultSet resultSet = preparedStatement.executeQuery();
            List<CarteCarburant> allCarteCarburant = new ArrayList<CarteCarburant>();
            while (resultSet.next()) {
                CarteCarburant cartecarburant = new CarteCarburant();
                cartecarburant.setId(resultSet.getInt("idcarte"));
                cartecarburant.setKmUtilisation(resultSet.getInt("kmutilisation"));
                cartecarburant.setLitreCarburant(resultSet.getInt("litrecarburant"));
                cartecarburant.setLesUtilisations(selectListeUtilisationCartePourCarteCarburant(cartecarburant.getId()));
                allCarteCarburant.add(cartecarburant);
            }
            System.out.println(allCarteCarburant);
            return allCarteCarburant;
        } catch (Exception e) {
            return null;

        }

    }

    public static boolean updateCarteCarburant(CarteCarburant carte) {
        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("update cartecarburant set kmutilisation = ?,litrecarburant = ? where circuit.idcarte = ?");
            preparedStatement.setInt(1, carte.getKmUtilisation());
            preparedStatement.setInt(2, carte.getLitreCarburant());
            preparedStatement.setInt(3, carte.getId());

            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static List<UtilisationCarte> selectListeUtilisationCartePourCarteCarburant(int carteCarburantId) {

        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select * from carburant_utilisation join utilisationcarte on carburant_utilisation.idutilisation = utilisationcarte.idutilisation where idcarte = ?");
            preparedStatement.setInt(1, carteCarburantId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<UtilisationCarte> allUtilisationCarte = new ArrayList<UtilisationCarte>();
            while (resultSet.next()) {
                UtilisationCarte heure = new UtilisationCarte();
                heure.setIdutilisationcarte(resultSet.getInt("idutilisation"));
                heure.setDateutilisation(resultSet.getDate("dateutilisation"));

                allUtilisationCarte.add(heure);
            }
            return allUtilisationCarte;

        } catch (Exception e) {
            return null;
        }

    }

    public static boolean deleteCarteCarburant(CarteCarburant carte) {
        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("update cartecarburant set supprimecartecarburant = 1 where cartecarburant.idcarte = ?");
            preparedStatement.setInt(1, carte.getId());
            preparedStatement.executeUpdate();

            return true;
        } catch (Exception e) {
            return false;

        }

    }
}
