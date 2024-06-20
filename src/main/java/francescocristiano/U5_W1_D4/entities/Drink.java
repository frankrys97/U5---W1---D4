package francescocristiano.U5_W1_D4.entities;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Drink extends ItemMenu {
    private double size;
    private Double alcoholConcentration;
    // Ricordarsi di chiedere a Riccardo


    public Drink(String name, double price, int calories, double size, Double alcoholConcentration) {
        super(name, price, calories);
        this.size = size;
        this.alcoholConcentration = alcoholConcentration;
    }

/*    @Override
    public String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", calories=" + calories +
                '}';
    }*/
}
