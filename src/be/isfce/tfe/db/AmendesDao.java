/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.db;

import be.isfce.tfe.metier.Amendes;

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
public class AmendesDao {
    public static boolean addAmendes(Amendes amende) {
        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("Insert into amendes (idamende,numeropv,datepv,montantpv,id) values (? , ?, ?,?,?)");
            preparedStatement.setInt(1, amende.getIdamendes());
            preparedStatement.setString(2, amende.getNumeropv());
            preparedStatement.setDate(3, new Date(amende.getDatepv().getTime()));
            preparedStatement.setInt(4, amende.getMontantpv());
            preparedStatement.setString(5, amende.getIdmaterielroulant());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public static List<Amendes> getTousLesAmendes() {
        return getTousLesAmendes(false);
    }

    public static List<Amendes> getTousLesAmendessarchives() {
        return getTousLesAmendes(true);
    }

    public static List<Amendes> getTousLesAmendes(boolean amendesSupprimes) {
        try {
            String supprimesamendes = amendesSupprimes ? "1" : "0";
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select * from amendes where supprimeamendes = " + supprimesamendes);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Amendes> allAmendes = new ArrayList<Amendes>();
            while (resultSet.next()) {
                Amendes amende = new Amendes();
                amende.setIdamendes(resultSet.getInt("idamende"));
                amende.setNumeropv(resultSet.getString("numeropv"));
                amende.setDatepv(resultSet.getDate("datepv"));
                amende.setMontantpv(resultSet.getInt("montantpv"));
                amende.setIdmaterielroulant(resultSet.getString("id"));

                allAmendes.add(amende);
            }
            System.out.println(allAmendes);
            return allAmendes;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static List<Amendes> getTousLesAmendesParDate(java.util.Date date) {
        try {
            Date dateSql = new Date(date.getTime());
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select * from amendes where datepv = ?");
            preparedStatement.setDate(1, dateSql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Amendes> allAmendes = new ArrayList<Amendes>();
            while (resultSet.next()) {
                Amendes amende = new Amendes();
                amende.setIdamendes(resultSet.getInt("idamende"));
                amende.setNumeropv(resultSet.getString("numeropv"));
                amende.setDatepv(resultSet.getDate("datepv"));
                amende.setMontantpv(resultSet.getInt("montantpv"));
                amende.setIdmaterielroulant(resultSet.getString("id"));
                allAmendes.add(amende);
            }
            System.out.println(allAmendes);
            return allAmendes;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    
      public static List<Amendes> getTousLesAmendesParNumeroPv(java.util.Date date) {
        try {
            Amendes amende = new Amendes();
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select * from amendes where numeropv = ?");
            preparedStatement.setString(1,amende.getNumeropv());
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Amendes> allAmendes = new ArrayList<Amendes>();
            while (resultSet.next()) {
             
                amende.setIdamendes(resultSet.getInt("idamende"));
                amende.setNumeropv(resultSet.getString("numeropv"));
                amende.setDatepv(resultSet.getDate("datepv"));
                amende.setMontantpv(resultSet.getInt("montantpv"));
                amende.setIdmaterielroulant(resultSet.getString("id"));
                allAmendes.add(amende);
            }
            System.out.println(allAmendes);
            return allAmendes;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    
    
    
    
    

    public static boolean updateAmendes(Amendes amende) {
        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("update amendes set numeropv = ?,datepv = ?,montantpv = ? where amendes.idamende = ?");
            preparedStatement.setString(1, amende.getNumeropv());
            preparedStatement.setDate(2, new Date(amende.getDatepv().getTime()));
            preparedStatement.setInt(3, amende.getMontantpv());
            preparedStatement.setInt(4, amende.getIdamendes());

            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean deleteAmendes(Amendes amende) {
        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("update amendes set supprimeamendes = 1 where amendes.idamende = ?");
            preparedStatement.setInt(1, amende.getIdamendes());
            preparedStatement.execute();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
    
}
