/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marie
 */
@Entity
@Table(name = "utilisateurs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateurs.findAll", query = "SELECT u FROM Utilisateurs u"),
    @NamedQuery(name = "Utilisateurs.findByIdUtilisateur", query = "SELECT u FROM Utilisateurs u WHERE u.idUtilisateur = :idUtilisateur"),
    @NamedQuery(name = "Utilisateurs.findByLogin", query = "SELECT u FROM Utilisateurs u WHERE u.login = :login"),
    @NamedQuery(name = "Utilisateurs.findByLibraire", query = "SELECT u FROM Utilisateurs u WHERE u.libraire = :libraire")})
public class Utilisateurs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_UTILISATEUR")
    private Integer idUtilisateur;
    @Lob
    @Size(max = 65535)
    @Column(name = "LOGIN")
    private String login;
    @Lob
    @Size(max = 65535)
    @Column(name = "PASSWORD")
    private String password;
    @Lob
    @Size(max = 65535)
    @Column(name = "NOM")
    private String nom;
    @Lob
    @Size(max = 65535)
    @Column(name = "PRENOM")
    private String prenom;
    @Lob
    @Size(max = 65535)
    @Column(name = "MAIL")
    private String mail;
    @Lob
    @Size(max = 65535)
    @Column(name = "ADRESSE_POSTALE")
    private String adressePostale;
    @Column(name = "LIBRAIRE")
    private Boolean libraire;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUtilisateur", fetch = FetchType.EAGER)
    private List<Commandes> commandesList;

    public Utilisateurs() {
    }

    public Utilisateurs(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAdressePostale() {
        return adressePostale;
    }

    public void setAdressePostale(String adressePostale) {
        this.adressePostale = adressePostale;
    }

    public Boolean getLibraire() {
        return libraire;
    }

    public void setLibraire(Boolean libraire) {
        this.libraire = libraire;
    }

    @XmlTransient
    public List<Commandes> getCommandesList() {
        return commandesList;
    }

    public void setCommandesList(List<Commandes> commandesList) {
        this.commandesList = commandesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUtilisateur != null ? idUtilisateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateurs)) {
            return false;
        }
        Utilisateurs other = (Utilisateurs) object;
        if ((this.idUtilisateur == null && other.idUtilisateur != null) || (this.idUtilisateur != null && !this.idUtilisateur.equals(other.idUtilisateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Utilisateurs[ idUtilisateur=" + idUtilisateur + " ]";
    }
    
}
