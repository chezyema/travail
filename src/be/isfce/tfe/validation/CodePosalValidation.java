/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.validation;

/**
 *
 * @author yema
 */
public class CodePosalValidation {
      public static boolean checkCodePostale(String codepostale) {

        if (codepostale == null || codepostale.isEmpty()) {
            System.out.println("veuillez inserer une donnée svp");
            return false;
        }
        if (codepostale.length()!=4) {
            System.out.println("veuillez introduire le bon format");
            return false;
        }
        try {
            Long.valueOf(codepostale);
        } catch (NumberFormatException e) {
            System.out.println("Error");
            e.printStackTrace();
            return false;
        }
        return true;



    } 
    
}
