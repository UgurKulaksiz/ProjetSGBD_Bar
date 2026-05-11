package be.ipam.projetsgbd_bar.mapper;

import be.ipam.projetsgbd_bar.dto.RoleAndUtilisateursDTO;
import be.ipam.projetsgbd_bar.dto.RolesDTO;
import be.ipam.projetsgbd_bar.dto.UtilisateurDTO;
import be.ipam.projetsgbd_bar.model.Roles;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RolesMapper {
    public RoleAndUtilisateursDTO convertToDTOWithUser(Roles roles) {

        return RoleAndUtilisateursDTO.builder()
                .idRole(roles.getIdRole())
                .role(roles.getRole())

                .utilisateurs(roles.getUtilisateur().stream().map(
                        utilisateur -> UtilisateurDTO.builder() //-> .builder() : Vérifier les propriétés(configurations) de Gradle
                                .idUser(utilisateur.getIdUser())
                                .nom_user(utilisateur.getNom_user())
                                .prenom_user(utilisateur.getPrenom_user())
                                .build()
                ).collect(Collectors.toSet()))
                .build();
    }

    public RolesDTO convertToDTO(Roles roles) {
        return RolesDTO.builder()
                .idRole(roles.getIdRole())
                .role(roles.getRole()
                ).build();
    }

    public Roles convertToEntity(RolesDTO rolesDTO) {
        return Roles.builder()
                .idRole(rolesDTO.getIdRole())
                .role(rolesDTO.getRole())

                .utilisateur(rolesDTO.getUtilisateur() != null ?
                        rolesDTO.getUtilisateur().stream().map(
                        utilisateurDTO -> be.ipam.projetsgbd_bar.model.Utilisateur.builder()
                                .idUser(utilisateurDTO.getIdUser())
                                .nom_user(utilisateurDTO.getNom_user())
                                .prenom_user(utilisateurDTO.getPrenom_user())
                                //Remplir les autres variables ?
                                .build()
                        ).collect(Collectors.toSet())
                        : null)
                .build();
    }
}
