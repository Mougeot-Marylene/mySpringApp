package net.codejava.my_spring_app.Service;

import java.util.List;

import net.codejava.my_spring_app.Entities.Categorie;

public interface CategorieService {
    
    Categorie saveCategorie(Categorie p);

    Categorie updateCategorie(Categorie p);

    void deleteCategorie(Categorie p);

    void deleteCategorieById(Long id);

    Categorie getCategorie(Long id);

    List<Categorie> getAllCategories();
}
