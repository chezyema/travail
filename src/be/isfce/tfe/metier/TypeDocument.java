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
public class TypeDocument {

    private int idtype;
    private String libelledocument;
    private List<DocumentAdministratif> lesdocumentsadministratifs;

    public List<DocumentAdministratif> getLesdocumentsadministratifs() {
        return lesdocumentsadministratifs;
    }

    public void setLesdocumentsadministratifs(List<DocumentAdministratif> lesdocumentsadministratifs) {
        this.lesdocumentsadministratifs = lesdocumentsadministratifs;
    }

    public int getIdtype() {
        return idtype;
    }

    public String getLibelledocument() {
        return libelledocument;
    }

    public void setIdtype(int idtype) {
        this.idtype = idtype;
    }

    public void setLibelledocument(String libelledocument) {
        this.libelledocument = libelledocument;
    }

    @Override
    public String toString() {
        return "TypeDocument{" + "idtype=" + idtype + ", libelledocument=" + libelledocument + ", lesdocumentsadministratifs=" + lesdocumentsadministratifs + '}';
    }
}
