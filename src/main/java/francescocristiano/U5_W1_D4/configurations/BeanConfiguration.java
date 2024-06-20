package francescocristiano.U5_W1_D4.configurations;


import francescocristiano.U5_W1_D4.entities.Drink;
import francescocristiano.U5_W1_D4.entities.Menu;
import francescocristiano.U5_W1_D4.entities.Pizza;
import francescocristiano.U5_W1_D4.entities.Topping;
import francescocristiano.U5_W1_D4.enums.Size;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration
@PropertySource("application.properties")
public class BeanConfiguration {

 /*   @Bean
    public Size regular() {
        return Size.REGULAR;
    }

    @Bean
    public Size xl() {
        return Size.XL;
    }*/


    @Bean
    public Topping ham() {
        return new Topping("Ham", 0.99, 35);

    }

    @Bean
    public Topping onions() {
        return new Topping("Onions", 0.69, 22);
    }

    @Bean
    public Topping pineapple() {
        return new Topping("Pineapple", 0.79, 24);
    }

    @Bean
    public Topping salami() {
        return new Topping("Salami", 0.99, 86);
    }

    @Bean
    public Drink lemonade() {
        return new Drink("Lemonade", 1.29, 128, 0.33, null);
    }

    @Bean
    public Drink water() {
        return new Drink("Water", 1.29, 0, 0.5, null);
    }

    @Bean
    public Drink wine() {
        return new Drink("Wine", 7.49, 607, 0.75, 13.0);
    }

    @Bean
    public Pizza hawaiianPizza() {
        return new Pizza("Hawaiian Pizza", 6.49, 1024, List.of(ham(), pineapple()), Size.REGULAR);
    }


    @Bean
    public Pizza salamiPizza() {
        return new Pizza("Pizza Salami", 5.99, 1160, List.of(salami()), Size.REGULAR);
    }


    @Bean
    public Pizza margheritaPizza() {
        return new Pizza("Pizza Margherita", 4.99, 1104, List.of(), Size.REGULAR);
    }

    private Pizza createPizzaXl(Pizza pizza) {
        return new Pizza(pizza.getName(), pizza.getPrice(), pizza.getCalories(), pizza.getToppings().stream().filter(topping -> !topping.getName().equals("Tomato") && !topping.getName().equals("Mozzarella")).toList(), Size.XL);
    }

    @Bean
    public Pizza hawaiianPizzaXl() {
        return createPizzaXl(hawaiianPizza());
    }

    @Bean
    public Pizza salamiPizzaXl() {
        return createPizzaXl(salamiPizza());
    }

    @Bean
    public Pizza margheritaPizzaXl() {
        return createPizzaXl(margheritaPizza());
    }


    @Bean
    public Menu menu() {
        return new Menu(List.of(margheritaPizza(), margheritaPizzaXl(), hawaiianPizza(), hawaiianPizzaXl(), salamiPizza(), salamiPizzaXl()), List.of(lemonade(), wine(), water()), List.of(ham(), pineapple(), onions(), salami()));
    }

  /*  @Bean(name = "coverCost")
    public Double coverCost(@Value("${cover.cost}") Double coverCost) {
        return coverCost;
    }*/


}


