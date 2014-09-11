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
    private int codepostale;
    private String ville;
    private int numeroOrdre;
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

  

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNumeroOrdre() {
        return numeroOrdre;
    }

    public void setNumeroOrdre(int numeroOrdre) {
        this.numeroOrdre = numeroOrdre;
    }

    public int getCodepostale() {
        return codepostale;
    }

    public String getVille() {
        return ville;
    }

    public void setCodepostale(int codepostale) {
        this.codepostale = codepostale;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Arret{" + "id=" + id + ", adresse=" + adresse + ", codepostale=" + codepostale + ", ville=" + ville + ", numeroOrdre=" + numeroOrdre + ", lescircuits=" + lescircuits + '}';
    }
    
    
    
    
}
