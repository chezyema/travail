/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.controleur;

import be.isfce.tfe.db.CarteCarburantDao;
import be.isfce.tfe.metier.CarteCarburant;

/**
 *
 * @author yema
 */
public class CarteCarburantControleur extends AbstractControleur<CarteCarburant> {

    @Override
    public void controleEtAjoute(CarteCarburant cartecarburant) throws ValidationException {

        if (cartecarburant == null) {
            throw new ValidationException("La carte est invalide");
        }

      

       
        if (CarteCarburantDao.addCarteCarburant(cartecarburant)) {
            setChanged();
            notifyObservers();
        }
    }

    @Override
    public void controleEtSupprime(CarteCarburant object) throws ValidationException {
        if (CarteCarburantDao.deleteCarteCarburant(object)) {
            setChanged();
            notifyObservers();
        }
    }

    @Override
    public void controleEtModifie(CarteCarburant object) throws ValidationException {
        if (CarteCarburantDao.updateCarteCarburant(object)) {
            setChanged();
            notifyObservers();
        }
    }

}
