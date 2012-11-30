/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marie
 */
@Entity
@Table(name = "lignes_commandes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LignesCommandes.findAll", query = "SELECT l FROM LignesCommandes l"),
    @NamedQuery(name = "LignesCommandes.findByIdLigneCommande", query = "SELECT l FROM LignesCommandes l WHERE l.idLigneCommande = :idLigneCommande"),
    @NamedQuery(name = "LignesCommandes.findByQuantite", query = "SELECT l FROM LignesCommandes l WHERE l.quantite = :quantite")})
public class LignesCommandes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_LIGNE_COMMANDE")
    private Integer idLigneCommande;
    @Column(name = "quantite")
    private Integer quantite;
    @JoinColumn(name = "ID_LIVRE", referencedColumnName = "ID_LIVRE")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Livres idLivre;
    @JoinColumn(name = "ID_COMMANDE", referencedColumnName = "ID_COMMANDE")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Commandes idCommande;

    public LignesCommandes() {
    }

    public LignesCommandes(Integer idLigneCommande) {
        this.idLigneCommande = idLigneCommande;
    }

    public Integer getIdLigneCommande() {
        return idLigneCommande;
    }

    public void setIdLigneCommande(Integer idLigneCommande) {
        this.idLigneCommande = idLigneCommande;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Livres getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(Livres idLivre) {
        this.idLivre = idLivre;
    }

    public Commandes getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Commandes idCommande) {
        this.idCommande = idCommande;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLigneCommande != null ? idLigneCommande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LignesCommandes)) {
            return false;
        }
        LignesCommandes other = (LignesCommandes) object;
        if ((this.idLigneCommande == null && other.idLigneCommande != null) || (this.idLigneCommande != null && !this.idLigneCommande.equals(other.idLigneCommande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.LignesCommandes[ idLigneCommande=" + idLigneCommande + " ]";
    }
    
}
