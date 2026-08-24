package net.codejava.my_spring_app.Entities;

import org.springframework.data.rest.core.config.Projection;


/* Récupérer juste le nom des produits */
@Projection(name = "nomProd", types = {Produit.class})
public interface ProduitProjection {
    public String getNomProduit();
}
