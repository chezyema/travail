/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.frame;

import be.isfce.tfe.controleur.DocumentsAdministratifsControleur;
import be.isfce.tfe.controleur.MaterielRoulantControleur;
import be.isfce.tfe.db.DocumentAdministratifDao;
import be.isfce.tfe.db.MaterielRoulantDao;
import be.isfce.tfe.vue.affichage.AffichageDocumentsPanel;
import be.isfce.tfe.vue.affichage.AffichageMaterielRoulantPanel;
import be.isfce.tfe.vue.ajout.DialogUtils;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author yema
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        initAlerts();

        jTabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int index = jTabbedPane.getSelectedIndex();
                //TODO Rafraichir les panels quand ils sont sélectionnés.
                switch (index) {
                    case 0:
                        initAlerts();
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void initAlerts() {
        nbEntretienAEffectuerUrgentLabel.setText("" + MaterielRoulantDao.getNbEntretiensAEffectuer());
        nbVehiculeEnOrdreLabel.setText("" + MaterielRoulantDao.getVehiculeEnOrdre().size());

        nbDocumentARenouvelerLabel.setText("" + DocumentAdministratifDao.getDocumentsARenouveler().size());
        nbDocumentEnOrdreLabel.setText("" + DocumentAdministratifDao.getDocumentsEnOrdre().size());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane = new javax.swing.JTabbedPane();
        jPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nbEntretienAEffectuerUrgentLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nbVehiculeEnOrdreLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        nbDocumentEnOrdreLabel = new javax.swing.JLabel();
        nbDocumentARenouvelerLabel = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jLabel1 = new javax.swing.JLabel();
        chauffeurTabPanel1 = new be.isfce.tfe.vue.frame.tabs.ChauffeurTabPanel();
        circuitTabPanel1 = new be.isfce.tfe.vue.frame.tabs.CircuitTabPanel();
        vehiculeTabPanel1 = new be.isfce.tfe.vue.frame.tabs.VehiculeTabPanel();
        ecoleTabPanel1 = new be.isfce.tfe.vue.frame.tabs.EcoleTabPanel();
        carteCarburantTabPanel1 = new be.isfce.tfe.vue.frame.tabs.CarteCarburantTabPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPaneStateChanged(evt);
            }
        });

        jPanel.setBackground(new java.awt.Color(255, 255, 255));
        jPanel.setForeground(new java.awt.Color(153, 153, 255));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Entretiens"));

        jLabel2.setText("Entretiens à effectuer d'urgence :");

        nbEntretienAEffectuerUrgentLabel.setText("0");

        jLabel5.setText("Véhicules en ordre :");

        nbVehiculeEnOrdreLabel.setText("0");

        jButton1.setText("Voir les véhicules à entretenir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Voir les véhicules en ordre");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 280, Short.MAX_VALUE)
                        .addComponent(nbEntretienAEffectuerUrgentLabel))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nbVehiculeEnOrdreLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nbEntretienAEffectuerUrgentLabel)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nbVehiculeEnOrdreLabel)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Documents"));

        jLabel9.setText("Documents à renouveler :");

        nbDocumentEnOrdreLabel.setText("0");

        nbDocumentARenouvelerLabel.setText("0");

        jLabel7.setText("Documents en ordre :");

        jButton3.setText("Voir les documents à renouveler");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Voir les documents en ordre");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 319, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nbDocumentARenouvelerLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nbDocumentEnOrdreLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(17, 17, 17))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nbDocumentARenouvelerLabel)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(nbDocumentEnOrdreLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)))
        );

        jCalendar1.setBorder(javax.swing.BorderFactory.createTitledBorder("Calendrier"));

        jLabel1.setMaximumSize(new java.awt.Dimension(500, 400));

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jCalendar1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)))
                .addContainerGap())
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(jCalendar1, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                        .addGap(4, 4, 4))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(23, 23, 23))))
        );

        jTabbedPane.addTab("Acceuil", jPanel);

        chauffeurTabPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jTabbedPane.addTab("Chauffeurs", chauffeurTabPanel1);

        circuitTabPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jTabbedPane.addTab("Circuits", circuitTabPanel1);

        vehiculeTabPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jTabbedPane.addTab("Véhicules", vehiculeTabPanel1);

        ecoleTabPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jTabbedPane.addTab("Etablissements", ecoleTabPanel1);

        carteCarburantTabPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jTabbedPane.addTab("Carte Carburant", carteCarburantTabPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPaneStateChanged
        if (jTabbedPane.getSelectedIndex() == 4) {
            ecoleTabPanel1.refresh();
        }
    }//GEN-LAST:event_jTabbedPaneStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DialogUtils.afficheDialog(this, new AffichageMaterielRoulantPanel(new MaterielRoulantControleur(), MaterielRoulantDao.getVehiculeAEntretenir()));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        DialogUtils.afficheDialog(this, new AffichageMaterielRoulantPanel(new MaterielRoulantControleur(), MaterielRoulantDao.getVehiculeEnOrdre()));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        DialogUtils.afficheDialog(this, new AffichageDocumentsPanel(new DocumentsAdministratifsControleur(), DocumentAdministratifDao.getDocumentsEnOrdre()));
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        DialogUtils.afficheDialog(this, new AffichageDocumentsPanel(new DocumentsAdministratifsControleur(), DocumentAdministratifDao.getDocumentsARenouveler()));
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private be.isfce.tfe.vue.frame.tabs.CarteCarburantTabPanel carteCarburantTabPanel1;
    private be.isfce.tfe.vue.frame.tabs.ChauffeurTabPanel chauffeurTabPanel1;
    private be.isfce.tfe.vue.frame.tabs.CircuitTabPanel circuitTabPanel1;
    private be.isfce.tfe.vue.frame.tabs.EcoleTabPanel ecoleTabPanel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JLabel nbDocumentARenouvelerLabel;
    private javax.swing.JLabel nbDocumentEnOrdreLabel;
    private javax.swing.JLabel nbEntretienAEffectuerUrgentLabel;
    private javax.swing.JLabel nbVehiculeEnOrdreLabel;
    private be.isfce.tfe.vue.frame.tabs.VehiculeTabPanel vehiculeTabPanel1;
    // End of variables declaration//GEN-END:variables
}
