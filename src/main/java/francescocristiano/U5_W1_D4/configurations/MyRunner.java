package francescocristiano.U5_W1_D4.configurations;

import francescocristiano.U5_W1_D4.entities.Menu;
import francescocristiano.U5_W1_D4.entities.Pizza;
import francescocristiano.U5_W1_D4.services.DrinkService;
import francescocristiano.U5_W1_D4.services.PizzaService;
import francescocristiano.U5_W1_D4.services.ToppingService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
@PropertySource("application.properties")
@Transactional
public class MyRunner implements CommandLineRunner {

    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private DrinkService drinkService;

    @Autowired
    private ToppingService toppingService;

/*    @Value("${coverCost}")
    private double coverCost;*/


    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        Menu menu = context.getBean(Menu.class);
        Random random = new Random();

/*        menu.getPizzas().forEach(System.out::println);

        toppingService.saveAllToppings(menu.getToppings());
        Topping mozzarella = new Topping("Mozzarella", 0.99, 35);
        Topping tomato = new Topping("Tomato", 0.69, 22);
        toppingService.saveTopping(mozzarella);
        toppingService.saveTopping(tomato);


        menu.getPizzas().forEach(pizza -> {
            List<Topping> pizzaToppings = new ArrayList<>();
            pizza.getToppings().forEach(topping -> {
                Topping newTopping = toppingService.findByName(topping.getName());
                pizzaToppings.add(newTopping);
            });

            pizza.setToppings(pizzaToppings);
            pizzaService.savePizza(pizza);
        });

        drinkService.saveAllDrinks(menu.getDrinks());*/

        List<Pizza> pizzeWithSalami = pizzaService.findPizzaWithToppingName();
        pizzeWithSalami.forEach(System.out::println);


    }
}
