/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.db;

import be.isfce.tfe.metier.Circuit;
import be.isfce.tfe.metier.DocumentAdministratif;
import be.isfce.tfe.metier.Entretien;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author yema
 */
public class EntretienDao {

    public static boolean addEntretien(Entretien entretien) {
        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("Insert into entretien (identretien,description,kmentretienfait,dateentretien,id) values (? , ?, ?,?,?)");
            preparedStatement.setInt(1, entretien.getId());
            preparedStatement.setString(2, entretien.getDescription());
            preparedStatement.setInt(3, entretien.getKmEntretienFait());
            preparedStatement.setDate(4, new Date(entretien.getDateEntretien().getTime()));
            preparedStatement.setString(5, entretien.getIdmaterielroulant());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public static List<Entretien> getTousLesEntretiens() {
        return getTousLesEntretiens(false);
    }

    public static List<Entretien> getTousLesEntretienssarchives() {
        return getTousLesEntretiens(true);
    }

    public static List<Entretien> getTousLesEntretiens(boolean entretienSupprimes) {
        try {
            String supprimesentretiens = entretienSupprimes ? "1" : "0";
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select * from entretien where supprimeentretien = " + supprimesentretiens);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Entretien> allEntretien = new ArrayList<Entretien>();
            while (resultSet.next()) {
                Entretien entretien = new Entretien();
                entretien.setId(resultSet.getInt("identretien"));
                entretien.setDescription(resultSet.getString("description"));
                entretien.setKmEntretienFait(resultSet.getInt("kmentretienfait"));
                entretien.setDateEntretien(resultSet.getDate("dateentretien"));
                entretien.setIdmaterielroulant(resultSet.getString("id"));

                allEntretien.add(entretien);
            }
            System.out.println(allEntretien);
            return allEntretien;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static List<Entretien> getTousLesEntretiens(java.util.Date date) {
        try {
            Date dateSql = new Date(date.getTime());
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select * from entretien where dateentretien = ?");
            preparedStatement.setDate(1, dateSql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Entretien> allEntretien = new ArrayList<Entretien>();
            while (resultSet.next()) {
                Entretien entretien = new Entretien();
                entretien.setId(resultSet.getInt("identretien"));
                entretien.setDescription(resultSet.getString("description"));
                entretien.setKmEntretienFait(resultSet.getInt("kmentretienfait"));
                entretien.setDateEntretien(resultSet.getDate("dateentretien"));
                entretien.setIdmaterielroulant(resultSet.getString("id"));

                allEntretien.add(entretien);
            }
            System.out.println(allEntretien);
            return allEntretien;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static boolean updateEntretien(Entretien entretien) {
        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("update entretien set description = ?,kmentretienfait = ?,dateentretien = ? where entretien.identretien = ?");
            preparedStatement.setString(1, entretien.getDescription());
            preparedStatement.setInt(2, entretien.getKmEntretienFait());
            preparedStatement.setDate(3, new Date(entretien.getDateEntretien().getTime()));
            preparedStatement.setInt(4, entretien.getId());

            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean deleteEntretien(Entretien entretien) {
        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("update entretien set supprimeentretiens = 1 where entretien.identretien = ?");
            preparedStatement.setInt(1, entretien.getId());
            preparedStatement.execute();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
