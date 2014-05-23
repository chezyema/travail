/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.affichage;


import be.isfce.tfe.controleur.DocumentsAdministratifsControleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.metier.DocumentAdministratif;
import be.isfce.tfe.modele.DocumentAdministratifModele;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author yema
 */
public class AffichageDocumentsPanel extends AffichagePanel {

  List<DocumentAdministratif> documents;
    
    String[] columnsNames = {"Libelle","Date validiter"};
    
     public AffichageDocumentsPanel(DocumentsAdministratifsControleur documentControleur){  
        super(documentControleur);
    }
     public void setDocuments(List<DocumentAdministratif> documents) {
        this.documents = documents;
    }
    
    public AffichageDocumentsPanel ( DocumentsAdministratifsControleur documentControleur, List<DocumentAdministratif> document) {
        this(documentControleur);
        this.documents = documents;
        displayData();
    }

    
    @Override
    public String getTitrePanel() {
        return "Les documents administratifs";
    }
 public void supprimeDocumentSelectionnes() throws ValidationException{
        int selectedRow = jTable1.getSelectedRow();
        try{
         abstractControleur.controleEtSupprime(documents.get(selectedRow));
            JOptionPane jop1;
            jop1 = new JOptionPane();
            jop1.showMessageDialog(null, "Suppression éxecuter", "Information", JOptionPane.INFORMATION_MESSAGE);
            
           }
          catch (NumberFormatException ex) {
            
            JOptionPane jop3;
            jop3 = new JOptionPane();
            jop3.showMessageDialog(null, "Suppression échoué", "Erreur", JOptionPane.ERROR_MESSAGE);
            
           }
    }
    @Override
    public AbstractTableModel getTableModel() {
        return new AbstractTableModel() {

            @Override
            public String getColumnName(int col) {
                return columnsNames[col].toString();
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
                switch(columnIndex){
               
                    case 0: 
                        return doc.getLibelle();
                    case 1:
                        return doc.getDateValiditer();
                    
                    
                    default :
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
    protected List<JMenuItem> getMenuItems() {
        List<JMenuItem> menuItems = new ArrayList<JMenuItem>();
        
        return menuItems;
    }

    @Override
    public void update(Observable o, Object arg) {
        setDocuments(DocumentAdministratifModele.getInstance().getTousLesElements());
    }
}

