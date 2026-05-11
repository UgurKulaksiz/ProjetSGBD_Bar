package be.ipam.projetsgbd_bar.controller;

import be.ipam.projetsgbd_bar.dto.RoleAndUtilisateursDTO;
import be.ipam.projetsgbd_bar.dto.RolesDTO;
import be.ipam.projetsgbd_bar.mapper.RolesMapper;
import be.ipam.projetsgbd_bar.model.Roles;
import be.ipam.projetsgbd_bar.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RolesController {
    @Autowired
    private RolesService rolesService;

    @Autowired
    private RolesMapper rolesMapper;

    //CRUD
    // GET all roles
    //@Secured("ROLE_ADMIN")
    @GetMapping
    public ResponseEntity<List<RolesDTO>> getAllRoles() {
        List<RolesDTO> roles = rolesService.getAllRoles().stream().map(rolesMapper::convertToDTO).toList();

        return ResponseEntity.ok(roles);
    }

    // GET role by id
    // @Secured("ROLE_VISITOR")
    @GetMapping("/{idRole}")
    public ResponseEntity<RolesDTO> getRoleById(@PathVariable int idRole) {
        Optional<Roles> rolesOptional = rolesService.getRoleById(idRole);

        return rolesOptional.map(roles ->
                        ResponseEntity.ok(rolesMapper.convertToDTO(roles)))
                .orElseGet(() ->
                        ResponseEntity.notFound().build());
    }

    // GET role by id with Users
    @GetMapping("/users/{idRole}")
    public ResponseEntity<RoleAndUtilisateursDTO> getRoleByIdWithUsers(@PathVariable int idRole) {
        Optional<Roles> rolesOptional = rolesService.getRoleByIdWithUsers(idRole);

        return rolesOptional.map(roles ->
                        ResponseEntity.ok(rolesMapper.convertToDTOWithUser(roles)))
                .orElseGet(() ->
                        ResponseEntity.notFound().build());
    }

    // POST Create role
    @PostMapping("/role")
    public ResponseEntity<RolesDTO> createRole(@RequestBody RolesDTO rolesDTO) {
        Roles createdRoles = rolesService.createRole(rolesMapper.convertToEntity(rolesDTO));

        return ResponseEntity.status(HttpStatus.CREATED).body(rolesMapper.convertToDTO(createdRoles));
    }

    // PUT Update role --> Remplace tout l'objet
    @PutMapping("/{idRole}")
    public ResponseEntity<Roles> updateRole(@PathVariable int idRole, @RequestBody RolesDTO roleToUpdate) {
        Optional<Roles> existingRoles = rolesService.getRoleById(idRole);

        if (existingRoles.isPresent()) {
            roleToUpdate.setIdRole(idRole);
            Roles updatedRoles = rolesService.updateRole(idRole, rolesMapper.convertToEntity(roleToUpdate));

            return ResponseEntity.ok(updatedRoles);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /*
    // PATCH Update role --> Remplace une partie de l'objet
    @PatchMapping("/{idRole}") {
        public ResponseEntity<Void> updateRolePatch(@PathVariable int idRole, @RequestBody RolesDTO roleToUpdate){
            Optional<Roles> existingRoles = rolesService.getRoleById(idRole);

            if (existingRoles.isPresent()) {
                Roles updateRole = rolesMapper.convertToEntity(roleToUpdate);
                Roles exist_role = existingRoles.get(); //Récupère le rôle en BD
                exist_role.setRole(updateRole.getRole());

                Roles updatedRole = rolesService.updateRole(idRole, exist_role);

                return ResponseEntity.ok(updatedRole);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    }
     */

    // DELETE Delete role
    @DeleteMapping("/{idRole}")
    public ResponseEntity<Void> deleteRole(@PathVariable int idRole) {
        Optional<Roles> existingRoles = rolesService.getRoleById(idRole);

        if (existingRoles.isPresent()) {
            rolesService.deleteRole(idRole);

            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
