/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.encodage;

import be.isfce.tfe.vue.ajout.*;
import be.isfce.tfe.controleur.MaterielRoulantControleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.metier.MaterielRoulant;
import be.isfce.tfe.validation.ValidationPlaque;
import javax.swing.JOptionPane;

/**
 *
 * @author yema
 */
public class EncodageMaterielRoulantJPanell extends javax.swing.JPanel {

    /**
     * Creates new form AjoutMateielRoulantJPanell
     */
    public EncodageMaterielRoulantJPanell() {
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

        idvehicule = new javax.swing.JLabel();
        marquevehicule = new javax.swing.JLabel();
        typevehicule = new javax.swing.JLabel();
        numimmatr = new javax.swing.JLabel();
        carburant = new javax.swing.JLabel();
        nbplaces = new javax.swing.JLabel();
        identifiantTextField = new javax.swing.JTextField();
        marqueTextField = new javax.swing.JTextField();
        typeTextField = new javax.swing.JTextField();
        plaqueTextField = new javax.swing.JTextField();
        carburantTextField = new javax.swing.JTextField();
        nbdeplaceTextField = new javax.swing.JTextField();
        kilometrage = new javax.swing.JLabel();
        kilometrageTextField = new javax.swing.JTextField();
        anneedeconstructionjllabel = new javax.swing.JLabel();
        datevaliterextincteur = new javax.swing.JLabel();
        validiterexctincteur = new com.toedter.calendar.JDateChooser();
        anneeconstruction = new com.toedter.calendar.JDateChooser();

        idvehicule.setText("Numero de chassis:");

        marquevehicule.setText("Marque:");

        typevehicule.setText("Type:");

        numimmatr.setText("Plaque immatriculation:");

        carburant.setText("Carburant:");

        nbplaces.setText("Nombres de Places:");

        marqueTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marqueTextFieldActionPerformed(evt);
            }
        });

        plaqueTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plaqueTextFieldActionPerformed(evt);
            }
        });

        kilometrage.setText("Kilometrage:");

        anneedeconstructionjllabel.setText("Annee de construction:");

        datevaliterextincteur.setText("Date validité exctincteur:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(datevaliterextincteur)
                    .addComponent(kilometrage, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nbplaces)
                    .addComponent(carburant)
                    .addComponent(numimmatr)
                    .addComponent(anneedeconstructionjllabel)
                    .addComponent(typevehicule)
                    .addComponent(marquevehicule)
                    .addComponent(idvehicule))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(marqueTextField)
                    .addComponent(typeTextField)
                    .addComponent(plaqueTextField)
                    .addComponent(carburantTextField)
                    .addComponent(nbdeplaceTextField)
                    .addComponent(kilometrageTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                    .addComponent(identifiantTextField)
                    .addComponent(anneeconstruction, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(validiterexctincteur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idvehicule)
                    .addComponent(identifiantTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(marquevehicule)
                    .addComponent(marqueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typevehicule)
                    .addComponent(typeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(anneedeconstructionjllabel)
                    .addComponent(anneeconstruction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numimmatr)
                    .addComponent(plaqueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carburant)
                    .addComponent(carburantTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nbplaces)
                    .addComponent(nbdeplaceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kilometrage)
                    .addComponent(kilometrageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(datevaliterextincteur)
                    .addComponent(validiterexctincteur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void marqueTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marqueTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_marqueTextFieldActionPerformed

    private void plaqueTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plaqueTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_plaqueTextFieldActionPerformed

    public MaterielRoulant getMaterielRoulantFromFields() {
        MaterielRoulant materielroulant = new MaterielRoulant();
        materielroulant.setId(identifiantTextField.getText());

        materielroulant.setMarque(marqueTextField.getText());

        materielroulant.setType(typeTextField.getText());

        materielroulant.setAnneedeconstruction(anneeconstruction.getDate());

        String plaque = plaqueTextField.getText();
        ValidationPlaque.checkPlaque(plaque);
        plaque = plaque.replace(".", "");
        plaque = plaque.replace("-", "");
        materielroulant.setNumImmatr(plaque);

        materielroulant.setCarburant(carburantTextField.getText());

        try {
            materielroulant.setNbDePlaces(Integer.valueOf(nbdeplaceTextField.getText()));
        } catch (NumberFormatException e) {
            materielroulant.setNbDePlaces(0);
        }
        try {
            materielroulant.setKmactuel(Integer.valueOf(kilometrageTextField.getText()));
        } catch (NumberFormatException e) {
            materielroulant.setNbDePlaces(0);
        }

        materielroulant.setDateexctincteur(validiterexctincteur.getDate());
        return materielroulant;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser anneeconstruction;
    private javax.swing.JLabel anneedeconstructionjllabel;
    private javax.swing.JLabel carburant;
    private javax.swing.JTextField carburantTextField;
    private javax.swing.JLabel datevaliterextincteur;
    private javax.swing.JTextField identifiantTextField;
    private javax.swing.JLabel idvehicule;
    private javax.swing.JLabel kilometrage;
    private javax.swing.JTextField kilometrageTextField;
    private javax.swing.JTextField marqueTextField;
    private javax.swing.JLabel marquevehicule;
    private javax.swing.JTextField nbdeplaceTextField;
    private javax.swing.JLabel nbplaces;
    private javax.swing.JLabel numimmatr;
    private javax.swing.JTextField plaqueTextField;
    private javax.swing.JTextField typeTextField;
    private javax.swing.JLabel typevehicule;
    private com.toedter.calendar.JDateChooser validiterexctincteur;
    // End of variables declaration//GEN-END:variables
}
