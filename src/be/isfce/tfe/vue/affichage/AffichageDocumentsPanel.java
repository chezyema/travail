/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.affichage;

import be.isfce.tfe.controleur.DocumentsAdministratifsControleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.metier.DocumentAdministratif;
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

    String[] columnsNames = {"Libelle", "Date validiter"};

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
                        return doc.getLibelle();
                    case 1:
                        return doc.getDateValiditer();

                    default:
                        return null;
                }
            }
        };
    }

    @Override
    protected void supprimeElement(int index) {
        try {
            abstractControleur.controleEtSupprime(documents.get(index));
        } catch (ValidationException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
