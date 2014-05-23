/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.controleur;

import be.isfce.tfe.modele.AbstractModel;
import be.isfce.tfe.metier.DocumentAdministratif;
import be.isfce.tfe.validation.StringValidation;
import java.util.Calendar;

/**
 *
 * @author yema
 */
public class DocumentsAdministratifsControleur extends AbstractControleur<DocumentAdministratif> {

    public DocumentsAdministratifsControleur(AbstractModel<DocumentAdministratif> modele) {
        super(modele);
    }

    @Override
    public void controleEtAjoute(DocumentAdministratif documents) throws ValidationException {

        if (documents == null) {
            throw new ValidationException("Le document est invalide");
        }
        if (documents.getLibelle() == null || !StringValidation.VerifString(documents.getLibelle())) {
            throw new ValidationException("le  libelle n'est pas valide");
        }
        Calendar joura = Calendar.getInstance();
        joura.add(Calendar.DAY_OF_MONTH, +1);
        joura.getTime();
        if (documents.getDateValiditer() == null || documents.getDateValiditer().after(joura.getTime())) {
            throw new ValidationException("Le date n'est pas valide");
        }
       modele.cree(documents);
    }

    @Override
    public void controleEtSupprime(DocumentAdministratif object) throws ValidationException {
       modele.supprime(object);
    }

    @Override
    public void controleEtModifie(DocumentAdministratif object) throws ValidationException {
       modele.modifie(object);  
    }

}
