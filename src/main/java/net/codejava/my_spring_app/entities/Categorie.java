package net.codejava.my_spring_app.Entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

// entity signifie que les objet de type Categorie seront persistés dans la bdd
@Entity
public class Categorie {

     // annotations essentielles de JPA (Java Persistence API) pour définir la clé primaire d'une entité.
    @Id // Clé primaire de l'entité Categorie (identifiant unique)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pour l'auto incrémentation
    public Long idCat;
    
    public String nomCat;
    public String descriptionCat;

    // ont dit a spring qu'il y à une association de ONE TO MANY entre categorie et produit
    @OneToMany (mappedBy = "categorie") //Ça se lit : "une (One) Categorie → vers plusieurs (Many) Produit". Autrement dit : une catégorie peut avoir plusieurs produits.
    private List<Produit> produits;

    //Constructeur
    public Categorie() {
        super(); //super() appelle le constructeur de la classe parente (la classe dont hérite Categorie).
    }

    public Categorie(String nomCat, String descriptionCat) {
        super();
        this.nomCat = nomCat;
        this.descriptionCat = descriptionCat;
    }


      // getter / seter
    public Long getIdCat() {
        return idCat;
    }

    public void setIdCat(Long idCat) {
        this.idCat = idCat;
    }

    public String getNomCat() {
        return nomCat;
    }

    public void setNomCat(String nomCat) {
        this.nomCat= nomCat;
    }

    public String getDescriptionCat() {
        return descriptionCat;
    }

    public void setDescriptionCat(String descriptionCat) {
        this.descriptionCat = descriptionCat;
    }

    @Override
    public String toString() {
        return "Categorie [IdCat=" + idCat + ", NomCat=" + nomCat + ", DescriptionCat=" + descriptionCat + "]";
    }
    
    
    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

}
