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
@Table(name = "etats_livres")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EtatsLivres.findAll", query = "SELECT e FROM EtatsLivres e"),
    @NamedQuery(name = "EtatsLivres.findByIdEtatLivre", query = "SELECT e FROM EtatsLivres e WHERE e.idEtatLivre = :idEtatLivre")})
public class EtatsLivres implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ETAT_LIVRE")
    private Integer idEtatLivre;
    @Lob
    @Size(max = 65535)
    @Column(name = "ETAT_LIVRE")
    private String etatLivre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEtatLivre", fetch = FetchType.EAGER)
    private List<Livres> livresList;

    public EtatsLivres() {
    }

    public EtatsLivres(Integer idEtatLivre) {
        this.idEtatLivre = idEtatLivre;
    }

    public Integer getIdEtatLivre() {
        return idEtatLivre;
    }

    public void setIdEtatLivre(Integer idEtatLivre) {
        this.idEtatLivre = idEtatLivre;
    }

    public String getEtatLivre() {
        return etatLivre;
    }

    public void setEtatLivre(String etatLivre) {
        this.etatLivre = etatLivre;
    }

    @XmlTransient
    public List<Livres> getLivresList() {
        return livresList;
    }

    public void setLivresList(List<Livres> livresList) {
        this.livresList = livresList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEtatLivre != null ? idEtatLivre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtatsLivres)) {
            return false;
        }
        EtatsLivres other = (EtatsLivres) object;
        if ((this.idEtatLivre == null && other.idEtatLivre != null) || (this.idEtatLivre != null && !this.idEtatLivre.equals(other.idEtatLivre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.EtatsLivres[ idEtatLivre=" + idEtatLivre + " ]";
    }
    
}
