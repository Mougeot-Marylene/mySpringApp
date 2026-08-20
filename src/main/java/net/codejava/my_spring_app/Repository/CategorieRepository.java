package net.codejava.my_spring_app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codejava.my_spring_app.Entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}
