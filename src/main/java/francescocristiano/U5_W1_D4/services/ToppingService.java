package francescocristiano.U5_W1_D4.services;


import francescocristiano.U5_W1_D4.entities.Topping;
import francescocristiano.U5_W1_D4.repositories.ToppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToppingService {

    @Autowired
    private ToppingRepository toppingRepository;


    public void saveTopping(Topping topping) {
        toppingRepository.save(topping);
        System.out.println("Topping salvato correttamente");
    }

    public Topping findByName(String name) {
        return toppingRepository.findByName(name);
    }

    public void saveAllToppings(List<Topping> toppings) {
        toppingRepository.saveAll(toppings);
        System.out.println("Toppings salvati correttamente");
    }


    public List<Topping> findAllToppings() {
        return toppingRepository.findAll();
    }

    public Topping findById(long id) {
        return toppingRepository.findById(id).orElseThrow(() -> new RuntimeException("Topping non trovato"));
    }


    public void findAndDeleteById(long id) {
        toppingRepository.deleteById(id);
        System.out.println("Topping eliminato correttamente");
    }

    public void findAndUpdate(long id, Topping topping) {
        Topping toppingToUpdate = this.findById(id);

        toppingToUpdate.setCalories(topping.getCalories());
        toppingToUpdate.setName(topping.getName());
        toppingToUpdate.setPrice(topping.getPrice());

        toppingRepository.save(toppingToUpdate);

        System.out.println("Topping aggiornato correttamente");
    }

    public long countToppings() {
        return toppingRepository.count();
    }
}
