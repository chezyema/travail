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
    private int kmutilisation;
    private int litrecarburant;
    
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

    public void setKmUtilisation(int KmUtilisation) {
        this.kmutilisation = KmUtilisation;
    }

    public void setLitreCarburant(int LitreCarburant) {
        this.litrecarburant = LitreCarburant;
    }

    public int getId() {
        return id;
    }

    public int getKmUtilisation() {
        return kmutilisation;
    }

    public int getLitreCarburant() {
        return litrecarburant;
    }

    public void setLesUtilisations(List<UtilisationCarte> LesUtilisations) {
        this.lesutilisations = LesUtilisations;
    }

    @Override
    public String toString() {
        return "CarteCarburant{" + "id=" + id + ", numcarte=" + numcarte + ", kmutilisation=" + kmutilisation + ", litrecarburant=" + litrecarburant + ", lesutilisations=" + lesutilisations + '}';
    }
    
    
}
