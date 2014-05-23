/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author yema
 */
public class Trajet {

    public void setDateTravail(Date dateTravail) {
        this.dateTravail = dateTravail;
    }

    private int idtrajets;
    private String heurededebut;
    private String heuredefin;
    private Date dateTravail;
    private Chauffeur leschauffeurs;
    private MaterielRoulant lesvehicules;
    private String idchauffeur;
    private String idmaterielroulant;
    private Circuit circuit;
    private int idcircuit;

    public Circuit getCircuit() {
        return circuit;
    }

    public int getIdcircuit() {
        return idcircuit;
    }

    public void setCircuit(Circuit circuit) {
        this.circuit = circuit;
    }

    public void setIdcircuit(int idcircuit) {
        this.idcircuit = idcircuit;
    }

    public MaterielRoulant getLesvehicules() {
        return lesvehicules;
    }

    public String getIdchauffeur() {
        return idchauffeur;
    }

    public void setLesvehicules(MaterielRoulant lesvehicules) {
        this.lesvehicules = lesvehicules;
    }

    public void setIdchauffeur(String idchauffeur) {
        this.idchauffeur = idchauffeur;
    }

    public int getIdtrajets() {
        return idtrajets;
    }

    public void setIdtrajets(int idtrajets) {
        this.idtrajets = idtrajets;
    }

    public Date getDateTravail() {
        return dateTravail;
    }

    public void setHeureDeDebut(String HeureDeDebut) {
        this.heurededebut = HeureDeDebut;
    }

    public void setHeureDeFin(String HeureDeFin) {
        this.heuredefin = HeureDeFin;
    }

    public String getHeureDeDebut() {
        return heurededebut;
    }

    public String getHeureDeFin() {
        return heuredefin;
    }

    public Chauffeur getLeschauffeurs() {
        return leschauffeurs;
    }

    public void setLeschauffeurs(Chauffeur leschauffeurs) {
        this.leschauffeurs = leschauffeurs;
    }

    public String getIdmaterielroulant() {
        return idmaterielroulant;
    }

    public void setIdmaterielroulant(String idmaterielroulant) {
        this.idmaterielroulant = idmaterielroulant;
    }

    @Override
    public String toString() {
        return "Trajets{" + "idtrajets=" + idtrajets + ", heurededebut=" + heurededebut + ", heuredefin=" + heuredefin + ", dateTravail=" + dateTravail + ", leschauffeurs=" + leschauffeurs + ", lesvehicules=" + lesvehicules + ", idchauffeur=" + idchauffeur + ", idmaterielroulant=" + idmaterielroulant + ", circuit=" + circuit + ", idcircuit=" + idcircuit + '}';
    }

}
