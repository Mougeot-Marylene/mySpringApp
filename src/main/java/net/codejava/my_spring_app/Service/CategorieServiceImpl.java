package net.codejava.my_spring_app.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.codejava.my_spring_app.Entities.Categorie;
import net.codejava.my_spring_app.Repository.CategorieRepository;

@Service  //permet de dire a pring que CategorieServiceImpl il s'agit d'un service
public class CategorieServiceImpl implements CategorieService {

    private final CategorieRepository categorieRepository;

    public CategorieServiceImpl(CategorieRepository categorieRepository) {
        super();
        this.categorieRepository = categorieRepository;
    }


    @Override
    public Categorie saveCategorie(Categorie c) {
       return categorieRepository.save(c);
    }

    @Override
    public Categorie getCategorie(Long id) {
        return categorieRepository.findById(1l).get();
    }

    @Override
    public Categorie updateCategorie(Categorie c) {
        return categorieRepository.save(c);
    }

    @Override
    public void deleteCategorie(Categorie c) {
        categorieRepository.delete(c);
    }
    
    @Override
    public void deleteCategorieById(Long id) {
        categorieRepository.deleteById(id);
    }

    @Override
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

}
