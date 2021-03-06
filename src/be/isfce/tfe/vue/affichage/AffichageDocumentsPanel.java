/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.affichage;

import be.isfce.tfe.controleur.DocumentsAdministratifsControleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.db.ChauffeurDao;
import be.isfce.tfe.db.DocumentAdministratifDao;
import be.isfce.tfe.db.TypeDocumentDao;
import be.isfce.tfe.metier.Chauffeur;
import be.isfce.tfe.metier.DocumentAdministratif;
import be.isfce.tfe.metier.TypeDocument;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author yema
 */
public class AffichageDocumentsPanel extends AffichagePanel {

    List<DocumentAdministratif> documents;
    String[] columnsNames = {"Libelle", "Date validiter", "Appartenance"};

    public void setDocuments(List<DocumentAdministratif> documents) {
        this.documents = documents;
        displayData();
    }

    public AffichageDocumentsPanel(DocumentsAdministratifsControleur documentControleur, List<DocumentAdministratif> document) {
        super(documentControleur);
        this.documents = document;
        displayData();
    }

    @Override
    public String getTitrePanel() {
        return "Les documents administratifs";
    }

    public void supprimeDocumentSelectionnes() throws ValidationException {
        int selectedRow = jTable1.getSelectedRow();
        try {
            abstractControleur.controleEtSupprime(documents.get(selectedRow));
            JOptionPane.showMessageDialog(null, "Suppression éxecuter", "Information", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Suppression échoué", "Erreur", JOptionPane.ERROR_MESSAGE);

        }
    }

    @Override
    public AbstractTableModel getTableModel() {
        return new AbstractTableModel() {
            @Override
            public String getColumnName(int col) {
                return columnsNames[col];
            }

            @Override
            public int getRowCount() {
                return documents.size();
            }

            @Override
            public int getColumnCount() {
                return columnsNames.length;
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return true;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                DocumentAdministratif doc = documents.get(rowIndex);
                switch (columnIndex) {

                    case 0:
                        TypeDocument type = TypeDocumentDao.getTypeDocumentAdministratif(doc.getIdtype());
                        return type != null ? type.getLibelledocument() : "";
                    case 1:
                        return doc.getDateValiditer();
                    case 2:
                        Chauffeur chauffeur = ChauffeurDao.getChauffeur(doc.getIdchauffeur());
                        return chauffeur != null ? (chauffeur.getNomChauffeur() + " " + chauffeur.getPrenomChauffeur()) : doc.getIdmaterielroulant();

                    default:
                        return null;
                }
            }

            @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                DocumentAdministratif document = documents.get(rowIndex);
                switch (columnIndex) {

                    case 0:
                        document.setDateValiditer(new Date());
                        //Todo encore à faire
                        break;
                    case 1:
                        document.setIdtype(Integer.valueOf((String) aValue));
                        break;
                }
                try {
                    abstractControleur.controleEtModifie(document);
                } catch (ValidationException ex) {
                    //TODO JOptionPane
                }
            }
        };
    }

    @Override
    protected void supprimeElement(int index) {
        try {
            DocumentAdministratif document = documents.get(index);
            abstractControleur.controleEtSupprime(document);
            documents.remove(document);
            jTable1.updateUI();
        } catch (ValidationException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("UPDATE");
        //reset();
    }

    private void reset() {
        documents = DocumentAdministratifDao.getTousLesDocuments();
        setDocuments(documents);
    }
}
