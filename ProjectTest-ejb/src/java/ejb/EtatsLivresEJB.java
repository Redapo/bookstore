
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jpa.EtatsLivres;

/**
 *
 * @author Marie
 */
@Stateless
public class EtatsLivresEJB implements EtatsLivresEJBLocal {

    @PersistenceContext(unitName = "ProjectTest-ejbPU")
    private EntityManager em;

    @Override
    public void ajouterEtatLivre(String etat) {
            //On instancie l'objet et on lui attribut son nom
        EtatsLivres objetetat = new EtatsLivres();
        objetetat.setEtatLivre(etat);
         
        //on l'ajoute dans la base de données
        em.persist(etat);
    }

    @Override
    public EtatsLivres trouverEtatLivreParId(Integer idEtatLivre) {
        Query query = em.createNamedQuery("EtatsLivres.findByIdEtatLivre");
        return (EtatsLivres) query.getSingleResult();
    }



}
