/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.affichage;

import be.isfce.tfe.controleur.UtilisationCarteControleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.db.CarteCarburantDao;
import be.isfce.tfe.db.CircuitDao;
import be.isfce.tfe.db.UtilisationCarteDao;
import be.isfce.tfe.metier.CarteCarburant;
import be.isfce.tfe.metier.UtilisationCarte;
import java.util.Date;
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
    String[] columnsNames = {"Date utilisation", "litre de carburant", "kilométre utilisation"};

    public AffichageUtilisationCarteJPanel(UtilisationCarteControleur utilisationControleur) {
        super(utilisationControleur);
        //displayData();
    }

    public void setUtilisationCarte(List<UtilisationCarte> utilisationcarte) {
        this.utilisations = utilisationcarte;
        displayData();
    }

    public AffichageUtilisationCarteJPanel(UtilisationCarteControleur utilisationControleur, List<UtilisationCarte> utilisation) {
        super(utilisationControleur);
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
            JOptionPane.showMessageDialog(null, "Suppression éxecutée", "Information", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Suppression échouée", "Erreur", JOptionPane.ERROR_MESSAGE);

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
                return columnIndex != 0;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                UtilisationCarte utilisation = utilisations.get(rowIndex);
                switch (columnIndex) {

                    case 0:
                        return utilisation.getDateUtilisation();
                    case 1:
                        return utilisation.getLitrecarburant();
                    case 2:
                        return utilisation.getKmutilisation();

                    default:
                        return null;
                }
            }

            @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                UtilisationCarte utilisation = utilisations.get(rowIndex);
                switch (columnIndex) {

                    case 0:
                        utilisation.setDateutilisation(new Date());

                    case 1:
                        utilisation.setLitrecarburant(Integer.valueOf((String) aValue));
                    case 2:
                        utilisation.setKmutilisation(Integer.valueOf((String) aValue));

                }
                try {
                    abstractControleur.controleEtModifie(utilisation);
                } catch (ValidationException ex) {
                    //TODO JOptionPane
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
        System.out.println("UPDATE");
        reset();
    }

    private void reset() {
        utilisations = UtilisationCarteDao.getTousLesUtilisationCarte();
        setUtilisationCarte(utilisations);
    }
}
