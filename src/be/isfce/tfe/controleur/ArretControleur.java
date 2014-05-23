/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.controleur;

import be.isfce.tfe.modele.AbstractModel;
import be.isfce.tfe.metier.Arret;
import be.isfce.tfe.validation.StringValidation;

/**
 *
 * @author yema
 */
public class ArretControleur extends AbstractControleur<Arret>{

    public ArretControleur(AbstractModel<Arret> modele) {
        super(modele);
    }
    
    @Override
    public void controleEtAjoute(Arret arret) throws ValidationException{
        if(!(arret != null && arret.getAdresse() != null && StringValidation.VerifString(arret.getAdresse()))){
            throw new ValidationException(" erreur L'adresse n'est pas valide");
        }
        modele.cree(arret); 
    }
    

   
    public void controleEtSupprime(Arret object) throws ValidationException {
        modele.supprime(object);
    }

   
    public void controleEtModifie(Arret object) throws ValidationException {
        modele.modifie(object);
    }
}
