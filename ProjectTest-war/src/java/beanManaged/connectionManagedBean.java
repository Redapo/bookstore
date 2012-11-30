/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beanManaged;

import ejb.UtilisateursEJBLocal;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import jpa.Utilisateurs;

/**
 *
 * @author Alex
 */
@Named(value = "connect")
@SessionScoped
public class connectionManagedBean implements Serializable {

    @EJB
    private UtilisateursEJBLocal utilisateursEJB;
    /**
     * Creates a new instance of connectionManagedBean
     */
    private String login;
    private String password;
    
    
    public connectionManagedBean() {
    }


    public String getLogin() {
        return login;
    }

    
    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void connectionUtilisateur()
    {
     utilisateursEJB.connectionUtilisateur(login, password);
    }

    
}
