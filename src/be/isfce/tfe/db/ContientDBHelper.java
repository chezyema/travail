/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.db;

import be.isfce.tfe.metier.Arret;
import be.isfce.tfe.metier.Circuit;
import be.isfce.tfe.metier.Contient;
import java.sql.PreparedStatement;

/**
 *
 * @author yema
 */
public class ContientDBHelper {

    public static boolean addContient(Contient contient) {
        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("Insert into contient (idcircuit,idarrets) values (? , ?)");
            preparedStatement.setInt(1, contient.getIdcircuit());
            preparedStatement.setInt(2, contient.getIdarrets());

            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public static boolean selectContient(Contient contient) {
        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("select * from contient");
            preparedStatement.execute();
            return true;
        } catch (Exception e) {
            return false;

        }

    }

    public static boolean updateContient(Contient contient) {
        //TODO implémenter la méthode
        return true;
    }

    public static boolean deleteContient(Arret arret, Circuit circuit) {
        try {
            PreparedStatement preparedStatement = Connexion.getInstance().getConn().prepareStatement("update contient set supprimecontient = 1 where contient.idarrets = ? and contient.idcircuit=?");
            preparedStatement.setInt(1, arret.getId());
            preparedStatement.setInt(2, circuit.getId());
            preparedStatement.executeUpdate();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
