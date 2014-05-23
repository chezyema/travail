/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.db;

import be.isfce.tfe.metier.Chauffeur;
import be.isfce.tfe.metier.Trajet;
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
public class TrajetDBHelper {

    public static boolean addTrajets(Trajet horaire) {
        try {
            System.out.println(horaire.toString());
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("Insert into trajets (idtrajets,heurededebut,heuredefin,datetravail,idchauffeur,idcircuit,id) values( ?, ?, ?,?,?,?,?)");
            preparedStatement.setInt(1, horaire.getIdtrajets());
            preparedStatement.setString(2, horaire.getHeureDeDebut());
            preparedStatement.setString(3, horaire.getHeureDeFin());
            preparedStatement.setDate(4, new Date(horaire.getDateTravail().getTime()));
            preparedStatement.setString(5, horaire.getIdchauffeur());
            preparedStatement.setInt(6, horaire.getIdcircuit());
            preparedStatement.setString(7, horaire.getIdmaterielroulant());
            preparedStatement.executeUpdate();
            Connexion.getInstance().getConn().commit();
            return true;
        } catch (Exception e) {
            return false;
        }

    }
      public static List<Trajet> getTousLesTrajets() {
        return getTousLesTrajets(false);
    }

    public static List<Trajet> getTousLesTrajetssarchives() {
        return getTousLesTrajets(true);
    }

    public static List<Trajet> getTousLesTrajets(boolean trajetsSupprimes) {
        try {
            String supprimestrajet = trajetsSupprimes ? "1" : "0";
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select * from trajets where supprimetrajets = " + supprimestrajet);

            ResultSet resultSet = preparedStatement.executeQuery();
            List<Trajet> allTrajets = new ArrayList<Trajet>();
            while (resultSet.next()) {
                Trajet heure = new Trajet();
                heure.setIdtrajets(resultSet.getInt("idtrajets"));
                heure.setHeureDeDebut(resultSet.getString("heurededebut"));
                heure.setHeureDeFin(resultSet.getString("heuredefin"));
                heure.setDateTravail(resultSet.getDate("datetravail"));
                heure.setIdchauffeur(resultSet.getString("idchauffeur"));
                heure.setIdcircuit(resultSet.getInt("idcircuit"));
                heure.setIdmaterielroulant(resultSet.getString("id"));
                allTrajets.add(heure);
            }
            System.out.println(allTrajets);
            return allTrajets;

        } catch (Exception e) {
            return null;
        }
    }
    
       public static boolean updateChauffeur(Trajet trajet) {
       try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("update trajets set heurededebut = ?,heuredefin = ?,datetravail = ? where trajets.idtrajets = ?");
            preparedStatement.setString(1, trajet.getHeureDeDebut());
            preparedStatement.setString(2, trajet.getHeureDeFin());
            preparedStatement.setDate(3, new Date(trajet.getDateTravail().getTime()));
            preparedStatement.setInt(4, trajet.getIdtrajets());
          
            preparedStatement.execute();
            Connexion.getInstance().getConn().commit();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean deleteTrajets(Trajet idtrajets) {
        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("update trajets set supprimetrajets = 1 where trajets.idtrajets = ?");
            preparedStatement.setInt(1, idtrajets.getIdtrajets());
            preparedStatement.execute();
            Connexion.getInstance().getConn().commit();

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
