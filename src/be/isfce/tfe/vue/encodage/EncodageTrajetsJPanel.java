/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.encodage;

import be.isfce.tfe.db.CircuitDao;
import be.isfce.tfe.db.MaterielRoulantDao;
import be.isfce.tfe.db.TrajetDao;
import be.isfce.tfe.metier.Circuit;
import be.isfce.tfe.metier.MaterielRoulant;
import be.isfce.tfe.metier.Trajet;
import be.isfce.tfe.vue.ajout.DialogUtils;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author yema
 */
public class EncodageTrajetsJPanel extends javax.swing.JPanel {

    private DialogUtils.DialogInterface dialogInterface;
    private List<MaterielRoulant> tousLesVehicules;
    private List<Circuit> tousLesCircuits;

    /**
     * Creates new form InsertionHeuredetravailJPanel1
     */
    public EncodageTrajetsJPanel() {
        initComponents();
        initComboboxes();
    }

    public Trajet getTrajetFromFields() {
        Trajet heuredetravail = new Trajet();
        heuredetravail.setIdtrajets(0);
        int heureDebut = heureDebutSpinField.getValue();
        int minuteDebut = minuteDebutSpinField.getValue();
        int heureFin = heuredefinSpinField.getValue();
        int minuteFin = minutefinSpinField.getValue();
        heuredetravail.setDateTravail(datetrajets.getDate());
        heuredetravail.setKmdepart(Integer.valueOf(kmdedepartTextField.getText()));
        heuredetravail.setKmfin(Integer.valueOf(kmdefinTextField.getText()));
        heuredetravail.setHeurededebut(new Timestamp(TimeUnit.HOURS.toMillis(heureDebut) + TimeUnit.MINUTES.toMillis(minuteDebut)));
        heuredetravail.setHeuredefin(new Timestamp(TimeUnit.HOURS.toMillis(heureFin) + TimeUnit.MINUTES.toMillis(minuteFin)));
        heuredetravail.setIdmaterielroulant(tousLesVehicules.get(vehiculeComboBox.getSelectedIndex()).getId());
        heuredetravail.setIdcircuit(tousLesCircuits.get(circuitComboBox.getSelectedIndex()).getId());
        return heuredetravail;

    }

    public DialogUtils.DialogInterface getDialogInterface() {
        return dialogInterface;
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        heureDebutSpinField = new com.toedter.components.JSpinField();
        minuteDebutSpinField = new com.toedter.components.JSpinField();
        heuredefinSpinField = new com.toedter.components.JSpinField();
        minutefinSpinField = new com.toedter.components.JSpinField();
        datetrajets = new com.toedter.calendar.JDateChooser();
        vehiculeComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        circuitComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        kmdedepartTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        kmdefinTextField = new javax.swing.JTextField();

        jLabel1.setText("Heure de debut:");

        jLabel2.setText("Heure de fin:");

        jLabel3.setText("Date du jour de travail:");

        heureDebutSpinField.setMaximum(23);
        heureDebutSpinField.setMinimum(0);

        minuteDebutSpinField.setMaximum(59);
        minuteDebutSpinField.setMinimum(0);

        heuredefinSpinField.setMaximum(23);
        heuredefinSpinField.setMinimum(0);

        minutefinSpinField.setMaximum(59);
        minutefinSpinField.setMinimum(0);

        jLabel4.setText("Vehicule utilisé :");

        jLabel5.setText("Parcours effectué :");

        jLabel6.setText("kilométrage de départ:");

        jLabel7.setText("kilométrage de fin:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(circuitComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(vehiculeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(datetrajets, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 38, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(heuredefinSpinField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(minutefinSpinField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(heureDebutSpinField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(minuteDebutSpinField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(kmdedepartTextField)
                            .addComponent(kmdefinTextField))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(heureDebutSpinField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minuteDebutSpinField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(heuredefinSpinField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minutefinSpinField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(datetrajets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(kmdedepartTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(kmdefinTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(vehiculeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(circuitComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox circuitComboBox;
    private com.toedter.calendar.JDateChooser datetrajets;
    private com.toedter.components.JSpinField heureDebutSpinField;
    private com.toedter.components.JSpinField heuredefinSpinField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField kmdedepartTextField;
    private javax.swing.JTextField kmdefinTextField;
    private com.toedter.components.JSpinField minuteDebutSpinField;
    private com.toedter.components.JSpinField minutefinSpinField;
    private javax.swing.JComboBox vehiculeComboBox;
    // End of variables declaration//GEN-END:variables

    private void initComboboxes() {
        tousLesVehicules = MaterielRoulantDao.getTousLesVehicules();
        for (MaterielRoulant vehicule : tousLesVehicules) {
            vehiculeComboBox.addItem(vehicule.getMarque() + " [" + vehicule.getNumImmatr() + "]");
        }

        tousLesCircuits = CircuitDao.getTousLesCircuits();
        for (Circuit circuit : tousLesCircuits) {
            circuitComboBox.addItem(circuit.getNomCircuit());
        }
    }
}
