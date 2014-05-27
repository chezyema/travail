/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.affichage;

import be.isfce.tfe.controleur.ChauffeurControleur;
import be.isfce.tfe.controleur.DocumentsAdministratifsControleur;
import be.isfce.tfe.controleur.TrajetsControleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.db.MaterielRoulantDao;
import be.isfce.tfe.db.TrajetDao;
import be.isfce.tfe.metier.Chauffeur;
import be.isfce.tfe.metier.MaterielRoulant;
import be.isfce.tfe.metier.Trajet;
import be.isfce.tfe.vue.ajout.AjoutTrajetsJPanel;
import be.isfce.tfe.vue.ajout.DialogUtils;
import be.isfce.tfe.vue.encodage.EncodageArretJPanel;
import be.isfce.tfe.vue.encodage.EncodageTrajetsJPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author yema
 */
public class AffichageChauffeurPanel extends AffichagePanel {

    List<Chauffeur> chauffeurs;

    String[] columnsNames = {"Nom", "Prénom", "Date de Naissance", "Adresse", "Code Postal", "Ville", "Email", "numcartesis", "numpermis"};

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
        JMenu attribuerBus = new JMenu("Assigner un véhicule");
        List<MaterielRoulant> tousLesVehicules = MaterielRoulantDao.getTousLesVehicules();

        ButtonGroup group = new ButtonGroup();
        for (MaterielRoulant materielRoulant : tousLesVehicules) {
            JMenuItem vehicule = new JRadioButtonMenuItem(materielRoulant.getMarque() + " [" + materielRoulant.getNumImmatr() + "]");
            group.add(vehicule);
            vehicule.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //TODO On verra plus tard 
                }
            });
            attribuerBus.add(vehicule);
        }
        menuItems.add(attribuerBus);

        //TODO Ajouter les menu items et leurs actions
        JMenuItem encoderHeure = new JMenuItem("Encoder heure de travail");
        encoderHeure.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO On verra plus tard
                final EncodageTrajetsJPanel encodageTrajetsJPanel = new EncodageTrajetsJPanel();
                JDialog afficheDialog = DialogUtils.afficheDialog(null, encodageTrajetsJPanel);
                afficheDialog.addWindowListener(new WindowAdapter() {

                    @Override
                    public void windowClosed(WindowEvent e) {
                        Trajet trajetFromFields = encodageTrajetsJPanel.getTrajetFromFields();
                        Chauffeur chauffeur = chauffeurs.get(jTable1.getSelectedRow());
                        trajetFromFields.setLeschauffeurs(chauffeur);
                        try {
                            new TrajetsControleur().controleEtAjoute(trajetFromFields);
                        } catch (ValidationException ex) {
                            //JOptionPane.show
                        }
                    }

                });
            }
        });
        menuItems.add(encoderHeure);

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
        menuItems.add(afficherDocument);
        return menuItems;
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
