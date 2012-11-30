/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.Commandes;
import jpa.Utilisateurs;

/**
 *
 * @author Marie
 */
@Stateless
public class CommandesEJB implements CommandesEJBLocal {

    @PersistenceContext(unitName = "ProjectTest-ejbPU")
    private EntityManager em;


    @Override
    public void ajouterCommande(Utilisateurs utilisateur) {
        Commandes commande = new Commandes();
        commande.setIdUtilisateur(utilisateur);
        commande.setEtatCommande("validé");
        em.persist(commande);
    }

}
