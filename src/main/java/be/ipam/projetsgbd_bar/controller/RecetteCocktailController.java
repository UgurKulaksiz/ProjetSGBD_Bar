package be.ipam.projetsgbd_bar.controller;

import be.ipam.projetsgbd_bar.dto.RecetteCocktailDTO;

import be.ipam.projetsgbd_bar.mapper.RecetteCocktailMapper;
import be.ipam.projetsgbd_bar.model.RecetteCocktail;
import be.ipam.projetsgbd_bar.service.RecetteCocktailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recettes")
public class RecetteCocktailController {
    @Autowired
    private RecetteCocktailService recetteCocktailService;
    @Autowired
    private RecetteCocktailMapper recetteCocktailMapper;


    //CRUD
    // GET all recettes
    @GetMapping
    public ResponseEntity<List<RecetteCocktailDTO>> getAllRecettes() {
        List<RecetteCocktailDTO> recettes = recetteCocktailService.getAllRecette().stream().map(recetteCocktailMapper::convertToDTOWithUser).toList();
        return ResponseEntity.ok(recettes);
    }

    // GET recette by id
    @GetMapping("/{idRecette}")
    public ResponseEntity<RecetteCocktailDTO> getRecetteById(@PathVariable int idRecette) {
        Optional<RecetteCocktail> recetteOptional = recetteCocktailService.getRecetteById(idRecette);

        return recetteOptional.map(recetteCocktail ->
                ResponseEntity.ok(recetteCocktailMapper.convertToDTOWithUser(recetteCocktail)))
                .orElseGet(() ->
                        ResponseEntity.notFound().build());
    }

    // POST Create recette
    @PostMapping("/recette")
    public ResponseEntity<RecetteCocktailDTO> createRecette(@RequestBody RecetteCocktailDTO recetteCocktailDTO) {
        RecetteCocktail createdRecette = recetteCocktailService.createRecette(recetteCocktailMapper.convertToEntity(recetteCocktailDTO));

        return ResponseEntity.status(HttpStatus.CREATED).body(recetteCocktailMapper.convertToDTOWithUser(createdRecette));

        //return null;
    }

    // PUT Update recette --> Remplace tout l'objet
    @PutMapping("/{idRecette}")
    public ResponseEntity<RecetteCocktail> updateRecette(@PathVariable int idRecette, @RequestBody RecetteCocktailDTO recetteToUpdate) {
        Optional<RecetteCocktail> existingRecette = recetteCocktailService.getRecetteById(idRecette);

        if (existingRecette.isPresent()) {
            recetteToUpdate.setIdRecette(idRecette);
            RecetteCocktail updatedRecette = recetteCocktailService.updateRecette(idRecette, recetteCocktailMapper.convertToEntity(recetteToUpdate));

            return ResponseEntity.ok(updatedRecette);
            //return null;
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE Delete course
    @DeleteMapping("/{idRecette}")
    public ResponseEntity<Void> deleteRecette(@PathVariable int idRecette) {
        Optional<RecetteCocktail> existingRecette = recetteCocktailService.getRecetteById(idRecette);

        if (existingRecette.isPresent()) {
            recetteCocktailService.deleteRecette(idRecette);

            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
