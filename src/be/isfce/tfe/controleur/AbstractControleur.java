/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.controleur;

import be.isfce.tfe.modele.AbstractModel;

/**
 *
 * @author yacsrk
 * @param <T>
 */
public abstract class AbstractControleur<T> {

    protected AbstractModel<T> modele;

    public AbstractControleur(AbstractModel<T> modele) {
        this.modele = modele;
    }

    public AbstractModel<T> getModele() {
        return modele;
    }

    public void setModele(AbstractModel<T> modele) {
        this.modele = modele;
    }

    public abstract void controleEtAjoute(T object) throws ValidationException;
    public abstract void controleEtSupprime(T object) throws ValidationException;
    public abstract void controleEtModifie(T object) throws ValidationException;
}
