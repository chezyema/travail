/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.db;

import be.isfce.tfe.metier.DocumentAdministratif;
import be.isfce.tfe.metier.TypeDocument;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yema
 */
public class TypeDocumentDao {
    
    public static boolean addTypeDocument(TypeDocument type) {
        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("Insert into type (idtype,libelledocument) values (  ?,?)");
            preparedStatement.setInt(1, type.getIdtype());
            preparedStatement.setString(2, type.getLibelledocument());
           
            preparedStatement.executeUpdate();
            
            return true;
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

    public static List<TypeDocument> getTousLesTypesDocument() {
        return getTousLesTypesDocument(false);
    }

    public static List<TypeDocument> getTousLesTypesarchives() {
        return getTousLesTypesDocument(true);
    }

    public static List<TypeDocument> getTousLesTypesDocument(boolean typeSupprimes) {
        try {
            String supprimes = typeSupprimes ? "1" : "0";
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select * from Type where supprimetype = " + supprimes);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<TypeDocument> alltype = new ArrayList<TypeDocument>();
            while (resultSet.next()) {
                TypeDocument typedocument = new TypeDocument();
                typedocument.setIdtype(resultSet.getInt("idtype"));
                typedocument.setLibelledocument(resultSet.getString("libelledocument"));
                typedocument.setLesdocumentsadministratifs(selectListeDocumentPourTypeDocument(typedocument.getIdtype()));
                alltype.add(typedocument);
             
            }
            System.out.println(alltype);
            return alltype;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }
    
        public static List<DocumentAdministratif> selectListeDocumentPourTypeDocument(int typeId) {
       try {

            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select * from  documentsadministratifs join  type  on documentsadministratifs.idtype = type.idtype where type.idtype = ?");
            preparedStatement.setInt(1, typeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<DocumentAdministratif> allDocuments = new ArrayList<DocumentAdministratif>();
            while (resultSet.next()) {
                DocumentAdministratif documents = new DocumentAdministratif();
                documents.setId(resultSet.getInt("iddocument"));
                documents.setLibelle(resultSet.getString("libelle"));
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

    
    
  

    public static boolean updateTypeDocument(TypeDocument type) {
        //TODO implémenter la méthode
        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("update type set libelledocument = ? where type.idtype = ?");
            preparedStatement.setString(1, type.getLibelledocument());
            preparedStatement.setInt(2, type.getIdtype());

            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

     public static boolean deleteType(TypeDocument types) {
        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("update type set supprimetype = 1 where type.idtype = ?");
            preparedStatement.setInt(1, types.getIdtype());
            preparedStatement.executeUpdate();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
