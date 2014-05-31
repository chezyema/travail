/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.ajout;

import be.isfce.tfe.controleur.UtilisationCarteControleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.metier.UtilisationCarte;
import javax.swing.JOptionPane;

/**
 *
 * @author yema
 */
public class AjoutUtilisationCarteJPanell extends javax.swing.JPanel {

    private DialogUtils.DialogInterface dialogInterface;

    /**
     * Creates new form EncodageUtilisationCarteJPanell
     */
    public AjoutUtilisationCarteJPanell() {
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

        jButton1 = new javax.swing.JButton();
        ajoutUtilisationCarteJPanell1 = new be.isfce.tfe.vue.encodage.EncodageUtilisationCarteJPanell();

        jButton1.setText("Enregistrer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ajoutUtilisationCarteJPanell1.setBorder(javax.swing.BorderFactory.createTitledBorder("Utilisation d'une carte carburant"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ajoutUtilisationCarteJPanell1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ajoutUtilisationCarteJPanell1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void setDialogInterface(DialogUtils.DialogInterface dialogInterface) {
        this.dialogInterface = dialogInterface;
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        UtilisationCarte carte = ajoutUtilisationCarteJPanell1.getUtilisationFromFields();
        try {
            new UtilisationCarteControleur().controleEtAjoute(carte);
            dialogInterface.onButtonSavePressed();
        } catch (ValidationException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private be.isfce.tfe.vue.encodage.EncodageUtilisationCarteJPanell ajoutUtilisationCarteJPanell1;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
