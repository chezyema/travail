/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.controleur;

import be.isfce.tfe.modele.AbstractModel;
import be.isfce.tfe.metier.CarteCarburant;

/**
 *
 * @author yema
 */
public class CarteCarburantControleur extends AbstractControleur<CarteCarburant>{

    public CarteCarburantControleur(AbstractModel<CarteCarburant> modele) {
        super(modele);
    }

    
    @Override
    public void controleEtAjoute(CarteCarburant cartecarburant) throws ValidationException {

        if (cartecarburant == null) {
            throw new ValidationException("La carte est invalide");
        }
        
        if (cartecarburant.getKmUtilisation() == 0) {
            throw new ValidationException("Le kilométrage n'est pas valide");
        }
        
        if (cartecarburant.getLitreCarburant() == 0) {
            throw new ValidationException("Les litres de carburant ne sont pas valide");
        }
         modele.cree(cartecarburant);
    }
       public void controleEtSupprime(CarteCarburant object) throws ValidationException {
        modele.supprime(object);
    }

   
    public void controleEtModifie(CarteCarburant object) throws ValidationException {
        modele.modifie(object);
    }
      
}
