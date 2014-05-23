/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.affichage;


import be.isfce.tfe.controleur.EleveControleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.metier.Eleve;
import be.isfce.tfe.modele.EleveModele;
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
public class AffichageElevePanel extends AffichagePanel{

      List<Eleve> eleves;
    
    String[] columnsNames = {"Registre national","Nom","Prénom","Date de Naissance","Adresse","Code Postal","Ville","Nom du responsable","telephone du responsable","Email du responsable"};
    
       public AffichageElevePanel(EleveControleur eleveControleur) {
        super(eleveControleur);
    }
   

    public void setEleve(List<Eleve> eleves) {
        this.eleves = eleves;
    }
    
    public AffichageElevePanel(EleveControleur eleveControleur, List<Eleve> eleve) {
        this(eleveControleur);
         this.eleves = eleves;
        displayData();
    }

    @Override
    public String getTitrePanel() {
        return "Les Eleves";
    }
    
    public void supprimeEleveSelectionnes() throws ValidationException{
        int selectedRow = jTable1.getSelectedRow();
        try{
        abstractControleur.controleEtSupprime(eleves.get(selectedRow));
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
                return eleves.size();
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
                Eleve eleve = eleves.get(rowIndex);
                switch(columnIndex){
                    case 0: 
                        return eleve.getId();
                    case 1: 
                        return eleve.getNomEleve();
                    case 2: 
                        return eleve.getPrenomEleve();
                    case 3: 
                        return eleve.getDatedenaissance();
                    case 4: 
                        return eleve.getAdresseEleve();
                    case 5: 
                        return eleve.getCdpostal();
                    case 6: 
                        return eleve.getVil();
                    case 7: 
                        return eleve.getNomResponsable();
                    case 8:
                        return eleve.getTelResponsable();
                    case 9:
                        return eleve.getEmailResponsable();
                    default :
                        return null;
                }
            }
        };
    }
        @Override
    protected void supprimeElement(int index) {
          try {
            abstractControleur.controleEtSupprime(eleves.get(index));
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
       setEleve(EleveModele.getInstance().getTousLesElements());
    }
}