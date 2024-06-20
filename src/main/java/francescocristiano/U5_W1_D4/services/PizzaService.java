package francescocristiano.U5_W1_D4.services;

import francescocristiano.U5_W1_D4.entities.Pizza;
import francescocristiano.U5_W1_D4.repositories.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    public void savePizza(Pizza pizza) {
        pizzaRepository.save(pizza);
        System.out.println("Pizza salvata correttamente");
    }

    public void saveAllPizzas(List<Pizza> pizzas) {
        pizzaRepository.saveAll(pizzas);
        System.out.println("Pizze salvate correttamente");
    }

    public List<Pizza> findAllPizzas() {
        return pizzaRepository.findAll();
    }

    public Pizza findById(long id) {
        return pizzaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pizza non trovata"));
    }

    public void findAndDeleteById(long id) {
        pizzaRepository.deleteById(id);
        System.out.println("Pizza eliminata correttamente");
    }

    public void findAndUpdate(long id, Pizza pizza) {
        Pizza pizzaToUpdate = this.findById(id);

        pizzaToUpdate.setCalories(pizza.getCalories());
        pizzaToUpdate.setName(pizza.getName());
        pizzaToUpdate.setPrice(pizza.getPrice());
        pizzaToUpdate.setSize(pizza.getSize());
        pizzaToUpdate.setToppings(pizza.getToppings());

        pizzaRepository.save(pizzaToUpdate);

        System.out.println("Pizza aggiornata correttamente");
    }

    public long countPizzas() {
        return pizzaRepository.count();
    }

    public List<Pizza> findPizzaWithSalami() {
        return pizzaRepository.findPizzaWithToppingName("Salami");
    }


}
