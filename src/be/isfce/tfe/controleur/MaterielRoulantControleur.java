/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.controleur;

import be.isfce.tfe.db.MaterielRoulantDao;
import be.isfce.tfe.metier.MaterielRoulant;
import be.isfce.tfe.validation.NumeroChassisValidation;
import be.isfce.tfe.validation.StringValidation;
import be.isfce.tfe.validation.ValidationPlaque;
import java.util.Calendar;

/**
 *
 * @author yema
 */
public class MaterielRoulantControleur extends AbstractControleur<MaterielRoulant> {

    @Override
    public void controleEtAjoute(MaterielRoulant vehicule) throws ValidationException {

        if (vehicule == null) {
            throw new ValidationException("Le vehicule est invalide");
        }
        if (vehicule.getMarque() == null || !StringValidation.VerifString(vehicule.getMarque())) {
            throw new ValidationException("La marque n'est pas valide");
        }
        
        if (vehicule.getCarburant() == null || !StringValidation.VerifString(vehicule.getCarburant())) {
            throw new ValidationException("Le carburant n'est pas valide");
        }
        if (vehicule.getNumImmatr() == null || !ValidationPlaque.checkPlaque(vehicule.getNumImmatr())) {
            throw new ValidationException("La plaque n'est pas valide");
        }
        Calendar joura = Calendar.getInstance();
        joura.add(Calendar.DAY_OF_MONTH, +1);
        joura.getTime();
        if (vehicule.getAnneedeconstruction() == null || vehicule.getAnneedeconstruction().after(joura.getTime())) {
            throw new ValidationException("Le date de construction n'est pas valide");
        }
        Calendar jourb = Calendar.getInstance();
        jourb.add(Calendar.DAY_OF_MONTH, +1);
        jourb.getTime();
        if (vehicule.getDateexctincteur() == null || vehicule.getDateexctincteur().before(jourb.getTime())) {
            throw new ValidationException("Le date de validité de l'exctincteur n'est pas valide");
        }
        if (vehicule.getKmactuel() == 0) {
            throw new ValidationException("Le kilométrage actuel n'est pas valide");
        }
        if (vehicule.getNbDePlaces() == 0) {
            throw new ValidationException("Le nombre de place n'est pas valide");
        }
        if (vehicule.getId() == null || !NumeroChassisValidation.checkChassis(vehicule.getId())) {
            throw new ValidationException("Le numero de chassis n'est pas valide");
        }
        if(MaterielRoulantDao.addMaterielRoulant(vehicule)) {
            setChanged();
            notifyObservers();
        }
    }

    @Override
    public void controleEtSupprime(MaterielRoulant object) throws ValidationException {
        if(MaterielRoulantDao.deleteMaterielRoulant(object)) {
            setChanged();
            notifyObservers();
        }
    }

    @Override
    public void controleEtModifie(MaterielRoulant object) throws ValidationException {
        if(MaterielRoulantDao.updateMaterielRoulant(object)) {
            setChanged();
            notifyObservers();
        }
    }
}
