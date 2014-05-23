/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.affichage;

import be.isfce.tfe.controleur.UtilisationCarteControleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.metier.UtilisationCarte;
import be.isfce.tfe.modele.UtilisationCarteModele;
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
public class AffichageUtilisationCarteJPanel extends AffichagePanel {

    List<UtilisationCarte> utilisations;

    String[] columnsNames = {"Date utilisation"};

    public AffichageUtilisationCarteJPanel(UtilisationCarteControleur utilisationControleur) {
       super(utilisationControleur);
    }

    public void setUtilisationCarte(List<UtilisationCarte> utilisationcarte) {
        this.utilisations = utilisationcarte;
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
    
     public void supprimeUtilisationCarteSelectionnes() throws ValidationException{
        int selectedRow = jTable1.getSelectedRow();
        try{
         abstractControleur.controleEtSupprime(utilisations.get(selectedRow));
            JOptionPane jop1;
            jop1 = new JOptionPane();
            jop1.showMessageDialog(null, "Suppression éxecuter", "Information", JOptionPane.INFORMATION_MESSAGE);
            
           }
          catch (NumberFormatException ex) {
            
            JOptionPane jop3;
            jop3 = new JOptionPane();
            jop3.showMessageDialog(null, "Suppression échoué", "Erreur", JOptionPane.ERROR_MESSAGE);
            
           }
    }

    

    @Override
    public AbstractTableModel getTableModel() {
        return new AbstractTableModel() {

            @Override
            public String getColumnName(int col) {
                return columnsNames[col].toString();
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
    protected List<JMenuItem> getMenuItems() {
        List<JMenuItem> menuItems = new ArrayList<JMenuItem>();
        
        return menuItems;
    }

    @Override
    public void update(Observable o, Object arg) {
        setUtilisationCarte(UtilisationCarteModele.getInstance().getTousLesElements());
    }
}
