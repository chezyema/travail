/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.db;

import be.isfce.tfe.metier.DocumentAdministratif;
import be.isfce.tfe.metier.MaterielRoulant;
import be.isfce.tfe.metier.TypeDocument;
import be.isfce.tfe.metier.TypeMaterielRoulant;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yema
 */
public class TypeMaterielDao {    
    public static boolean addTypeMateriel(TypeMaterielRoulant type) {
        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("Insert into typematerielroulant (idtypemateriel,typemateriel) values (  ?,?)");
            preparedStatement.setInt(1, type.getIdtypemateriel());
            preparedStatement.setString(2, type.getTypemateriel());

            preparedStatement.executeUpdate();

            return true;
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

    public static List<TypeMaterielRoulant> getTousLesTypesMateriel() {
        return  getTousLesTypesMateriel(false);
    }

    public static List<TypeMaterielRoulant> getTousLesTypesMaterielarchives() {
        return getTousLesTypesMateriel(true);
    }

    public static List<TypeMaterielRoulant> getTousLesTypesMateriel(boolean typeSupprimes) {
        try {
            String supprimes = typeSupprimes ? "1" : "0";
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select * from typematerielroulant where supprimetypematerielroulant = " + supprimes);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<TypeMaterielRoulant> alltype = new ArrayList<TypeMaterielRoulant>();
            while (resultSet.next()) {
                TypeMaterielRoulant typemateriel = new TypeMaterielRoulant();
                typemateriel.setIdtypemateriel(resultSet.getInt("idtypemateriel"));
                typemateriel.setTypemateriel(resultSet.getString("typemateriel"));
                typemateriel.setLesTypesMaterielRoulant(selectListeMaterielPourTypeMateriel(typemateriel.getIdtypemateriel()));
                
                alltype.add(typemateriel);
            }
            System.out.println(alltype);
            return alltype;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static TypeMaterielRoulant getTypeMateriel(int idType) {
        TypeMaterielRoulant typemateriel = null;
        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select * from typematerielroulant where idtypemateriel = ?");
            preparedStatement.setInt(1, idType);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
               typemateriel = new TypeMaterielRoulant();
                typemateriel.setIdtypemateriel(resultSet.getInt("idtypemateriel"));
                typemateriel.setTypemateriel(resultSet.getString("typemateriel"));
                typemateriel.setLesTypesMaterielRoulant(selectListeMaterielPourTypeMateriel(typemateriel.getIdtypemateriel()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typemateriel;
    }

    public static List<MaterielRoulant> selectListeMaterielPourTypeMateriel(int typeId) {
        try {

            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select * from  materielroulant join  typematerielroulant  on materielroulant.id = typematerielroulant.idtypemateriel where typematerielroulant.idtypemateriel = ?");
            preparedStatement.setInt(1, typeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<MaterielRoulant> allMateriel = new ArrayList<MaterielRoulant>();
            while (resultSet.next()) {
                MaterielRoulant materiel = new MaterielRoulant();
                materiel.setId(resultSet.getString("id"));
                materiel.setMarque(resultSet.getString("marque"));
                materiel.setIdtypemateriel(resultSet.getInt("idtypemateriel"));
                materiel.setAnneedeconstruction(resultSet.getDate("anneeconstruction"));
                materiel.setCarburant(resultSet.getString("carburant"));
                materiel.setNumImmatr(resultSet.getString("numimmatr"));
                materiel.setNbDePlaces(resultSet.getInt("nbdeplaces"));
                materiel.setKmactuel(resultSet.getInt("kmactuel"));
                materiel.setDateexctincteur(resultSet.getDate("validiterexctincteur"));
                

               allMateriel .add(materiel);
            }
            //  System.out.println(allDocuments);
            return allMateriel;

        } catch (Exception e) {
            return null;
        }
    }

    public static boolean updateTypeMateriel(TypeMaterielRoulant type) {
        //TODO implémenter la méthode
        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("update typematerielroulant set typemateriel = ? where typematerielroulant.idtypemateriel = ?");
            preparedStatement.setString(1, type.getTypemateriel());
            preparedStatement.setInt(2, type.getIdtypemateriel());

            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean deleteType(TypeMaterielRoulant types) {
        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("update typematerielroulant set supprimetypematerielroulant = 1 where typematerielroulant.idtypemateriel = ?");
            preparedStatement.setInt(1, types.getIdtypemateriel());
            preparedStatement.executeUpdate();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
