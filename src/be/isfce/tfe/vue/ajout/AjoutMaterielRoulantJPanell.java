/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.ajout;

import be.isfce.tfe.controleur.MaterielRoulantControleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.metier.MaterielRoulant;
import javax.swing.JOptionPane;

/**
 *
 * @author yema
 */
public class AjoutMaterielRoulantJPanell extends javax.swing.JPanel {

    private DialogUtils.DialogInterface dialogInterface;

    /**
     * Creates new form AjoutMateielRoulantJPanell
     */
    public AjoutMaterielRoulantJPanell() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ajoutervehicule = new javax.swing.JToggleButton();
        ajoutMaterielRoulantJPanell1 = new be.isfce.tfe.vue.encodage.EncodageMaterielRoulantJPanell();

        ajoutervehicule.setText("Enregistrer");
        ajoutervehicule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoutervehiculeActionPerformed(evt);
            }
        });

        ajoutMaterielRoulantJPanell1.setBorder(javax.swing.BorderFactory.createTitledBorder("Matériel Roulant"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ajoutervehicule, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ajoutMaterielRoulantJPanell1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ajoutMaterielRoulantJPanell1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ajoutervehicule)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void setDialogInterface(DialogUtils.DialogInterface dialogInterface) {
        this.dialogInterface = dialogInterface;
    }

    private void ajoutervehiculeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajoutervehiculeActionPerformed
        // TODO add your handling code here:
        MaterielRoulant materielroulant = ajoutMaterielRoulantJPanell1.getMaterielRoulantFromFields();
        try {
            new MaterielRoulantControleur().controleEtAjoute(materielroulant);
            dialogInterface.onButtonSavePressed();
        } catch (ValidationException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_ajoutervehiculeActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private be.isfce.tfe.vue.encodage.EncodageMaterielRoulantJPanell ajoutMaterielRoulantJPanell1;
    private javax.swing.JToggleButton ajoutervehicule;
    // End of variables declaration//GEN-END:variables
}
