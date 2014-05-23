/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.controleur;

import be.isfce.tfe.modele.AbstractModel;
import be.isfce.tfe.metier.Eleve;
import be.isfce.tfe.validation.EmailValidation;
import be.isfce.tfe.validation.StringValidation;
import java.util.Calendar;

/**
 *
 * @author yema
 */
public class EleveControleur extends AbstractControleur<Eleve>{

    public EleveControleur(AbstractModel<Eleve> modele) {
        super(modele);
    }
    
    @Override
    public void controleEtAjoute(Eleve eleve) throws ValidationException{
        
        if(eleve == null){
            throw new ValidationException("Le chauffeur est invalide");
        }
        if(eleve.getAdresseEleve() == null || !StringValidation.VerifString(eleve.getAdresseEleve())){
            throw new ValidationException("L'adresse n'est pas valide");
        }
        if(eleve.getCdpostal() == 0 ){
            throw new ValidationException("Le code postal n'est pas valide");
            
        }
        
        Calendar auj = Calendar.getInstance();
        auj.add(Calendar.YEAR,-3);auj.getTime();
        if(eleve.getDatedenaissance() == null|| eleve.getDatedenaissance().before(auj.getTime())){
            throw new ValidationException("L'eleve doit avoir minimum 3 ans");
             
        }
        if(eleve.getNomEleve() == null || !StringValidation.VerifString(eleve.getNomEleve())){
            throw new ValidationException("Le nom de l'eleve n'est pas valide");
        }
        if(eleve.getEmailResponsable() == null || !EmailValidation.validateEmailAddress(eleve.getEmailResponsable())){
            throw new ValidationException("Le email  n'est pas valide");
        }
       
         if(eleve.getPrenomEleve() == null || !StringValidation.VerifString(eleve.getPrenomEleve())){
         throw new ValidationException("Le prenom n'est pas valide");
        }
         
         if(eleve.getNomResponsable() == null || !StringValidation.VerifString(eleve.getNomResponsable())){
            throw new ValidationException("Le nom du responsable de l'eleve n'est pas valide");
        }
         
        if(eleve.getTelResponsable() == null ){
         throw new ValidationException("Le numero de telephone n'est pas valide");
          
         
        }
       if(eleve.getVil() == null || !StringValidation.VerifString(eleve.getVil())){
            throw new ValidationException("La ville n'est pas valide");
        }
       if(eleve.getId() == null ){
            throw new ValidationException("Le registre national n'est pas valide");
            
        }
        modele.cree(eleve);
}

    @Override
    public void controleEtSupprime(Eleve object) throws ValidationException {
         modele.supprime(object);
    }

    @Override
    public void controleEtModifie(Eleve object) throws ValidationException {
         modele.modifie(object);
    }
}
