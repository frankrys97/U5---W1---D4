package francescocristiano.U5_W1_D4.entities;


import francescocristiano.U5_W1_D4.enums.Size;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Pizza extends ItemMenu {

    @ManyToMany
    @JoinTable(name = "pizza_topping", joinColumns = @JoinColumn(name = "pizza_id"), inverseJoinColumns = @JoinColumn(name = "topping_id"))
    private List<Topping> toppings;
    @Enumerated(EnumType.STRING)
    private Size size;


    public Pizza(String name, double price, int calories, List<Topping> toppings, Size size) {
        super(name, price, calories);
        this.size = size;
        this.setName(customName(size, name));
        this.setPrice(customPrice(size, price));
        this.setCalories(customCalories(size, calories));
        this.toppings = baseToppings(toppings);
    }


    private String customName(Size size, String name) {
        if (size == Size.XL) {
            return name + " XL";
        }
        return name;
    }

    private double customPrice(Size size, double price) {
        if (size == Size.XL) {
            return price * 1.5;
        }
        return price;
    }

    private int customCalories(Size size, int calories) {
        if (size == Size.XL) {
            return (int) (calories * 1.5);
        }
        return calories;
    }


    private List<Topping> baseToppings(List<Topping> toppings) {
        Topping mozzarella = new Topping("Mozzarella", 0.99, 35);
        Topping tomato = new Topping("Tomato", 0.69, 22);
        List<Topping> baseToppings = new ArrayList<>();
        baseToppings.add(mozzarella);
        baseToppings.add(tomato);
        baseToppings.addAll(toppings);
        return baseToppings;
    }


    @Override
    public String toString() {
        return "Pizza{" +
                super.toString() +
                ", toppings=" + toppings.stream().map(Topping::getName).collect(Collectors.joining(", ")) +
                ", size=" + size +
                '}';
    }

/*    @Override
    public String toString() {
        return "Pizza{" +
                super.toString() +
                "toppings=" + toppings +
                ", size=" + size +
                '}';
    }*/
}
