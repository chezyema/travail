/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.affichage;

import be.isfce.tfe.controleur.EntretienControleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.db.EntretienDao;
import be.isfce.tfe.metier.Entretien;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author yema
 */
public class AffichageEntretienPanel extends AffichagePanel {

    List<Entretien> entretiens;

    String[] columnsNames = {"Description", "Kilometrage actuel", "Date entretien"};

    public AffichageEntretienPanel(EntretienControleur entretienControleur) {
        super(entretienControleur);
        //displayData();
    }

    public void setEntretien(List<Entretien> entretiens) {
        this.entretiens = entretiens;
        displayData();
    }

    public AffichageEntretienPanel(EntretienControleur entretienControleur, List<Entretien> entretien) {
        super(entretienControleur);
        this.entretiens = entretien;
        displayData();
    }

    @Override
    public String getTitrePanel() {
        return "Les entretiens des vehicules";

    }

    public void supprimeEntretiensSelectionnes() throws ValidationException {
        int selectedRow = jTable1.getSelectedRow();
        try {
            abstractControleur.controleEtSupprime(entretiens.get(selectedRow));
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
                return entretiens.size();
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
                Entretien entretien = entretiens.get(rowIndex);
                switch (columnIndex) {

                    case 0:
                        return entretien.getDescription();
                    case 1:
                        return entretien.getKmEntretienFait();
                    case 2:
                        return entretien.getDateEntretien();

                    default:
                        return null;
                }
            }
            
             @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                Entretien entretien = entretiens.get(rowIndex);
                switch (columnIndex) {
                    
                     case 0:
                         entretien.setDescription((String) aValue);
                         break;
                    case 1:
                        entretien.setKmEntretienFait(Integer.valueOf((String) aValue));
                        break;
                    case 2:
                        entretien.setDateEntretien(new Date());
                        break;
                  
                }
                try {
                    abstractControleur.controleEtModifie(entretien);
                } catch (ValidationException ex) {
                    //TODO JOptionPane
                }
            }
        };
    }

    @Override
    protected void supprimeElement(int index) {
        try {
            abstractControleur.controleEtSupprime(entretiens.get(index));
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
       
         {
            entretiens = EntretienDao.getTousLesEntretiens();
        }
        setEntretien(entretiens);
    }
}
