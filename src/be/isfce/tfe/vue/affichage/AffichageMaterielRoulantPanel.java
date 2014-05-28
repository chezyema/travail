/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.affichage;

import be.isfce.tfe.controleur.MaterielRoulantControleur;
import be.isfce.tfe.controleur.UtilisationCarteControleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.metier.MaterielRoulant;
import be.isfce.tfe.vue.ajout.DialogUtils;
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
public class AffichageMaterielRoulantPanel extends AffichagePanel {

    List<MaterielRoulant> vehicules;

    String[] columnsNames = {"Numero de chassis", "Marque", "Type", "Annee de construction", "Carburant", "Plaque", "Nombre de place", "Kilometre actuel"};

    public void setVehicules(List<MaterielRoulant> vehicules) {
        this.vehicules = vehicules;
        displayData();
    }

    public AffichageMaterielRoulantPanel(MaterielRoulantControleur vehiculeControleur, List<MaterielRoulant> vehicule) {
        super(vehiculeControleur);
        this.vehicules = vehicule;
        displayData();
    }

    @Override
    public String getTitrePanel() {
        return "Les vehicules";
    }

    public void supprimeVehiculesSelectionnes() throws ValidationException {
        int selectedRow = jTable1.getSelectedRow();
        try {
            abstractControleur.controleEtSupprime(vehicules.get(selectedRow));
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
                switch (columnIndex) {
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

                    default:
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
    protected List<JMenuItem> getMenuItems() {
        List<JMenuItem> menuItems = new ArrayList<JMenuItem>();
        menuItems.add(getAfficherEntretienMenuItem());
        menuItems.add( getUtilisationCarburantMenuItem());
        menuItems.add( getAjouterEntretienMenuItem());
        menuItems.add( getAjouterDocumentMenuItem()); 
        
        
        return menuItems;
         }
    
     private JMenuItem getAfficherEntretienMenuItem(){
        JMenuItem entretien = new JMenuItem("Les Entretiens");
        entretien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 //TODO On verra plus tard
            }
        });
        return entretien;
    }
     
     
    
    
    private JMenuItem getUtilisationCarburantMenuItem(){
        JMenuItem utilisation = new JMenuItem("Utilisation Carte Carburant");
        utilisation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MaterielRoulant materielRoulant = vehicules.get(jTable1.getSelectedRow());
                //TODO Utilisation Carte
                AffichageUtilisationCarteJPanel affichageUtilisationCarteJPanel = new AffichageUtilisationCarteJPanel(new UtilisationCarteControleur(), materielRoulant.getLesmemos());
                DialogUtils.afficheDialog(null, affichageUtilisationCarteJPanel);
            }
        });
        return utilisation;
    }
    
      private JMenuItem getAjouterEntretienMenuItem(){
        JMenuItem ajouterEntretien = new JMenuItem("Ajouter Entretiens");
        ajouterEntretien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 //TODO On verra plus tard
            }
        });
        return ajouterEntretien;
    }
      
        private JMenuItem getAjouterDocumentMenuItem(){
        JMenuItem ajouterdocument = new JMenuItem("Ajouter Documents");
        ajouterdocument.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 //TODO On verra plus tard
            }
        });
        return ajouterdocument;
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
