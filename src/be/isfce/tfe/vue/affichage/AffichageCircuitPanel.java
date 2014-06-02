/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.affichage;

import be.isfce.tfe.controleur.ArretControleur;
import be.isfce.tfe.controleur.CircuitControleur;
import be.isfce.tfe.controleur.EleveControleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.metier.Circuit;
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
public class AffichageCircuitPanel extends AffichagePanel {

    List<Circuit> circuits;

    String[] columnsNames = {"Nom circuit", "Temps prevu", "Kilometre de depart", "kilometre de fin"};

    public void setCircuit(List<Circuit> circuits) {
        this.circuits = circuits;
        displayData();
    }

    public AffichageCircuitPanel(CircuitControleur circuitControleur, List<Circuit> circuit) {
        super(circuitControleur);
        this.circuits = circuit;
        displayData();
    }

    @Override
    public String getTitrePanel() {
        return "Les Circuits";
    }

    public void supprimeCircuitsSelectionnes() throws ValidationException {
        int selectedRow = jTable1.getSelectedRow();
        try {
            abstractControleur.controleEtSupprime(circuits.get(selectedRow));
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
                switch (columnIndex) {

                    case 0:
                        return trajet.getNomCircuit();
                    case 1:
                        return trajet.getTempsPrevu();
                    case 2:
                        return trajet.getKmDepart();
                    case 3:
                        return trajet.getKmFin();

                    default:
                        return null;
                }
            }
                @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                Circuit circuit = circuits.get(rowIndex);
                switch (columnIndex) {
                    
                     case 0:
                         circuit.setNomCircuit((String) aValue);
                         break;
                    case 1:
                        circuit.setTempsPrevu((String) aValue);
                        break;
                    case 2:
                        circuit.setKmDepart((Integer) aValue);
                        break;
                    case 3:
                         circuit.setKmFin((Integer) aValue);
                        
                        break;
                   
                }
                try {
                    abstractControleur.controleEtModifie(circuit);
                } catch (ValidationException ex) {
                    //TODO JOptionPane
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
    protected List<JMenuItem> getMenuItems() {
        List<JMenuItem> menuItems = new ArrayList<JMenuItem>();
        menuItems.add(getAfficherArretMenuItem());
        menuItems.add(getAfficherEleveMenuItem());
        menuItems.add(getAjouterArretMenuItem());
       
       
        
        return menuItems;
    }
      private JMenuItem getAfficherArretMenuItem(){
        JMenuItem afficherArret = new JMenuItem("Afficher Arrêts");
        afficherArret.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Circuit circuit = circuits.get(jTable1.getSelectedRow());
                AffichageArretPanel affichageArretPanel = new AffichageArretPanel(new ArretControleur(), circuit.getLesarrets());
                DialogUtils.afficheDialog(null, affichageArretPanel);
            }
        });
        return afficherArret;
    }
      
      private JMenuItem getAfficherEleveMenuItem(){
        JMenuItem afficherEleve = new JMenuItem("Afficher Eleves");
        afficherEleve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Circuit circuit = circuits.get(jTable1.getSelectedRow());
                AffichageElevePanel affichageElevePanel = new AffichageElevePanel(new EleveControleur(), circuit.getLeseleves());
                DialogUtils.afficheDialog(null, affichageElevePanel);
            }
        });
        return afficherEleve;
    }
       
     
     
       
           private JMenuItem getAjouterArretMenuItem(){
        JMenuItem ajouterArret = new JMenuItem("Ajouter Arret");
        ajouterArret.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Circuit circuit = circuits.get(jTable1.getSelectedRow());
               //TODO à faire action
            }
        });
        return ajouterArret;
    }

  
    @Override
    public void update(Observable o, Object arg) {
        setCircuit(circuits);
    }

}
