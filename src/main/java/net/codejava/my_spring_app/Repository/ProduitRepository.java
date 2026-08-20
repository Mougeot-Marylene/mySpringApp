package net.codejava.my_spring_app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.codejava.my_spring_app.Entities.Categorie;
import net.codejava.my_spring_app.Entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

    List<Produit> findByNomProduit(String nom);
    List<Produit> findByNomProduitContains(String nom);

    // retourne les produit qui on (nom) et un prix supperieu  a (prix)  
    @Query("select p from Produit p where p.nomProduit like %:nom and p.prixProduit > :prix")
    List<Produit> findByNomPrix (@Param("nom") String nom, @Param("prix") Double prix);

    // retourne produit qui ont la catégorie (categorie)
    @Query("select p from Produit p where p.categorie = ?1")
    List<Produit> findByCategorie(Categorie categorie);
    

    //retourne les produit d'une catgerorie
    List<Produit> findByCategorieIdCat(Long id);

    //Retourne les produits dont les noms sont triés par odre ascendant (petit au plus grand) => premiere methode
    List<Produit> findByOrderByNomProduitAsc();

    //Retourne les produits dont les noms sont triés par odre ascendant (petit au plus grand) et les prix pas ordre descendant=> deuxieme methode
    @Query("select p from Produit p order by p.nomProduit ASC, p.prixProduit DESC")
    List<Produit> trierProduitsNompPrix();

}
