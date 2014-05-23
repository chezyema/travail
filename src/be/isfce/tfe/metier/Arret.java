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
public class Arret {

    private int id;
    private String adresse;
    private List<Circuit> lescircuits;

    public List<Circuit> getLescircuits() {
        return lescircuits;
    }

    public void setLesCircuits(List<Circuit> lesCircuits) {
        this.lescircuits = lesCircuits;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    @Override
    public String toString() {
        return "Arret{" + "id=" + id + ", adresse=" + adresse + ", lescircuits=" + lescircuits + '}';
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
