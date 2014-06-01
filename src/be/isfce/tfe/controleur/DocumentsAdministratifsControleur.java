/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.controleur;

import be.isfce.tfe.db.DocumentAdministratifDao;
import be.isfce.tfe.metier.DocumentAdministratif;
import be.isfce.tfe.validation.StringValidation;
import java.util.Calendar;

/**
 *
 * @author yema
 */
public class DocumentsAdministratifsControleur extends AbstractControleur<DocumentAdministratif> {

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
        if (documents.getDateValiditer() == null || documents.getDateValiditer().before(joura.getTime())) {
            throw new ValidationException("Le date n'est pas valide");
        }
        if (DocumentAdministratifDao.addDocumentsAdministratifs(documents)) {
            setChanged();
            notifyObservers();
        }
    }

    @Override
    public void controleEtSupprime(DocumentAdministratif object) throws ValidationException {
        DocumentAdministratifDao.deleteDocumentsAdministratifs(object);
        if (DocumentAdministratifDao.deleteDocumentsAdministratifs(object)) {
            setChanged();
            notifyObservers();
        }
    }

    @Override
    public void controleEtModifie(DocumentAdministratif object) throws ValidationException {
        if (DocumentAdministratifDao.updateDocuments(object)) {
            setChanged();
            notifyObservers();
        }
    }

}
