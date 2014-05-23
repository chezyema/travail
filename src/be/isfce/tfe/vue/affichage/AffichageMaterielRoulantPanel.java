/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.affichage;


import be.isfce.tfe.controleur.MaterielRoulantControleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.db.MaterielRoulantDBHelper;
import be.isfce.tfe.metier.MaterielRoulant;
import be.isfce.tfe.modele.MaterielRoulantModele;
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
public class AffichageMaterielRoulantPanel extends AffichagePanel{

      List<MaterielRoulant> vehicules;
    
    String[] columnsNames = {"Numero de chassis","Marque","Type","Annee de construction","Carburant","Plaque","Nombre de place","Kilometre actuel"};
    
    
    public AffichageMaterielRoulantPanel(MaterielRoulantControleur vehiculeControleur) {
        super(vehiculeControleur);
    }

    public void setVehicules(List<MaterielRoulant> vehicules) {
        this.vehicules = vehicules;
         displayData();
    }
    
    public AffichageMaterielRoulantPanel(MaterielRoulantControleur vehiculeControleur, List<MaterielRoulant> vehicule) {
        this(vehiculeControleur);
        this.vehicules = vehicule;
        displayData();
    }

    @Override
    public String getTitrePanel() {
        return "Les vehicules";
    }

     public void supprimeVehiculesSelectionnes() throws ValidationException{
        int selectedRow = jTable1.getSelectedRow();
        try{
        abstractControleur.controleEtSupprime(vehicules.get(selectedRow));
        
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
                return vehicules.size();
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
                MaterielRoulant vehicule = vehicules.get(rowIndex);
                switch(columnIndex){
                    case 0: 
                        return vehicule.getId();
                    case 1: 
                        return vehicule.getMarque();
                    case 2: 
                        return vehicule.getType();
                    case 3: 
                        return vehicule.getAnneedeconstruction();
                    case 4: 
                        return vehicule.getCarburant();
                    case 5: 
                        return vehicule.getNumImmatr();
                    case 6: 
                        return vehicule.getNbdeplaces();
                    case 7: 
                        return vehicule.getKmactuel();
                        
                    default :
                        return null;
                }
            }
        };
    }
        @Override
    protected void supprimeElement(int index) {
        try {
            abstractControleur.controleEtSupprime(vehicules.get(index));
                JOptionPane jop1;
            jop1 = new JOptionPane();
            jop1.showMessageDialog(null, "Suppression éxecuter", "Information", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (ValidationException ex) {
            
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
           }
    }
    
  

    @Override
    public void update(Observable o, Object arg) {
         setVehicules(MaterielRoulantModele.getInstance().getTousLesElements());
    }
    
    
      @Override
    protected List<JMenuItem> getMenuItems() {
        List<JMenuItem> menuItems = new ArrayList<JMenuItem>();
        //TODO Ajouter les menu items et leurs actions
        JMenuItem afficherEntretien = new JMenuItem("Les Entretiens");
        afficherEntretien.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO On verra plus tard
            }
        });
        menuItems.add(afficherEntretien);
        
        return menuItems;
    }
    
     protected List<JMenuItem> getMenuItemsCarburant() {
        List<JMenuItem> menuItems = new ArrayList<JMenuItem>();
        //TODO Ajouter les menu items et leurs actions
        JMenuItem afficherCarburant = new JMenuItem("consommation carburant");
        afficherCarburant.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO On verra plus tard
            }
        });
        menuItems.add(afficherCarburant);
        
        return menuItems;
    }
     
      protected List<JMenuItem> getMenuItemsDocument() {
        List<JMenuItem> menuItems = new ArrayList<JMenuItem>();
        //TODO Ajouter les menu items et leurs actions
        JMenuItem afficherDocument = new JMenuItem("afficher documents");
        afficherDocument.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO On verra plus tard
            }
        });
        menuItems.add(afficherDocument);
        
        return menuItems;
    }
    
        protected List<JMenuItem> getMenuItemsUtlisationCarte() {
        List<JMenuItem> menuItems = new ArrayList<JMenuItem>();
        //TODO Ajouter les menu items et leurs actions
        JMenuItem afficherUtilisation = new JMenuItem("Utilisatin Carte Carburant");
        afficherUtilisation.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO On verra plus tard
            }
        });
        menuItems.add(afficherUtilisation);
        
        return menuItems;
    }
}