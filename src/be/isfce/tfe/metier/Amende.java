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
public class Amende {
    private int idamendes;
    private String numeropv;
    private Date datepv;
    private int montantpv;
    private String idmaterielroulant;
    private String idchauffeur;

    public int getIdamendes() {
        return idamendes;
    }

    public String getNumeropv() {
        return numeropv;
    }

    public Date getDatepv() {
        return datepv;
    }

    public int getMontantpv() {
        return montantpv;
    }

    public String getIdmaterielroulant() {
        return idmaterielroulant;
    }

    public String getIdchauffeur() {
        return idchauffeur;
    }
    
    
    

    public void setIdamendes(int idamendes) {
        this.idamendes = idamendes;
    }

    public void setNumeropv(String numeropv) {
        this.numeropv = numeropv;
    }

    public void setDatepv(Date datepv) {
        this.datepv = datepv;
    }

    public void setMontantpv(int montantpv) {
        this.montantpv = montantpv;
    }

    public void setIdmaterielroulant(String idmaterielroulant) {
        this.idmaterielroulant = idmaterielroulant;
    }

    public void setIdchauffeur(String idchauffeur) {
        this.idchauffeur = idchauffeur;
    }

    @Override
    public String toString() {
        return "Amende{" + "idamendes=" + idamendes + ", numeropv=" + numeropv + ", datepv=" + datepv + ", montantpv=" + montantpv + ", idmaterielroulant=" + idmaterielroulant + ", idchauffeur=" + idchauffeur + '}';
    }
    
    
   
    
    
}
