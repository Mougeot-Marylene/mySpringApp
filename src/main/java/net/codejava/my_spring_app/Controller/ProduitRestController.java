package net.codejava.my_spring_app.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.my_spring_app.Entities.Produit;
import net.codejava.my_spring_app.Service.ProduitService;;

@RestController // dis à spring que cette classe va contenir des methodes qui seront des web service qui seront consommé à travers un navigateur
@RequestMapping("/api") // sert à définir une URL (une route) sur laquelle le Controller va répondre. C'est l'annotation la plus générale pour dire "cette classe ou cette méthode répond à telle adresse".
@CrossOrigin  // autorise les requêtes cross-origin (CORS), pour qu'Angular puisse consommer ce web service (api)
@AllArgsConstructor // genere constructeur avec tout les attributs

public class ProduitRestController {

    private final ProduitService produitService = null;
    
    @GetMapping() // equivalent de @RequestMapping(method=RequestMethod.GET)
    List<Produit> getAllProduits(){
        return produitService.getAllProduits();
    }
}
