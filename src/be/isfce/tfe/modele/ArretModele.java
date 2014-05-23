/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.modele;

import be.isfce.tfe.db.ArretDBHelper;
import be.isfce.tfe.metier.Arret;
import java.util.List;

/**
 *
 * @author yema
 */
public class ArretModele extends AbstractModel<Arret> {

  private static ArretModele instance;

    private ArretModele() {
        liste = ArretDBHelper.getTousLesArrets();
    }

    public static ArretModele getInstance() {
        if (instance == null) {
            instance = new ArretModele();
        }
        return instance;
    }

    @Override
    public List<Arret> getTousLesElements() {
        return liste;
    }

    @Override
    public boolean supprime(Arret element) {
        liste.remove(element);
        boolean deleteArret = ArretDBHelper.deleteArret(element);
        if (deleteArret) {
            setChanged();
            notifyObservers(ELEMENT_SUPPRIME);
        }
        return deleteArret;
    }

    @Override
    public boolean modifie(Arret element) {
        Arret arret = getArret(element.getId());
        if (arret != null) {
            boolean updateChauffeur = ArretDBHelper.updateArret(element);
            if (updateChauffeur) {
                setChanged();
                notifyObservers(ELEMENT_MODIFIE);
            }
            return updateChauffeur;
        }
        return false;
    }

    @Override
    public boolean cree(Arret element) {
        //J'ajoute l'élément dans la BD
        boolean addArret = ArretDBHelper.addArret(element);
        if (addArret) {
            liste.add(element);
            setChanged();
            notifyObservers(ELEMENT_AJOUTE);
        }
        return addArret;
    }

    private Arret getArret(int id) {
        for (Arret arret : liste) {
            if (arret.getId() ==0 ) {
                return arret;
            }
        }
        return null;
    }

   
   

}