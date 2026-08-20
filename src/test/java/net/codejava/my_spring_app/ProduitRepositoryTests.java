package net.codejava.my_spring_app;

import java.util.Date;
import java.util.List;

//junit => framework pour faire des test unitaires
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import net.codejava.my_spring_app.Entities.Categorie;
import net.codejava.my_spring_app.Entities.Produit;
import net.codejava.my_spring_app.Repository.ProduitRepository;

@SpringBootTest
class ProduitRepositoryTests {

	@Autowired //Injection de dependance PAR CHAMP, plus dur a tester que final	
	private ProduitRepository produitRepository; //ProduitRepository est notre interface


	// Création d'un produit
	@Test
	public void testCreateProduit(){
		Produit prod = new Produit("PC lenovo", 5250.500, new Date());
		produitRepository.save(prod); //enregistre l'objet dans al bdd
	}

	// Consultation d'un produit par son id
	@Test
	public void testFindProduit(){
		Produit p = produitRepository.findById(4L).get();
		System.out.println(p);
	}

	// Modification d'un produit
	@Test
	public void testUpdateProduit(){
		Produit p = produitRepository.findById(1L).get();
		p.setPrixProduit(2300.00);
		produitRepository.save(p);

		System.out.println(p);
	}

	// Suppression d'un produit
	@Test
	public void testDeleteProduit(){
		produitRepository.deleteById(1l);
	}

	// Afficher tous les produits
	@Test
	public void testFindAllProduits(){
		List<Produit> produits = produitRepository.findAll();
		for (Produit p:produits){
		
			System.out.println(p);
		}
	}

	// Afficher les produit par nom
	@Test
	public void testFindProduitByNom(){
		List<Produit> prods = produitRepository.findByNomProduit("PC Dell");
		for(Produit p:prods){
			System.out.println(p);
		}
	}

	// afficher les produit qui contiennent le mot ..
	@Test
	public void testFindProduitByNomContains(){
		List<Produit> prods = produitRepository.findByNomProduitContains("PC");
		for(Produit p:prods) {
			System.out.println(p);
		}
	}

	// Afficher les produit par nom
	@Test
	public void testFindProduitByNomPrix(){
		List<Produit> prods = produitRepository.findByNomPrix("PC Dell", 2000.5);
		for(Produit p:prods){
			System.out.println(p);
		}
	}

	// recup produit avec la categorie (categorie)
	@Test
	public void testFindByCategorie(){
		Categorie cat = new Categorie();
		cat.setIdCat(4L);		
		List<Produit> prods = produitRepository.findByCategorie(cat);
		for(Produit p:prods){
			System.out.println(p);
		}
	}

	// recup produit par l'id de la categorie
	@Test
	public void testFindByCategorieIdCat(){
		List<Produit> prods = produitRepository.findByCategorieIdCat(2L);
		for(Produit p:prods){
			System.out.println(p);
		}
	}

	// Retourne les produits dont les noms sont triés par odre ascendant (petit au plus grand)
	@Test
	public void testFindByOrderByNomProduitAsc(){
		List<Produit> prods = produitRepository.findByOrderByNomProduitAsc();
		for(Produit p:prods){
			System.out.println(p);
		}
	}

    //Retourne les produits dont les noms sont triés par odre ascendant (petit au plus grand) et les prix pas ordre descendant=> deuxieme methode
	@Test
	public void testTrierProduitNomPrix(){
		List<Produit> prods = produitRepository.trierProduitsNompPrix();
		for(Produit p:prods){
			System.out.println(p);
		}
	}
}
