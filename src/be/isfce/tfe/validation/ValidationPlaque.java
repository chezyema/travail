/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.validation;

/**
 *
 * @author yema
 */
public class ValidationPlaque { 
    
    
    public static boolean checkPlaque(String numImmatr) {

        if (numImmatr == null || numImmatr.isEmpty()) {
            System.out.println("veuillez inserer une donnée svp");
            return false;
        }
        if (numImmatr.length() != 7 ) {
            System.out.println("veuillez introduire le bon format");
            return false;
        }
        try {
            String.valueOf(numImmatr);
        } catch (NumberFormatException e) {
            System.out.println("Error");
            e.printStackTrace();
            return false;
        }
        return true;

    }                                                    
    
}
