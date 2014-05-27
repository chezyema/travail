/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.encodage;

import be.isfce.tfe.vue.ajout.*;
import be.isfce.tfe.controleur.EntretienControleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.metier.Entretien;
import javax.swing.JOptionPane;

/**
 *
 * @author yema
 */
public class EncodageEntretienJPanell extends javax.swing.JPanel {

    /**
     * Creates new form AjoutEntretienJPanell
     */
    public EncodageEntretienJPanell() {
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

        description = new javax.swing.JLabel();
        kmactuel = new javax.swing.JLabel();
        dateentretien = new javax.swing.JLabel();
        descriptionTextField = new javax.swing.JTextField();
        kmactuelTextField = new javax.swing.JTextField();
        dateentretienfait = new com.toedter.calendar.JDateChooser();

        description.setText("Description:");

        kmactuel.setText("Kilométrage actuel:");

        dateentretien.setText("Date entretien:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kmactuel, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateentretien, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateentretienfait, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(kmactuelTextField)
                    .addComponent(descriptionTextField))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(description)
                    .addComponent(descriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kmactuel)
                    .addComponent(kmactuelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(dateentretien)
                    .addComponent(dateentretienfait, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public Entretien getEntretienFromFields() {
        Entretien entretien = new Entretien();
        entretien.setId(0);
        entretien.setDescription(descriptionTextField.getText());
        try {
            entretien.setKmEntretienFait(Integer.valueOf(kmactuelTextField.getText()));
        } catch (NumberFormatException e) {
            entretien.setKmEntretienFait(0);
        }
        entretien.setDateEntretien(dateentretienfait.getDate());

        return entretien;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dateentretien;
    private com.toedter.calendar.JDateChooser dateentretienfait;
    private javax.swing.JLabel description;
    private javax.swing.JTextField descriptionTextField;
    private javax.swing.JLabel kmactuel;
    private javax.swing.JTextField kmactuelTextField;
    // End of variables declaration//GEN-END:variables
}
