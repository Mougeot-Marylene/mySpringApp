package net.codejava.my_spring_app.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.codejava.my_spring_app.Entities.Produit;
import net.codejava.my_spring_app.Service.ProduitService;
import org.springframework.web.bind.annotation.RequestMethod;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;





@RestController // dis à spring que cette classe va contenir des methodes qui seront des web service qui seront consommé à travers un navigateur
@RequestMapping("/api") // sert à définir une URL (une route) sur laquelle le Controller va répondre. C'est l'annotation la plus générale pour dire "cette classe ou cette méthode répond à telle adresse".
@CrossOrigin  // autorise les requêtes cross-origin (CORS), pour qu'Angular puisse consommer ce web service (api)
@AllArgsConstructor // genere constructeur avec tout les attributs

public class ProduitRestController {

    private final ProduitService produitService;
    

    /* Récupére tous les produit */ 
    //@GetMapping() // equivalent de @RequestMapping(method=RequestMethod.GET)
     @RequestMapping(method=RequestMethod.GET)
    public List<Produit> getAllProduits(){
        return produitService.getAllProduits();
    }

    /* Récupère un produit par son id */
    @GetMapping("/{id}")
    public Produit getProduitById(@PathVariable("id") Long id){
        return produitService.getProduit(id);
    }

    /* Création d'un produit */
    @PostMapping()
    public Produit createProduit(@RequestBody Produit produit){
        return produitService.saveProduit(produit);
    }

    /* Modifier un produit */
    @PutMapping()
    public Produit modifieProduit(@RequestBody Produit produit){
        return produitService.updateProduit(produit);
    }

    /* Supprimer un produit */
    @DeleteMapping("/{id}")
    public void deleProduit(@PathVariable("id") Long id){
        produitService.deleteProduitById(id);
    }

    /* retorune produit ayant une catégorie données */
    @GetMapping("/produitCat/{idCat}")
    public List<Produit> getProduitsByCatId(@PathVariable("idCat") long idCat){
        return produitService.findByCategorieIdCat(idCat);
    }
    

}
