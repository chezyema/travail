/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.modele;

import be.isfce.tfe.db.UtilisationCarteDBHelper;
import be.isfce.tfe.metier.UtilisationCarte;
import java.util.List;

/**
 *
 * @author yema
 */
public class UtilisationCarteModele extends AbstractModel<UtilisationCarte> {
     private static UtilisationCarteModele instance;

    private UtilisationCarteModele() {
        liste = UtilisationCarteDBHelper.getTousLesUtilisationCarte();
    }

    public static UtilisationCarteModele getInstance() {
        if (instance == null) {
            instance = new UtilisationCarteModele();
        }
        return instance;
    }

    @Override
    public List<UtilisationCarte> getTousLesElements() {
        return liste;
    }

    @Override
    public boolean supprime(UtilisationCarte element) {
        liste.remove(element);
        boolean deleteUtilisationCarte = UtilisationCarteDBHelper.deleteUtilisationCarte(element);
        if (deleteUtilisationCarte) {
            setChanged();
            notifyObservers(ELEMENT_SUPPRIME);
        }
        return deleteUtilisationCarte;
    }

    @Override
    public boolean modifie(UtilisationCarte element) {
        UtilisationCarte utilisation = getUtilisationCarte(element.getIdutilisationcarte());
        if (utilisation != null) {
            boolean updateUtilisationCarte = UtilisationCarteDBHelper.updateUtilisationCarte(utilisation);
            if (updateUtilisationCarte) {
                setChanged();
                notifyObservers(ELEMENT_MODIFIE);
            }
            return updateUtilisationCarte;
        }
        return false;
    }

    @Override
    public boolean cree(UtilisationCarte element) {
        //J'ajoute l'élément dans la BD
        boolean addUtilisationCarte = UtilisationCarteDBHelper.addUtilisationCarte(element);
        if (addUtilisationCarte) {
            liste.add(element);
            setChanged();
            notifyObservers(ELEMENT_AJOUTE);
        }
        return addUtilisationCarte;
    }

    private UtilisationCarte getUtilisationCarte(int id) {
        for (UtilisationCarte utilisation : liste) {
            if (utilisation.getIdutilisationcarte() == 0 ) {
                return utilisation;
            }
        }
        return null;
    }

   
}