/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Local;
import jpa.Utilisateurs;

/**
 *
 * @author Marie
 */
@Local
public interface UtilisateursEJBLocal {
    
    //Les différentes méthodes suivantes sont des méthodes qui serviront à accéder à la base de données de par l'appication 
    //WebApplication2
    
    //Ajouter un utilisateur
    public void ajouterUtilisateur(String login, String password, String nom, String prenom, String mail, String adresse_postale);
    
    //Sélectionner un utilisateur en fonction de son ID
    public Utilisateurs trouverUtilisateur(Integer id);
    
    //Retourner la liste des logins des utilisateurs de toute la bas de données
    public List<Utilisateurs> getUtilisateurs();
    
    //permet à l'utilisateur de modifier son profil
    public void modifierUtilisateur(Utilisateurs idUtilisateurs, String password, String mail, String adresse_postale);
    
    //permet de récupérer le password d'un utilisateur en fonction de son login
    public boolean connectionUtilisateur(String login, String password);
    
}
