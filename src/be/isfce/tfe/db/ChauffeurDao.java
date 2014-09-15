/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.db;

import be.isfce.tfe.metier.Amende;
import be.isfce.tfe.metier.Chauffeur;
import be.isfce.tfe.metier.Circuit;
import be.isfce.tfe.metier.DocumentAdministratif;
import be.isfce.tfe.metier.Trajet;
import be.isfce.tfe.metier.UtilisationCarte;
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
public class ChauffeurDao {

    public static boolean addChauffeur(Chauffeur chauffeur) {

        try {
            Date dateSql = new Date(chauffeur.getDateNaissance().getTime());

            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("Insert into chauffeur (idchauffeur,nom,prenom,datenaissance,sexe,adresse,codepostal,ville,numtelephone,email,numcartesis,numpermis) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1, chauffeur.getId());

            preparedStatement.setString(2, chauffeur.getNomChauffeur());
            preparedStatement.setString(3, chauffeur.getPrenomChauffeur());
            preparedStatement.setDate(4, dateSql);
            preparedStatement.setString(5, chauffeur.getSexe());
            preparedStatement.setString(6, chauffeur.getAdresse());
            preparedStatement.setInt(7, chauffeur.getCodepostale());
            preparedStatement.setString(8, chauffeur.getVille());
            preparedStatement.setString(9, chauffeur.getNumTelephone());
            preparedStatement.setString(10, chauffeur.getEmail());
            preparedStatement.setString(11, chauffeur.getNumcartesis());
            preparedStatement.setString(12, chauffeur.getNumpermis());

            preparedStatement.executeUpdate();

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

    public static Chauffeur getChauffeur(String id) {
        List<Chauffeur> tousLesChauffeurs = getTousLesChauffeurs();
        for (Chauffeur chauffeur : tousLesChauffeurs) {
            if (chauffeur.getId().equals(id)) {
                return chauffeur;
            }
        }
        return null;
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
                chauffeur.setSexe(resultSet.getString("sexe"));
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
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("update chauffeur set nom = ?,prenom = ?,datenaissance = ?,sexe = ?,adresse = ?,codepostal = ?,ville = ?,numtelephone = ?,email = ?,numcartesis = ?, numpermis = ? where chauffeur.idchauffeur = ?");
            preparedStatement.setString(1, chauffeur.getNomChauffeur());
            preparedStatement.setString(2, chauffeur.getPrenomChauffeur());
            preparedStatement.setDate(3, new Date(chauffeur.getDateNaissance().getTime()));
            preparedStatement.setString(4, chauffeur.getSexe());
            preparedStatement.setString(5, chauffeur.getAdresse());
            preparedStatement.setInt(6, chauffeur.getCodepostale());
            preparedStatement.setString(7, chauffeur.getVille());
            preparedStatement.setString(8, chauffeur.getNumTelephone());
            preparedStatement.setString(9, chauffeur.getEmail());
            preparedStatement.setString(10, chauffeur.getNumcartesis());
            preparedStatement.setString(11, chauffeur.getNumpermis());
            preparedStatement.setString(12, chauffeur.getId());
            preparedStatement.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
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
                circuit.setTempsprevu(resultSet.getTimestamp("tempsprevu"));

                allCircuit.add(circuit);
            }
            return allCircuit;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static List<Amende> selectListeAmendesPourChauffeur(String chauffeurId) {
        try {

            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select * from amendes join chauffeur on amendes.id = chauffeur.idchauffeur where chauffeur.idchauffeur = ?");
            preparedStatement.setString(1, chauffeurId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Amende> allAmendes = new ArrayList<Amende>();
            while (resultSet.next()) {
                Amende amende = new Amende();
                amende.setIdamendes(resultSet.getInt("idamende"));
                amende.setNumeropv(resultSet.getString("numeropv"));
                amende.setDatepv(resultSet.getDate("datepv"));
                amende.setMontantpv(resultSet.getInt("montantpv"));
                amende.setIdmaterielroulant(resultSet.getString("id"));
                amende.setIdchauffeur(resultSet.getString("idchauffeur"));

                allAmendes.add(amende);
            }

            return allAmendes;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static List<DocumentAdministratif> selectListeDocumentsPourChauffeur(String chauffeurIdb) {

        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select * from documentsadministratifs inner join chauffeur on documentsadministratifs.idchauffeur = chauffeur.idchauffeur inner join type on documentsadministratifs.idtype = type.idtype where chauffeur.idchauffeur = ?");
            preparedStatement.setString(1, chauffeurIdb);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<DocumentAdministratif> allDocuments = new ArrayList<DocumentAdministratif>();
            while (resultSet.next()) {
                DocumentAdministratif documents = new DocumentAdministratif();
                documents.setId(resultSet.getInt("iddocument"));
                documents.setDateValiditer(resultSet.getDate("datevaliditer"));
                documents.setIdmaterielroulant(resultSet.getString("id"));
                documents.setIdchauffeur(resultSet.getString("idchauffeur"));
                documents.setIdtype(resultSet.getInt("idtype"));

                allDocuments.add(documents);
            }
            return allDocuments;
        } catch (Exception e) {
            e.printStackTrace();
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
                heure.setHeurededebut(resultSet.getTimestamp("heurededebut"));
                heure.setHeuredefin(resultSet.getTimestamp("heuredefin"));
                heure.setDateTravail(resultSet.getDate("datetravail"));
                heure.setKmdepart(resultSet.getInt("kmdepart"));
                heure.setKmfin(resultSet.getInt("kmfin"));

                allHeureDeTravail.add(heure);
            }
            return allHeureDeTravail;

        } catch (Exception e) {
            return null;
        }
    }

    public static List<UtilisationCarte> selectListeUtilisationCartePourChauffeur(String chauffeurId) {

        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select * from utilisationcarte where id = ?");
            preparedStatement.setString(1, chauffeurId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<UtilisationCarte> allUtilisationCarte = new ArrayList<UtilisationCarte>();
            while (resultSet.next()) {
                UtilisationCarte heure = new UtilisationCarte();
                heure.setIdutilisationcarte(resultSet.getInt("idutilisation"));
                heure.setDateutilisation(resultSet.getDate("dateutilisation"));
                heure.setLitrecarburant(resultSet.getInt("litrecarburant"));
                heure.setKmutilisation(resultSet.getInt("kmutilisation"));
                heure.setIdcartecarburant(resultSet.getInt("idcarte"));
                heure.setIdchauffeur(resultSet.getString("idchauffeur"));
                allUtilisationCarte.add(heure);
            }
            // System.out.println(allUtilisationCarte);
            return allUtilisationCarte;

        } catch (Exception e) {
            return null;
        }

    }

    public static boolean deleteChauffeur(Chauffeur chauffeur) {

        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("update chauffeur set supprimechauffeur = 1 where chauffeur.idchauffeur = ?");
            preparedStatement.setString(1, chauffeur.getId());
            preparedStatement.execute();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
