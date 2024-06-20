package francescocristiano.U5_W1_D4.entities;

import francescocristiano.U5_W1_D4.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class Table {
    private int id;
    private int seats;
    private State state;
}
