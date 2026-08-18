package net.codejava.my_spring_app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codejava.my_spring_app.Entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

    
}
