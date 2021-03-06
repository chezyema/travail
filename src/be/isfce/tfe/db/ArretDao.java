/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.db;

import be.isfce.tfe.metier.Arret;
import be.isfce.tfe.metier.Circuit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yema
 */
public class ArretDao {

    public static boolean addArret(Arret arret) {
        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("Insert into arrets (idarrets,adressearrets,codepostal,ville) values (?,?, ?, ?)");
            preparedStatement.setInt(1, arret.getId());
            preparedStatement.setString(2, arret.getAdresse());
            preparedStatement.setInt(3,arret.getCodepostale());
            preparedStatement.setString(4,arret.getVille());
            preparedStatement.executeUpdate();
            int dernierIdGenere = getDernierIdGenere();
            arret.setId(dernierIdGenere);
            List<Circuit> lescircuits = arret.getLescircuits();
            for (Circuit circuit : lescircuits) {
                lie(arret, circuit);
            }
            return true;
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

    public static List<Arret> getTousLesArrets() {
        return getTousLesArrets(false);
    }

    public static List<Arret> getTousLesArretsarchives() {
        return getTousLesArrets(true);
    }

    public static List<Arret> getTousLesArrets(boolean arretsSupprimes) {
        try {
            String supprimes = arretsSupprimes ? "1" : "0";
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select * from arrets where supprimearrets = " + supprimes);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Arret> allArret = new ArrayList<Arret>();
            while (resultSet.next()) {
                Arret arret = new Arret();
                arret.setId(resultSet.getInt("idarrets"));
                arret.setAdresse(resultSet.getString("adressearrets"));
                arret.setCodepostale(resultSet.getInt("codepostal"));
                arret.setVille(resultSet.getString("ville"));
                arret.setLesCircuits(selectListeCircuitPourArret(arret.getId()));
                arret.setNumeroOrdre(resultSet.getInt("numeroordre"));
                
                System.out.println(arret);
                allArret.add(arret);
            }
            //System.out.println(allArret);
            return allArret;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    public static boolean updateArret(Arret arret) {
        //TODO implémenter la méthode
        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("update arrets set adressearrets = ?,codepostal = ?,ville = ?, numeroordre = ? where arrets.idarrets = ?");
            preparedStatement.setString(1, arret.getAdresse());
            preparedStatement.setInt(2, arret.getCodepostale());
            preparedStatement.setString(3, arret.getVille());
            preparedStatement.setInt(4, arret.getNumeroOrdre());
            preparedStatement.setInt(5, arret.getId());

            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Circuit> selectListeCircuitPourArret(int arretId) {

        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select * from contient join circuit on contient.idcircuit = circuit.idcircuit where idarrets = ?");
            preparedStatement.setInt(1, arretId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Circuit> allCircuit = new ArrayList<Circuit>();
            while (resultSet.next()) {
                Circuit circuit = new Circuit();
                circuit.setId(resultSet.getInt("idcircuit"));
                circuit.setNomCircuit(resultSet.getString("nomcircuit"));
                circuit.setTempsprevu(resultSet.getTimestamp("tempsprevu"));
                
                allCircuit.add(circuit);
            }
            //System.out.println(allCircuit);
            return allCircuit;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static boolean deleteArret(Arret arrets) {
        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("update arrets set supprimearrets = 1 where arrets.idarrets = ?");
            preparedStatement.setInt(1, arrets.getId());
            preparedStatement.executeUpdate();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static int getDernierIdGenere() {
        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select max(last_insert_id()) as last_id from tfe.arrets");
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static boolean lie(Arret arret, Circuit circuit) {
        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("Insert into contient(idcircuit,idarrets) values (?,?)");
            preparedStatement.setInt(1, circuit.getId());
            preparedStatement.setInt(2, arret.getId());
            preparedStatement.executeUpdate();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
