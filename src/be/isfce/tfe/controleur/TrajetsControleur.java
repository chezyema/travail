/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.controleur;

import be.isfce.tfe.db.TrajetDao;
import be.isfce.tfe.metier.Trajet;
import java.util.Calendar;

/**
 *
 * @author yema
 */
public class TrajetsControleur extends AbstractControleur<Trajet> {

    @Override
    public void controleEtAjoute(Trajet heure) throws ValidationException {
        Calendar joura = Calendar.getInstance();
        joura.add(Calendar.HOUR, 0);
        joura.getTime();
        //if( == null || heure.getHeureDeDebut(joura.getTime())){
        throw new ValidationException("Le date n'est pas valide");
        //TODO
    }//encore faire la methode cree

    @Override
    public void controleEtSupprime(Trajet object) throws ValidationException {
        if(TrajetDao.deleteTrajets(object)) {
            setChanged();
            notifyObservers();
        }
    }

    @Override
    public void controleEtModifie(Trajet object) throws ValidationException {
        if(TrajetDao.updateChauffeur(object)) {
            setChanged();
            notifyObservers();
        }
    }

}
