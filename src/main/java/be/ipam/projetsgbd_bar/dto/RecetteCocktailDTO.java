package be.ipam.projetsgbd_bar.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class RecetteCocktailDTO {
    private int idRecette;
    private String nomRecette;
    private String descriptionRecette;
    private Boolean officielle;
    @JsonIgnore
    private Set<UtilisateurDTO> utilisateur;
}
