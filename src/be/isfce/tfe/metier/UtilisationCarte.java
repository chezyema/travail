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
public class UtilisationCarte {
    
    private  int idutilisationcarte;
    private Date dateutilisation;
    private int litrecarburant;
    private int kmutilisation;
    private MaterielRoulant lesvehicules;
    private CarteCarburant lescartes;
    private String idvehicule;
    private int idcartecarburant;
    
    
    public int getIdutilisationcarte() {
        return idutilisationcarte;
    }

    public void setIdutilisationcarte(int idutilisationcarte) {
        this.idutilisationcarte = idutilisationcarte;
    }

    public UtilisationCarte() {
    }

    public int getKmutilisation() {
        return kmutilisation;
    }

    public void setKmutilisation(int kmutilisation) {
        this.kmutilisation = kmutilisation;
    }


    public Date getDateUtilisation() {
        return dateutilisation;
    }

    public Date getDateutilisation() {
        return dateutilisation;
    }

    public void setDateutilisation(Date dateutilisation) {
        this.dateutilisation = dateutilisation;
    }

    public int getLitrecarburant() {
        return litrecarburant;
    }

    public void setLitrecarburant(int litrecarburant) {
        this.litrecarburant = litrecarburant;
    }

    
    public MaterielRoulant getLesvehicules() {
        return lesvehicules;
    }

    public CarteCarburant getLescartes() {
        return lescartes;
    }

    public void setLesvehicules(MaterielRoulant lesvehicules) {
        this.lesvehicules = lesvehicules;
    }

    public void setLescartes(CarteCarburant lescartes) {
        this.lescartes = lescartes;
    }

    public String getIdvehicule() {
        return idvehicule;
    }

    public int getIdcartecarburant() {
        return idcartecarburant;
    }

    public void setIdvehicule(String idvehicule) {
        this.idvehicule = idvehicule;
    }

    public void setIdcartecarburant(int idcartecarburant) {
        this.idcartecarburant = idcartecarburant;
    }

    @Override
    public String toString() {
        return "UtilisationCarte{" + "idutilisationcarte=" + idutilisationcarte + ", dateutilisation=" + dateutilisation + ", litrecarburant=" + litrecarburant + ", kmutilisation=" + kmutilisation + ", lesvehicules=" + lesvehicules + ", lescartes=" + lescartes + ", idvehicule=" + idvehicule + ", idcartecarburant=" + idcartecarburant + '}';
    }

   
   
        
}
