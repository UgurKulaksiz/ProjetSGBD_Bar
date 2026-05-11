package be.ipam.projetsgbd_bar.controller;

import be.ipam.projetsgbd_bar.dto.UserAndRoleDTO;
import be.ipam.projetsgbd_bar.dto.UtilisateurAndRecetteDTO;
import be.ipam.projetsgbd_bar.dto.UtilisateurDTO;
import be.ipam.projetsgbd_bar.mapper.UtilisateurMapper;
import be.ipam.projetsgbd_bar.model.Utilisateur;
import be.ipam.projetsgbd_bar.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {
    private final UtilisateurService utilisateurService;
    @Autowired //--> Permet de lancer POSTMAN (localhost:8080/utilisateurs) par exemple
    private UtilisateurMapper userMapper;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    //Get (read) all utilisateur sans DTO
    /*
    @GetMapping("/withoutDTO")
    public ResponseEntity<List<Utilisateur>> getAllUserWithoutDTO(){
        List<Utilisateur> utilisateurs = utilisateurService.getAllUser().stream().toList();
        return ResponseEntity.ok(utilisateurs);
    }
    */

    //CRUD
    //GET Get (read) all utilisateur DTO
    @GetMapping
    public ResponseEntity<List<UtilisateurDTO>> getAllUser() {
        List<UtilisateurDTO> utilisateur = utilisateurService.getAllUser().stream().map(userMapper::convertToDTO).toList();
        // .map(s -> userMapper.convertToDTO(s)).toList();

        return ResponseEntity.ok(utilisateur);
    }

    //GET Get (read) utilisateur by id
    @GetMapping("/{idUser}")
    public ResponseEntity<UtilisateurDTO> getUtilisateurById(@PathVariable int idUser) {
        Optional<Utilisateur> userOptional = utilisateurService.getUserById(idUser);
        //To avoid null

        //if (student.isPresent()) {
        //    return ResponseEntity.ok(studentMapper.convertToDTO(student.get()));
        //} else {
        //    return ResponseEntity.notFound().build();
        //}

        return userOptional.map(utilisateur ->
                        ResponseEntity.ok(userMapper.convertToDTO(utilisateur)))
                .orElseGet(() ->
                        ResponseEntity.notFound().build());
    }

    // GET utilisateur by id with Roles
    @GetMapping("/roles/{idUser}")
    public ResponseEntity<UserAndRoleDTO> getUtilisateurByIDWithRoles(@PathVariable int idUser) {
        Optional<Utilisateur> userOptional = utilisateurService.getUserByIdWithRoles(idUser);

        return userOptional.map(utilisateur ->
                        ResponseEntity.ok(userMapper.convertToDTOWithRoles(utilisateur)))
                .orElseGet(() ->
                        ResponseEntity.notFound().build());
    }

    // GET utilisateur by id with Recettes
    @GetMapping("/recettes/{idUser}")
    public ResponseEntity<UtilisateurAndRecetteDTO> getUtilisateurByIDWithRecettes(@PathVariable int idUser) {
        Optional<Utilisateur> userOptional = utilisateurService.getUserByIdWithRecettes(idUser);

        return userOptional.map(utilisateur ->
                        ResponseEntity.ok(userMapper.convertToDTOWithRecettes(utilisateur)))
                .orElseGet(() ->
                        ResponseEntity.notFound().build());
    }

    //POST Create utilisateur
    @PostMapping("/utilisateur")
    public ResponseEntity<UtilisateurDTO> createUtilisateur(@RequestBody UtilisateurDTO utilisateurDTO) {
        Utilisateur createdUtilisateur = utilisateurService.createUser(userMapper.convertToEntity(utilisateurDTO));

        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.convertToDTO(createdUtilisateur));
    }

    /*
    //POST Create utilisateur
    @PostMapping("/registerUser")
    public ResponseEntity<UtilisateurDTO> createUtilisateur(@RequestBody UtilisateurDTO utilisateurDTO) {
        Utilisateur createdUtilisateur = utilisateurService.createUser(userMapper.convertToEntity(utilisateurDTO));

        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.convertToDTO(createdUtilisateur));
    }
     */


    //PUT Update utilisateur --> Remplace tout l'objet
    @PutMapping("/{idUser}")
    public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable int idUser, @RequestBody UtilisateurDTO userToUpdate) {
        Optional<Utilisateur> existingUtilisateur = utilisateurService.getUserById(idUser);

        if (existingUtilisateur.isPresent()) {
            userToUpdate.setIdUser(idUser);
            Utilisateur updatedUser = utilisateurService.updateUser(idUser, userMapper.convertToEntity(userToUpdate));

            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //PATCH Update utilisateur --> Remplace une partie de l'objet
    @PatchMapping("/{idUser}")
    public ResponseEntity<Utilisateur> updateUtilisateurPatch(@PathVariable int idUser, @RequestBody UtilisateurDTO utilisateurToUpdate) {
        Optional<Utilisateur> existingUtilisateur = utilisateurService.getUserById(idUser);

        if (existingUtilisateur.isPresent()) {
            Utilisateur updateUser = userMapper.convertToEntity(utilisateurToUpdate);
            Utilisateur exist_user = existingUtilisateur.get(); //Récupérer l'utilisateur en BD
            exist_user.setNom_user(updateUser.getNom_user());
            exist_user.setPrenom_user(updateUser.getPrenom_user());

            Utilisateur updatedUtilisateur = utilisateurService.updateUser(idUser, exist_user);

            return ResponseEntity.ok(updatedUtilisateur);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //DELETE Delete utilisateur
    @DeleteMapping("/{idUser}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable int idUser) {
        Optional<Utilisateur> existingUtilisateur = utilisateurService.getUserById(idUser);

        if (existingUtilisateur.isPresent()) {
            utilisateurService.deleteUser(idUser);

            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
