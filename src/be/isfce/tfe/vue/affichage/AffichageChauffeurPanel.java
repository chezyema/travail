/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.affichage;

import be.isfce.tfe.controleur.ChauffeurControleur;
import be.isfce.tfe.controleur.DocumentsAdministratifsControleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.metier.Arret;
import be.isfce.tfe.metier.Chauffeur;
import be.isfce.tfe.vue.ajout.DialogUtils;
import be.isfce.tfe.vue.encodage.EncodageTrajetsJPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author yema
 */
public class AffichageChauffeurPanel extends AffichagePanel {

    List<Chauffeur> chauffeurs;

    String[] columnsNames = {"Registre national","Nom", "Prénom", "Date de Naissance", "Adresse", "Code Postal", "Ville", "Email", "numcartesis", "numpermis"};

    public void setChauffeurs(List<Chauffeur> chauffeurs) {
        this.chauffeurs = chauffeurs;
        displayData();
    }

    public AffichageChauffeurPanel(ChauffeurControleur chauffeurControleur, List<Chauffeur> chauffeurs) {
        super(chauffeurControleur);
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

            abstractControleur.controleEtSupprime(chauffeurs.get(selectedRow));
            JOptionPane.showMessageDialog(this, "Suppression exécutée", "Information", JOptionPane.INFORMATION_MESSAGE);
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
                        return chauffeur.getId();
                    
                    case 1:
                        return chauffeur.getNomChauffeur();
                    case 2:
                        return chauffeur.getPrenomChauffeur();
                    case 3:
                        return chauffeur.getDateNaissance();
                    case 4:
                        return chauffeur.getAdresse();
                    case 5:
                        return chauffeur.getCodepostale();
                    case 6:
                        return chauffeur.getVille();
                    case 7:
                        return chauffeur.getEmail();
                    case 8:
                        return chauffeur.getNumcartesis();
                    case 9:
                        return chauffeur.getNumpermis();

                    default:
                        return null;
                }
            }

            @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                Chauffeur chauffeur = chauffeurs.get(rowIndex);
                switch (columnIndex) {
                    
                     case 0:
                         chauffeur.setId((String) aValue);
                         break;
                    case 1:
                        chauffeur.setNomChauffeur((String) aValue);
                        break;
                    case 2:
                        chauffeur.setPrenomChauffeur((String) aValue);
                        break;
                    case 3:
                        //TODO
                        chauffeur.setDateNaissance(new Date());
                        break;
                    case 4:
                        chauffeur.setAdresse((String) aValue);
                        break;
                    case 5:
                        chauffeur.setCodepostale((Integer) aValue);
                        break;
                    case 6:
                        chauffeur.setVille((String) aValue);
                        break;
                    case 7:
                        chauffeur.setEmail((String) aValue);
                        break;
                    case 8:
                        chauffeur.setNumcartesis((String) aValue);
                        break;
                    case 9:
                        chauffeur.setNumpermis((String) aValue);
                        break;
                }
                try {
                    abstractControleur.controleEtModifie(chauffeur);
                } catch (ValidationException ex) {
                    //TODO JOptionPane
                }
            }
        };
    }

    @Override
    protected void supprimeElement(int index) {
        try {
            abstractControleur.controleEtSupprime(chauffeurs.get(index));
            JOptionPane.showMessageDialog(this, "Suppression exécutée", "Information", JOptionPane.INFORMATION_MESSAGE);
        } catch (ValidationException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    protected List<JMenuItem> getMenuItems() {
        List<JMenuItem> menuItems = new ArrayList<JMenuItem>();
        menuItems.add(getEncoderHeureMenuItem());
        menuItems.add(getAfficherDocumentMenuItem());
        menuItems.add(getAfficherChauffeurArchiverMenuItem());
        menuItems.add(getAjouterDocumentMenuItem());

        return menuItems;
    }

    private JMenuItem getEncoderHeureMenuItem() {
        JMenuItem encoderHeure = new JMenuItem("Encoder heure de travail");
        encoderHeure.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO On verra plus tard
                final EncodageTrajetsJPanel encodageTrajetsJPanel = new EncodageTrajetsJPanel();
                JDialog afficheDialog = DialogUtils.afficheDialog(null, encodageTrajetsJPanel);
                //TODO Ajouter dans la DB
            }
        });
        return encoderHeure;
    }

    private JMenuItem getAfficherDocumentMenuItem() {
        JMenuItem afficherDocument = new JMenuItem("Afficher documents");
        afficherDocument.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO On verra plus tard
                Chauffeur chauffeur = chauffeurs.get(jTable1.getSelectedRow());
                AffichageDocumentsPanel affichageDocumentsPanel = new AffichageDocumentsPanel(new DocumentsAdministratifsControleur(), chauffeur.getLesdocuments());
                DialogUtils.afficheDialog(null, affichageDocumentsPanel);
            }
        });
        return afficherDocument;
    }
    
     private JMenuItem getAfficherChauffeurArchiverMenuItem() {
        JMenuItem afficherChauffeurArchives = new JMenuItem("Chauffeurs Archives");
        afficherChauffeurArchives.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO On verra plus tard
                Chauffeur chauffeur = chauffeurs.get(jTable1.getSelectedRow());
               //todo afficher chauffeur archiver
            }
        });
        return  afficherChauffeurArchives;
    }
     
      private JMenuItem getAjouterDocumentMenuItem() {
        JMenuItem ajouterDocument = new JMenuItem("Ajouter documents");
        ajouterDocument.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO On verra plus tard
                Chauffeur chauffeur = chauffeurs.get(jTable1.getSelectedRow());
               //todo afficher chauffeur archiver
            }
        });
        return  ajouterDocument;
    }

    @Override
    public void update(Observable o, Object arg) {
        setChauffeurs(chauffeurs);
    }
}
