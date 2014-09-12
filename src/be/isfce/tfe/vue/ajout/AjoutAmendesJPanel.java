/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.ajout;

import be.isfce.tfe.controleur.AmendesControleur;
import be.isfce.tfe.controleur.EntretienControleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.metier.Amende;
import be.isfce.tfe.metier.Entretien;
import be.isfce.tfe.metier.MaterielRoulant;
import javax.swing.JOptionPane;

/**
 *
 * @author yema
 */
public class AjoutAmendesJPanel extends javax.swing.JPanel {
    
    private DialogUtils.DialogInterface dialogInterface;
    private MaterielRoulant materielRoulant;


    /**
     * Creates new form AjoutAmendesJPanel
     */
    public AjoutAmendesJPanel() {
        initComponents();
    }
    
       public AjoutAmendesJPanel(MaterielRoulant materielRoulant) {
        initComponents();
        this.materielRoulant = materielRoulant;
    }
       
    
     public void setDialogInterface(DialogUtils.DialogInterface dialogInterface) {
        this.dialogInterface = dialogInterface;
    }
                                
      

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        encodageAmendesJPanell1 = new be.isfce.tfe.vue.encodage.EncodageAmendesJPanell();
        ajouter = new javax.swing.JToggleButton();

        ajouter.setText("Enregister");
        ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(encodageAmendesJPanell1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ajouter)
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(encodageAmendesJPanell1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(ajouter)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed
        // TODO add your handling code here:
        Amende amende = encodageAmendesJPanell1.getAmendesFromFields();

        try {
            if (materielRoulant != null) {
                amende.setIdmaterielroulant(materielRoulant.getId());
            }
            new AmendesControleur().controleEtAjoute(amende);
            if (dialogInterface != null) {
                dialogInterface.onButtonSavePressed();
            }
        } catch (ValidationException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_ajouterActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton ajouter;
    private be.isfce.tfe.vue.encodage.EncodageAmendesJPanell encodageAmendesJPanell1;
    // End of variables declaration//GEN-END:variables
}