/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.affichage;

import be.isfce.tfe.controleur.ChauffeurControleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.db.ChauffeurDBHelper;
import be.isfce.tfe.metier.Chauffeur;
import be.isfce.tfe.modele.ChauffeurModele;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author yema
 */
public class AffichageChauffeurPanel extends AffichagePanel {

    List<Chauffeur> chauffeurs;

    String[] columnsNames = {"Nom", "Prénom", "Date de Naissance", "Adresse", "Code Postal", "Ville", "Email","numcartesis","numpermis"};

    public AffichageChauffeurPanel(ChauffeurControleur chauffeurControleur) {
        super(chauffeurControleur);
        chauffeurs = chauffeurControleur.getModele().getTousLesElements();
        displayData();
    }

    public void setChauffeurs(List<Chauffeur> chauffeurs) {
        this.chauffeurs = chauffeurs;
        displayData();
    }

    public AffichageChauffeurPanel(ChauffeurControleur chauffeurControleur, List<Chauffeur> chauffeurs) {
        this(chauffeurControleur);
        this.chauffeurs = chauffeurs;
        displayData();
    }

    @Override
    public String getTitrePanel() {
        return "Chauffeurs";
    }

    public void supprimeChauffeursSelectionnes() {
        int selectedRow = jTable1.getSelectedRow();
        try {
            //TODO Ajouter message validation
            abstractControleur.controleEtSupprime(chauffeurs.get(selectedRow));
        } catch (ValidationException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
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
                return chauffeurs.size();
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
                Chauffeur chauffeur = chauffeurs.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return chauffeur.getNomChauffeur();
                    case 1:
                        return chauffeur.getPrenomChauffeur();
                    case 2:
                        return chauffeur.getDateNaissance();
                    case 3:
                        return chauffeur.getAdresse();
                    case 4:
                        return chauffeur.getCodepostale();
                    case 5:
                        return chauffeur.getVille();
                    case 6:
                        return chauffeur.getEmail();
                    case 7:
                        return chauffeur.getNumcartesis();
                    case 8:
                        return chauffeur.getNumpermis();
                    
                    default:
                        return null;
                }
            }
        };
    }

    @Override
    public void update(Observable o, Object arg) {
        setChauffeurs(ChauffeurModele.getInstance().getTousLesElements());
    }

    @Override
    protected void supprimeElement(int index) {
        try {
            abstractControleur.controleEtSupprime(chauffeurs.get(index));
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
        //TODO Ajouter les menu items et leurs actions
        JMenuItem attribuerBus = new JMenuItem("Assigner un véhicule");
        attribuerBus.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO On verra plus tard
            }
        });
        menuItems.add(attribuerBus);
        
        return menuItems;
    }
    
     protected List<JMenuItem> getMenuItemsheure() {
        List<JMenuItem> menuItems = new ArrayList<JMenuItem>();
        //TODO Ajouter les menu items et leurs actions
        JMenuItem encoderHeure = new JMenuItem("Encoder heure de travail");
        encoderHeure.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO On verra plus tard
            }
        });
        menuItems.add(encoderHeure);
        
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
}
