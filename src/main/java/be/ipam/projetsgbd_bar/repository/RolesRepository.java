package be.ipam.projetsgbd_bar.repository;

import be.ipam.projetsgbd_bar.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {
}
