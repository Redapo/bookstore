/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Local;
import jpa.Utilisateurs;

/**
 *
 * @author Marie
 */
@Local
public interface CommandesEJBLocal {
    
    //Les différentes méthodes suivantes sont des méthodes qui serviront à accéder à la base de données de par l'appication 
    //WebApplication2
    
    //Ajouter une commande
    public void ajouterCommande(Utilisateurs utilisateurs);
    
}
