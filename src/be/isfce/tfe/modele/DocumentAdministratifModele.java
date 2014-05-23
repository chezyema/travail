/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.modele;

import be.isfce.tfe.db.DocumentAdministratifDBHelper;
import be.isfce.tfe.metier.DocumentAdministratif;
import java.util.List;

/**
 *
 * @author yema
 */
public class DocumentAdministratifModele extends AbstractModel<DocumentAdministratif> {

  private static DocumentAdministratifModele instance;

    private DocumentAdministratifModele() {
        liste = DocumentAdministratifDBHelper.getTousLesDocuments();
    }

    public static DocumentAdministratifModele getInstance() {
        if (instance == null) {
            instance = new DocumentAdministratifModele();
        }
        return instance;
    }

    @Override
    public List<DocumentAdministratif> getTousLesElements() {
        return liste;
    }

    @Override
    public boolean supprime(DocumentAdministratif element) {
        liste.remove(element);
        boolean deleteDocumentAdministratif = DocumentAdministratifDBHelper.deleteDocumentsAdministratifs(element);
        if (deleteDocumentAdministratif) {
            setChanged();
            notifyObservers(ELEMENT_SUPPRIME);
        }
        return deleteDocumentAdministratif;
    }

    @Override
    public boolean modifie(DocumentAdministratif element) {
        DocumentAdministratif document = getDocumentAdministratif(element.getId());
        if (document != null) {
            boolean updateDocument = DocumentAdministratifDBHelper.updateDocuments(document);
            if (updateDocument) {
                setChanged();
                notifyObservers(ELEMENT_MODIFIE);
            }
            return updateDocument;
        }
        return false;
    }

    @Override
    public boolean cree(DocumentAdministratif element) {
        //J'ajoute l'élément dans la BD
        boolean addDocumentAdministratif = DocumentAdministratifDBHelper.addDocumentsAdministratifs(element);
        if (addDocumentAdministratif) {
            liste.add(element);
            setChanged();
            notifyObservers(ELEMENT_AJOUTE);
        }
        return addDocumentAdministratif;
    }

    private DocumentAdministratif getDocumentAdministratif(int id) {
        for (DocumentAdministratif document : liste) {
            if (document.getId() == 0 ) {
                return document;
            }
        }
        return null;
    }

}