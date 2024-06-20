package francescocristiano.U5_W1_D4.repositories;

import francescocristiano.U5_W1_D4.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}
