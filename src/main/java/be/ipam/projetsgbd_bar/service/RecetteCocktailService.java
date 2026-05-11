package be.ipam.projetsgbd_bar.service;

import be.ipam.projetsgbd_bar.model.RecetteCocktail;
import be.ipam.projetsgbd_bar.repository.RecetteCocktailRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecetteCocktailService {
    @Autowired
    private final RecetteCocktailRepository recetteCocktailRepository;


    private final UtilisateurService utilisateurService;


    @Autowired
    public RecetteCocktailService(RecetteCocktailRepository recetteCocktailRepository, UtilisateurService utilisateurService) {
        this.recetteCocktailRepository = recetteCocktailRepository;
        this.utilisateurService = utilisateurService;
    }

    //Création de méthodes
    public List<RecetteCocktail> getAllRecetteWithoutDTO() {
        return recetteCocktailRepository.findAll();
    }
    public List<RecetteCocktail> getAllRecette() {
        return recetteCocktailRepository.findAll();
    }

    //CRUD
    public Optional<RecetteCocktail> getRecetteById(int idRecette) {
        return recetteCocktailRepository.findById(idRecette);
    }

    public RecetteCocktail createRecette(RecetteCocktail recetteCocktail) {
        return recetteCocktailRepository.save(recetteCocktail);
    }

    public RecetteCocktail updateRecette(int idRecette, RecetteCocktail updatedRecette) {
        Optional<RecetteCocktail> existingRecetteOptional = recetteCocktailRepository.findById(idRecette);

        if (existingRecetteOptional.isPresent()) {
            RecetteCocktail existingRecette = existingRecetteOptional.get();
            existingRecette.setNomRecette(updatedRecette.getNomRecette());
            existingRecette.setDescriptionRecette(updatedRecette.getDescriptionRecette());
            existingRecette.setOfficielle(updatedRecette.getOfficielle());

            return recetteCocktailRepository.save(existingRecette);
        } else {
            throw new EntityNotFoundException("Recette with ID " + idRecette + " not found.");
        }
    }

    public void deleteRecette(int idRecette) {
        recetteCocktailRepository.deleteById(idRecette);
    }
}
