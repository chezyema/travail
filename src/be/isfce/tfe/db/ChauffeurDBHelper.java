/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.db;

import be.isfce.tfe.metier.Chauffeur;
import be.isfce.tfe.metier.Circuit;
import be.isfce.tfe.metier.DocumentAdministratif;
import be.isfce.tfe.metier.Trajet;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yema
 */
public class ChauffeurDBHelper {

    public static boolean addChauffeur(Chauffeur chauffeur) {

        try {
            Date dateSql = new Date(chauffeur.getDateNaissance().getTime());
          
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("Insert into chauffeur (idchauffeur,nom,prenom,datenaissance,adresse,codepostal,ville,numtelephone,email,numcartesis,numpermis) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, chauffeur.getId());

            preparedStatement.setString(2, chauffeur.getNomChauffeur());
            preparedStatement.setString(3, chauffeur.getPrenomChauffeur());
            preparedStatement.setDate(4, dateSql);
            preparedStatement.setString(5, chauffeur.getAdresse());
            preparedStatement.setInt(6, chauffeur.getCodepostale());
            preparedStatement.setString(7, chauffeur.getVille());
            preparedStatement.setString(8, chauffeur.getNumTelephone());
            preparedStatement.setString(9, chauffeur.getEmail());
            preparedStatement.setString(10,chauffeur.getNumcartesis());
            preparedStatement.setString(11, chauffeur.getNumpermis());
          
            preparedStatement.executeUpdate();
            Connexion.getInstance().getConn().commit();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static List<Chauffeur> getTousLesChauffeurs() {
        return getTousLesChauffeurs(false);
    }

    public static List<Chauffeur> getTousLesChauffeursarchives() {
        return getTousLesChauffeurs(true);
    }

    private static List<Chauffeur> getTousLesChauffeurs(boolean chauffeursSupprimes) {

        try {
            String supprimes = chauffeursSupprimes ? "1" : "0";
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select * from chauffeur where supprimechauffeur = " + supprimes);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Chauffeur> allChauffeurs = new ArrayList<Chauffeur>();
            while (resultSet.next()) {
                Chauffeur chauffeur = new Chauffeur();
                chauffeur.setId(resultSet.getString("idchauffeur"));
                chauffeur.setNomChauffeur(resultSet.getString("nom"));
                chauffeur.setPrenomChauffeur(resultSet.getString("prenom"));
                chauffeur.setDateNaissance(resultSet.getDate("datenaissance"));
                chauffeur.setAdresse(resultSet.getString("adresse"));
                chauffeur.setCodepostale(resultSet.getInt("codepostal"));
                chauffeur.setVille(resultSet.getString("ville"));
                chauffeur.setNumTelephone(resultSet.getString("numtelephone"));
                chauffeur.setEmail(resultSet.getString("email"));
                chauffeur.setNumcartesis(resultSet.getString("numcartesis"));
                chauffeur.setNumpermis(resultSet.getString("numpermis"));
                chauffeur.setLesCircuits(selectListeCircuitPourChauffeur(chauffeur.getId()));
                chauffeur.setLesdocuments(selectListeDocumentsPourChauffeur(chauffeur.getId()));
                chauffeur.setLesheures(selectListeTrajetsPourChauffeur(chauffeur.getId()));
                allChauffeurs.add(chauffeur);

            }
            return allChauffeurs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

  public static boolean updateChauffeur(Chauffeur chauffeur) {
        //TODO implémenter la méthode
        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("update chauffeur set nom = ?,prenom = ?,datenaissance = ?,adresse = ?,codepostal = ?,ville = ?,numtelephone = ?,email = ?,numcartesis = ?, numpermis = ? where chauffeur.idchauffeur = ?");
            preparedStatement.setString(1, chauffeur.getNomChauffeur());
            preparedStatement.setString(2, chauffeur.getPrenomChauffeur());
            preparedStatement.setDate(3, new Date(chauffeur.getDateNaissance().getTime()));
            preparedStatement.setString(4, chauffeur.getAdresse());
            preparedStatement.setInt(5, chauffeur.getCodepostale());
            preparedStatement.setString(6, chauffeur.getVille());
            preparedStatement.setString(7, chauffeur.getNumTelephone());
            preparedStatement.setString(8, chauffeur.getEmail());
            preparedStatement.setString(9,chauffeur.getNumcartesis());
            preparedStatement.setString(10, chauffeur.getNumpermis());
            preparedStatement.setString(11, chauffeur.getId());
            preparedStatement.execute();
            Connexion.getInstance().getConn().commit();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
  
    public static List<Circuit> selectListeCircuitPourChauffeur(String chauffeurId) {

        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select * from circuit where idchauffeur = ?");
            preparedStatement.setString(1, chauffeurId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Circuit> allCircuit = new ArrayList<Circuit>();
            while (resultSet.next()) {
                Circuit circuit = new Circuit();
                circuit.setId(resultSet.getInt("idcircuit"));
                circuit.setNomCircuit(resultSet.getString("nomcircuit"));
                circuit.setTempsPrevu(resultSet.getString("tempsprevu"));
                circuit.setKmDepart(resultSet.getInt("kmdepart"));
                circuit.setKmFin(resultSet.getInt("kmfin"));

                allCircuit.add(circuit);
            }
            return allCircuit;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static List<DocumentAdministratif> selectListeDocumentsPourChauffeur(String chauffeurIdb) {

        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select * from documentsadministratifs join chauffeur on  documentsadministratifs.idchauffeur = chauffeur.idchauffeur  where chauffeur.idchauffeur = ?");
            preparedStatement.setString(1, chauffeurIdb);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<DocumentAdministratif> allDocuments = new ArrayList<DocumentAdministratif>();
            while (resultSet.next()) {
                DocumentAdministratif documents = new DocumentAdministratif();
                documents.setId(resultSet.getInt("iddocument"));
                documents.setLibelle(resultSet.getString("libelle"));
                documents.setDateValiditer(resultSet.getDate("datevaliditer"));
                documents.setIdmaterielroulant(resultSet.getString("id"));
                documents.setIdchauffeur(resultSet.getString("idchauffeur"));

                allDocuments.add(documents);
            }
            return allDocuments;
        } catch (Exception e) {
            return null;
        }

    }

    public static List<Trajet> selectListeTrajetsPourChauffeur(String chauffeurIdc) {
        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select * from trajets where idchauffeur = ?");
            preparedStatement.setString(1, chauffeurIdc);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Trajet> allHeureDeTravail = new ArrayList<Trajet>();
            while (resultSet.next()) {
                Trajet heure = new Trajet();
                heure.setIdtrajets(resultSet.getInt("idtrajets"));
                heure.setHeureDeDebut(resultSet.getString("heurededebut"));
                heure.setHeureDeFin(resultSet.getString("heuredefin"));
                heure.setDateTravail(resultSet.getDate("datetravail"));

                allHeureDeTravail.add(heure);
            }
            return allHeureDeTravail;

        } catch (Exception e) {
            return null;
        }
    }

    public static boolean deleteChauffeur(Chauffeur chauffeur) {

        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("update chauffeur set supprime = 1 where chauffeur.idchauffeur = ?");
            preparedStatement.setString(1, chauffeur.getId());
            preparedStatement.execute();
            Connexion.getInstance().getConn().commit();

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}