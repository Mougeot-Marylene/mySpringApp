package net.codejava.my_spring_app;


import java.util.List;

//junit => framework pour faire des test unitaires
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import net.codejava.my_spring_app.Entities.Categorie;
import net.codejava.my_spring_app.Repository.CategorieRepository;

@SpringBootTest
class CategorieRepositoryTests {

    @Autowired // Injection de dependance PAR CHAMP, plus dur a tester que final
    private CategorieRepository categorieRepository; // notre interface


    //Categorie c = new Categorie("Informatique", "Ordinateurs, périphériques et accessoires informatiques");


    // Création d'une categorie
    @Test
    public void testCreateCategorise()
    {
        Categorie c = new Categorie("Téléphonie", "Smartphones, accessoires et objets connectés");
        categorieRepository.save(c);
    }

    // Récupèration d'une catégorie par id
    @Test
    public void testFindCategorie(){
        Categorie c = categorieRepository.findById(1L).get();
        System.out.println(c);
    }

    // Modifier une catégroie
    @Test
    public void testUpdateCategorie(){
        Categorie c = categorieRepository.findById(1L).get();
		c.setDescriptionCat("périphériques et accessoires informatiques de petite et grande taille");
        categorieRepository.save(c);        
		System.out.println(c);
    }

    // Supprimer une categorie
    @Test
    public void testDeleteCategorie(){
        categorieRepository.deleteById(1l);
    }

    //Récupérer toutes les catégories
    @Test
    public void testFindAllCategorie(){
        List<Categorie> categories = categorieRepository.findAll();
        for(Categorie c:categories )
            System.out.println(c);

    }
}
