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
public class Chauffeur {

    public Chauffeur() {
    }

  

   

    public void setLesCircuits(List<Circuit> LesCircuits) {
        this.lescircuits = LesCircuits;
    }

    public void setLesvehicules(List<MaterielRoulant> lesvehicules) {
        this.lesvehicules = lesvehicules;
    }

    public void setLesdocuments(List<DocumentAdministratif> lesdocuments) {
        this.lesdocuments = lesdocuments;
    }

    public void setLesheures(List<Trajet> lesheures) {
        this.lesheures = lesheures;
    }

    public String getId() {
        return id;
    }
    

    

    public String getNomChauffeur() {
        return nomchauffeur;
    }

    public String getPrenomChauffeur() {
        return prenomchauffeur;
    }

    public String getAdresse() {
        return adresse;
    }

    public Date getDateNaissance() {
        return datedenaissance;
    }

    public String getNumTelephone() {
        return numtelephone;
    }

    public void setCodepostale(int codepostale) {
        this.codepostale = codepostale;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

   
    public int getCodepostale() {
        return codepostale;
        
    }

    public String getVille() {
        return ville;
    }

  

    public String getEmail() {
        return email;
    }

   

    

    public void setId(String id) {
        this.id = id;
    }

    public void setNomChauffeur(String NomChauffeur) {
        this.nomchauffeur = NomChauffeur;
    }

    public void setPrenomChauffeur(String PrenomChauffeur) {
        this.prenomchauffeur = PrenomChauffeur;
    }

    public void setAdresse(String Adresse) {
        this.adresse = Adresse;
    }

    public void setDateNaissance(Date DateNaissance) {
        this.datedenaissance = DateNaissance;
    }

    public void setNumTelephone(String NumTelephone) {
        this.numtelephone = NumTelephone;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public String getNumcartesis() {
        return numcartesis;
    }

    public String getNumpermis() {
        return numpermis;
    }

    public void setNumcartesis(String numcartesis) {
        this.numcartesis = numcartesis;
    }

    public void setNumpermis(String numpermis) {
        this.numpermis = numpermis;
    }

 

  

   

   
    
    private String id;
    private String nomchauffeur;
    private String prenomchauffeur;
    private Date datedenaissance;
    private String adresse;
    private int codepostale;
    private String ville;
    private String numtelephone;
    private String email;
    private String numcartesis;
    private String numpermis;
    private List<Circuit> lescircuits;
    private List<Trajet> lesheures;
    private List<MaterielRoulant> lesvehicules;
    private List<DocumentAdministratif> lesdocuments;

    public List<Circuit> getLescircuits() {
        return lescircuits;
    }

    public List<MaterielRoulant> getLesvehicules() {
        return lesvehicules;
    }

    public List<DocumentAdministratif> getLesdocuments() {
        return lesdocuments;
    }

    public List<Trajet> getLesheures() {
        return lesheures;
    }

    @Override
    public String toString() {
        return "Chauffeur{" + "id=" + id + ", nomchauffeur=" + nomchauffeur + ", prenomchauffeur=" + prenomchauffeur + ", datedenaissance=" + datedenaissance + ", adresse=" + adresse + ", codepostale=" + codepostale + ", ville=" + ville + ", numtelephone=" + numtelephone + ", email=" + email + ", numcartesis=" + numcartesis + ", numpermis=" + numpermis + ", lescircuits=" + lescircuits + ", lesheures=" + lesheures + ", lesvehicules=" + lesvehicules + ", lesdocuments=" + lesdocuments + '}';
    }

    
   

   

  
    
    
}
