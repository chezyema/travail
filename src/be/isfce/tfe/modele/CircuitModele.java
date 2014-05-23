/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.modele;

import be.isfce.tfe.db.CircuitDBHelper;
import be.isfce.tfe.metier.Circuit;
import java.util.List;

/**
 *
 * @author yema
 */
public class CircuitModele extends AbstractModel<Circuit> {
     private static CircuitModele instance;

    private CircuitModele() {
        liste = CircuitDBHelper.getTousLesCircuits();
    }

    public static CircuitModele getInstance() {
        if (instance == null) {
            instance = new CircuitModele();
        }
        return instance;
    }

    @Override
    public List<Circuit> getTousLesElements() {
        return liste;
    }

    @Override
    public boolean supprime(Circuit element) {
        liste.remove(element);
        boolean deleteCircuit = CircuitDBHelper.deletetCircuit(element);
        if (deleteCircuit) {
            setChanged();
            notifyObservers(ELEMENT_SUPPRIME);
        }
        return deleteCircuit;
    }

    @Override
    public boolean modifie(Circuit element) {
        Circuit circuit = getCircuit(element.getId());
        if (circuit != null) {
            boolean updateChauffeur = CircuitDBHelper.updateCircuit(circuit);
            if (updateChauffeur) {
                setChanged();
                notifyObservers(ELEMENT_MODIFIE);
            }
            return updateChauffeur;
        }
        return false;
    }

    @Override
    public boolean cree(Circuit element) {
        //J'ajoute l'élément dans la BD
        boolean addCircuit = CircuitDBHelper.addCircuit(element);
        if (addCircuit) {
            liste.add(element);
            setChanged();
            notifyObservers(ELEMENT_AJOUTE);
        }
        return addCircuit;
    }

    private Circuit getCircuit(int id) {
        for (Circuit circuit : liste) {
            if (circuit.getId() == 0) {
                return circuit;
            }
        }
        return null;
    }

    
}

