/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.metier;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yema
 */
public class CarteCarburant {

    private int id;
    private String numcarte;
   
  
    
    private List<UtilisationCarte> lesutilisations;

  

    public List<UtilisationCarte> getLesutilisations() {
        return lesutilisations;
    }

    public String getNumcarte() {
        return numcarte;
    }

    public void setNumcarte(String numcarte) {
        this.numcarte = numcarte;
    }

    

    public void setId(int id) {
        this.id = id;
    }

   

    public int getId() {
        return id;
    }

  

    public void setLesUtilisations(List<UtilisationCarte> LesUtilisations) {
        this.lesutilisations = LesUtilisations;
    }

    @Override
    public String toString() {
        return "CarteCarburant{" + "id=" + id + ", numcarte=" + numcarte + ", lesutilisations=" + lesutilisations + '}';
    }

   
    
}
