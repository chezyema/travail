/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.affichage;

import be.isfce.tfe.controleur.UtilisationCarteControleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.metier.UtilisationCarte;
import java.util.List;
import java.util.Observable;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author yema
 */
public class AffichageUtilisationCarteJPanel extends AffichagePanel {

    List<UtilisationCarte> utilisations;

    String[] columnsNames = {"Date utilisation"};

    public AffichageUtilisationCarteJPanel(UtilisationCarteControleur utilisationControleur) {
        super(utilisationControleur);
        displayData();
    }

    public void setUtilisationCarte(List<UtilisationCarte> utilisationcarte) {
        this.utilisations = utilisationcarte;
        displayData();
    }

    public AffichageUtilisationCarteJPanel(UtilisationCarteControleur utilisationControleur, List<UtilisationCarte> utilisation) {
        this(utilisationControleur);
        this.utilisations = utilisation;
        displayData();
    }

    @Override
    public String getTitrePanel() {
        return "Carte utilisation";
    }

    public void supprimeUtilisationCarteSelectionnes() throws ValidationException {
        int selectedRow = jTable1.getSelectedRow();
        try {
            abstractControleur.controleEtSupprime(utilisations.get(selectedRow));
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
                return utilisations.size();
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
                UtilisationCarte utilisation = utilisations.get(rowIndex);
                switch (columnIndex) {

                    case 0:
                        return utilisation.getDateUtilisation();

                    default:
                        return null;
                }
            }
        };
    }

    @Override
    protected void supprimeElement(int index) {
        try {
            abstractControleur.controleEtSupprime(utilisations.get(index));
        } catch (ValidationException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
