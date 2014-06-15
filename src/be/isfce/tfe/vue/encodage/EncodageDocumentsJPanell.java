/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.encodage;

import be.isfce.tfe.db.ChauffeurDao;
import be.isfce.tfe.db.DocumentAdministratifDao;
import be.isfce.tfe.db.TypeDocumentDao;
import be.isfce.tfe.metier.DocumentAdministratif;
import be.isfce.tfe.metier.TypeDocument;
import java.util.List;

/**
 *
 * @author yema
 */
public class EncodageDocumentsJPanell extends javax.swing.JPanel {

    List<TypeDocument> types;

    /**
     * Creates new form AjoutDocumentsJPanell
     */
    public EncodageDocumentsJPanell() {
        initComponents();
        types = TypeDocumentDao.getTousLesTypesDocument();
        initComboboxType();
    }

    public DocumentAdministratif getDocumentFromFields() {
        DocumentAdministratif documents = new DocumentAdministratif();
        documents.setId(0);
     documents.setDateValiditer(datedocument.getDate());
        documents.setIdtype(types.get(typeDocumentComboBox.getSelectedIndex()).getIdtype());
        return documents;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        datedevaliditer = new javax.swing.JLabel();
        datedocument = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        typeDocumentComboBox = new javax.swing.JComboBox();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        datedevaliditer.setText("Date de fin de validité :");

        jLabel1.setText("Type :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(datedevaliditer)
                    .addComponent(jLabel1))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(typeDocumentComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(datedocument, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(datedevaliditer)
                    .addComponent(datedocument, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(typeDocumentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel datedevaliditer;
    private com.toedter.calendar.JDateChooser datedocument;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox typeDocumentComboBox;
    // End of variables declaration//GEN-END:variables

    private void initComboboxType() {
        for (TypeDocument typeDocument : types) {
            typeDocumentComboBox.addItem(typeDocument.getLibelledocument());
        }
    }
}
