/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.controleur;

import be.isfce.tfe.modele.AbstractModel;
import be.isfce.tfe.metier.Chauffeur;
import be.isfce.tfe.validation.EmailValidation;
import be.isfce.tfe.validation.StringValidation;
import java.util.Calendar;

/**
 *
 * @author yema
 */
public class ChauffeurControleur extends AbstractControleur<Chauffeur> {

    public ChauffeurControleur(AbstractModel<Chauffeur> modele) {
        super(modele);
    }
    
    @Override
    public void controleEtAjoute(Chauffeur chauffeur) throws ValidationException {

        if (chauffeur == null) {
            throw new ValidationException("Le chauffeur est invalide");
        }
        if (chauffeur.getAdresse() == null || !StringValidation.VerifString(chauffeur.getAdresse())) {
            throw new ValidationException("L'adresse n'est pas valide");
        }
        if (chauffeur.getCodepostale() == 0) {
            throw new ValidationException("Le code postal n'est pas valide");
        }

        Calendar auj = Calendar.getInstance();
        auj.add(Calendar.YEAR, -21);
        if (chauffeur.getDateNaissance() == null || chauffeur.getDateNaissance().after(auj.getTime())) {
            throw new ValidationException("Le chauffeur doit avoir plus de 21 ans");
            //ajouter argument
        }
        if (chauffeur.getVille() == null || !StringValidation.VerifString(chauffeur.getVille())) {
            throw new ValidationException("La ville n'est pas valide");
        }
        if (chauffeur.getEmail() == null || !EmailValidation.validateEmailAddress(chauffeur.getEmail())) {
            throw new ValidationException("Le email  n'est pas valide");
        }

        if (chauffeur.getPrenomChauffeur() == null || !StringValidation.VerifString(chauffeur.getPrenomChauffeur())) {
            throw new ValidationException("Le prenom n'est pas valide");
        }

        if (chauffeur.getNumTelephone() == null) {
            throw new ValidationException("Le numero de telephone n'est pas valide");
        }
        
        

      

        if (chauffeur.getId() == null) {
            throw new ValidationException("Le registre national n'est pas valide");
        }

        modele.cree(chauffeur);
    }

    @Override
    public void controleEtSupprime(Chauffeur object) throws ValidationException {
        modele.supprime(object);
    }

    @Override
    public void controleEtModifie(Chauffeur object) throws ValidationException {
        modele.modifie(object);
    }
}
