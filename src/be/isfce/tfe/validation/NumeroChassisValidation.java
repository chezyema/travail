/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.validation;

/**
 *
 * @author yema
 */
public class NumeroChassisValidation {
     public static boolean checkChassis(String chassis) {

        if (chassis == null || chassis.isEmpty()) {
            System.out.println("veuillez inserer une donnée svp");
            return false;
        }
        if (chassis.length() != 19 ) {
            System.out.println("veuillez introduire le bon format");
            return false;
        }
        try {
            String.valueOf(chassis);
        } catch (NumberFormatException e) {
            System.out.println("Error");
            e.printStackTrace();
            return false;
        }
        return true;

    }                                                    
    
    
}
