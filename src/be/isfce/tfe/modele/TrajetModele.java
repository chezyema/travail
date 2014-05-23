/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.modele;

import be.isfce.tfe.db.TrajetDBHelper;
import be.isfce.tfe.metier.Trajet;
import java.util.List;

/**
 *
 * @author yema
 */
public class TrajetModele extends AbstractModel<Trajet> {
     private static TrajetModele instance;

    private TrajetModele() {
        liste = TrajetDBHelper.getTousLesTrajets();
    }

    public static TrajetModele getInstance() {
        if (instance == null) {
            instance = new TrajetModele();
        }
        return instance;
    }

    @Override
    public List<Trajet> getTousLesElements() {
        return liste;
    }

    @Override
    public boolean supprime(Trajet element) {
        liste.remove(element);
        boolean deleteTrajet = TrajetDBHelper.deleteTrajets(element);
        if (deleteTrajet) {
            setChanged();
            notifyObservers(ELEMENT_SUPPRIME);
        }
        return deleteTrajet;
    }

    @Override
    public boolean modifie(Trajet element) {
        Trajet trajet = getTrajet(element.getIdtrajets());
        if (trajet != null) {
            boolean updateChauffeur = TrajetDBHelper.updateChauffeur(trajet);
            if (updateChauffeur) {
                setChanged();
                notifyObservers(ELEMENT_MODIFIE);
            }
            return updateChauffeur;
        }
        return false;
    }

    @Override
    public boolean cree(Trajet element) {
        //J'ajoute l'élément dans la BD
        boolean addTrajet = TrajetDBHelper.addTrajets(element);
        if (addTrajet) {
            liste.add(element);
            setChanged();
            notifyObservers(ELEMENT_AJOUTE);
        }
        return addTrajet;
    }

    private Trajet getTrajet(int id) {
        for (Trajet trajet : liste) {
            if (trajet.getIdtrajets() == 0 ) {
                return trajet;
            }
        }
        return null;
    }

  
}
