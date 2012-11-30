/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jpa.Categories;

/**
 *
 * @author Marie
 */
@Stateless
public class CategoriesEJB implements CategoriesEJBLocal {

    @PersistenceContext(unitName = "ProjectTest-ejbPU")
    private EntityManager em;
    
    @Override
    public void ajouterCategorie(String nom) {
        em.persist(nom);
    }

    @Override
    public List<Categories> getCategories() {
        Query query = em.createNamedQuery("Categories.findAll");
        return query.getResultList();
    }

    

    @Override
    public Categories trouverCatgorieParId(Integer id) {
        Query query = em.createNamedQuery("Categories.findByIdCategorie");
        return (Categories) query.getSingleResult();
    }

    @Override
    public void supprimerCategorie(Categories categorie) {
        em.remove(categorie);
    }

}
