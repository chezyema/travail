/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.affichage;


import be.isfce.tfe.controleur.EcoleControlleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.db.EcoleDBHelper;
import be.isfce.tfe.metier.Ecole;
import be.isfce.tfe.modele.EcoleModele;
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
public class AffichageEcolePanel  extends AffichagePanel{


     List<Ecole> ecoles;
    
    String[] columnsNames = {"Nom ecole","Adresse ecole","Code postal","Ville"," Telephone","email","Nom du directeur"};
    
     public AffichageEcolePanel(EcoleControlleur ecoleControleur) {
        super(ecoleControleur);
        ecoles = ecoleControleur.getModele().getTousLesElements();
         displayData();
    }
     
     
     public void setEcole(List<Ecole> ecoles) {
        this.ecoles = ecoles;
         displayData();
    }
    
    public AffichageEcolePanel(EcoleControlleur ecoleControleur, List<Ecole> ecole) {
        this(ecoleControleur);
        this.ecoles = ecole;
        displayData();
    }

    
    @Override
    public String getTitrePanel() {
        return "les Etablissements";
    }
    
     public void supprimeEcolesSelectionnes() throws ValidationException{
        int selectedRow = jTable1.getSelectedRow();
        try{
        abstractControleur.controleEtSupprime(ecoles.get(selectedRow));
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
                return ecoles.size();
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
                Ecole ecole = ecoles.get(rowIndex);
                switch(columnIndex){
               
                    case 0: 
                        return ecole.getNomecole();
                    case 1:
                        return ecole.getAdresseecole();
                    case 2:
                        return ecole.getCdpostal();
                    case 3:
                        return ecole.getVil();
                    case 4:
                        return ecole.getTelecole();
                    case 5:
                        return ecole.getEmailecole();
                    case 6:
                        return ecole.getNomdirecteur();
                    
                            
                    
                    default :
                        return null;
                }
            }
        };
    }
        @Override
    protected void supprimeElement(int index) {
          try {
            abstractControleur.controleEtSupprime(ecoles.get(index));
        } catch (ValidationException ex) {
                  JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
           }
}
    
   

    @Override
    public void update(Observable o, Object arg) {
        setEcole(EcoleModele.getInstance().getTousLesElements());
    }
    
    
       @Override
    protected List<JMenuItem> getMenuItems() {
        List<JMenuItem> menuItems = new ArrayList<JMenuItem>();
        //TODO Ajouter les menu items et leurs actions
        JMenuItem afficherEleve = new JMenuItem("Les Eleves");
        afficherEleve.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO On verra plus tard
            }
        });
        menuItems.add(afficherEleve);
        
        return menuItems;
    }
    
     protected List<JMenuItem> getMenuItemsCircuit() {
        List<JMenuItem> menuItems = new ArrayList<JMenuItem>();
        //TODO Ajouter les menu items et leurs actions
        JMenuItem afficherCircuit = new JMenuItem("Les Circuits");
        afficherCircuit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO On verra plus tard
            }
        });
        menuItems.add(afficherCircuit);
        
        return menuItems;
    }
     
    
}