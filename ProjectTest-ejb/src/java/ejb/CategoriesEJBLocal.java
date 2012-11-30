/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import jpa.Categories;

/**
 *
 * @author Marie
 */
@Local
public interface CategoriesEJBLocal {
    
    //Les différentes méthodes suivantes sont des méthodes qui serviront à accéder à la base de données de par l'appication 
    //WebApplication2
    
    //Ajouter une categorie
    public void ajouterCategorie(String nom);
    
    
    //Lister des catégories
    public List<Categories> getCategories();
    
    //Trouver un catégorie grace à son ID
    public Categories trouverCatgorieParId(Integer id);
    
    
    //Supprimer une categorie
    public void supprimerCategorie(Categories categorie);
    
}
