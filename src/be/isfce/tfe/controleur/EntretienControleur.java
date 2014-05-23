/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.controleur;

import be.isfce.tfe.modele.AbstractModel;
import be.isfce.tfe.metier.Entretien;
import be.isfce.tfe.validation.StringValidation;
import java.util.Calendar;

/**
 *
 * @author yema
 */
public class EntretienControleur extends AbstractControleur<Entretien>{

    public EntretienControleur(AbstractModel<Entretien> modele) {
        super(modele);
    }
    
    @Override
     public void controleEtAjoute(Entretien entretien) throws ValidationException{
        
        if(entretien == null){
            throw new ValidationException("L'entretien est invalide");
        }
        if(entretien.getDescription() == null || !StringValidation.VerifString(entretien.getDescription())){
            throw new ValidationException("la description n'est pas valide");
        }
        Calendar joura = Calendar.getInstance();
        joura.add(Calendar.DAY_OF_MONTH, 0);joura.getTime();
        if(entretien.getDateEntretien() == null || entretien.getDateEntretien() .after(joura.getTime())){
        throw new ValidationException("Le date n'est pas valide");
        }
        
         if(entretien.getKmEntretienFait() == 0){
            throw new ValidationException("Le kilometrage n'est pas valide");
        }
          modele.cree(entretien);
      }

    @Override
    public void controleEtSupprime(Entretien object) throws ValidationException {
        modele.supprime(object); ;
    }

    @Override
    public void controleEtModifie(Entretien object) throws ValidationException {
         modele.modifie(object);;
    }
    }
