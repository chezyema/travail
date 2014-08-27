/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.affichage;

import be.isfce.tfe.controleur.AmendesControleur;
import be.isfce.tfe.controleur.EntretienControleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.db.AmendesDao;
import be.isfce.tfe.db.EntretienDao;
import be.isfce.tfe.metier.Amendes;
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
public class AffichageAmendePanel extends AffichagePanel {

    List<Amendes> amende;

    String[] columnsNames = {"numero de pv", "date du pv", "montant du pv"};

    public AffichageAmendePanel(AmendesControleur amendeControleur) {
        super(amendeControleur);
        displayData();
    }

    public void setAmendes(List<Amendes> amendes) {
        this.amende = amendes;
        displayData();
    }

    public AffichageAmendePanel(AmendesControleur amendeControleur, List<Amendes> amende) {
        this(amendeControleur);
        this.amende = amende;
        displayData();
    }

    @Override
    public String getTitrePanel() {
        return "Les amendes éfféctuer avec les vehicules";

    }

    public void supprimeAmendesSelectionnes() throws ValidationException {
        int selectedRow = jTable1.getSelectedRow();
        try {
            abstractControleur.controleEtSupprime(amende.get(selectedRow));
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
                return amende.size();
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
                Amendes amendes = amende.get(rowIndex);
                switch (columnIndex) {

                    case 0:
                        return amendes.getNumeropv();
                    case 1:
                        return amendes.getDatepv();
                    case 2:
                        return amendes.getMontantpv();

                    default:
                        return null;
                }
            }
            
             @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                Amendes amendes = amende.get(rowIndex);
                switch (columnIndex) {
                    
                     case 0:
                         amendes.setNumeropv((String) aValue);
                         break;
                   
                    case 1:
                        amendes.setDatepv(new Date());
                        break;
                   case 2:
                        amendes.setMontantpv(Integer.valueOf((String) aValue));
                        break;
                }
                try {
                    abstractControleur.controleEtModifie(amende);
                } catch (ValidationException ex) {
                    //TODO JOptionPane
                }
            }
        };
    }

    @Override
    protected void supprimeElement(int index) {
        try {
            abstractControleur.controleEtSupprime(amende.get(index));
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
            amende = AmendesDao.getTousLesAmendes();
        }
        setAmendes(amende);
    }
}
