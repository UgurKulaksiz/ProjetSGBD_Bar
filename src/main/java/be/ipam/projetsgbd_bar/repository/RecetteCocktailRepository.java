package be.ipam.projetsgbd_bar.repository;

import be.ipam.projetsgbd_bar.model.RecetteCocktail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetteCocktailRepository extends JpaRepository<RecetteCocktail, Integer> {
}
