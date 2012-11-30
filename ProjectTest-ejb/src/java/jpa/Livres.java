/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marie
 */
@Entity
@Table(name = "livres")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Livres.findAll", query = "SELECT l FROM Livres l"),
    @NamedQuery(name = "Livres.findByIdLivre", query = "SELECT l FROM Livres l WHERE l.idLivre = :idLivre"),
    @NamedQuery(name = "Livres.findByNbrPages", query = "SELECT l FROM Livres l WHERE l.nbrPages = :nbrPages"),
    @NamedQuery(name = "Livres.findByStock", query = "SELECT l FROM Livres l WHERE l.stock = :stock"),
    @NamedQuery(name = "Livres.findBySeuil", query = "SELECT l FROM Livres l WHERE l.seuil = :seuil"),
    @NamedQuery(name = "Livres.findByPrix", query = "SELECT l FROM Livres l WHERE l.prix = :prix"),
    @NamedQuery(name = "Livres.findByParutionDate", query = "SELECT l FROM Livres l WHERE l.parutionDate = :parutionDate"),
    @NamedQuery(name = "Livres.findByCategorie", query = "SELECT l FROM Livres l WHERE l.idCategorie = :idCategorie"),
    @NamedQuery(name = "Livres.findByPopularite", query = "SELECT l FROM Livres l WHERE l.popularite = :popularite")})
    
public class Livres implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_LIVRE")
    private Integer idLivre;
    @Lob
    @Size(max = 65535)
    @Column(name = "NOM")
    private String nom;
    @Lob
    @Size(max = 65535)
    @Column(name = "EDITEUR")
    private String editeur;
    @Column(name = "NBR_PAGES")
    private Integer nbrPages;
    @Column(name = "STOCK")
    private Integer stock;
    @Column(name = "SEUIL")
    private Integer seuil;
    @Column(name = "PRIX")
    private Long prix;
    @Lob
    @Size(max = 65535)
    @Column(name = "RESUME")
    private String resume;
    @Column(name = "PARUTION_DATE")
    @Temporal(TemporalType.DATE)
    private Date parutionDate;
    @Lob
    @Size(max = 65535)
    @Column(name = "SOMMAIRE")
    private String sommaire;
    @Lob
    @Size(max = 65535)
    @Column(name = "AUTEUR")
    private String auteur;
    @Column(name = "POPULARITE")
    private Integer popularite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLivre", fetch = FetchType.EAGER)
    private List<LignesCommandes> lignesCommandesList;
    @JoinColumn(name = "ID_ETAT_LIVRE", referencedColumnName = "ID_ETAT_LIVRE")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private EtatsLivres idEtatLivre;
    @JoinColumn(name = "ID_CATEGORIE", referencedColumnName = "ID_CATEGORIE")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Categories idCategorie;

    public Livres() {
    }

    public Livres(Integer idLivre) {
        this.idLivre = idLivre;
    }

    public Integer getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(Integer idLivre) {
        this.idLivre = idLivre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public Integer getNbrPages() {
        return nbrPages;
    }

    public void setNbrPages(Integer nbrPages) {
        this.nbrPages = nbrPages;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSeuil() {
        return seuil;
    }

    public void setSeuil(Integer seuil) {
        this.seuil = seuil;
    }

    public Long getPrix() {
        return prix;
    }

    public void setPrix(Long prix) {
        this.prix = prix;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Date getParutionDate() {
        return parutionDate;
    }

    public void setParutionDate(Date parutionDate) {
        this.parutionDate = parutionDate;
    }

    public String getSommaire() {
        return sommaire;
    }

    public void setSommaire(String sommaire) {
        this.sommaire = sommaire;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public Integer getPopularite() {
        return popularite;
    }

    public void setPopularite(Integer popularite) {
        this.popularite = popularite;
    }

    @XmlTransient
    public List<LignesCommandes> getLignesCommandesList() {
        return lignesCommandesList;
    }

    public void setLignesCommandesList(List<LignesCommandes> lignesCommandesList) {
        this.lignesCommandesList = lignesCommandesList;
    }

    public EtatsLivres getIdEtatLivre() {
        return idEtatLivre;
    }

    public void setIdEtatLivre(EtatsLivres idEtatLivre) {
        this.idEtatLivre = idEtatLivre;
    }

    public Categories getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Categories idCategorie) {
        this.idCategorie = idCategorie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLivre != null ? idLivre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livres)) {
            return false;
        }
        Livres other = (Livres) object;
        if ((this.idLivre == null && other.idLivre != null) || (this.idLivre != null && !this.idLivre.equals(other.idLivre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.Livres[ idLivre=" + idLivre + " ]";
    }
    
}
