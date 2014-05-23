/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.modele;

import be.isfce.tfe.db.EleveDBHelper;
import be.isfce.tfe.metier.Eleve;
import java.util.List;

/**
 *
 * @author yema
 */
public class EleveModele extends AbstractModel<Eleve> {

    private static EleveModele instance;

    private EleveModele() {
        liste = EleveDBHelper.getTousLesEleves();
    }

    public static EleveModele getInstance() {
        if (instance == null) {
            instance = new EleveModele();
        }
        return instance;
    }

    @Override
    public List<Eleve> getTousLesElements() {
        return liste;
    }

    @Override
    public boolean supprime(Eleve element) {
        liste.remove(element);
        boolean deleteEleve = EleveDBHelper.deleteEleve(element);
        if (deleteEleve) {
            setChanged();
            notifyObservers(ELEMENT_SUPPRIME);
        }
        return deleteEleve;
    }

    @Override
    public boolean modifie(Eleve element) {
        Eleve eleve = getEleve(element.getId());
        if (eleve != null) {
            boolean updateEleve = EleveDBHelper.updateEleve(eleve);
            if (updateEleve) {
                setChanged();
                notifyObservers(ELEMENT_MODIFIE);
            }
            return updateEleve;
        }
        return false;
    }

    
    public boolean cree(Eleve element) {
        //J'ajoute l'élément dans la BD
        boolean addEleve = EleveDBHelper.addEleve(element);
        if (addEleve) {
            liste.add(element);
            setChanged();
            notifyObservers(ELEMENT_AJOUTE);
        }
        return addEleve;
    }

    private Eleve getEleve(String id) {
        for (Eleve eleve : liste) {
            if (eleve.getId() != null && eleve.getId().equals(id)) {
                return eleve;
            }
        }
        return null;
    }
}

   