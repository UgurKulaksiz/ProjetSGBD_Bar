package be.ipam.projetsgbd_bar.service;

import be.ipam.projetsgbd_bar.model.Roles;
import be.ipam.projetsgbd_bar.repository.RolesRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesService {
    @Autowired
    private RolesRepository rolesRepository;

    //Création de méthodes

    /*
    // Method pour ajouter ou mettre à jour un rôle
    public Roles createOrUpdateRole(Roles role) {
        return rolesRepository.save(role);
    }
     */

    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }


    public Optional<Roles> getRoleById(int idRole) {
        return rolesRepository.findById(idRole);
    }

    @Transactional //-> Méthode exécutée dans son intégralité (succés ou rien) pour maintenir la cohérence des données
    public Optional<Roles> getRoleByIdWithUsers(int idRole) {
        Optional<Roles> r =  rolesRepository.findById(idRole);
        Roles r1 = r.get();
        r1.getUtilisateur();
        Optional<Roles> r2 = Optional.of(r1);

        return r2;
    }


    public Roles createRole(Roles roles) {
        return rolesRepository.save(roles);
    }

    public Roles updateRole(int idRole, Roles updatedRole) {
        Optional<Roles> existingRolesOptional = rolesRepository.findById(idRole);

        if (existingRolesOptional.isPresent()) {
            Roles existingRoles = existingRolesOptional.get();
            existingRoles.setRole(updatedRole.getRole());

            return rolesRepository.save(existingRoles);
        } else {
            throw new EntityNotFoundException("Rôle with ID " + idRole + " not found.");
        }
    }

    public void deleteRole(int idRole) {
        rolesRepository.deleteById(idRole);
    }
}
