/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.db;

import be.isfce.tfe.metier.Amendes;
import be.isfce.tfe.metier.Circuit;
import be.isfce.tfe.metier.DocumentAdministratif;
import be.isfce.tfe.metier.Entretien;
import be.isfce.tfe.metier.MaterielRoulant;
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
public class MaterielRoulantDao {

    public static boolean addMaterielRoulant(MaterielRoulant vehicule) {

        try {
            Date dateSql = new Date(vehicule.getAnneedeconstruction().getTime());
            Date dateSqla = new Date(vehicule.getDateexctincteur().getTime());

            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("Insert into materielroulant (id,marque,idtypemateriel,anneedeconstruction,carburant,numimmatr,nbdeplaces,kmactuel,validiterexctincteur) VALUES (? , ?, ?,?,?,?,?,?,?)");
            preparedStatement.setString(1, vehicule.getId());

            preparedStatement.setString(2, vehicule.getMarque());
            preparedStatement.setInt(3,vehicule.getIdtypemateriel());
            preparedStatement.setDate(4, dateSql);
            preparedStatement.setString(5, vehicule.getCarburant());
            preparedStatement.setString(6, vehicule.getNumImmatr());
            preparedStatement.setInt(7, vehicule.getNbDePlaces());
            preparedStatement.setInt(8, vehicule.getKmactuel());
            preparedStatement.setDate(9, dateSqla);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<MaterielRoulant> getTousLesVehicules() {
        return getTousLesMaterielRoulant(false);
    }

    public static List<MaterielRoulant> getTousLesVehiculesarchives() {
        return getTousLesMaterielRoulant(true);
    }

    private static List<MaterielRoulant> getTousLesMaterielRoulant(boolean vehiculeSupprimes) {
        try {
            String supprimesmateriel = vehiculeSupprimes ? "1" : "0";
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select * from materielroulant where supprimematerielroulant = " + supprimesmateriel);

            ResultSet resultSet = preparedStatement.executeQuery();
            List<MaterielRoulant> allMaterielRoulant = new ArrayList<MaterielRoulant>();
            while (resultSet.next()) {
                MaterielRoulant vehicule = new MaterielRoulant();
                vehicule.setId(resultSet.getString("id"));
                vehicule.setMarque(resultSet.getString("marque"));
                vehicule.setIdtypemateriel(resultSet.getInt("idtypemateriel"));
                vehicule.setAnneedeconstruction(resultSet.getDate("anneedeconstruction"));
                vehicule.setCarburant(resultSet.getString("carburant"));
                vehicule.setNumImmatr(resultSet.getString("numimmatr"));
                vehicule.setNbDePlaces(resultSet.getInt("nbdeplaces"));
                vehicule.setKmactuel(resultSet.getInt("kmactuel"));
                vehicule.setDateexctincteur(resultSet.getDate("validiterexctincteur"));
              
                vehicule.setLesEntretiens(selectListeEntretienPourMaterielRoulant(vehicule.getId()));
                vehicule.setLesdocuments(selectListeDocumentsPourMaterielRoulant(vehicule.getId()));
                vehicule.setLesMemos(selectListeUtilisationCartePourMaterielRoulant(vehicule.getId()));

                allMaterielRoulant.add(vehicule);

            }
            System.out.println(allMaterielRoulant);
            return allMaterielRoulant;
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean updateMaterielRoulant(MaterielRoulant vehicule) {
        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("update materielroulant set marque = ?,type = ?,anneedeconstruction = ?,carburant = ?,numimmatr = ?,nbdeplaces = ?,kmactuel = ?,validiterexctincteur = ? where materielroulant.id = ?");
            preparedStatement.setString(1, vehicule.getMarque());
            preparedStatement.setInt(2,vehicule.getIdtypemateriel());
            preparedStatement.setDate(3, new Date(vehicule.getAnneedeconstruction().getTime()));
            preparedStatement.setString(4, vehicule.getCarburant());
            preparedStatement.setString(5, vehicule.getNumImmatr());
            preparedStatement.setInt(6, vehicule.getNbDePlaces());
            preparedStatement.setInt(7, vehicule.getKmactuel());
            preparedStatement.setDate(8, new Date(vehicule.getDateexctincteur().getTime()));
            preparedStatement.setString(9, vehicule.getId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static List<Entretien> selectListeEntretienPourMaterielRoulant(String materielRoulantId) {
        try {

            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select * from entretien join materielroulant on entretien.id = materielroulant.id where materielroulant.id = ?");
            preparedStatement.setString(1, materielRoulantId);
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
            //System.out.println(allEntretien);
            return allEntretien;

        } catch (Exception e) {
            return null;
        }

    }
    
    
     public static List<Amendes> selectListeAmendesPourMaterielRoulant(String materielRoulantId) {
        try {

            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select * from amendes join materielroulant on amendes.idamendes = materielroulant.id where materielroulant.id = ?");
            preparedStatement.setString(1, materielRoulantId);
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
        
            return allAmendes;

        } catch (Exception e) {
            return null;
        }

    }


    public static List<UtilisationCarte> selectListeUtilisationCartePourMaterielRoulant(String materielRoulantIdb) {

        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select * from utilisationcarte where id = ?");
            preparedStatement.setString(1, materielRoulantIdb);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<UtilisationCarte> allUtilisationCarte = new ArrayList<UtilisationCarte>();
            while (resultSet.next()) {
                UtilisationCarte heure = new UtilisationCarte();
                heure.setIdutilisationcarte(resultSet.getInt("idutilisation"));
                heure.setDateutilisation(resultSet.getDate("dateutilisation"));
                heure.setLitrecarburant(resultSet.getInt("litrecarburant"));
                heure.setKmutilisation(resultSet.getInt("kmutilisation"));
                heure.setIdcartecarburant(resultSet.getInt("idcarte"));
                allUtilisationCarte.add(heure);
            }
            // System.out.println(allUtilisationCarte);
            return allUtilisationCarte;

        } catch (Exception e) {
            return null;
        }

    }

    public static List<DocumentAdministratif> selectListeDocumentsPourMaterielRoulant(String materielRoulantIdc) {

        try {

            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select * from  documentsadministratifs join  materielroulant  on documentsadministratifs.id = materielroulant.id where materielroulant.id = ?");
            preparedStatement.setString(1, materielRoulantIdc);
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
            //  System.out.println(allDocuments);
            return allDocuments;

        } catch (Exception e) {
            return null;
        }
    }

    public static List<Circuit> getTousLesCircuitsPourMaterielRoulants(String materielroulantId) {
        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select * from circuit join materielroulant on circuit.idcircuit = materielroulant.id where materielroulant.id = ?");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Circuit> allCircuit = new ArrayList<Circuit>();
            while (resultSet.next()) {
                Circuit circuit = new Circuit();
                circuit.setId(resultSet.getInt("idcircuit"));
                circuit.setNomCircuit(resultSet.getString("nomcircuit"));
                circuit.setTempsprevu(resultSet.getTimestamp("tempsprevu"));

                circuit.setIdmaterielroulant(resultSet.getString("id"));
                allCircuit.add(circuit);
            }
            System.out.println(allCircuit);
            return allCircuit;

        } catch (Exception e) {
            return null;
        }
    }

    public static List<Trajet> selectTrajetsPourMaterielRoulant(String materielroulantID) {
        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select * from trajets join materielroulant on trajets.idtrajets= materielroulant.id where materielroulant.id = ?");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Trajet> allTrajets = new ArrayList<Trajet>();
            while (resultSet.next()) {
                Trajet heure = new Trajet();
                heure.setIdtrajets(resultSet.getInt("idtrajets"));
                heure.setHeurededebut(resultSet.getTimestamp("heurededebut"));
                heure.setHeuredefin(resultSet.getTimestamp("heuredefin"));
                heure.setDateTravail(resultSet.getDate("datetravail"));
                heure.setIdmaterielroulant(resultSet.getString("id"));
                allTrajets.add(heure);
            }
            System.out.println(allTrajets);
            return allTrajets;

        } catch (Exception e) {
            return null;
        }
    }

    public static boolean deleteMaterielRoulant(MaterielRoulant vehicule) {
        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("update materielroulant set supprimematerielroulant = 1 where materielroulant.id= ?");
            preparedStatement.setString(1, vehicule.getId());
            preparedStatement.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static int getNbEntretiensAEffectuer() {
        List<MaterielRoulant> tousLesVehicules = getTousLesVehicules();
        int entretienAEffectuer = 0;
        for (MaterielRoulant vehicule : tousLesVehicules) {
            Entretien dernierEntretien = getDernierEntretien(vehicule);
            if (dernierEntretien != null) {
                if (vehicule.getKmactuel() - dernierEntretien.getKmEntretienFait() > 25000) {
                    entretienAEffectuer++;
                }
            } else {
                if (vehicule.getKmactuel() > 25000) {
                    entretienAEffectuer++;
                }
            }
        }
        return entretienAEffectuer;
    }

    public static int getNbEntretiensEnOrdre() {
        List<MaterielRoulant> tousLesVehicules = getTousLesVehicules();
        int entretienAEffectuer = 0;
        for (MaterielRoulant vehicule : tousLesVehicules) {
            Entretien dernierEntretien = getDernierEntretien(vehicule);
            if (dernierEntretien != null) {
                if (vehicule.getKmactuel() - dernierEntretien.getKmEntretienFait() <= 20000) {
                    entretienAEffectuer++;
                }
            } else {
                if (vehicule.getKmactuel()  <= 20000) {
                    entretienAEffectuer++;
                }
            }
        }
        return entretienAEffectuer;
    }

    private static Entretien getDernierEntretien(MaterielRoulant materielRoulant) {
        List<Entretien> lesentretiens = materielRoulant.getLesentretiens();
        java.util.Date date = new Date(0);
        Entretien dernierEntretien = null;
        for (Entretien entretien : lesentretiens) {
            if (entretien.getDateEntretien().after(date)) {
                date = entretien.getDateEntretien();
                dernierEntretien = entretien;
            }
        }
        return dernierEntretien;
    }

    private static int getConsommationPourVehicule(MaterielRoulant vehicule, int mois, int annee) {
        List<UtilisationCarte> tousLesUtilisationCarte = UtilisationCarteDao.getTousLesUtilisationCarte();
        List<UtilisationCarte> utilisations = new ArrayList<UtilisationCarte>();
        for (UtilisationCarte utilisationCarte : tousLesUtilisationCarte) {
            if (utilisationCarte.getIdvehicule().equals(vehicule.getId()) && utilisationCarte.getDateUtilisation().getMonth() == mois && utilisationCarte.getDateUtilisation().getYear() == annee) {
                utilisations.add(utilisationCarte);
            }
        }
        //TODO Terminer la logique
        for (UtilisationCarte utilisationCarte : utilisations) {
        }

        return 0;
    }
}
