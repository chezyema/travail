/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.controleur;

import be.isfce.tfe.modele.AbstractModel;
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

    public MaterielRoulantControleur(AbstractModel<MaterielRoulant> modele) {
        super(modele);
    }

    @Override
    public void controleEtAjoute(MaterielRoulant vehicule) throws ValidationException {

        if (vehicule == null) {
            throw new ValidationException("Le vehicule est invalide");
        }
        if (vehicule.getMarque() == null || !StringValidation.VerifString(vehicule.getMarque())) {
            throw new ValidationException("La marque n'est pas valide");
        }

        if (vehicule.getType() == null || !StringValidation.VerifString(vehicule.getType())) {
            throw new ValidationException("Le type n'est pas valide");
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
            throw new ValidationException("Le date n'est pas valide");
        }
        Calendar jourb = Calendar.getInstance();
        jourb.add(Calendar.DAY_OF_MONTH, +1);
        jourb.getTime();
        if (vehicule.getDateexctincteur() == null || vehicule.getDateexctincteur().after(jourb.getTime())) {
            throw new ValidationException("Le date n'est pas valide");
        }
        if (vehicule.getKmactuel() == 0) {
            throw new ValidationException("Le kilométrage n'est pas valide");
        }
        if (vehicule.getNbDePlaces() == 0) {
            throw new ValidationException("Le kilométrage n'est pas valide");
        }
        if (vehicule.getId() == null || !NumeroChassisValidation.checkChassis(vehicule.getId())) {
            throw new ValidationException("Le numero de telephone n'est pas valide");
        }
        modele.cree(vehicule);
    }

    @Override
    public void controleEtSupprime(MaterielRoulant object) throws ValidationException {
        modele.supprime(object);
    }

    @Override
    public void controleEtModifie(MaterielRoulant object) throws ValidationException {
        modele.modifie(object);
    }
    }
  