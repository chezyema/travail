/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.controleur;

import be.isfce.tfe.db.MaterielRoulantDao;
import be.isfce.tfe.db.TrajetDao;
import be.isfce.tfe.metier.MaterielRoulant;
import be.isfce.tfe.metier.Trajet;
import java.util.List;

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
        if (trajet.getKmdepart() > trajet.getKmfin()) {
            throw new ValidationException("Le kilometrage n'est pas valide");
        }
        MaterielRoulant materielRoulant = MaterielRoulantDao.getMaterielRoulant(trajet.getIdmaterielroulant());
        if (materielRoulant != null && materielRoulant.getKmactuel() > trajet.getKmdepart()) {
            throw new ValidationException("Le kilométrage du véhicule est supérieur au kilomètre de départ du trajet !");
        }
        List<Trajet> trajetsEnMemeTemps = TrajetDao.getTrajets(trajet.getIdchauffeur(), trajet.getDateTravail(), trajet.getHeurededebut().getTime(), trajet.getHeuredefin().getTime());
        if (!trajetsEnMemeTemps.isEmpty()) {
            throw new ValidationException("Ce trajet se déroule en même temps qu'un trajet existant !");
        }
        List<Trajet> trajetsDuVehicule = TrajetDao.getTrajetsPourVehicules(trajet.getIdmaterielroulant(), trajet.getDateTravail(), trajet.getHeurededebut().getTime(), trajet.getHeuredefin().getTime());
        if (!trajetsDuVehicule.isEmpty()) {
            throw new ValidationException("Le véhicule est déjà utilisé dans un autre trajet au même moment");
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
