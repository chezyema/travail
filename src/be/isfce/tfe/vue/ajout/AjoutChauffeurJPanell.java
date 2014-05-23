/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.ajout;

import be.isfce.tfe.controleur.ChauffeurControleur;
import be.isfce.tfe.controleur.ValidationException;
import be.isfce.tfe.db.ChauffeurDBHelper;
import be.isfce.tfe.metier.Chauffeur;
import be.isfce.tfe.modele.ChauffeurModele;
import be.isfce.tfe.validation.ChauffeurValidation;
import be.isfce.tfe.validation.CodePosalValidation;
import be.isfce.tfe.validation.EmailValidation;
import be.isfce.tfe.validation.NumTelValidation;
import be.isfce.tfe.validation.StringValidation;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author yema
 */
public class AjoutChauffeurJPanell extends javax.swing.JPanel {

    /**
     * Creates new form AjoutChauffeurJPanell
     */
    public AjoutChauffeurJPanell() {
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
        modification = new javax.swing.JButton();
        retour = new javax.swing.JButton();
        enregistrerChauffeur = new javax.swing.JButton();
        codepostale = new javax.swing.JLabel();
        codepostaleTextField = new javax.swing.JTextField();
        ville = new javax.swing.JLabel();
        villeTextField = new javax.swing.JTextField();
        dateChooser = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        numcartesisTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        numpermisTextField = new javax.swing.JTextField();

        idChauffeur.setText("registre national:");

        nomChauffeur.setText("Nom :");

        prenomChauffeur.setText("Prenom :");

        AdresseChauffeur.setText("Adresse:");

        dateChauffeur.setText("Date de naissance:");

        numChauffeur.setText("Numero de telephone:");

        emailChauffeur.setText("Email:");

        emailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextFieldActionPerformed(evt);
            }
        });

        modification.setText("Modifier");
        modification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificationActionPerformed(evt);
            }
        });

        retour.setText("Annuler");

        enregistrerChauffeur.setText("Enregistrer");
        enregistrerChauffeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enregistrerChauffeurActionPerformed(evt);
            }
        });

        codepostale.setText("Code postale:");

        ville.setText("Ville:");

        jLabel1.setText("Numero carte SIS:");

        jLabel2.setText("Numero de permis:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailChauffeur, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(idChauffeur, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(registreNationalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(dateChauffeur, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                .addComponent(AdresseChauffeur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ville, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(codepostale, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(81, 81, 81)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(adresseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(codepostaleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(numTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                                    .addComponent(villeTextField, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(numpermisTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(numcartesisTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(emailTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(prenomChauffeur, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nomChauffeur, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(prenomTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nomchauffeurTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(numChauffeur, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(retour, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(modification, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(enregistrerChauffeur, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(prenomChauffeur))
                    .addComponent(prenomTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateChauffeur))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(AdresseChauffeur))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(adresseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codepostale, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(codepostaleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ville, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(villeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(numChauffeur, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailChauffeur)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(numcartesisTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(numpermisTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(retour)
                    .addComponent(modification)
                    .addComponent(enregistrerChauffeur))
                .addGap(75, 75, 75))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void modificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modificationActionPerformed

    private void enregistrerChauffeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enregistrerChauffeurActionPerformed
        Chauffeur chauffeur = getChauffeurFromFields();
        try {
            new ChauffeurControleur(ChauffeurModele.getInstance()).controleEtAjoute(chauffeur);
        } catch (ValidationException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_enregistrerChauffeurActionPerformed

    private Chauffeur getChauffeurFromFields() {
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
        cartesis = cartesis.replace("-" , "");
        cartesis = cartesis.replace("." , "");
        cartesis = cartesis.replace("/" , "");
        chauffeur.setNumcartesis(String.valueOf(cartesis));
        
        String numpermis = numpermisTextField.getText();
        numpermis = numpermis.replace("-" , "");
        numpermis= numpermis.replace("." , "");
        numpermis = numpermis.replace("/" , "");
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
    private javax.swing.JButton enregistrerChauffeur;
    private javax.swing.JLabel idChauffeur;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton modification;
    private javax.swing.JLabel nomChauffeur;
    private javax.swing.JTextField nomchauffeurTextField;
    private javax.swing.JLabel numChauffeur;
    private javax.swing.JTextField numTextField;
    private javax.swing.JTextField numcartesisTextField;
    private javax.swing.JTextField numpermisTextField;
    private javax.swing.JLabel prenomChauffeur;
    private javax.swing.JTextField prenomTextField;
    private javax.swing.JTextField registreNationalTextField;
    private javax.swing.JButton retour;
    private javax.swing.JLabel ville;
    private javax.swing.JTextField villeTextField;
    // End of variables declaration//GEN-END:variables
}
