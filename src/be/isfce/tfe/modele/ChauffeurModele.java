/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.modele;

import be.isfce.tfe.db.ChauffeurDBHelper;
import be.isfce.tfe.metier.Chauffeur;
import java.util.List;

/**
 *
 * @author yema
 */
public class ChauffeurModele extends AbstractModel<Chauffeur> {

    private static ChauffeurModele instance;

    private ChauffeurModele() {
        liste = ChauffeurDBHelper.getTousLesChauffeurs();
    }

    public static ChauffeurModele getInstance() {
        if (instance == null) {
            instance = new ChauffeurModele();
        }
        return instance;
    }

    @Override
    public List<Chauffeur> getTousLesElements() {
        return liste;
    }

    @Override
    public boolean supprime(Chauffeur element) {
        liste.remove(element);
        boolean deleteChauffeur = ChauffeurDBHelper.deleteChauffeur(element);
        if (deleteChauffeur) {
            setChanged();
            notifyObservers(ELEMENT_SUPPRIME);
        }
        return deleteChauffeur;
    }

    @Override
    public boolean modifie(Chauffeur element) {
        Chauffeur chauffeur = getChauffeur(element.getId());
        if (chauffeur != null) {
            boolean updateChauffeur = ChauffeurDBHelper.updateChauffeur(chauffeur);
            if (updateChauffeur) {
                setChanged();
                notifyObservers(ELEMENT_MODIFIE);
            }
            return updateChauffeur;
        }
        return false;
    }

    @Override
    public boolean cree(Chauffeur element) {
        //J'ajoute l'élément dans la BD
        boolean addChauffeur = ChauffeurDBHelper.addChauffeur(element);
        if (addChauffeur) {
            liste.add(element);
            setChanged();
            notifyObservers(ELEMENT_AJOUTE);
        }
        return addChauffeur;
    }

    private Chauffeur getChauffeur(String id) {
        for (Chauffeur chauffeur : liste) {
            if (chauffeur.getId() != null && chauffeur.getId().equals(id)) {
                return chauffeur;
            }
        }
        return null;
    }

}
