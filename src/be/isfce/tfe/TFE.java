/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.isfce.tfe;

import be.isfce.tfe.db.ArretDBHelper;
import be.isfce.tfe.db.CarteCarburantDBHelper;
import be.isfce.tfe.db.ChauffeurDBHelper;
import be.isfce.tfe.db.CircuitDBHelper;
import be.isfce.tfe.db.DocumentAdministratifDBHelper;
import be.isfce.tfe.db.EcoleDBHelper;
import be.isfce.tfe.db.EleveDBHelper;
import be.isfce.tfe.db.EntretienDBHelper;
import be.isfce.tfe.db.TrajetDBHelper;
import be.isfce.tfe.db.MaterielRoulantDBHelper;
import be.isfce.tfe.db.UtilisationCarteDBHelper;
import be.isfce.tfe.vue.affichage.AffichageArretPanel;
import be.isfce.tfe.vue.affichage.AffichageCarteCarburantPanel;
import be.isfce.tfe.vue.affichage.AffichageCircuitPanel;
import be.isfce.tfe.vue.affichage.AffichageDocumentsPanel;
import be.isfce.tfe.vue.affichage.AffichageEcolePanel;
import be.isfce.tfe.vue.affichage.AffichageElevePanel;
import be.isfce.tfe.vue.affichage.AffichageEntretienPanel;
import be.isfce.tfe.vue.affichage.AffichageTrajetsPanell;
import be.isfce.tfe.vue.affichage.AffichageMaterielRoulantPanel;
import be.isfce.tfe.vue.affichage.AffichagePanel;
import be.isfce.tfe.vue.affichage.AffichageUtilisationCarteJPanel;
import be.isfce.tfe.vue.affichage.AffichageChauffeurPanel;
import be.isfce.tfe.vue.ajout.AjoutArretJPanell;
import be.isfce.tfe.vue.ajout.AjoutCarteCarburantJPanell;
import be.isfce.tfe.vue.ajout.AjoutChauffeurJPanell;
import be.isfce.tfe.vue.ajout.AjoutCircuitJPanell;
import be.isfce.tfe.vue.ajout.AjoutDocumentsJPanell;
import be.isfce.tfe.vue.ajout.AjoutEcoleJPanel;
import be.isfce.tfe.vue.ajout.AjoutEleveJPanel;
import be.isfce.tfe.vue.ajout.AjoutEntretienJPanell;
import be.isfce.tfe.vue.ajout.AjoutMateielRoulantJPanell;
import be.isfce.tfe.vue.ajout.AjoutUtilisationCarteJPanell;
import be.isfce.tfe.vue.ajout.AjoutTrajetsJPanel;
import be.isfce.tfe.vue.ajout.AjoutTrajetsJPanel;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author yema
 */
public class TFE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Ceci est un test
        JPanel jp = new AjoutChauffeurJPanell();
        JPanel jpa = new AjoutCarteCarburantJPanell();
        JPanel jpb = new AjoutArretJPanell();
        JPanel jpc = new AjoutCircuitJPanell();
        JPanel jpd = new AjoutDocumentsJPanell();
        JPanel jpe = new AjoutEcoleJPanel();
        JPanel jpf = new AjoutEleveJPanel();
        JPanel jpg = new AjoutEntretienJPanell();
        JPanel jph = new AjoutMateielRoulantJPanell();
        JPanel jpi = new AjoutUtilisationCarteJPanell();
        JPanel jpj = new AjoutTrajetsJPanel();
      
       

       // AffichagePanel aa = new AffichageChauffeurPanel(ChauffeurDBHelper.selectChauffeur());
        
        //AffichagePanel ab = new AffichageArretPanel(ArretDBHelper.selectArrets());
        //AffichagePanel ac = new AffichageCarteCarburantPanel(CarteCarburantDBHelper.selectCarteCarburant());
        //AffichagePanel ad = new AffichageCircuitPanel(CircuitDBHelper.selectCircuit());
        //AffichagePanel ae = new AffichageDocumentsPanel(DocumentsAdministratifsDBHelper.selectDocuments());
        // AffichagePanel af = new AffichageEcolePanel(EcoleDBHelper.selectEcole());
        // AffichagePanel ag = new AffichageElevePanel(EleveDBHelper.selectEleve());
        // AffichagePanel ah = new AffichageEntretienPanel(EntretienDBHelper.selectEntretien());
        // AffichagePanel ai = new AffichageTrajetsPanell(TrajetsDBHELPER.selectHeureDeTravail());
        //AffichagePanel aj = new AffichageMaterielRoulantPanel(MaterielRoulantDBHelper.selectMaterielRoulant());
        // AffichagePanel ak = new AffichageUtilisationCarteJPanel(UtlisationCarteDBHelper.selectUtilisationCarte());  
         
                
       //  ChauffeurDBHelper.selectChauffeur();
       //   ArretDBHelper.selectArrets();
       //  CarteCarburantDBHelper.selectCarteCarburant();
       //   CircuitDBHelper.selectCircuit();
       //   DocumentsAdministratifsDBHelper.selectDocuments();
       //   EcoleDBHelper.selectEcole();
       //  EleveDBHelper.selectEleve();
       //  EntretienDBHelper.selectEntretien();
       //   TrajetsDBHELPER.selectHeureDeTravail();
       //   MaterielRoulantDBHelper.selectMaterielRoulant();


        JFrame jf = new JFrame();
        //jf.add(aj);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
        /*ChauffeurDBHelper.selectChauffeur();
         ArretDBHelper.selectArrets();
         CarteCarburantDBHelper.selectCarteCarburant();
         CircuitDBHelper.selectCircuit();
         DocumentsAdministratifsDBHelper.selectDocuments();
         EcoleDBHelper.selectEcole();
         EleveDBHelper.selectEleve();
         EntretienDBHelper.selectEntretien();
         TrajetsDBHELPER.selectHeureDeTravail();
         MaterielRoulantDBHelper.selectMaterielRoulant();
         UtlisationCarteDBHelper.selectUtilisationCarte();
         TrajetsDBHELPER.selectHeureDeTravail();*/

    }
}
