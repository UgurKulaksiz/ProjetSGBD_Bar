package be.ipam.projetsgbd_bar.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class UtilisateurAndRecetteDTO {
    private int idRecette;
    private int idUser;
    private String nom_user;
    private String prenom_user;
    private String email;
    private String password;
    private Set<RecetteCocktailDTO> recettes;
}
