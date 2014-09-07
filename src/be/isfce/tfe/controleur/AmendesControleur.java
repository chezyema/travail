/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.controleur;

import be.isfce.tfe.db.AmendesDao;
import be.isfce.tfe.db.EntretienDao;
import be.isfce.tfe.metier.Amende;
import be.isfce.tfe.metier.Entretien;
import be.isfce.tfe.validation.StringValidation;
import java.util.Calendar;

/**
 *
 * @author yema
 */
public class AmendesControleur extends AbstractControleur<Amende> {


    
    @Override
    public void controleEtAjoute(Amende amende) throws ValidationException {

        if (amende == null) {
            throw new ValidationException("L'amende est invalide");
        }
        if (amende.getNumeropv() == null ) {
            throw new ValidationException("le numéro de pv est null");
        }
        
        if (amende.getDatepv() == null ) {
            throw new ValidationException("Le date n'est pas valide");
        }
        if (amende.getMontantpv() <= 0) {
            throw new ValidationException("Le montant est null");
        }
        if(AmendesDao.addAmendes(amende)) {
            setChanged();
            notifyObservers();
        }
    }

    
    @Override
    public void controleEtSupprime(Amende object) throws ValidationException {
        if(AmendesDao.deleteAmendes(object)) {
            setChanged();
            notifyObservers();
        }
    }

  
    @Override
    public void controleEtModifie(Amende object) throws ValidationException {
        if(AmendesDao.updateAmendes(object)) {
            setChanged();
            notifyObservers();
        }
    }

    
   

   

  
}

