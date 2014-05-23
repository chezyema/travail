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
    private int kmutilisation;
    private int litrecarburant;
    private List<UtilisationCarte> lesutilisations;

    @Override
    public String toString() {
        return "CarteCarburant{" + "id=" + id + ", kmutilisation=" + kmutilisation + ", litrecarburant=" + litrecarburant + ", lesutilisations=" + lesutilisations + '}';
    }

    public List<UtilisationCarte> getLesutilisations() {
        return lesutilisations;
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
}
