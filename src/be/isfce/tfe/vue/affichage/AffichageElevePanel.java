/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.affichage;

import be.isfce.tfe.controleur.EleveControleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.db.EleveDao;
import be.isfce.tfe.metier.Eleve;
import java.util.Date;
import java.util.List;
import java.util.Observable;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author yema
 */
public class AffichageElevePanel extends AffichagePanel {

    List<Eleve> eleves;

    String[] columnsNames = {"Registre national", "Nom", "Prénom", "Date de Naissance","sexe", "Adresse", "Code Postal", "Ville", "Nom du responsable", "telephone du responsable", "Email du responsable"};

    public AffichageElevePanel(EleveControleur eleveControleur) {
        super(eleveControleur);
        displayData();
    }

    public void setEleve(List<Eleve> eleves) {
        this.eleves = eleves;
        displayData();
    }

    public AffichageElevePanel(EleveControleur eleveControleur, List<Eleve> eleves) {
        super(eleveControleur);
        this.eleves = eleves;
        displayData();
    }

    @Override
    public String getTitrePanel() {
        return "Les Eleves";
    }

    public void supprimeEleveSelectionnes() throws ValidationException {
        int selectedRow = jTable1.getSelectedRow();
        try {
            abstractControleur.controleEtSupprime(eleves.get(selectedRow));
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
                return eleves.size();
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
                Eleve eleve = eleves.get(rowIndex);
                switch (columnIndex) {
                    case 0:
                        return eleve.getId();
                    case 1:
                        return eleve.getNomEleve();
                    case 2:
                        return eleve.getPrenomEleve();
                    case 3:
                        return eleve.getDatedenaissance();
                    case 4:
                        return eleve.getSexe();
                    case 5:
                        return eleve.getAdresseEleve();
                    case 6:
                        return eleve.getCdpostal();
                    case 7:
                        return eleve.getVil();
                    case 8:
                        return eleve.getNomResponsable();
                    case 9:
                        return eleve.getTelResponsable();
                    case 10:
                        return eleve.getEmailResponsable();
                    default:
                        return null;
                }
            }
            
             @Override
            public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
                Eleve eleve = eleves.get(rowIndex);
                switch (columnIndex) {
                    
                     case 0:
                         eleve.setId((String) aValue);
                         break;
                    case 1:
                        eleve.setNomEleve((String) aValue);
                        break;
                    case 2:
                        eleve.setPrenomEleve((String) aValue);
                        break;
                    case 3:
                        //TODO
                        eleve.setDatedenaissance(new Date());
                        break;
                    case 4:
                        eleve.setSexe((String) aValue);
                    case 5:
                        eleve.setAdresseEleve((String) aValue);
                        break;
                    case 6:
                        eleve.setCdpostal(Integer.valueOf((String) aValue));
                        break;
                    case 7:
                        eleve.setVil((String) aValue);
                        break;
                    case 8:
                        eleve.setNomResponsable((String) aValue);
                        break;
                    case 9:
                        eleve.setTelResponsable((String) aValue);
                        break;
                    case 10:
                        eleve.setEmailResponsable((String) aValue);
                        break;
                }
                try {
                    abstractControleur.controleEtModifie(eleve);
                } catch (ValidationException ex) {
                    //TODO JOptionPane
                }
            }
        };
    }

    @Override
    protected void supprimeElement(int index) {
        try {
            abstractControleur.controleEtSupprime(eleves.get(index));
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
            eleves = EleveDao.getTousLesEleves();
        }
        setEleve(eleves);
    }


}
