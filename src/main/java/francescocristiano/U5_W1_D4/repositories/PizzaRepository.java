package francescocristiano.U5_W1_D4.repositories;

import francescocristiano.U5_W1_D4.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {

    @Query("SELECT p FROM Pizza p JOIN p.toppings t WHERE t.name = :toppingName")
    List<Pizza> findPizzaWithToppingName(@Param("toppingName") String toppingName);
}
