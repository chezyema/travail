/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.ajout;

import be.isfce.tfe.controleur.EcoleControlleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.metier.Ecole;
import javax.swing.JOptionPane;

/**
 *
 * @author yema
 */
public class AjoutEcoleJPanel extends javax.swing.JPanel {

    /**
     * Creates new form EncodageEcoleJPanel
     */
    public AjoutEcoleJPanel() {
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

        enregistrerecole = new javax.swing.JButton();
        ajoutEcoleJPanel1 = new be.isfce.tfe.vue.encodage.EncodageEcoleJPanel();

        enregistrerecole.setText("Enregistrer");
        enregistrerecole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enregistrerecoleActionPerformed(evt);
            }
        });

        ajoutEcoleJPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ecole"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ajoutEcoleJPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(enregistrerecole)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ajoutEcoleJPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enregistrerecole)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void enregistrerecoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enregistrerecoleActionPerformed
        // TODO add your handling code here:

        Ecole ecole = ajoutEcoleJPanel1.getEcoleFromFields();
        try {
            new EcoleControlleur().controleEtAjoute(ecole);
        } catch (ValidationException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_enregistrerecoleActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private be.isfce.tfe.vue.encodage.EncodageEcoleJPanel ajoutEcoleJPanel1;
    private javax.swing.JButton enregistrerecole;
    // End of variables declaration//GEN-END:variables
}
