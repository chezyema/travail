/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.modele;

import java.util.List;
import java.util.Observable;

/**
 *
 * @author yacsrk
 */
public abstract class AbstractModel<T> extends Observable {

    public static final String ELEMENT_AJOUTE = "element_ajoute";
    public static final String ELEMENT_MODIFIE = "element_modifie";
    public static final String ELEMENT_SUPPRIME = "element_supprime";

    protected List<T> liste;

    public abstract List<T> getTousLesElements();

    public abstract boolean supprime(T element);

    public abstract boolean modifie(T element);

    public abstract boolean cree(T element);

}
