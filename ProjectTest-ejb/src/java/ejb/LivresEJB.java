/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jpa.Categories;
import jpa.EtatsLivres;
import jpa.Livres;

/**
 *
 * @author Marie
 */
@Stateless
public class LivresEJB implements LivresEJBLocal {

    @PersistenceContext(unitName = "ProjectTest-ejbPU")
    private EntityManager em;

    @Override
    public List<Livres> getLivres() {
        Query query = em.createNamedQuery("Livres.findAll");
        return query.getResultList();
    }
    


    @Override
    public Livres trouverLivreParId(Livres idLivre) {
        Query query = em.createNamedQuery("Livres.findByIdLivre");
        return (Livres) query.getSingleResult();
    }


    @Override
    public void supprimerLivre(Livres livre) {
        em.remove(livre);
    }

    @Override
    public void ajouterLivre(Categories idCategorie, EtatsLivres idEtatLivre, String nom, String editeur, Integer nbr_pages, Integer stock, Integer seuil, Long prix, String resume, Date parutionDate, String sommaire, String auteur, Integer popularite) {
        //on instanci l'objet et on lui attribut ces nouveaux paramètres
        Livres livre = new Livres();
        livre.setIdLivre(0);
        livre.setIdCategorie(idCategorie);
        livre.setIdEtatLivre(idEtatLivre);
        livre.setNom(nom);
        livre.setEditeur(editeur);
        livre.setNbrPages(nbr_pages);
        livre.setStock(stock);
        livre.setSeuil(seuil);
        livre.setPrix(prix);
        livre.setResume(resume);
        livre.setParutionDate(parutionDate);
        livre.setSommaire(sommaire);
        livre.setAuteur(auteur);
        livre.setPopularite(popularite);
        
        //On insère dans la base de donnée le nouvel utilisateur
        em.persist(livre);
        
    }

    @Override
    public List<Livres> ListerLivresParPopularite(Integer popularite) {
        Query query = em.createNamedQuery("Livres.findByPopularite");
        return query.getResultList();
    }

    @Override
    public List<Livres> trouverLivresParCategorie(Categories idCategorie) {
        Query query = em.createNamedQuery("Livres.findByCategorie");
        return query.getResultList();
    }

}
