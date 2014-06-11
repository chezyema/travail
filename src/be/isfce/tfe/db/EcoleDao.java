/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.db;

import be.isfce.tfe.metier.Circuit;
import be.isfce.tfe.metier.Ecole;
import be.isfce.tfe.metier.Eleve;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yema
 */
public class EcoleDao {

    public static boolean addEcole(Ecole ecole) {

        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("Insert into ecole (idecole,nomecole,adresseecole,cdpostal,vil,telecole,emailecole,nomdirecteur) VALUES (? , ?, ?,?,?,?,?,?)");
            preparedStatement.setInt(1, ecole.getId());
            preparedStatement.setString(2, ecole.getNomecole());
            preparedStatement.setString(3, ecole.getAdresseecole());
            preparedStatement.setInt(4, ecole.getCdpostal());
            preparedStatement.setString(5, ecole.getVil());
            preparedStatement.setString(6, ecole.getTelecole());
            preparedStatement.setString(7, ecole.getEmailecole());
            preparedStatement.setString(8, ecole.getNomdirecteur());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public static List<Ecole> getTousLesEcoles() {
        return getTousLesEcole(false);
    }

    public static List<Ecole> getTousLesEcolesarchives() {
        return getTousLesEcole(true);
    }

    public static List<Ecole> getTousLesEcole(boolean ecolessupprimes) {

        try {
            String supprimesecoles = ecolessupprimes ? "1" : "0";
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select * from ecole where supprimeecole =" + supprimesecoles);

            List<Ecole> allEcole = new ArrayList<Ecole>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Ecole ecole = new Ecole();
                ecole.setId(resultSet.getInt("idecole"));
                ecole.setNomecole(resultSet.getString("nomecole"));
                ecole.setAdresseecole(resultSet.getString("adresseecole"));
                ecole.setCdpostal(resultSet.getInt("cdpostal"));
                ecole.setVil(resultSet.getString("vil"));
                ecole.setTelecole(resultSet.getString("telecole"));
                ecole.setEmailecole(resultSet.getString("emailecole"));
                ecole.setNomdirecteur(resultSet.getString("nomdirecteur"));
                ecole.setLescircuits(selectListeCircuitPourEcole(ecole.getId()));
                ecole.setLeseleves(selectListeElevePourEcole(ecole.getId()));
                allEcole.add(ecole);

            }
            System.out.println(allEcole);
            return allEcole;
        } catch (Exception e) {
            return null;
        }
    }
    
       public static boolean updateEcole(Ecole ecole) {
        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("update ecole set nomecole = ?,adresseecole = ?,cdpostal = ?,vil = ?,telecole = ?,emailecole = ?,nomdirecteur = ? where ecole.idecole = ?");
            preparedStatement.setString(1, ecole.getNomecole());
            preparedStatement.setString(2, ecole.getAdresseecole());
            preparedStatement.setInt(3, ecole.getCdpostal());
            preparedStatement.setString(4, ecole.getVil());
            preparedStatement.setString(5, ecole.getTelecole());
            preparedStatement.setString(6,ecole.getEmailecole() );
            preparedStatement.setString(7, ecole.getNomdirecteur());
            preparedStatement.setInt(8, ecole.getId());
           
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static List<Eleve> selectListeElevePourEcole(int ecoleId) {

        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select * from eleve join ecole on eleve.idecole = ecole.idecole where ecole.idecole = ?");
            preparedStatement.setInt(1, ecoleId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Eleve> allEleve = new ArrayList<Eleve>();
            while (resultSet.next()) {
                Eleve eleve = new Eleve();
                eleve.setId(resultSet.getString("ideleve"));
                eleve.setNomEleve(resultSet.getString("nomeleve"));
                eleve.setPrenomEleve(resultSet.getString("prenomeleve"));
                eleve.setDatedenaissance(resultSet.getDate("datedenaissance"));
                eleve.setAdresseEleve(resultSet.getString("adresseeleve"));
                eleve.setCdpostal(resultSet.getInt("codepostal"));
                eleve.setVil(resultSet.getString("ville"));
                eleve.setNomResponsable(resultSet.getString("nomresponsable"));
                eleve.setTelResponsable(resultSet.getString("telresponsable"));
                eleve.setEmailResponsable(resultSet.getString("emailresponsable"));
                eleve.setIdcircuit(resultSet.getInt("idcircuit"));
                eleve.setIdecole(resultSet.getInt("idecole"));
                allEleve.add(eleve);

            }
            //System.out.println(allEleve);
            return allEleve;
        } catch (Exception e) {
            return null;
        }
    }
    
    
     public static List<Circuit> selectListeCircuitPourEcole(int ecoleId) {

        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select * from circuit where idecole = ?");
            preparedStatement.setInt(1, ecoleId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Circuit> allCircuit = new ArrayList<Circuit>();
            while (resultSet.next()) {
                Circuit circuit = new Circuit();
                circuit.setId(resultSet.getInt("idcircuit"));
                circuit.setNomCircuit(resultSet.getString("nomcircuit"));
                circuit.setTempsprevu(resultSet.getTimestamp("tempsprevu"));
               
                allCircuit.add(circuit);
            }
            return allCircuit;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static boolean deleteEcole(Ecole ecole) {

        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("update ecole set supprimeecole = 1 where ecole.idecole = ?");
            preparedStatement.setInt(1, ecole.getId());
            preparedStatement.execute();

            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
