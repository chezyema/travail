/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.modele;

import be.isfce.tfe.db.CarteCarburantDBHelper;
import be.isfce.tfe.metier.CarteCarburant;
import java.util.List;

/**
 *
 * @author yema
 */
public class CarteCarburantModele extends AbstractModel<CarteCarburant> {
    
    private static CarteCarburantModele instance;

    private CarteCarburantModele() {
       liste = CarteCarburantDBHelper.getTousLesCartesCarburant();
    }

    public static CarteCarburantModele getInstance() {
        if (instance == null) {
            instance = new CarteCarburantModele ();
        }
        return instance;
    }

 
    public List<CarteCarburant> getTousLesElements() {
        return liste;
    }

    
    public boolean supprime(CarteCarburant element) {
        liste.remove(element);
        boolean deleteCarteCarburant = CarteCarburantDBHelper.deleteCarteCarburant(element);
        if (deleteCarteCarburant) {
            setChanged();
            notifyObservers(ELEMENT_SUPPRIME);
        }
        return deleteCarteCarburant;
    }

    
    public boolean modifie(CarteCarburant element) {
        CarteCarburant carte = getCarteCarburant(element.getId());
        if (carte != null) {
            boolean updateCarteCarburant = CarteCarburantDBHelper.updateCarteCarburant(carte);
            if (updateCarteCarburant) {
                setChanged();
                notifyObservers(ELEMENT_MODIFIE);
            }
            return updateCarteCarburant;
        }
        return false;
    }

    
    public boolean cree(CarteCarburant element) {
        //J'ajoute l'élément dans la BD
        boolean addCarteCarburant = CarteCarburantDBHelper.addCarteCarburant(element);
        if (addCarteCarburant) {
            liste.add(element);
            setChanged();
            notifyObservers(ELEMENT_AJOUTE);
        }
        return addCarteCarburant;
    }

      private CarteCarburant getCarteCarburant(int id) {
        for (CarteCarburant carte : liste) {
            if (carte.getId() == 0 ) {
                return carte;
            }
        }
        return null;
    }

}
