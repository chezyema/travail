/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.metier;

import java.util.List;

/**
 *
 * @author yema
 */
public class Circuit {

    private int id;
    private String nomcircuit;
    private String tempsprevu;
   
    private MaterielRoulant materielroulant;
    private String idmaterielroulant;
    private String idchauffeur;
    private Ecole ecole;
    private int idecole;
    private Chauffeur chauffeurs;
    private List<Arret> lesarrets;
    private List<Eleve> leseleves;
    private List<Trajet> lestrajets;

    public List<Trajet> getLestrajets() {
        return lestrajets;
    }

    public void setLestrajets(List<Trajet> lestrajets) {
        this.lestrajets = lestrajets;
    }

    public Ecole getEcole() {
        return ecole;
    }

    public int getIdecole() {
        return idecole;
    }

    public void setEcole(Ecole ecole) {
        this.ecole = ecole;
    }

    public void setIdecole(int idecole) {
        this.idecole = idecole;
    }

    public void setLesArrets(List<Arret> LesArrets) {
        this.lesarrets = LesArrets;
    }

    public void setLesEleves(List<Eleve> LesEleves) {
        this.leseleves = LesEleves;
    }

    public int getId() {
        return id;
    }

    public String getNomCircuit() {
        return nomcircuit;
    }

    public String getTempsPrevu() {
        return tempsprevu;
    }

  

    public void setId(int id) {
        this.id = id;
    }

    public void setNomCircuit(String NomCircuit) {
        this.nomcircuit = NomCircuit;
    }

    public void setTempsPrevu(String TempsPrevu) {
        this.tempsprevu = TempsPrevu;
    }

   

   

    public List<Arret> getLesarrets() {
        return lesarrets;
    }

    public List<Eleve> getLeseleves() {
        return leseleves;
    }

    public MaterielRoulant getMaterielroulant() {
        return materielroulant;
    }

    public void setMaterielroulant(MaterielRoulant materielroulant) {
        this.materielroulant = materielroulant;
    }

    public String getIdmaterielroulant() {
        return idmaterielroulant;
    }

    public void setIdmaterielroulant(String idmaterielroulant) {
        this.idmaterielroulant = idmaterielroulant;
    }

    public String getIdchauffeur() {
        return idchauffeur;
    }

    public Chauffeur getChauffeurs() {
        return chauffeurs;
    }

    public void setIdchauffeur(String idchauffeur) {
        this.idchauffeur = idchauffeur;
    }

    public void setChauffeurs(Chauffeur chauffeurs) {
        this.chauffeurs = chauffeurs;
    }

    @Override
    public String toString() {
        return "Circuit{" + "id=" + id + ", nomcircuit=" + nomcircuit + ", tempsprevu=" + tempsprevu + ", materielroulant=" + materielroulant + ", idmaterielroulant=" + idmaterielroulant + ", idchauffeur=" + idchauffeur + ", ecole=" + ecole + ", idecole=" + idecole + ", chauffeurs=" + chauffeurs + ", lesarrets=" + lesarrets + ", leseleves=" + leseleves + ", lestrajets=" + lestrajets + '}';
    }

   

}
