/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.controleur;

import be.isfce.tfe.db.TrajetDao;
import be.isfce.tfe.metier.Trajet;

/**
 *
 * @author yema
 */
public class TrajetsControleur extends AbstractControleur<Trajet> {

    @Override
    public void controleEtAjoute(Trajet trajet) throws ValidationException {
        if (trajet.getKmdepart() == 0) {
            throw new ValidationException("Le kilometrage n'est pas valide");
        }
        if (trajet.getKmfin() == 0) {
            throw new ValidationException("Le kilometrage n'est pas valide");
        }
        TrajetDao.addTrajets(trajet);
    }

    @Override
    public void controleEtSupprime(Trajet object) throws ValidationException {
        if (TrajetDao.deleteTrajets(object)) {
            setChanged();
            notifyObservers();
        }
    }

    @Override
    public void controleEtModifie(Trajet object) throws ValidationException {
        if (TrajetDao.updateChauffeur(object)) {
            setChanged();
            notifyObservers();
        }
    }

}
