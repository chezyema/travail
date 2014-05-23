/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.validation;

/**
 *
 * @author yema
 */
public class StringValidation {

    public static boolean VerifString(String caractere) {
        if (caractere == null || caractere.isEmpty()) {
            System.out.println("veuillez inserer une donnée svp");
            return false;
        }
        for (int i = 0; i < caractere.length(); i++) {
            if (caractere.charAt(i) == '1' || caractere.charAt(i) == '2' || caractere.charAt(i) == '3' || caractere.charAt(i) == '4'
                    || caractere.charAt(i) == '5' || caractere.charAt(i) == '6' || caractere.charAt(i) == '7' || caractere.charAt(i) == '8'
                    || caractere.charAt(i) == '9' || caractere.charAt(i) == '0') {
                System.out.println("veuillez rentrer une donnée correcte");

                return false;
            }
        }
        return true;
    }
}
