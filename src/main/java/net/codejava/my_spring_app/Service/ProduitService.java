package net.codejava.my_spring_app.Service;

import java.util.List;

import net.codejava.my_spring_app.Entities.Produit;

public interface ProduitService {

    Produit saveProduit(Produit p);
    Produit updateProduit(Produit p);
    void deleteProduit(Produit p);
    void deleteProduitById(Long id);
    Produit getProduit(Long id);
    List<Produit> getAllProduits();

}
