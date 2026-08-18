package net.codejava.my_spring_app;

import java.util.Date;
import java.util.List;

//junit => framework pour faire des test unitaires
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import net.codejava.my_spring_app.Repository.ProduitRepository;
import net.codejava.my_spring_app.entities.Produit;

@SpringBootTest
class MySpringAppApplicationTests {

	@Autowired
	//Injection de dependance
	private ProduitRepository produitRepository; //ProduitRepository est notre interface


	// Création d'un produit
	@Test
	public void testCreateProduit(){
		Produit prod = new Produit("PC Asus", 2250.500, new Date());
		produitRepository.save(prod); //enregistre l'objet dans al bdd
	}

	// Consultation d'un produit par son id
	@Test
	public void testFindProduit(){
		Produit p = produitRepository.findById(1L).get();
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
		for (Produit p:produits)
			System.out.println(p);
	}
}
