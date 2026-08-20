package net.codejava.my_spring_app.Entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

// entity signifie que les objet de type Produit seront persistés dans la bdd
@Entity
public class Produit {

    // annotations essentielles de JPA (Java Persistence API) pour définir la clé primaire d'une entité.
    @Id // Clé primaire de l'entité Produit (identifiant unique)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pour l'auto incrémentation
    private Long idProduit;
    
    private String nomProduit;
    private Double prixProduit;
    private Date dateCreation;

    @ManyToOne
    private Categorie categorie; //Ça se lit : plusieurs (Many) Produit → vers un (One) Categorie". Autrement dit : plusieurs produits peuvent avoir la même catégorie, mais un produit n'a qu'une seule catégorie.
  

    // constructor
    public Produit() {
        //super() appelle le constructeur de la classe parente (la classe dont hérite Produit).
        super();
    }

    public Produit(String nomProduit, Double prixProduit, Date dateProduit) {
        super();
        this.nomProduit = nomProduit;
        this.prixProduit = prixProduit;
        this.dateCreation = dateProduit;
    }

    // getter / seter
    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public void setPrixProduit(Double prixProduit) {
        this.prixProduit = prixProduit;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Long getIdProduit() {
        return idProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public Double getPrixProduit() {
        return prixProduit;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    @Override
    public String toString() {
        return "Produit [idProduit=" + idProduit + ", nomProduit=" + nomProduit + ", prixProduit=" + prixProduit
                + ", dateCreation=" + dateCreation + "]";
    }  

    
    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    
}
