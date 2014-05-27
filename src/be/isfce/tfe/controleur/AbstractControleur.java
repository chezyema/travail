/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.controleur;

import java.util.Observable;

/**
 *
 * @author yacsrk
 * @param <T>
 */
public abstract class AbstractControleur<T> extends Observable{

    public abstract void controleEtAjoute(T object) throws ValidationException;

    public abstract void controleEtSupprime(T object) throws ValidationException;

    public abstract void controleEtModifie(T object) throws ValidationException;
}
