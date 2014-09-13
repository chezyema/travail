/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.affichage;

import be.isfce.tfe.controleur.AmendesControleur;
import be.isfce.tfe.controleur.DocumentsAdministratifsControleur;
import be.isfce.tfe.controleur.EntretienControleur;
import be.isfce.tfe.controleur.MaterielRoulantControleur;
import be.isfce.tfe.controleur.UtilisationCarteControleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.db.CircuitDao;
import be.isfce.tfe.db.MaterielRoulantDao;
import be.isfce.tfe.db.TypeMaterielDao;
import be.isfce.tfe.metier.MaterielRoulant;
import be.isfce.tfe.metier.TypeMaterielRoulant;
import be.isfce.tfe.vue.ajout.AjoutAmendesJPanel;
import be.isfce.tfe.vue.ajout.AjoutDocumentsJPanell;
import be.isfce.tfe.vue.ajout.AjoutEntretienJPanell;
import be.isfce.tfe.vue.ajout.AjoutUtilisationCarteJPanell;
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
public class AffichageMaterielRoulantPanel extends AffichagePanel {

    List<MaterielRoulant> vehicules;
    String[] columnsNames = {"Numero de chassis", "Marque", "Type", "Annee de construction", "Carburant", "Plaque", "Nombre de place", "Kilometre actuel"};

    private Dialog dialog;

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
                        TypeMaterielRoulant type = TypeMaterielDao.getTypeMateriel(vehicule.getIdtypemateriel());
                        //System.out.println(""+type);
                        return type != null ? type.getTypemateriel() : "";

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

            @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                MaterielRoulant vehicule = vehicules.get(rowIndex);
                switch (columnIndex) {

                    case 0:
                        vehicule.setId((String) aValue);
                        break;
                    case 1:
                        vehicule.setMarque((String) aValue);
                        break;

                    case 2:
                        vehicule.setIdtypemateriel(Integer.valueOf((String) aValue));
                        break;

                    case 3:
                        //TODO
                        vehicule.setAnneedeconstruction(new Date());
                        break;
                    case 4:
                        vehicule.setCarburant((String) aValue);
                        break;
                    case 5:
                        vehicule.setNumImmatr((String) aValue);
                        break;
                    case 6:
                        vehicule.setNbDePlaces(Integer.valueOf(aValue.toString()));
                        break;
                    case 7:
                        vehicule.setKmactuel(Integer.valueOf(aValue.toString()));
                        break;

                }
                try {
                    abstractControleur.controleEtModifie(vehicule);
                } catch (ValidationException ex) {
                    //TODO JOptionPane
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
        menuItems.add(getAjouterEntretienMenuItem());
        menuItems.add(getAfficherDocumentMenuItem());
        menuItems.add(getAjouterDocumentMenuItem());
        menuItems.add(getAfficherAmendesMenuItem());
        menuItems.add(getAjouterAmendeMenuItem());
        menuItems.add(getAjouterUtilisationCarteMenuItem());
        menuItems.add(getUtilisationCarburantMenuItem());
        menuItems.add(getAfficherUtlisationsMensuelles());

        return menuItems;
    }

    private JMenuItem getAfficherEntretienMenuItem() {
        JMenuItem entretien = new JMenuItem("Les Entretiens");
        entretien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MaterielRoulant materiel = vehicules.get(jTable1.getSelectedRow());
                AffichageEntretienPanel affichageEntretienPanel = new AffichageEntretienPanel(new EntretienControleur(), materiel.getLesentretiens());
                DialogUtils.afficheDialog(null, affichageEntretienPanel);
            }
        });
        return entretien;
    }

    private JMenuItem getAfficherUtlisationsMensuelles() {
        JMenuItem entretien = new JMenuItem("Statistique Carte Carburant");
        entretien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MaterielRoulant materiel = vehicules.get(jTable1.getSelectedRow());
                AfficherEtRechercherUtilisationCartePanel affichageEntretienPanel = new AfficherEtRechercherUtilisationCartePanel(materiel);
                DialogUtils.afficheDialog(null, affichageEntretienPanel);
            }
        });
        return entretien;
    }

    private JMenuItem getAfficherAmendesMenuItem() {
        JMenuItem amende = new JMenuItem("Les Amendes");
        amende.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MaterielRoulant materiel = vehicules.get(jTable1.getSelectedRow());
                AffichageAmendePanel affichageAmendePanel = new AffichageAmendePanel(new AmendesControleur(), materiel.getLesamendes());
                DialogUtils.afficheDialog(null, affichageAmendePanel);
            }
        });
        return amende;
    }

    private JMenuItem getUtilisationCarburantMenuItem() {
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

    private JMenuItem getAjouterEntretienMenuItem() {
        JMenuItem ajouterEntretien = new JMenuItem("Ajouter Entretiens");
        ajouterEntretien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MaterielRoulant materielRoulant = vehicules.get(jTable1.getSelectedRow());
                AjoutEntretienJPanell ajoutEntretienJPanell = new AjoutEntretienJPanell(materielRoulant);
                ajoutEntretienJPanell.setDialogInterface(new DialogUtils.DialogInterface() {

                    @Override
                    public void onButtonSavePressed() {
                        dialog.dispose();
                        reset();
                    }
                });
                dialog = DialogUtils.afficheDialog(null, ajoutEntretienJPanell);
            }
        });
        return ajouterEntretien;
    }

    private JMenuItem getAjouterAmendeMenuItem() {
        JMenuItem ajouterAmende = new JMenuItem("Ajouter Amende");
        ajouterAmende.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MaterielRoulant materielRoulant = vehicules.get(jTable1.getSelectedRow());
                AjoutAmendesJPanel ajoutAmendesJPanel = new AjoutAmendesJPanel(materielRoulant);
                ajoutAmendesJPanel.setDialogInterface(new DialogUtils.DialogInterface() {

                    @Override
                    public void onButtonSavePressed() {
                        dialog.dispose();
                        reset();
                    }
                });
                dialog = DialogUtils.afficheDialog(null, ajoutAmendesJPanel);
            }
        });
        return ajouterAmende;
    }

    private JMenuItem getAfficherDocumentMenuItem() {
        JMenuItem afficherDocument = new JMenuItem("Afficher documents");
        afficherDocument.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                MaterielRoulant materiel = vehicules.get(jTable1.getSelectedRow());
                AffichageDocumentsPanel affichageDocumentsPanel = new AffichageDocumentsPanel(new DocumentsAdministratifsControleur(), materiel.getLesdocuments());
                DialogUtils.afficheDialog(null, affichageDocumentsPanel);
            }
        });
        return afficherDocument;
    }

    private JMenuItem getAjouterDocumentMenuItem() {
        JMenuItem ajouterDocument = new JMenuItem("Ajouter documents");
        ajouterDocument.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                MaterielRoulant materiel = vehicules.get(jTable1.getSelectedRow());
                AjoutDocumentsJPanell ajoutDocumentsJPanell = new AjoutDocumentsJPanell(materiel);
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

    private JMenuItem getAjouterUtilisationCarteMenuItem() {
        JMenuItem ajouterUtilisation = new JMenuItem("Ajouter Utilisation carte");
        ajouterUtilisation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MaterielRoulant materiels = vehicules.get(jTable1.getSelectedRow());
                AjoutUtilisationCarteJPanell ajoutUtilisationJPanell = new AjoutUtilisationCarteJPanell(materiels);
                ajoutUtilisationJPanell.setDialogInterface(new DialogUtils.DialogInterface() {

                    @Override
                    public void onButtonSavePressed() {
                        dialog.dispose();
                        reset();
                    }
                });
                dialog = DialogUtils.afficheDialog(null, ajoutUtilisationJPanell);
            }
        });
        return ajouterUtilisation;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("UPDATE");
        reset();
    }

    private void reset() {

        {
            vehicules = MaterielRoulantDao.getTousLesVehicules();
        }
        setVehicules(vehicules);
    }
}
