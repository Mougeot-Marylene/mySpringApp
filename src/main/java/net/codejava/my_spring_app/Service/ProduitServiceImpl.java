package net.codejava.my_spring_app.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.codejava.my_spring_app.Entities.Categorie;
import net.codejava.my_spring_app.Entities.Produit;
import net.codejava.my_spring_app.Repository.ProduitRepository;

@Service // permet de dire a pring que ProduitServiceImpl il s'agit d'un service
public class ProduitServiceImpl implements ProduitService {

    // Injection de dependance PAR CONSTRUCTEUR
    // @Autowired
    // final => le rendre inumable (empêche juste de réassigner produitRepository
    // après sa première initialisation (généralement faite dans le constructeur,
    // via l'injection de dépendance Spring))
    /*
     * Pourquoi l'injection par constructeur est-elle le meilleur?
     * . plus simple à tester
     * . les dépendances peuventre être final
     * -> plus sûr, immuable
     * . plus claire : on voit immédiatement ce dont la classe à besoin
     * . compatible Lombok
     * -> @RequiredArgsConstructor
     */
    private final ProduitRepository produitRepository; // permet de faire les opperation du CRUD

    public ProduitServiceImpl(ProduitRepository produitRepository) {
        super();
        this.produitRepository = produitRepository;
    }

    @Override
    public Produit saveProduit(Produit p) {
        return produitRepository.save(p);
    }

    @Override
    public Produit updateProduit(Produit p) {
        return produitRepository.save(p);
    }

    @Override
    public void deleteProduit(Produit p) {
        produitRepository.delete(p);
    }

    @Override
    public void deleteProduitById(Long id) {
        produitRepository.deleteById(id);
    }

    @Override
    public Produit getProduit(Long id) {
        return produitRepository.findById(id).get();
    }

    @Override
    public List<Produit> getAllProduits() {

        return produitRepository.findAll();
    }

    @Override
    public List<Produit> findByNomProduit(String nom) {
        return produitRepository.findByNomProduit(nom);
    }

    @Override
    public List<Produit> findByNomProduitContains(String nom) {
        return produitRepository.findByNomProduitContains(nom);
    }

    @Override
    public List<Produit> findByNomPrix(String nom, Double prix) {
        return produitRepository.findByNomPrix(nom, prix);
    }

    @Override
    public List<Produit> findByCategorie(Categorie categorie) {
       return produitRepository.findByCategorie(categorie);
    }

    @Override
    public List<Produit> findByCategorieIdCat(Long id) {
        return produitRepository.findByCategorieIdCat(id);
    }

    @Override
    public List<Produit> findByOrderByNomProduitAsc() {
        return produitRepository.findByOrderByNomProduitAsc();
    }

    @Override
    public List<Produit> trierProduitsNomspPrix() {
        return produitRepository.trierProduitsNomspPrix();
    }

}
