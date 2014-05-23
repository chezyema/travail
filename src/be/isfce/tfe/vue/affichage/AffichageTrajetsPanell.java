/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.affichage;


import be.isfce.tfe.controleur.TrajetsControleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.metier.Trajet;
import be.isfce.tfe.modele.TrajetModele;
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
public class AffichageTrajetsPanell  extends AffichagePanel {
    

   List<Trajet> trajets;
    
    String[] columnsNames = {"heure de debut","Heure de fin","Date de travail"};
    
      public AffichageTrajetsPanell(TrajetsControleur trajetControleur) {
        super(trajetControleur);
    }
   
     public void setTrajet(List<Trajet> trajet) {
        this.trajets = trajet;
    }
    
      public AffichageTrajetsPanell(TrajetsControleur trajetControleur, List<Trajet> trajet) {
        this(trajetControleur);
        this.trajets = trajet;
        displayData();
    }

    
    @Override
    public String getTitrePanel() {
        return "Les Trajets";
    }
     public void supprimeTrajetsSelectionnes() throws ValidationException{
        int selectedRow = jTable1.getSelectedRow();
        try{
         abstractControleur.controleEtSupprime(trajets.get(selectedRow));
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
                return trajets.size();
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
                Trajet heure = trajets.get(rowIndex);
                switch(columnIndex){
               
                    case 0: 
                        return heure.getHeureDeDebut();
                    case 1:
                        return heure.getHeureDeFin();
                    case 2:
                        return heure.getDateTravail();
                        
                    
                    default :
                        return null;
                }
            }
        };
    }
        @Override
    protected void supprimeElement(int index) {
         try {
            abstractControleur.controleEtSupprime(trajets.get(index));
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
       setTrajet(TrajetModele.getInstance().getTousLesElements());
    }
}
