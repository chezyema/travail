/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.modele;

import be.isfce.tfe.db.MaterielRoulantDBHelper;
import be.isfce.tfe.metier.MaterielRoulant;
import java.util.List;

/**
 *
 * @author yema
 */
public class MaterielRoulantModele extends AbstractModel<MaterielRoulant> {

    private static MaterielRoulantModele instance;

    private MaterielRoulantModele() {
        liste = MaterielRoulantDBHelper.getTousLesVehicules();
    }

    public static MaterielRoulantModele getInstance() {
        if (instance == null) {
            instance = new MaterielRoulantModele();
        }
        return instance;
    }

    @Override
    public List<MaterielRoulant> getTousLesElements() {
        return liste;
    }

    @Override
    public boolean supprime(MaterielRoulant element) {
        liste.remove(element);
        boolean deleteMaterielRoulant = MaterielRoulantDBHelper.deleteMaterielRoulant(element);
        if (deleteMaterielRoulant) {
            setChanged();
            notifyObservers(ELEMENT_SUPPRIME);
        }
        return deleteMaterielRoulant;
    }

    @Override
    public boolean modifie(MaterielRoulant element) {
        MaterielRoulant vehicule = getMaterielRoulant(element.getId());
        if (vehicule != null) {
            boolean updateMaterielRoulant = MaterielRoulantDBHelper.updateMaterielRoulant(vehicule);
            if (updateMaterielRoulant) {
                setChanged();
                notifyObservers(ELEMENT_MODIFIE);
            }
            return updateMaterielRoulant;
        }
        return false;
    }

    @Override
    public boolean cree(MaterielRoulant element) {
        //J'ajoute l'élément dans la BD
        boolean addMaterielRoulant = MaterielRoulantDBHelper.addMaterielRoulant(element);
        if (addMaterielRoulant) {
            liste.add(element);
            setChanged();
            notifyObservers(ELEMENT_AJOUTE);
        }
        return addMaterielRoulant;
    }

    private MaterielRoulant getMaterielRoulant(String id) {
        for (MaterielRoulant vehicule : liste) {
            if (vehicule.getId() != null && vehicule.getId().equals(id)) {
                return vehicule;
            }
        }
        return null;
    }

}
