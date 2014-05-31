/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.affichage;

import be.isfce.tfe.controleur.CarteCarburantControleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.metier.CarteCarburant;
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
public class AffichageCarteCarburantPanel extends AffichagePanel {

    List<CarteCarburant> cartecarburant;

    String[] columnsNames = {"Numéro de Carte", "kilometre utilisation", "Litre de carburant"};

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
                        return carte.getKmUtilisation();
                    case 2:
                        return carte.getLitreCarburant();
                    default:
                        return null;
                }
            }
        };
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
        JMenuItem afficherCarte = new JMenuItem("Afficher Utilisation véhicule");
        afficherCarte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // CarteCarburant carte = carte.get(jTable1.getSelectedRow());
                //Todo encore faire action
            }

        });
        return afficherCarte;
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
