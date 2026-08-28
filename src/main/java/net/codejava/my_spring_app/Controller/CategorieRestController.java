package net.codejava.my_spring_app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.my_spring_app.Entities.Categorie;
import net.codejava.my_spring_app.Service.CategorieService; 
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/cat")
@CrossOrigin
@AllArgsConstructor
public class CategorieRestController {

    @Autowired
    CategorieService categorieService;

    /* Récupère toutes les catégories */
    @RequestMapping(method = RequestMethod.GET)
    public List<Categorie> getAllCategories() {
        return categorieService.getAllCategories();
    }

    /* Récupère une catégorie par son id */
    @GetMapping("/{id}")
    public Categorie getCategorieById(@PathVariable("id") Long id) {
        return categorieService.getCategorie(id);
    }
}