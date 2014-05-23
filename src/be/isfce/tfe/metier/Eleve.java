/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.metier;

import java.util.Date;

/**
 *
 * @author yema
 */
public class Eleve {

    
  
    private String id;
    private String nomeleve;
    private String prenomeleve;
    private String adresseeleve;
    private Date datedenaissance;
    private int cdpostal;
    private String vil;
    private String nomresponsable;
    private String telresponsable;
    private int idcircuit;
    private int idecole;
    private String emailresponsable;
    private Ecole coordonnee;
    private Circuit empreinter;



    public int getIdcircuit() {
        return idcircuit;
    }

    public int getIdecole() {
        return idecole;
    }
    
    public Date getDatedenaissance() {
        return datedenaissance;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public void setNomEleve(String NomEleve) {
        this.nomeleve = NomEleve;
    }

    public void setPrenomEleve(String PrenomEleve) {
        this.prenomeleve = PrenomEleve;
    }

    public void setAdresseEleve(String AdresseEleve) {
        this.adresseeleve = AdresseEleve;
    }

    public void setNomResponsable(String NomResponsable) {
        this.nomresponsable = NomResponsable;
    }

    public void setTelResponsable(String TelResponsable) {
        this.telresponsable = TelResponsable;
    }

    public void setEmailResponsable(String EmailResponsable) {
        this.emailresponsable = EmailResponsable;
    }

    public void setCoordonnee(Ecole Coordonnee) {
        this.coordonnee = Coordonnee;
    }

    public void setEmpreinter(Circuit Empreinter) {
        this.empreinter = Empreinter;
    }

    public String getId() {
        return id;
    }

    public String getNomEleve() {
        return nomeleve;
    }

    public String getPrenomEleve() {
        return prenomeleve;
    }

    public String getAdresseEleve() {
        return adresseeleve;
    }

    public int getCdpostal() {
        return cdpostal;
    }

    public void setCdpostal(int cdpostal) {
        this.cdpostal = cdpostal;
    }

    public void setVil(String vil) {
        this.vil = vil;
    }

    public String getVil() {
        return vil;
    }

    public String getNomResponsable() {
        return nomresponsable;
    }

    public String getTelResponsable() {
        return telresponsable;
    }

    public String getEmailResponsable() {
        return emailresponsable;
    }

    public Ecole getCoordonnee() {
        return coordonnee;
    }

    public Circuit getEmpreinter() {
        return empreinter;

    }
    
      @Override
    public String toString() {
        return "Eleve{" + "id=" + id + ", nomeleve=" + nomeleve + ", prenomeleve=" + prenomeleve + ", adresseeleve=" + adresseeleve + ", datedenaissance=" + datedenaissance + ", cdpostal=" + cdpostal + ", vil=" + vil + ", nomresponsable=" + nomresponsable + ", telresponsable=" + telresponsable + ", idcircuit=" + idcircuit + ", idecole=" + idecole + ", emailresponsable=" + emailresponsable + ", coordonnee=" + coordonnee + ", empreinter=" + empreinter + '}';
    }

    public void setDatedenaissance(Date datedenaissance) {
        this.datedenaissance = datedenaissance;
    }

    public void setIdcircuit(int idcircuit) {
        this.idcircuit = idcircuit;
    }

    public void setIdecole(int idecole) {
        this.idecole = idecole;
    }
}
