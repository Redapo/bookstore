/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;


import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import jpa.Categories;
import jpa.EtatsLivres;
import jpa.Livres;

/**
 *
 * @author Marie
 */
@Local
public interface LivresEJBLocal {
    
    //Les différentes méthodes suivantes sont des méthodes qui serviront à accéder à la base de données de par l'appication 
    //WebApplication2
    
    //obtenir la liste des livres
    public List<Livres> getLivres();
    
    //Ajouter un livre
    public void ajouterLivre(Categories idCategorie, EtatsLivres etatsLivres, String nom, String editeur, Integer nbr_pages, Integer stock, Integer seuil, Long prix, String resume, Date parutionDate, String sommaire, String auteur, Integer popularite);
   
    
    //Trouver un livre par son Id
    public Livres trouverLivreParId(Livres idLivre);

    //Trouver une liste de livre en fonction de la popularité
    public List<Livres> ListerLivresParPopularite(Integer popularite);
    
    //Supprimer un livre
    public void supprimerLivre(Livres livre);
    
    //Trouver une liste de livres appartenant à une catégorie
    public List<Livres> trouverLivresParCategorie(Categories idCategorie);
    
}
