/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.controleur;

import be.isfce.tfe.db.UtilisationCarteDao;
import be.isfce.tfe.metier.UtilisationCarte;
import java.util.Calendar;

/**
 *
 * @author yema
 */
public class UtilisationCarteControleur extends AbstractControleur<UtilisationCarte> {

    @Override
    public void controleEtAjoute(UtilisationCarte carte) throws ValidationException {
        Calendar joura = Calendar.getInstance();
        joura.add(Calendar.DAY_OF_MONTH, 0);
        joura.getTime();
        if (carte.getDateUtilisation() == null || carte.getDateUtilisation().after(joura.getTime())) {
            throw new ValidationException("Le date n'est pas valide");
        }
        if (carte.getLitrecarburant() == 0) {
            throw new ValidationException("Les litres de carburant ne sont pas valide");
        }
        if (UtilisationCarteDao.addUtilisationCarte(carte)) {
            setChanged();
            notifyObservers();
        }
    }

    @Override
    public void controleEtSupprime(UtilisationCarte object) throws ValidationException {
        if (UtilisationCarteDao.deleteUtilisationCarte(object)) {
            setChanged();
            notifyObservers();
        }
    }

    @Override
    public void controleEtModifie(UtilisationCarte object) throws ValidationException {
        if (UtilisationCarteDao.updateUtilisationCarte(object)) {
            setChanged();
            notifyObservers();
        }
    }
}
