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
public class TypeMaterielRoulant {
    private int idtypemateriel;
    private String typemateriel;
    private List<MaterielRoulant> lesTypesMaterielRoulant;

    public int getIdtypemateriel() {
        return idtypemateriel;
    }

    public String getTypemateriel() {
        return typemateriel;
    }

    public void setIdtypemateriel(int idtypemateriel) {
        this.idtypemateriel = idtypemateriel;
    }

    public void setTypemateriel(String typemateriel) {
        this.typemateriel = typemateriel;
    }

    public List<MaterielRoulant> getLesTypesMaterielRoulant() {
        return lesTypesMaterielRoulant;
    }

    public void setLesTypesMaterielRoulant(List<MaterielRoulant> lesTypesMaterielRoulant) {
        this.lesTypesMaterielRoulant = lesTypesMaterielRoulant;
    }

    @Override
    public String toString() {
        return "TypeMaterielRoulant{" + "idtypemateriel=" + idtypemateriel + ", typemateriel=" + typemateriel + ", lesTypesMaterielRoulant=" + lesTypesMaterielRoulant + '}';
    }
    

   
    
    
    
}
