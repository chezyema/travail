/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe.controleur;

import be.isfce.tfe.modele.AbstractModel;
import be.isfce.tfe.metier.UtilisationCarte;
import java.util.Calendar;

/**
 *
 * @author yema
 */
public class UtilisationCarteControleur extends AbstractControleur<UtilisationCarte> {

    public UtilisationCarteControleur(AbstractModel<UtilisationCarte> modele) {
        super(modele);
    }

    @Override
    public void controleEtAjoute(UtilisationCarte carte) throws ValidationException {
        Calendar joura = Calendar.getInstance();
        joura.add(Calendar.DAY_OF_MONTH, 0);
        joura.getTime();
        if (carte.getDateUtilisation() == null || carte.getDateUtilisation().after(joura.getTime())) {
            throw new ValidationException("Le date n'est pas valide");
        }
        modele.cree(carte);
    }

    @Override
    public void controleEtSupprime(UtilisationCarte object) throws ValidationException {
        modele.supprime(object);
    }

    @Override
    public void controleEtModifie(UtilisationCarte object) throws ValidationException {
        modele.modifie(object);
    }
}
