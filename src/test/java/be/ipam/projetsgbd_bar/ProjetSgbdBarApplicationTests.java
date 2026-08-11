package be.ipam.projetsgbd_bar;

import be.ipam.projetsgbd_bar.model.Roles;
import be.ipam.projetsgbd_bar.model.Utilisateur;
import be.ipam.projetsgbd_bar.service.RolesService;
import be.ipam.projetsgbd_bar.service.UtilisateurService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProjetSgbdBarApplicationTests {
    @Autowired
    UtilisateurService utilisateurService;
    @Autowired
    RolesService rolesService;

    @Test
    void contextLoads() {
        List<Utilisateur> listUsers = utilisateurService.getAllUser();
        for (Utilisateur u : listUsers){
            System.out.println(u.getPrenom_user()+" "+u.getNom_user());
        }

        List<Roles> listRoles = rolesService.getAllRoles();
        for (Roles r : listRoles){
            System.out.println(r.getRole());
        }
    }

}
