/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.modele;

import be.isfce.tfe.db.EntretienDBHelper;
import be.isfce.tfe.metier.Entretien;
import java.util.List;

/**
 *
 * @author yema
 */
public class EntretienModele extends AbstractModel<Entretien> {

    private static EntretienModele instance;

    private EntretienModele() {
        liste = EntretienDBHelper.getTousLesEntretiens();
    }

    public static EntretienModele getInstance() {
        if (instance == null) {
            instance = new EntretienModele();
        }
        return instance;
    }

    @Override
    public List<Entretien> getTousLesElements() {
        return liste;
    }

    @Override
    public boolean supprime(Entretien element) {
        liste.remove(element);
        boolean deleteEntretien = EntretienDBHelper.deleteEntretien(element);
        if (deleteEntretien) {
            setChanged();
            notifyObservers(ELEMENT_SUPPRIME);
        }
        return deleteEntretien;
    }

    @Override
    public boolean modifie(Entretien element) {
        Entretien entretien = getEntretien(element.getId());
        if (entretien != null) {
            boolean updateEntretien = EntretienDBHelper.updateEntretien(entretien);
            if (updateEntretien) {
                setChanged();
                notifyObservers(ELEMENT_MODIFIE);
            }
            return updateEntretien;
        }
        return false;
    }

    
    public boolean cree(Entretien element) {
        //J'ajoute l'élément dans la BD
        boolean addEntretien = EntretienDBHelper.addEntretien(element);
        if (addEntretien) {
            liste.add(element);
            setChanged();
            notifyObservers(ELEMENT_AJOUTE);
        }
        return addEntretien;
    }

    private Entretien getEntretien(int id) {
        for (Entretien entretien : liste) {
            if (entretien.getId() == 0 ) {
                return entretien;
            }
        }
        return null;
    }
}

   