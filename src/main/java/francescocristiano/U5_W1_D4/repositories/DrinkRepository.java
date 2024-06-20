package francescocristiano.U5_W1_D4.repositories;

import francescocristiano.U5_W1_D4.entities.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, Long> {
}
