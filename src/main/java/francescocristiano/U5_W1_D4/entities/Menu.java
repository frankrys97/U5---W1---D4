package francescocristiano.U5_W1_D4.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Menu {
    List<Pizza> pizzas;
    List<Drink> drinks;
    List<Topping> toppings;

    @Override
    public String toString() {
        return "Menu{" +
                "pizzas=" + pizzas +
                ", drinks=" + drinks +
                ", toppings=" + toppings +
                '}';
    }
}
