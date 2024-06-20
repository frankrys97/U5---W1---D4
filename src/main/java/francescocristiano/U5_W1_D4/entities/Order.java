package francescocristiano.U5_W1_D4.entities;

import francescocristiano.U5_W1_D4.enums.StateOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@ToString
public class Order {

    private int orderNumber;
    private Table table;
    private List<ItemMenu> items;
    private StateOrder stateOrder;
    private int seats;
    private LocalDateTime dateTime;
    private double totalPrice;

    public Order(int orderNumber, Table table, List<ItemMenu> items, StateOrder stateOrder, int seats, double coverCost) {
        this.orderNumber = orderNumber;
        this.table = table;
        this.items = items;
        this.stateOrder = stateOrder;
        this.seats = seats;
        this.dateTime = LocalDateTime.now();
        this.totalPrice = calculateTotalPrice(coverCost);
    }

    private double calculateTotalPrice(double coverCost) {
        double itemsTotal = items.stream().mapToDouble(ItemMenu::getPrice).sum();
        return itemsTotal + (coverCost * seats);
    }
}
