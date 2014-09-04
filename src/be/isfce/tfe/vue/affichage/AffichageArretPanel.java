/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.affichage;

import be.isfce.tfe.controleur.ArretControleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.db.ArretDao;
import be.isfce.tfe.metier.Arret;
import java.awt.Cursor;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DragSource;
import java.util.List;
import java.util.Observable;
import javax.activation.ActivationDataFlavor;
import javax.activation.DataHandler;
import javax.swing.DropMode;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.TransferHandler;
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

        jTable1.setDragEnabled(true);
        jTable1.setDropMode(DropMode.INSERT_ROWS);
        jTable1.setTransferHandler(new TableRowTransferHandler(jTable1));
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
        return new MyTableModel();
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
        System.out.println("UPDATE");
        reset();
    }

    private void reset() {
        arrets = ArretDao.getTousLesArrets();
        setArret(arrets);
    }

    public class MyTableModel extends javax.swing.table.AbstractTableModel implements Reorderable {

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
            try {
                abstractControleur.controleEtModifie(arret);
            } catch (ValidationException ex) {
                //TODO JOptionPane
            }
        }

        @Override
        public void reorder(int fromIndex, int toIndex) {
            Arret arret = arrets.remove(fromIndex);
            if(toIndex >= fromIndex){
                toIndex--;
            }
            arrets.add(toIndex , arret);
            fireTableDataChanged();
        }
    }

    /**
     * Handles drag & drop row reordering
     */
    public static class TableRowTransferHandler extends TransferHandler {

        private final DataFlavor localObjectFlavor = new ActivationDataFlavor(Integer.class, DataFlavor.javaJVMLocalObjectMimeType, "Integer Row Index");
        private JTable table = null;

        public TableRowTransferHandler(JTable table) {
            this.table = table;
        }

        @Override
        protected Transferable createTransferable(JComponent c) {
            assert (c == table);
            return new DataHandler(new Integer(table.getSelectedRow()), localObjectFlavor.getMimeType());
        }

        @Override
        public boolean canImport(TransferHandler.TransferSupport info) {
            boolean b = info.getComponent() == table && info.isDrop() && info.isDataFlavorSupported(localObjectFlavor);
            table.setCursor(b ? DragSource.DefaultMoveDrop : DragSource.DefaultMoveNoDrop);
            return b;
        }

        @Override
        public int getSourceActions(JComponent c) {
            return TransferHandler.COPY_OR_MOVE;
        }

        @Override
        public boolean importData(TransferHandler.TransferSupport info) {
            JTable target = (JTable) info.getComponent();
            JTable.DropLocation dl = (JTable.DropLocation) info.getDropLocation();
            int index = dl.getRow();
            int max = table.getModel().getRowCount();
            if (index < 0 || index > max) {
                index = max;
            }
            target.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            try {
                Integer rowFrom = (Integer) info.getTransferable().getTransferData(localObjectFlavor);
                if (rowFrom != -1 && rowFrom != index) {
                    ((Reorderable) table.getModel()).reorder(rowFrom, index);
                    if (index > rowFrom) {
                        index--;
                    }
                    target.getSelectionModel().addSelectionInterval(index, index);
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }

        @Override
        protected void exportDone(JComponent c, Transferable t, int act) {
            if (act == TransferHandler.MOVE) {
                table.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        }

    }

    public static interface Reorderable {

        public void reorder(int fromIndex, int toIndex);
    }

}
