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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "commandes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commandes.findAll", query = "SELECT c FROM Commandes c"),
    @NamedQuery(name = "Commandes.findByIdCommande", query = "SELECT c FROM Commandes c WHERE c.idCommande = :idCommande")})
public class Commandes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_COMMANDE")
    private Integer idCommande;
    @Lob
    @Size(max = 65535)
    @Column(name = "ETAT_COMMANDE")
    private String etatCommande;
    @JoinColumn(name = "ID_UTILISATEUR", referencedColumnName = "ID_UTILISATEUR")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Utilisateurs idUtilisateur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCommande", fetch = FetchType.EAGER)
    private List<LignesCommandes> lignesCommandesList;

    public Commandes() {
    }

    public Commandes(Integer idCommande) {
        this.idCommande = idCommande;
    }

    public Integer getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
    }

    public String getEtatCommande() {
        return etatCommande;
    }

    public void setEtatCommande(String etatCommande) {
        this.etatCommande = etatCommande;
    }

    public Utilisateurs getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Utilisateurs idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @XmlTransient
    public List<LignesCommandes> getLignesCommandesList() {
        return lignesCommandesList;
    }

    public void setLignesCommandesList(List<LignesCommandes> lignesCommandesList) {
        this.lignesCommandesList = lignesCommandesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCommande != null ? idCommande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commandes)) {
            return false;
        }
        Commandes other = (Commandes) object;
        if ((this.idCommande == null && other.idCommande != null) || (this.idCommande != null && !this.idCommande.equals(other.idCommande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Commandes[ idCommande=" + idCommande + " ]";
    }
    
}
