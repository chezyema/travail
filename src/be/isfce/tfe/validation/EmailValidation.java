/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.validation;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.validator.EmailValidator;

/**
 *
 * @author yema
 */

    
    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author hicham
 */
public class EmailValidation {
    public static boolean validateEmailAddress(String votreEmail){
EmailValidator emailValidator = EmailValidator.getInstance();
return emailValidator.isValid(votreEmail);

}




}
    
    

    
