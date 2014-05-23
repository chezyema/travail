/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.db;

import be.isfce.tfe.metier.Chauffeur;
import be.isfce.tfe.metier.Circuit;
import be.isfce.tfe.metier.DocumentAdministratif;
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

public class DocumentAdministratifDBHelper {


    public static boolean addDocumentsAdministratifs(DocumentAdministratif documents) {

        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("Insert into documentsadministratifs (iddocument,libelle,datevaliditer,id,idchauffeur) VALUES(? , ?, ?,?,?)");

            preparedStatement.setInt(1, documents.getId());
            preparedStatement.setString(2, documents.getLibelle());
            preparedStatement.setDate(3, new Date(documents.getDateValiditer().getTime()));
            preparedStatement.setString(4, documents.getIdmaterielroulant());
            preparedStatement.setString(5, documents.getIdchauffeur());
            //ajouter les clés étrangére

            preparedStatement.executeUpdate();
            Connexion.getInstance().getConn().commit();
            return true;
        } catch (Exception e) {
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
                documents.setLibelle(resultSet.getString("libelle"));
                documents.setDateValiditer(resultSet.getDate("datevaliditer"));
                documents.setIdmaterielroulant(resultSet.getString("id"));
                documents.setIdchauffeur(resultSet.getString("idchauffeur"));

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
            preparedStatement.setString(1, document.getLibelle());
            preparedStatement.setDate(2, new Date(document.getDateValiditer().getTime()));
            preparedStatement.setInt(3,document.getId());
          
            preparedStatement.execute();
            Connexion.getInstance().getConn().commit();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    public static boolean deleteDocumentsAdministratifs( DocumentAdministratif documents) {

        try {

            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("update documentsadministratifs set supprimedocument = 1 where documentsadministratifs.iddocument = ?");
            preparedStatement.setInt(1, documents.getId());
            preparedStatement.execute();
            Connexion.getInstance().getConn().commit();

            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
