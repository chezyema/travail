/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.encodage;

import be.isfce.tfe.vue.ajout.*;
import be.isfce.tfe.controleur.ChauffeurControleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.metier.Chauffeur;
import javax.swing.JOptionPane;

/**
 *
 * @author yema
 */
public class EncodageChauffeurJPanell extends javax.swing.JPanel {

    /**
     * Creates new form AjoutChauffeurJPanell
     */
    public EncodageChauffeurJPanell() {
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

        idChauffeur = new javax.swing.JLabel();
        nomChauffeur = new javax.swing.JLabel();
        prenomChauffeur = new javax.swing.JLabel();
        AdresseChauffeur = new javax.swing.JLabel();
        dateChauffeur = new javax.swing.JLabel();
        numChauffeur = new javax.swing.JLabel();
        emailChauffeur = new javax.swing.JLabel();
        registreNationalTextField = new javax.swing.JTextField();
        nomchauffeurTextField = new javax.swing.JTextField();
        prenomTextField = new javax.swing.JTextField();
        adresseTextField = new javax.swing.JTextField();
        numTextField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();
        codepostale = new javax.swing.JLabel();
        codepostaleTextField = new javax.swing.JTextField();
        ville = new javax.swing.JLabel();
        villeTextField = new javax.swing.JTextField();
        dateChooser = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        numcartesisTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        numpermisTextField = new javax.swing.JTextField();

        idChauffeur.setText("Registre National :");

        nomChauffeur.setText("Nom :");

        prenomChauffeur.setText("Prénom :");

        AdresseChauffeur.setText("Adresse :");

        dateChauffeur.setText("Date de naissance :");

        numChauffeur.setText("Numero de Téléphone :");

        emailChauffeur.setText("E-mai l:");

        emailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextFieldActionPerformed(evt);
            }
        });

        codepostale.setText("Code postale :");

        ville.setText("Ville :");

        jLabel1.setText("Numero Carte SIS :");

        jLabel2.setText("Numero de Permis :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idChauffeur, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(prenomChauffeur, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nomChauffeur, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dateChauffeur))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(AdresseChauffeur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(codepostale)
                        .addGap(90, 90, 90))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ville, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numcartesisTextField)
                    .addComponent(numpermisTextField)
                    .addComponent(villeTextField)
                    .addComponent(adresseTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(dateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prenomTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(nomchauffeurTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(registreNationalTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(emailTextField)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(codepostaleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(numTextField))
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(numChauffeur, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addContainerGap(232, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(emailChauffeur, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idChauffeur)
                    .addComponent(registreNationalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomChauffeur)
                    .addComponent(nomchauffeurTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prenomChauffeur)
                    .addComponent(prenomTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateChauffeur)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AdresseChauffeur)
                    .addComponent(adresseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codepostale)
                    .addComponent(codepostaleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ville, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(villeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numChauffeur, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailChauffeur)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(numcartesisTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(numpermisTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public Chauffeur getChauffeurFromFields() {
        Chauffeur chauffeur = new Chauffeur();

        String registreNational = registreNationalTextField.getText();
        registreNational = registreNational.replace("-", "");
        registreNational = registreNational.replace(".", "");
        chauffeur.setId(registreNational);

        chauffeur.setNomChauffeur(nomchauffeurTextField.getText());

        chauffeur.setPrenomChauffeur(prenomTextField.getText());

        chauffeur.setDateNaissance(dateChooser.getDate());

        chauffeur.setAdresse(adresseTextField.getText());

        chauffeur.setCodepostale(Integer.valueOf(codepostaleTextField.getText()));

        chauffeur.setVille(villeTextField.getText());

        String numtel = numTextField.getText();
        numtel = numtel.replace("-", "");
        numtel = numtel.replace(".", "");
        numtel = numtel.replace("/", "");
        chauffeur.setNumTelephone(String.valueOf(numtel));

        chauffeur.setEmail(String.valueOf(emailTextField.getText()));

        String cartesis = numcartesisTextField.getText();
        cartesis = cartesis.replace("-", "");
        cartesis = cartesis.replace(".", "");
        cartesis = cartesis.replace("/", "");
        chauffeur.setNumcartesis(String.valueOf(cartesis));

        String numpermis = numpermisTextField.getText();
        numpermis = numpermis.replace("-", "");
        numpermis = numpermis.replace(".", "");
        numpermis = numpermis.replace("/", "");
        chauffeur.setNumpermis(String.valueOf(cartesis));

        return chauffeur;
    }

    private void emailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTextFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AdresseChauffeur;
    private javax.swing.JTextField adresseTextField;
    private javax.swing.JLabel codepostale;
    private javax.swing.JTextField codepostaleTextField;
    private javax.swing.JLabel dateChauffeur;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel emailChauffeur;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel idChauffeur;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel nomChauffeur;
    private javax.swing.JTextField nomchauffeurTextField;
    private javax.swing.JLabel numChauffeur;
    private javax.swing.JTextField numTextField;
    private javax.swing.JTextField numcartesisTextField;
    private javax.swing.JTextField numpermisTextField;
    private javax.swing.JLabel prenomChauffeur;
    private javax.swing.JTextField prenomTextField;
    private javax.swing.JTextField registreNationalTextField;
    private javax.swing.JLabel ville;
    private javax.swing.JTextField villeTextField;
    // End of variables declaration//GEN-END:variables
}