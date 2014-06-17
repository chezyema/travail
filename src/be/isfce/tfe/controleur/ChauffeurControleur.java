/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.controleur;

import be.isfce.tfe.db.ChauffeurDao;
import be.isfce.tfe.metier.Chauffeur;
import be.isfce.tfe.validation.EmailValidation;
import be.isfce.tfe.validation.StringValidation;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author yema
 */
public class ChauffeurControleur extends AbstractControleur<Chauffeur> {

    @Override
    public void controleEtAjoute(Chauffeur chauffeur) throws ValidationException {

        if (chauffeur == null) {
            throw new ValidationException("Le chauffeur est invalide");
        }
        if (chauffeur.getAdresse() == null ) {
            throw new ValidationException("L'adresse n'est pas valide");
        }
        if (chauffeur.getCodepostale() == 0) {
            throw new ValidationException("Le code postal n'est pas valide");
        }

        Calendar auj = Calendar.getInstance();
        auj.add(Calendar.YEAR, -21);
        if (chauffeur.getDateNaissance() == null || chauffeur.getDateNaissance().after(auj.getTime())) {
            throw new ValidationException("Le chauffeur doit avoir plus de 21 ans");
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
        if (chauffeur.getId() == null || !checkRegistreNational(chauffeur.getId(), chauffeur.getDateNaissance())) {
            throw new ValidationException("Le registre national n'est pas valide");
        }
        if (ChauffeurDao.addChauffeur(chauffeur)) {
            setChanged();
            notifyObservers();
        }

    }

    public static boolean checkRegistreNational(String registreNational, Date dateDeNaissance) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
        String format = simpleDateFormat.format(dateDeNaissance);
        return registreNational.startsWith(format);
    }

    @Override
    public void controleEtSupprime(Chauffeur object) throws ValidationException {
        if (ChauffeurDao.deleteChauffeur(object)) {
            setChanged();
            notifyObservers();
        }
    }

    @Override
    public void controleEtModifie(Chauffeur object) throws ValidationException {
        if (ChauffeurDao.updateChauffeur(object)) {
            setChanged();
            notifyObservers();
        }
    }
}
