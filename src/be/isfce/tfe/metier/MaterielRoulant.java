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
public class MaterielRoulant {

    private String id;
    private String marque;
    private TypeMaterielRoulant typemateriel;
    private int idtypemateriel;
    private String carburant;
    private String numImmatr;
    private int nbdeplaces;
    private int kmactuel;
    private Date anneedeconstruction;
    private Date dateexctincteur;
    
    private List<Entretien> lesentretiens;
    private List<Chauffeur> Leschauffeurs;
    private List<DocumentAdministratif> lesdocuments;
    private List<Circuit> lescircuits;
    private List<UtilisationCarte> lesmemos;
    private List<Trajet> lestrajets;
    private List<Amendes> lesamendes;
    
    
    public int getKmactuel() {
        return kmactuel;
    }

    public void setKmactuel(int kmactuel) {
        this.kmactuel = kmactuel;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMarque(String Marque) {
        this.marque = Marque;
    }

    public int getIdtypemateriel() {
        return idtypemateriel;
    }

    public List<Amendes> getLesamendes() {
        return lesamendes;
    }
    
    

    public void setIdtypemateriel(int idtypemateriel) {
        this.idtypemateriel = idtypemateriel;
    }

    

    public void setCarburant(String Carburant) {
        this.carburant = Carburant;
    }

    public void setNumImmatr(String NumImmatr) {
        this.numImmatr = NumImmatr;
    }

    public void setNbDePlaces(int NbDePlaces) {
        this.nbdeplaces = NbDePlaces;
        
    }

    public Date getAnneedeconstruction() {
        return anneedeconstruction;
    }

    public Date getDateexctincteur() {
        return dateexctincteur;
    }

    public void setAnneedeconstruction(Date anneedeconstruction) {
        this.anneedeconstruction = anneedeconstruction;
    }

    public void setDateexctincteur(Date dateexctincteur) {
        this.dateexctincteur = dateexctincteur;
    }

    public void setLesamendes(List<Amendes> lesamendes) {
        this.lesamendes = lesamendes;
    }
    
    
    

    public String getId() {
        return id;
    }

    public String getMarque() {
        return marque;
    }

    

    public String getCarburant() {
        return carburant;
    }

    public String getNumImmatr() {
        return numImmatr;
    }

    public int getNbDePlaces() {
        return nbdeplaces;
    }

    public void setLesEntretiens(List<Entretien> LesEntretiens) {
        this.lesentretiens = LesEntretiens;
    }

    public void setLesChauffeurs(List<Chauffeur> LesChauffeurs) {
        this.Leschauffeurs = LesChauffeurs;
    }

    public void setLesdocuments(List<DocumentAdministratif> lesdocuments) {
        this.lesdocuments = lesdocuments;
    }

    

    public void setLesMemos(List<UtilisationCarte> LesMemos) {
        this.lesmemos = LesMemos;
    }

    public int getNbdeplaces() {
        return nbdeplaces;
    }

    public List<Entretien> getLesentretiens() {
        return lesentretiens;
    }

    public List<Chauffeur> getLeschauffeurs() {
        return Leschauffeurs;
    }

    public List<DocumentAdministratif> getLesdocuments() {
        return lesdocuments;
    }

    public List<UtilisationCarte> getLesmemos() {
        return lesmemos;
    }

    public List<Circuit> getLescircuits() {
        return lescircuits;
    }

    public void setLescircuits(List<Circuit> lescircuits) {
        this.lescircuits = lescircuits;
    }

    public List<Trajet> getLestrajets() {
        return lestrajets;
    }

    public void setLestrajets(List<Trajet> lestrajets) {
        this.lestrajets = lestrajets;
    }

    public TypeMaterielRoulant getTypemateriel() {
        return typemateriel;
    }

    public void setTypemateriel(TypeMaterielRoulant typemateriel) {
        this.typemateriel = typemateriel;
    }

    @Override
    public String toString() {
        return "MaterielRoulant{" + "id=" + id + ", marque=" + marque + ", typemateriel=" + typemateriel + ", idtypemateriel=" + idtypemateriel + ", carburant=" + carburant + ", numImmatr=" + numImmatr + ", nbdeplaces=" + nbdeplaces + ", kmactuel=" + kmactuel + ", anneedeconstruction=" + anneedeconstruction + ", dateexctincteur=" + dateexctincteur + ", lesentretiens=" + lesentretiens + ", Leschauffeurs=" + Leschauffeurs + ", lesdocuments=" + lesdocuments + ", lescircuits=" + lescircuits + ", lesmemos=" + lesmemos + ", lestrajets=" + lestrajets + ", lesamendes=" + lesamendes + '}';
    }

  
    

    

   


   

  
     
    
   
    
    
    

    
    
    
}
