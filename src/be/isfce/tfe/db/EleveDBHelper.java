/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.db;

import be.isfce.tfe.metier.Chauffeur;
import be.isfce.tfe.metier.Eleve;
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
public class EleveDBHelper {

    public static boolean addEleve(Eleve eleve) {

        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("Insert into eleve (ideleve,nomeleve,prenomeleve,datedenaissance,adresseeleve,codepostal,ville,nomresponsable,telresponsable,emailresponsable) VALUES (? , ?, ?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, eleve.getId());
            preparedStatement.setString(2, eleve.getNomEleve());
            preparedStatement.setString(3, eleve.getPrenomEleve());
            preparedStatement.setDate(4, new Date(eleve.getDatedenaissance().getTime()));
            preparedStatement.setString(5, eleve.getAdresseEleve());
            preparedStatement.setInt(6, eleve.getCdpostal());
            preparedStatement.setString(7, eleve.getVil());
            preparedStatement.setString(8, eleve.getNomResponsable());
            preparedStatement.setString(9, eleve.getTelResponsable());
            preparedStatement.setString(10, eleve.getEmailResponsable());

            preparedStatement.executeUpdate();
            Connexion.getInstance().getConn().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
       public static List<Eleve> getTousLesEleves() {
        return getTousLesEleves(false);
    }

    public static List<Eleve> getTousLesElevesarchives() {
        return getTousLesEleves(true);
    }


    public static List<Eleve> getTousLesEleves(boolean elevesSupprimes) {

        try {
             String supprimes = elevesSupprimes ? "1" : "0";
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select * from eleve where supprimeeleve = " + supprimes);
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
            System.out.println(allEleve);
            return allEleve;
        } catch (Exception e) {
            return null;
        }
    }
    
   public static boolean updateEleve(Eleve eleve) {
       try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("update eleve set nomeleve = ?,prenomeleve = ?,datedenaissance = ?,adresseeleve = ?,codepostal = ?,ville = ?,nomresponsable = ?,telresponsable = ?,emailresponsable = ? where eleve.ideleve = ?");
            preparedStatement.setString(1, eleve.getNomEleve());
            preparedStatement.setString(2, eleve.getPrenomEleve());
            preparedStatement.setDate(3, new Date(eleve.getDatedenaissance().getTime()));
            preparedStatement.setString(4, eleve.getAdresseEleve());
            preparedStatement.setInt(5, eleve.getCdpostal());
            preparedStatement.setString(6, eleve.getVil());
            preparedStatement.setString(7, eleve.getNomResponsable());
            preparedStatement.setString(8, eleve.getTelResponsable());
            preparedStatement.setString(9, eleve.getEmailResponsable());
            preparedStatement.setString(10,eleve.getId());
            preparedStatement.execute();
            Connexion.getInstance().getConn().commit();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
   
    public static boolean deleteEleve(Eleve eleve){
            try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("update eleve set supprimeeleve = 1 where eleve.ideleve = ?");
            preparedStatement.setString(1, eleve.getId());
            preparedStatement.execute();
            Connexion.getInstance().getConn().commit();

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

