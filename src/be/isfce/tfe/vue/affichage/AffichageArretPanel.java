/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.affichage;

import be.isfce.tfe.controleur.ArretControleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.metier.Arret;
import java.util.List;
import java.util.Observable;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author yema
 */
public class AffichageArretPanel extends AffichagePanel {

    List<Arret> arrets;

    String[] columnsNames = {"Adresse des Arret"};

    public void setArret(List<Arret> arret) {
        this.arrets = arret;
        displayData();
    }

    public AffichageArretPanel(ArretControleur arretControleur, List<Arret> arret) {
        super(arretControleur);
        this.arrets = arret;
        displayData();
    }

    @Override
    public String getTitrePanel() {
        return "Arret";
    }

    public void supprimeArretsSelectionnes() throws ValidationException {
        int selectedRow = jTable1.getSelectedRow();
        try {
            abstractControleur.controleEtSupprime(arrets.get(selectedRow));
            JOptionPane.showMessageDialog(null, "Suppression éxecuter", "Information", JOptionPane.INFORMATION_MESSAGE);
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
                return arrets.size();
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
                Arret arret = arrets.get(rowIndex);
                switch (columnIndex) {

                    case 0:
                        return arret.getAdresse();

                    default:
                        return null;
                }
            }

            @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                Arret arret = arrets.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        arret.setAdresse((String) aValue);
                }
            }

        };
    }

    @Override
    protected void supprimeElement(int index) {
        try {
            abstractControleur.controleEtSupprime(arrets.get(index));
        } catch (ValidationException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
