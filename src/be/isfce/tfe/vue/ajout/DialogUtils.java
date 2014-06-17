/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.vue.ajout;

import java.awt.Window;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author yema
 */
public class DialogUtils {

    public static JDialog afficheDialog(Window owner, JPanel jpanel) {
        JDialog jDialog = new JDialog(owner);
        jDialog.add(jpanel);
        jDialog.pack();
        jDialog.setVisible(true);
        return jDialog;
    }

    public static interface DialogInterface {

        public void onButtonSavePressed();
    }

}
