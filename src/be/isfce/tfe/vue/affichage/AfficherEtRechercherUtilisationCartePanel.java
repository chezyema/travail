/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.affichage;

import be.isfce.tfe.controleur.EntretienControleur;
import be.isfce.tfe.controleur.UtilisationCarteControleur;
import be.isfce.tfe.db.EntretienDao;
import be.isfce.tfe.db.MaterielRoulantDao;
import be.isfce.tfe.metier.MaterielRoulant;
import java.awt.BorderLayout;
import java.text.DecimalFormat;
import java.util.Date;

/**
 *
 * @author Yema
 */
public class AfficherEtRechercherUtilisationCartePanel extends javax.swing.JPanel {

    private MaterielRoulant materielRoulant;
    DecimalFormat df = new DecimalFormat("#.00");

    public AfficherEtRechercherUtilisationCartePanel(MaterielRoulant materielRoulant) {
        initComponents();
        this.materielRoulant = materielRoulant;
        affichageEntretienPanel = new AffichageUtilisationCarteJPanel(new UtilisationCarteControleur());
        Date date = new Date();
        affichageEntretienPanel.setUtilisationCarte(MaterielRoulantDao.getConsommationsPourVehicule(materielRoulant, date.getMonth(), date.getYear()));
        jPanel1.add(affichageEntretienPanel, BorderLayout.CENTER);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        consommationLabel = new javax.swing.JLabel();

        jDateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser1PropertyChange(evt);
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Consommation moyenne : ");

        consommationLabel.setText("0 L/100km");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(consommationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(consommationLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange

        Date date = jDateChooser1.getDate();
        if (date != null) {
            consommationLabel.setText(df.format(MaterielRoulantDao.getConsommationPourVehicule(materielRoulant, date.getMonth(), date.getYear()))+ " L/100km");
            affichageEntretienPanel.setUtilisationCarte(MaterielRoulantDao.getConsommationsPourVehicule(materielRoulant, date.getMonth(), date.getYear()));
        }
    }//GEN-LAST:event_jDateChooser1PropertyChange

    private AffichageUtilisationCarteJPanel affichageEntretienPanel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel consommationLabel;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
