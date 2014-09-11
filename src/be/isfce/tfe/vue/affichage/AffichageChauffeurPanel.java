/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.affichage;

import be.isfce.tfe.controleur.ChauffeurControleur;
import be.isfce.tfe.controleur.DocumentsAdministratifsControleur;
import be.isfce.tfe.controleur.TrajetsControleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.db.ChauffeurDao;
import be.isfce.tfe.metier.Chauffeur;
import be.isfce.tfe.vue.ajout.AjoutDocumentsJPanell;
import be.isfce.tfe.vue.ajout.AjoutTrajetsJPanel;
import be.isfce.tfe.vue.ajout.DialogUtils;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author yema
 */
public class AffichageChauffeurPanel extends AffichagePanel {

    private List<Chauffeur> chauffeurs;
    private boolean afficheArchive;
    private String[] columnsNames = {"Registre national", "Nom", "Prénom", "Date de Naissance","sexe", "Adresse", "Code Postal", "Ville", "Email", "numcartesis", "numpermis"};

    private Dialog dialog = null;

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

    public void setAfficheArchive(boolean afficheArchive) {
        this.afficheArchive = afficheArchive;
    }

    /**
     * Supprime le chauffeur sélectionné.
     */
    public void supprimeChauffeursSelectionnes() {
        //Récupère l'indice du chauffeur selectionné
        int selectedRow = jTable1.getSelectedRow();
        try {
            //Supprime le chauffeur.
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
        //Retourne le TableModel qui permet de créer la JTable dans la classe mère.
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

            /**
             * Retourne la valeur correspondant à un case de la JTable.
             *
             * @param rowIndex index de la ligne de la case
             * @param columnIndex index de la colonne de la case
             * @return
             */
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
                        return chauffeur.getSexe();
                    case 5:
                        return chauffeur.getAdresse();
                    case 6:
                        return chauffeur.getCodepostale();
                    case 7:
                        return chauffeur.getVille();
                    case 8:
                        return chauffeur.getEmail();
                    case 9:
                        return chauffeur.getNumcartesis();
                    case 10:
                        return chauffeur.getNumpermis();

                    default:
                        return null;
                }
            }

            /**
             * Change la valeur de la case de la JTable
             *
             * @param aValue nouvelle valeur
             * @param rowIndex
             * @param columnIndex
             */
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
                    case 4 :
                        chauffeur.setSexe((String) aValue);
                        break;
                    case 5:
                        chauffeur.setAdresse((String) aValue);
                        break;
                    case 6:
                        chauffeur.setCodepostale(Integer.valueOf((String) aValue));
                        break;
                    case 7:
                        chauffeur.setVille((String) aValue);
                        break;
                    case 8:
                        chauffeur.setEmail((String) aValue);
                        break;
                    case 9:
                        chauffeur.setNumcartesis((String) aValue);
                        break;
                    case 10:
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

    /**
     * Ajoute des entrées dans le Popup Menu
     *
     * @return
     */
    @Override
    protected List<JMenuItem> getMenuItems() {
        List<JMenuItem> menuItems = new ArrayList<JMenuItem>();
        menuItems.add(getEncoderHeureMenuItem());
        menuItems.add(getAfficherDocumentMenuItem());
        menuItems.add(getAjouterDocumentMenuItem());
        menuItems.add(getAfficherFeuilleDeRouteMenuItem());
        menuItems.add(getAfficherTrajetsMensuelsMenuItem());

        return menuItems;
    }

    //Crée un menu item et son ActionListener.

    private JMenuItem getEncoderHeureMenuItem() {
        JMenuItem encoderHeure = new JMenuItem("Encoder heure de travail");
        encoderHeure.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Chauffeur chauffeur = chauffeurs.get(jTable1.getSelectedRow());
                final AjoutTrajetsJPanel encodageTrajetsJPanel = new AjoutTrajetsJPanel(chauffeur);
                encodageTrajetsJPanel.setDialogInterface(new DialogUtils.DialogInterface() {
                    @Override
                    public void onButtonSavePressed() {
                        dialog.dispose();
                        reset();
                    }
                });
                dialog = DialogUtils.afficheDialog(null, encodageTrajetsJPanel);

            }
        });
        return encoderHeure;
    }

    private JMenuItem getAfficherDocumentMenuItem() {
        JMenuItem afficherDocument = new JMenuItem("Afficher documents");
        afficherDocument.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Chauffeur chauffeur = chauffeurs.get(jTable1.getSelectedRow());
                AffichageDocumentsPanel affichageDocumentsPanel = new AffichageDocumentsPanel(new DocumentsAdministratifsControleur(), chauffeur.getLesdocuments());
                DialogUtils.afficheDialog(null, affichageDocumentsPanel);
            }
        });
        return afficherDocument;
    }

    private JMenuItem getAfficherFeuilleDeRouteMenuItem() {
        JMenuItem afficherFeuilleDeRoute = new JMenuItem("Afficher feuille de route");
        afficherFeuilleDeRoute.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Chauffeur chauffeur = chauffeurs.get(jTable1.getSelectedRow());

                AffichageTrajetsPanell affichageFeuilleDeRoutePanel = new AffichageTrajetsPanell(new TrajetsControleur(), chauffeur.getLesheures());
                DialogUtils.afficheDialog(null, affichageFeuilleDeRoutePanel);
            }
        });
        return afficherFeuilleDeRoute;
    }

    private JMenuItem getAfficherTrajetsMensuelsMenuItem() {
        JMenuItem afficherFeuilleDeRoute = new JMenuItem("Afficher feuille de route mensuelle");
        afficherFeuilleDeRoute.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Chauffeur chauffeur = chauffeurs.get(jTable1.getSelectedRow());

                AffichageHeureTravailMensuel affichageFeuilleDeRoutePanel = new AffichageHeureTravailMensuel(chauffeur);
                DialogUtils.afficheDialog(null, affichageFeuilleDeRoutePanel);
            }
        });
        return afficherFeuilleDeRoute;
    }

    private JMenuItem getAjouterDocumentMenuItem() {
        JMenuItem ajouterDocument = new JMenuItem("Ajouter documents");
        ajouterDocument.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Chauffeur chauffeur = chauffeurs.get(jTable1.getSelectedRow());
                AjoutDocumentsJPanell ajoutDocumentsJPanell = new AjoutDocumentsJPanell(chauffeur);
                ajoutDocumentsJPanell.setDialogInterface(new DialogUtils.DialogInterface() {
                    @Override
                    public void onButtonSavePressed() {
                        dialog.dispose();
                        reset();
                    }
                });
                dialog = DialogUtils.afficheDialog(null, ajoutDocumentsJPanell);
            }
        });
        return ajouterDocument;
    }
    
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("UPDATE");
        reset();
    }
    //Reset la vue. Recharche tous les chauffeurs de la BD.
    private void reset() {
        if (afficheArchive) {
            chauffeurs = ChauffeurDao.getTousLesChauffeursarchives();
        } else {
            chauffeurs = ChauffeurDao.getTousLesChauffeurs();
        }
        setChauffeurs(chauffeurs);
    }
}
