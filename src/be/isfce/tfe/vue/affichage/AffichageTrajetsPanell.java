/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.affichage;

import be.isfce.tfe.controleur.TrajetsControleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.db.CircuitDao;
import be.isfce.tfe.db.TrajetDao;
import be.isfce.tfe.metier.Trajet;
import java.util.Date;
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

    String[] columnsNames = {"heure de debut", "Heure de fin", "Date de travail","kmdepart","kmfin"};

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
                    case 3:
                           return heure.getKmdepart();
                      case 4:
                           return heure.getKmfin();
                    default:
                        return null;
                }
            }
            
             @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                Trajet trajet = trajets.get(rowIndex);
                switch (columnIndex) {
                    
                     case 0:
                         trajet.setHeureDeDebut((String) aValue);
                         break;
                    case 1:
                        trajet.setHeureDeFin((String) aValue);
                        break;
                    case 2:
                        trajet.setDateTravail(new Date());
                        break;
                    case 3:
                        trajet.setKmdepart((Integer)aValue);
                        break;
                    case 4:
                        trajet.setKmfin((Integer)aValue);
                        break;
                    
                }
                try {
                    abstractControleur.controleEtModifie(trajet);
                } catch (ValidationException ex) {
                    //TODO JOptionPane
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
        System.out.println("UPDATE");
        reset();
    }

    private void reset() {
       
         {
            trajets = TrajetDao.getTousLesTrajets();
        }
        setTrajet(trajets);
    }

}
