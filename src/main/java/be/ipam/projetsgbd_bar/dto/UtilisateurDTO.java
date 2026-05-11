package be.ipam.projetsgbd_bar.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@Builder
public class UtilisateurDTO {
    private int idUser;
    private String nom_user;
    private String prenom_user;
    private String email;
    private String password;
    @JsonIgnore
    private Set<RolesDTO> roles;
    @JsonIgnore
    private Set<RecetteCocktailDTO> recettes;
}
