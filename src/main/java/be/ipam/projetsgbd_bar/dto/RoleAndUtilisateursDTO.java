package be.ipam.projetsgbd_bar.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@Builder
public class RoleAndUtilisateursDTO {
    private int idUser;
    private int idRole;
    private String role;
    private Set<UtilisateurDTO> utilisateurs;
}
