/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanManaged;

import ejb.UtilisateursEJBLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author Alex
 */
@Named(value = "Utilisateurs")
@SessionScoped
public class UtilisateursManagedBean implements Serializable {

    @EJB
    private UtilisateursEJBLocal utilisateursEJB;
    /**
     * Creates a new instance of UtilisateursManagedBean
     */
    private String login;
    private String password;
    private String email;
    private String nom;
    private String prenom;
    private String adresse;
    
    public UtilisateursManagedBean() {
    }

    public String getAdresse() {
        return adresse;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getNom() {
        return nom;
    }

    public String getPassword() {
        return password;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public void ajouterUtilisateur()
    {
        utilisateursEJB.ajouterUtilisateur(login, password, nom, prenom, email, adresse);
    }
    
}
