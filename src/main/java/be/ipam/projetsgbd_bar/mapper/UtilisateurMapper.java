package be.ipam.projetsgbd_bar.mapper;

import be.ipam.projetsgbd_bar.dto.*;
import be.ipam.projetsgbd_bar.model.Roles;
import be.ipam.projetsgbd_bar.model.Utilisateur;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UtilisateurMapper {

    public UtilisateurDTO convertToDTO(Utilisateur utilisateur) {
        return UtilisateurDTO.builder()
                .idUser(utilisateur.getIdUser())
                .nom_user(utilisateur.getNom_user())
                .prenom_user(utilisateur.getPrenom_user())
                .email(utilisateur.getEmail())
                .password(utilisateur.getPassword())
                .build();
    }

    public UserAndRoleDTO convertToDTOWithRoles(Utilisateur utilisateur) {

        return UserAndRoleDTO.builder()
                .idUser(utilisateur.getIdUser())
                .nom_user(utilisateur.getNom_user())
                .prenom_user(utilisateur.getPrenom_user())
                .email(utilisateur.getEmail())
                .password(utilisateur.getPassword())

                .roles(utilisateur.getRoles().stream().map(
                        roles -> RolesDTO.builder() //-> .builder() : Vérifier les propriétés(configurations) de Gradle
                                .idRole(roles.getIdRole())
                                .role(roles.getRole())
                                .build()
                ).collect(Collectors.toSet()))
                .build();
    }

    public UtilisateurAndRecetteDTO convertToDTOWithRecettes(Utilisateur utilisateur) {

        return UtilisateurAndRecetteDTO.builder()
                .idUser(utilisateur.getIdUser())
                .nom_user(utilisateur.getNom_user())
                .prenom_user(utilisateur.getPrenom_user())
                .email(utilisateur.getEmail())
                .password(utilisateur.getPassword())

                .recettes(utilisateur.getRecettes().stream().map(
                        recetteCocktail -> RecetteCocktailDTO.builder() //-> .builder() : Vérifier les propriétés(configurations) de Gradle
                                .idRecette(recetteCocktail.getIdRecette())
                                .nomRecette(recetteCocktail.getNomRecette())
                                .descriptionRecette(recetteCocktail.getDescriptionRecette())
                                .officielle(recetteCocktail.getOfficielle())
                                .build()
                ).collect(Collectors.toSet()))
                .build();
    }
    public Utilisateur convertToEntity(UtilisateurDTO utilisateurDTO) {
        return Utilisateur.builder()
                .idUser(utilisateurDTO.getIdUser())
                .nom_user(utilisateurDTO.getNom_user())
                .prenom_user(utilisateurDTO.getPrenom_user())
                .email(utilisateurDTO.getEmail())
                .password(utilisateurDTO.getPassword())

                .roles(utilisateurDTO.getRoles() != null ?
                        utilisateurDTO.getRoles().stream().map(
                        rolesDTO -> Roles.builder()
                                .idRole(rolesDTO.getIdRole())
                                .role(rolesDTO.getRole())
                                .build()
                ).collect(Collectors.toSet())
                        : null)
                .build();
    }
}
