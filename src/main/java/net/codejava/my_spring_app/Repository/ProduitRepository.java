package net.codejava.my_spring_app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codejava.my_spring_app.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

    
}
