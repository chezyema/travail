/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.controleur;

import be.isfce.tfe.db.CircuitDao;
import be.isfce.tfe.metier.Circuit;
import be.isfce.tfe.validation.StringValidation;

/**
 *
 * @author yema
 */
public class CircuitControleur extends AbstractControleur<Circuit> {

    @Override
    public void controleEtAjoute(Circuit circuit) throws ValidationException {

        if (circuit == null) {
            throw new ValidationException("Le circuit est invalide");
        }
        if (circuit.getNomCircuit() == null || !StringValidation.VerifString(circuit.getNomCircuit())) {
            throw new ValidationException("le nom n'est pas valide");
        }
    
        if (circuit.getTempsprevu() == null) {
            throw new ValidationException("Le temps prévu n'est pas valide");
        }
        if (CircuitDao.addCircuit(circuit)) {
            setChanged();
            notifyObservers();
        }

    }

    @Override
    public void controleEtSupprime(Circuit object) throws ValidationException {
        if (CircuitDao.deletetCircuit(object)) {
            setChanged();
            notifyObservers();
        }
    }

    @Override
    public void controleEtModifie(Circuit object) throws ValidationException {
        if (CircuitDao.updateCircuit(object)) {
            setChanged();
            notifyObservers();
        }
    }
}
