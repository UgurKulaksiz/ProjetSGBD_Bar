package be.ipam.projetsgbd_bar.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@Builder
public class RolesDTO {
    private int idRole;
    private String role;
    @JsonIgnore
    private Set<UtilisateurDTO> utilisateur;
}
