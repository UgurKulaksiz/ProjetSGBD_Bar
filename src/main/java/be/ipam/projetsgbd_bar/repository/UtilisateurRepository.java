package be.ipam.projetsgbd_bar.repository;

import be.ipam.projetsgbd_bar.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
   // Optional<Utilisateur> findByLogin(String login);
}
