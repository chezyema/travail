/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.modele;

import be.isfce.tfe.db.EcoleDBHelper;
import be.isfce.tfe.metier.Ecole;
import java.util.List;

/**
 *
 * @author yema
 */
public class EcoleModele extends AbstractModel<Ecole> {

    private static EcoleModele instance;

    private EcoleModele() {
        liste = EcoleDBHelper.getTousLesEcoles();
    }

    public static EcoleModele getInstance() {
        if (instance == null) {
            instance = new EcoleModele();
        }
        return instance;
    }

    @Override
    public List<Ecole> getTousLesElements() {
        return liste;
    }

    @Override
    public boolean supprime(Ecole element) {
        liste.remove(element);
        boolean deleteEcole = EcoleDBHelper.deleteEcole(element);
        if (deleteEcole) {
            setChanged();
            notifyObservers(ELEMENT_SUPPRIME);
        }
        return deleteEcole;
    }

    @Override
    public boolean modifie(Ecole element) {
        Ecole ecole = getEcole(element.getId());
        if (ecole != null) {
            boolean updateEcole = EcoleDBHelper.updateEcole(ecole);
            if (updateEcole) {
                setChanged();
                notifyObservers(ELEMENT_MODIFIE);
            }
            return updateEcole;
        }
        return false;
    }

    
    public boolean cree(Ecole element) {
        //J'ajoute l'élément dans la BD
        boolean addEcole = EcoleDBHelper.addEcole(element);
        if (addEcole) {
            liste.add(element);
            setChanged();
            notifyObservers(ELEMENT_AJOUTE);
        }
        return addEcole;
    }

    private Ecole getEcole(int id) {
        for (Ecole ecole : liste) {
            if (ecole.getId() == 0 ) {
                return ecole;
            }
        }
        return null;
    }

}
