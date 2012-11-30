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
import jpa.Utilisateurs;

/**
 *
 * @author Marie
 */
@Stateless
public class UtilisateursEJB implements UtilisateursEJBLocal {

    @PersistenceContext(unitName = "ProjectTest-ejbPU")
    private EntityManager em;

    @Override
    public void ajouterUtilisateur(String login, String password, String nom, String prenom, String mail, String adresse_postale) {
        //on instacie l'objet et on lui attribut ces nouveaux paramètres
        Utilisateurs utilisateur = new Utilisateurs();
        utilisateur.setIdUtilisateur(0);
        utilisateur.setLogin(login);
        utilisateur.setPassword(password);
        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setMail(mail);
        utilisateur.setAdressePostale(adresse_postale);
        utilisateur.setLibraire(Boolean.FALSE);
        
        //on insère dans la base de données le nouvel utilisateur
        em.persist(utilisateur);
    }

    @Override
    public Utilisateurs trouverUtilisateur(Integer id) {
        Query query = em.createNamedQuery("Utilisateurs.findByIdUtilisateur");
        return (Utilisateurs) query.getSingleResult();
    }

    @Override
    public List<Utilisateurs> getUtilisateurs() {
        Query query = em.createNamedQuery("Utilisateurs.findAll");
        return query.getResultList();
    }

    @Override
    public void modifierUtilisateur(Utilisateurs idUtilisateurs, String password, String mail, String adresse_postale) {
        
    }

    @Override
    public boolean connectionUtilisateur(String login, String password) {
        Query query = em.createNamedQuery("Utilisateurs.findByLogin");
        query.setParameter("login", login);
        Utilisateurs utilisateur = (Utilisateurs) query.getSingleResult();
        if (utilisateur == null)
        {
            return false;
        }
        return utilisateur.getPassword().equals(password);
    }

}
