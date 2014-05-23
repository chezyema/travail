/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.affichage;


import be.isfce.tfe.controleur.EntretienControleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.metier.Entretien;
import be.isfce.tfe.modele.EntretienModele;
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
public class AffichageEntretienPanel extends AffichagePanel{


    List<Entretien> entretiens;
    
    String[] columnsNames = {"Description","Kilometrage actuel","Date entretien"};
     
    public AffichageEntretienPanel(EntretienControleur entretienControleur) {
       super(entretienControleur);
    }
     
     public void setEntretien(List<Entretien> entretiens) {
        this.entretiens = entretiens;
    }
    
    public AffichageEntretienPanel(EntretienControleur entretienControleur, List<Entretien> entretien) {
        this(entretienControleur);
        this.entretiens = entretien;
        displayData();
    }

    
    @Override
    public String getTitrePanel() {
        return "Les entretiens des vehicules";
        
    }
    
       public void supprimeEntretiensSelectionnes() throws ValidationException{
        int selectedRow = jTable1.getSelectedRow();
        try{
         abstractControleur.controleEtSupprime(entretiens.get(selectedRow));
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
                return entretiens.size();
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
                Entretien entretien = entretiens.get(rowIndex);
                switch(columnIndex){
               
                    case 0: 
                        return entretien.getDescription();
                    case 1:
                        return entretien.getKmEntretienFait();
                    case 2:
                        return entretien.getDateEntretien();
                    
                    
                    default :
                        return null;
                }
            }
        };
    }
        @Override
    protected void supprimeElement(int index)  {
       try {
            abstractControleur.controleEtSupprime(entretiens.get(index));
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
        setEntretien(EntretienModele.getInstance().getTousLesElements());
    }
}