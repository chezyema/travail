/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.controleur;
import be.isfce.tfe.modele.AbstractModel;
import be.isfce.tfe.metier.Circuit;
import be.isfce.tfe.validation.StringValidation;

/**
 *
 * @author yema
 */
public class CircuitControleur extends AbstractControleur<Circuit>{

    public CircuitControleur(AbstractModel<Circuit> modele) {
        super(modele);
    }
    
    @Override
     public void controleEtAjoute(Circuit circuit) throws ValidationException{
        
        if(circuit == null){
            throw new ValidationException("Le circuit est invalide");
        }
        if(circuit.getNomCircuit() == null || !StringValidation.VerifString(circuit.getNomCircuit())){
            throw new ValidationException("le nom n'est pas valide");
        }
        if(circuit.getKmFin() == 0){
            throw new ValidationException("Le kilometrage n'est pas valide");
        }
         if(circuit.getKmDepart() == 0){
            throw new ValidationException("Le kilometrage n'est pas valide");
        }
        if(circuit.getTempsPrevu() == null){
            throw new ValidationException("Le temps prévu n'est pas valide");
        }
        modele.cree(circuit);
  }

    @Override
    public void controleEtSupprime(Circuit object) throws ValidationException {
        modele.supprime(object) ;
    }

    @Override
    public void controleEtModifie(Circuit object) throws ValidationException {
        modele.modifie(object);
    }
}
