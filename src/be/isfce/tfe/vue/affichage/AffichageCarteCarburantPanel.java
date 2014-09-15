/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.affichage;

import be.isfce.tfe.controleur.CarteCarburantControleur;
import be.isfce.tfe.controleur.MaterielRoulantControleur;
import be.isfce.tfe.controleur.UtilisationCarteControleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.db.CarteCarburantDao;
import be.isfce.tfe.metier.CarteCarburant;
import be.isfce.tfe.metier.UtilisationCarte;
import be.isfce.tfe.vue.ajout.DialogUtils;
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
public class AffichageCarteCarburantPanel extends AffichagePanel {

    List<CarteCarburant> cartecarburant;

    String[] columnsNames = {"Numéro de Carte", "Nombre d'utilisations", "Carburant (Litre)", "Dernière utilisation"};

    public void setCarteCarburant(List<CarteCarburant> cartecarburant) {
        this.cartecarburant = cartecarburant;
        displayData();
    }

    public AffichageCarteCarburantPanel(CarteCarburantControleur cartecarburantControleur, List<CarteCarburant> cartecarburant) {
        super(cartecarburantControleur);
        this.cartecarburant = cartecarburant;
        displayData();
    }

    @Override
    public String getTitrePanel() {
        return "Carte de Carburant";
    }

    public void supprimeCarteCarburantSelectionnes() throws ValidationException {
        int selectedRow = jTable1.getSelectedRow();
        try {
            abstractControleur.controleEtSupprime(cartecarburant.get(selectedRow));
        } catch (NumberFormatException ex) {
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
                return cartecarburant.size();
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
                CarteCarburant carte = cartecarburant.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return carte.getNumcarte();
                    case 1:
                        return carte.getLesutilisations().size();
                    case 2:
                        return calculLitre(carte);
                    case 3:
                        return getDerniereUtilisation(carte);
                    default:
                        return null;
                }
            }

            @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                CarteCarburant carte = cartecarburant.get(rowIndex);
                switch (columnIndex) {

                    case 0:
                        carte.setNumcarte((String) aValue);
                        break;

                }
                try {
                    abstractControleur.controleEtModifie(carte);
                } catch (ValidationException ex) {
                    // TODO message
                }
            }

        };
    }

    private Object getDerniereUtilisation(CarteCarburant carte) {
        List<UtilisationCarte> lesutilisations = carte.getLesutilisations();
        Date derniereUtilisation = new Date(0);
        for (UtilisationCarte utilisationCarte : lesutilisations) {
            if (derniereUtilisation.before(utilisationCarte.getDateUtilisation())) {
                derniereUtilisation = utilisationCarte.getDateUtilisation();
            }
        }
        return derniereUtilisation.equals(new Date(0)) ? null : derniereUtilisation;
    }

    private int calculLitre(CarteCarburant carte) {
        List<UtilisationCarte> lesutilisations = carte.getLesutilisations();
        int litres = 0;
        for (UtilisationCarte utilisationCarte : lesutilisations) {
            litres += utilisationCarte.getLitrecarburant();
        }
        return litres;
    }

    @Override
    protected void supprimeElement(int index) {
        try {
            abstractControleur.controleEtSupprime(cartecarburant.get(index));
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
        menuItems.add(getAfficherVehiculeUtilisationMenuItem());

        return menuItems;
    }

    private JMenuItem getAfficherVehiculeUtilisationMenuItem() {
        JMenuItem afficherCarte = new JMenuItem("Afficher Utilisation Cartes");
        afficherCarte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                CarteCarburant carte = cartecarburant.get(jTable1.getSelectedRow());
                AffichageUtilisationCarteJPanel affichageVehiculePanel = new AffichageUtilisationCarteJPanel(new UtilisationCarteControleur(), carte.getLesutilisations());
                DialogUtils.afficheDialog(null, affichageVehiculePanel);
            }

        });
        return afficherCarte;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("UPDATE");
        //reset();
    }

    private void reset() {
        cartecarburant = CarteCarburantDao.getTousLesCartesCarburant();
        setCarteCarburant(cartecarburant);
    }
}
