/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Local;
import jpa.EtatsLivres;

/**
 *
 * @author Marie
 */
@Local
public interface EtatsLivresEJBLocal {
    
    //Les différentes méthodes suivantes sont des méthodes qui serviront à accéder à la base de données de par l'appication 
    //WebApplication2
    
    //Ajouter une categorie
    public void ajouterEtatLivre(String etat);
    
    //Trouver un objet livre en entrant son id
    public EtatsLivres trouverEtatLivreParId(Integer idEtatLivre);
 
}
