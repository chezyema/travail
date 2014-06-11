/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.metier;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author yema
 */
public class Trajet {

    public void setDateTravail(Date dateTravail) {
        this.dateTravail = dateTravail;
    }

    private int idtrajets;
   
    
    private Timestamp heurededebut;
    private Timestamp heuredefin;
    private Date dateTravail;
    private int kmdepart;
    private int kmfin;
    private String idchauffeur;
    private String idmaterielroulant;
    private int idcircuit;

    public int getIdcircuit() {
        return idcircuit;
    }

    public void setIdcircuit(int idcircuit) {
        this.idcircuit = idcircuit;
    }

    public String getIdchauffeur() {
        return idchauffeur;
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

    public Timestamp getHeurededebut() {
        return heurededebut;
    }

    public Timestamp getHeuredefin() {
        return heuredefin;
    }

    public void setHeurededebut(Timestamp heurededebut) {
        this.heurededebut = heurededebut;
    }

    public void setHeuredefin(Timestamp heuredefin) {
        this.heuredefin = heuredefin;
    }


  

   

    public String getIdmaterielroulant() {
        return idmaterielroulant;
    }

    public void setIdmaterielroulant(String idmaterielroulant) {
        this.idmaterielroulant = idmaterielroulant;
    }

    public int getKmdepart() {
        return kmdepart;
    }

    public int getKmfin() {
        return kmfin;
    }

    public void setKmdepart(int kmdepart) {
        this.kmdepart = kmdepart;
    }

    public void setKmfin(int kmfin) {
        this.kmfin = kmfin;
    }

    @Override
    public String toString() {
        return "Trajet{" + "idtrajets=" + idtrajets + ", heurededebut=" + heurededebut + ", heuredefin=" + heuredefin + ", dateTravail=" + dateTravail + ", kmdepart=" + kmdepart + ", kmfin=" + kmfin + ", idchauffeur=" + idchauffeur + ", idmaterielroulant=" + idmaterielroulant + ", idcircuit=" + idcircuit + '}';
    }
    

   

}
