package be.ipam.projetsgbd_bar.mapper;

import be.ipam.projetsgbd_bar.dto.RecetteCocktailDTO;
import be.ipam.projetsgbd_bar.dto.UtilisateurDTO;
import be.ipam.projetsgbd_bar.model.RecetteCocktail;
import be.ipam.projetsgbd_bar.model.Utilisateur;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RecetteCocktailMapper {

    public RecetteCocktailDTO convertToDTO(RecetteCocktail recette) {
        return RecetteCocktailDTO.builder()
                .idRecette(recette.getIdRecette())
                .nomRecette(recette.getNomRecette())
                .descriptionRecette(recette.getDescriptionRecette())
                .officielle(recette.getOfficielle())
                .build();
    }

    public RecetteCocktailDTO convertToDTOWithUser(RecetteCocktail recette) {
        return RecetteCocktailDTO.builder()
                .idRecette(recette.getIdRecette())
                .nomRecette(recette.getNomRecette())
                .descriptionRecette(recette.getDescriptionRecette())
                .officielle(recette.getOfficielle())

                .utilisateur(recette.getUtilisateur() != null ?
                        recette.getUtilisateur().stream().map(
                                user -> UtilisateurDTO.builder()
                                        .idUser(user.getIdUser())
                                        .nom_user(user.getNom_user())
                                        .prenom_user(user.getPrenom_user())
                                        .email(user.getEmail())
                                        .password(user.getPassword())
                                        .build()
                        ).collect(Collectors.toSet())
                        : null)
                .build();
    }
    public RecetteCocktail convertToEntity(RecetteCocktailDTO recetteCocktailDTO) {
        return RecetteCocktail.builder()
                .idRecette(recetteCocktailDTO.getIdRecette())
                .nomRecette(recetteCocktailDTO.getNomRecette())
                .descriptionRecette(recetteCocktailDTO.getDescriptionRecette())
                .officielle(recetteCocktailDTO.getOfficielle())

                .utilisateur(recetteCocktailDTO.getUtilisateur() != null ?
                        recetteCocktailDTO.getUtilisateur().stream().map(
                                utilisateurDTO -> Utilisateur.builder()
                                        .idUser(utilisateurDTO.getIdUser())
                                        .nom_user(utilisateurDTO.getNom_user())
                                        .prenom_user(utilisateurDTO.getPrenom_user())
                                        .email(utilisateurDTO.getEmail())
                                        //Remplir les autres variables
                                        .build()
                        ).collect(Collectors.toSet())
                        : null)
                .build();
    }
}
