package francescocristiano.U5_W1_D4.repositories;

import francescocristiano.U5_W1_D4.entities.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToppingRepository extends JpaRepository<Topping, Long> {

    Topping findByName(String name);
}
