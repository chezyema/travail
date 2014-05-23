/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.affichage;


import be.isfce.tfe.controleur.CircuitControleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.db.CircuitDBHelper;
import be.isfce.tfe.metier.Circuit;
import be.isfce.tfe.modele.CarteCarburantModele;
import be.isfce.tfe.modele.CircuitModele;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class AffichageCircuitPanel extends AffichagePanel {
    
    List<Circuit> circuits;
    
    String[] columnsNames = {"Nom circuit","Temps prevu","Kilometre de depart","kilometre de fin"};
    
     public AffichageCircuitPanel(CircuitControleur circuitControleur) {
       super(circuitControleur);
       circuits = circuitControleur.getModele().getTousLesElements();
        displayData();
    }
     public void setCircuit(List<Circuit> circuits) {
        this.circuits = circuits;
         displayData();
    }
    
    public AffichageCircuitPanel(CircuitControleur circuitControleur, List<Circuit> circuit) {
        this(circuitControleur);
        this.circuits = circuit;
        displayData();
    }

    
    @Override
    public String getTitrePanel() {
        return "Les Circuits";
    }
    
     public void supprimeCircuitsSelectionnes() throws ValidationException{
        int selectedRow = jTable1.getSelectedRow();
        try{
         abstractControleur.controleEtSupprime(circuits.get(selectedRow));
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
                return circuits.size();
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
                Circuit trajet = circuits.get(rowIndex);
                switch(columnIndex){
               
                    case 0: 
                        return trajet.getNomCircuit();
                    case 1:
                        return trajet.getTempsPrevu();
                    case 2:
                        return trajet.getKmDepart();
                    case 3:
                        return trajet.getKmFin();
                    
                    
                    default :
                        return null;
                }
            }
        };
    }
        @Override
    protected void supprimeElement(int index) {
       try {
            abstractControleur.controleEtSupprime(circuits.get(index));
        } catch (ValidationException ex) {
                  JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
           }
}
    
  

    @Override
    public void update(Observable o, Object arg) {
        setCircuit(CircuitModele.getInstance().getTousLesElements());
    }
      
    @Override
    protected List<JMenuItem> getMenuItems() {
        List<JMenuItem> menuItems = new ArrayList<JMenuItem>();
        //TODO Ajouter les menu items et leurs actions
        JMenuItem attribuerCircuit = new JMenuItem("Assigner un circuit");
        attribuerCircuit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO On verra plus tard
            }
        });
        menuItems.add(attribuerCircuit);
        
        return menuItems;
    }
    
     protected List<JMenuItem> getMenuItemsArret() {
        List<JMenuItem> menuItems = new ArrayList<JMenuItem>();
        //TODO Ajouter les menu items et leurs actions
        JMenuItem afficherArret = new JMenuItem("afficher  arrets ");
        afficherArret.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO On verra plus tard
            }
        });
        menuItems.add(afficherArret);
        
        return menuItems;
    }
     
        protected List<JMenuItem> getMenuItemsEleve() {
        List<JMenuItem> menuItems = new ArrayList<JMenuItem>();
        //TODO Ajouter les menu items et leurs actions
        JMenuItem afficherEleve = new JMenuItem("afficher eleves");
        afficherEleve.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO On verra plus tard
            }
        });
        menuItems.add(afficherEleve);
        
        return menuItems;
    }
}
