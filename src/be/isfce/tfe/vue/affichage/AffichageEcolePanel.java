/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.affichage;

import be.isfce.tfe.controleur.CircuitControleur;
import be.isfce.tfe.controleur.EcoleControlleur;
import be.isfce.tfe.controleur.EleveControleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.metier.Circuit;
import be.isfce.tfe.metier.Ecole;
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
public class AffichageEcolePanel extends AffichagePanel {

    List<Ecole> ecoles;

    String[] columnsNames = {"Nom ecole", "Adresse ecole", "Code postal", "Ville", " Telephone", "email", "Nom du directeur"};

    public void setEcole(List<Ecole> ecoles) {
        this.ecoles = ecoles;
        displayData();
    }

    public AffichageEcolePanel(EcoleControlleur ecoleControleur, List<Ecole> ecole) {
        super(ecoleControleur);
        this.ecoles = ecole;
        displayData();
    }

    @Override
    public String getTitrePanel() {
        return "les Etablissements";
    }

    public void supprimeEcolesSelectionnes() throws ValidationException {
        int selectedRow = jTable1.getSelectedRow();
        try {
            abstractControleur.controleEtSupprime(ecoles.get(selectedRow));
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
                switch (columnIndex) {

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

                    default:
                        return null;
                }
            }
            
             @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                Ecole ecole = ecoles.get(rowIndex);
                switch (columnIndex) {
                    
                     case 0:
                         ecole.setNomecole((String) aValue);
                         break;
                    case 1:
                        ecole.setAdresseecole((String) aValue);
                        break;
                    case 2:
                        ecole.setCdpostal((Integer) aValue);
                        break;
                    case 3:
                        //TODO
                        ecole.setVil((String)aValue);
                        break;
                    case 4:
                        ecole.setTelecole((String) aValue);
                        break;
                    case 5:
                        ecole.setEmailecole((String) aValue);
                        break;
                    case 6:
                        ecole.setNomdirecteur((String) aValue);
                        break;
                  
                }
                try {
                    abstractControleur.controleEtModifie(ecole);
                } catch (ValidationException ex) {
                    //TODO JOptionPane
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
    
    
      protected List<JMenuItem> getMenuItems() {
        List<JMenuItem> menuItems = new ArrayList<JMenuItem>();
        menuItems.add(getAfficherEleveMenuItem());
        menuItems.add(getAfficherCircuitMenuItem());
        menuItems.add(getAjouterElevesMenuItem());
       
        
        
        return menuItems;
    }
    
    private JMenuItem getAfficherEleveMenuItem(){
        JMenuItem afficherEleve = new JMenuItem("Afficher Eléves");
        afficherEleve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO On verra plus tard
                Ecole ecole = ecoles.get(jTable1.getSelectedRow());
                AffichageElevePanel affichageElevePanel = new AffichageElevePanel(new EleveControleur(), ecole.getLeseleves());
                DialogUtils.afficheDialog(null, affichageElevePanel);
                //TODO Ajouter dans la DB
            }
        });
        return afficherEleve;
    }
     
    private JMenuItem getAfficherCircuitMenuItem(){
        JMenuItem afficherCircuit = new JMenuItem("Afficher Circuits");
        afficherCircuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO On verra plus tard
                Ecole ecole = ecoles.get(jTable1.getSelectedRow());
                AffichageCircuitPanel affichageCircuitPanel = new AffichageCircuitPanel(new CircuitControleur(), ecole.getLescircuits());
                DialogUtils.afficheDialog(null, affichageCircuitPanel);
                //TODO Ajouter dans la DB
            }
        });
        return afficherCircuit;
    }
    
       private JMenuItem getAjouterElevesMenuItem(){
        JMenuItem ajouterEleves = new JMenuItem("Ajouter Eleves");
        ajouterEleves.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO On verra plus tard
                Ecole ecole = ecoles.get(jTable1.getSelectedRow());
                AffichageCircuitPanel affichageCircuitPanel = new AffichageCircuitPanel(new CircuitControleur(), ecole.getLescircuits());
                DialogUtils.afficheDialog(null, affichageCircuitPanel);
                //TODO Ajouter dans la DB
            }
        });
        return ajouterEleves;
    }

    @Override
    public void update(Observable o, Object arg) {
     setEcole(ecoles);
    }

}
