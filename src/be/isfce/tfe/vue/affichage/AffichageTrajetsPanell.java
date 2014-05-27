/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.affichage;

import be.isfce.tfe.controleur.TrajetsControleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.metier.Trajet;
import java.util.List;
import java.util.Observable;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author yema
 */
public class AffichageTrajetsPanell extends AffichagePanel {

    List<Trajet> trajets;

    String[] columnsNames = {"heure de debut", "Heure de fin", "Date de travail"};

    public AffichageTrajetsPanell(TrajetsControleur trajetControleur) {
        super(trajetControleur);
        displayData();
    }

    public void setTrajet(List<Trajet> trajet) {
        this.trajets = trajet;
        displayData();
    }

    public AffichageTrajetsPanell(TrajetsControleur trajetControleur, List<Trajet> trajet) {
        this(trajetControleur);
        this.trajets = trajet;
        displayData();
    }

    @Override
    public String getTitrePanel() {
        return "Les Trajets";
    }

    public void supprimeTrajetsSelectionnes() throws ValidationException {
        int selectedRow = jTable1.getSelectedRow();
        try {
            abstractControleur.controleEtSupprime(trajets.get(selectedRow));
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
                return trajets.size();
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
                Trajet heure = trajets.get(rowIndex);
                switch (columnIndex) {

                    case 0:
                        return heure.getHeureDeDebut();
                    case 1:
                        return heure.getHeureDeFin();
                    case 2:
                        return heure.getDateTravail();

                    default:
                        return null;
                }
            }
        };
    }

    @Override
    protected void supprimeElement(int index) {
        try {
            abstractControleur.controleEtSupprime(trajets.get(index));
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
