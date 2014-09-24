/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.db;

import be.isfce.tfe.metier.Chauffeur;
import be.isfce.tfe.metier.Circuit;
import be.isfce.tfe.metier.DocumentAdministratif;
import be.isfce.tfe.metier.TypeDocument;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author yema
 */
public class DocumentAdministratifDao {

    public static boolean addDocumentsAdministratifs(DocumentAdministratif documents) {

        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("Insert into documentsadministratifs (iddocument,datevaliditer,id,idchauffeur,idtype) VALUES(? , ?, ?,?,?)");

            preparedStatement.setInt(1, documents.getId());

            preparedStatement.setDate(2, new Date(documents.getDateValiditer().getTime()));
            preparedStatement.setString(3, documents.getIdmaterielroulant());
            preparedStatement.setString(4, documents.getIdchauffeur());
            preparedStatement.setInt(5, documents.getIdtype());
            //ajouter les clés étrangére

            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public static List<DocumentAdministratif> getTousLesDocuments() {
        return getTousLesDocuments(false);
    }

    public static List<DocumentAdministratif> getTousLesDocumentsarchives() {
        return getTousLesDocuments(true);
    }

    public static List<DocumentAdministratif> getTousLesDocuments(boolean documentSupprimes) {
        try {
            String supprimes = documentSupprimes ? "1" : "0";

            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select * from documentsadministratifs where supprimedocument = " + supprimes);

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
            System.out.println(allDocuments);
            return allDocuments;

        } catch (Exception e) {
            return null;
        }

    }

    public static boolean updateDocuments(DocumentAdministratif document) {
        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("update documentsadministratifs set libelle = ?,datevaliditer = ? where documentsadministratifs.iddocument = ?");

            preparedStatement.setDate(2, new Date(document.getDateValiditer().getTime()));
            preparedStatement.setInt(3, document.getId());

            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteDocumentsAdministratifs(DocumentAdministratif documents) {

        try {
            System.out.println(documents.toString());
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("update documentsadministratifs set supprimedocument = 1 where documentsadministratifs.iddocument = ?");
            preparedStatement.setInt(1, documents.getId());
            preparedStatement.execute();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<DocumentAdministratif> getDocumentsEnOrdre() {
        List<DocumentAdministratif> tousLesDocuments = DocumentAdministratifDao.getTousLesDocuments();
        List<DocumentAdministratif> documentsEnOrdre = new ArrayList<DocumentAdministratif>();
        for (DocumentAdministratif doc : tousLesDocuments) {
            if (Calendar.getInstance().getTimeInMillis() - doc.getDateValiditer().getTime() < 0) {
                documentsEnOrdre.add(doc);
            }
        }
        return documentsEnOrdre;
    }

    public static List<DocumentAdministratif> getDocumentsARenouveler() {
        List<DocumentAdministratif> tousLesDocuments = DocumentAdministratifDao.getTousLesDocuments();
        List<DocumentAdministratif> documentsARenouveler = new ArrayList<DocumentAdministratif>();

        for (DocumentAdministratif doc : tousLesDocuments) {
            if (Calendar.getInstance().getTimeInMillis() - doc.getDateValiditer().getTime() >= 0) {
                documentsARenouveler.add(doc);
            }
        }
        return documentsARenouveler;
    }

    public static List<DocumentAdministratif> getDocumentsABientotRenouveler() {
        List<DocumentAdministratif> tousLesDocuments = DocumentAdministratifDao.getTousLesDocuments();
        List<DocumentAdministratif> documentsARenouveler = new ArrayList<DocumentAdministratif>();
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        timeInMillis += TimeUnit.DAYS.toMillis(5);
        for (DocumentAdministratif doc : tousLesDocuments) {
            if (timeInMillis < doc.getDateValiditer().getTime() && doc.getDateValiditer().getTime() > Calendar.getInstance().getTimeInMillis()) {
                documentsARenouveler.add(doc);
            }
        }
        return documentsARenouveler;
    }
}
