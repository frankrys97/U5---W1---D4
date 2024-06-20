package francescocristiano.U5_W1_D4.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Topping extends ItemMenu {

    @ManyToMany(mappedBy = "toppings")
    private List<Pizza> pizzas;

    public Topping(String name, double price, int calories) {
        super(name, price, calories);
    }


}
