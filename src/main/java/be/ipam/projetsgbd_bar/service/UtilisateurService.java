package be.ipam.projetsgbd_bar.service;

import be.ipam.projetsgbd_bar.model.Utilisateur;
import be.ipam.projetsgbd_bar.repository.UtilisateurRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {
    @Autowired
    private final UtilisateurRepository utilisateurRepository;

    /*
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
     */

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    //Création de méthodes
    //CRUD
    public List<Utilisateur> getAllUserWithoutDTO() {
        return utilisateurRepository.findAll();
    }
    public List<Utilisateur> getAllUser() {
        return utilisateurRepository.findAll();
    }

    public Optional<Utilisateur> getUserById(int idUser) {
        return utilisateurRepository.findById(idUser);
    }

    @Transactional
    public Optional<Utilisateur> getUserByIdWithRoles(int idUser) {
        Optional<Utilisateur> user =  utilisateurRepository.findById(idUser);
        Utilisateur user1 = user.get();
        user1.getRoles();
        Optional<Utilisateur> user2 = Optional.of(user1);

        return user2;
    }
    @Transactional
    public Optional<Utilisateur> getUserByIdWithRecettes(int idUser) {
        Optional<Utilisateur> user =  utilisateurRepository.findById(idUser);
        Utilisateur user1 = user.get();
        user1.getRecettes();
        Optional<Utilisateur> user2 = Optional.of(user1);

        return user2;
    }

    public Utilisateur createUser(Utilisateur utilisateur) {
        /*
        // Password hashé
        utilisateur.setPassword(bCryptPasswordEncoder.encode(utilisateur.getPassword()));
        */

        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur updateUser(int idUser, Utilisateur updatedUser) {
        Optional<Utilisateur> existingUtilisateurOptional = utilisateurRepository.findById(idUser);

        if (existingUtilisateurOptional.isPresent()) {
            Utilisateur existingUtilisateur = existingUtilisateurOptional.get();
                existingUtilisateur.setNom_user(updatedUser.getNom_user());
                existingUtilisateur.setPrenom_user(updatedUser.getPrenom_user());
                existingUtilisateur.setEmail(updatedUser.getEmail());
                existingUtilisateur.setPassword(updatedUser.getPassword());

            return utilisateurRepository.save(existingUtilisateur);
        } else {
            throw new EntityNotFoundException("User with ID " + idUser + " not found.");
        }
    }

    /*
    public Utilisateur patchUtilisateur(int idUser, Utilisateur updatedUser) {
        Optional<Utilisateur> existingUtilisateurOptional = utilisateurRepository.findById(idUser);
        if (existingUtilisateurOptional.isPresent()) {
            Utilisateur existingUtilisateur = existingUtilisateurOptional.get();

            if (updatedUser.getPrenomUser() != null) {
                existingUtilisateur.setPrenomUser(updatedUser.getPrenomUser());
            }

            return utilisateurRepository.save(existingUtilisateur);
        } else {
            throw new EntityNotFoundException("User with ID " + idUser + " not found.");
        }
    }
     */

    public void deleteUser(int idUser) {
        utilisateurRepository.deleteById(idUser);
    }

    /*
    //Find by login
    public Optional<Utilisateur> findByLogin(String login){
        return utilisateurRepository.findByLogin(login);
    }
     */
}
