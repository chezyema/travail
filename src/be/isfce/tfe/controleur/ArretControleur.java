/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.controleur;

import be.isfce.tfe.db.ArretDao;
import be.isfce.tfe.metier.Arret;
import be.isfce.tfe.validation.StringValidation;

/**
 *
 * @author yema
 */
public class ArretControleur extends AbstractControleur<Arret> {

    @Override
    public void controleEtAjoute(Arret arret) throws ValidationException {
        if (!(arret != null && arret.getAdresse() != null)) {
            throw new ValidationException("L'adresse n'est pas valide");
        }
        if (ArretDao.addArret(arret)) {
            setChanged();
            notifyObservers();
        }
    }

    @Override
    public void controleEtSupprime(Arret object) throws ValidationException {
        if (ArretDao.deleteArret(object)) {
            setChanged();
            notifyObservers();
        }
    }

    @Override
    public void controleEtModifie(Arret object) throws ValidationException {
        if (ArretDao.updateArret(object)) {
            setChanged();
            notifyObservers();
        }

    }
}
