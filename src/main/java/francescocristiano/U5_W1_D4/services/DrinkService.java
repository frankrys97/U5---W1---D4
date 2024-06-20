package francescocristiano.U5_W1_D4.services;


import francescocristiano.U5_W1_D4.entities.Drink;
import francescocristiano.U5_W1_D4.repositories.DrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkService {

    @Autowired
    private DrinkRepository drinkRepository;


    public void saveDrink(Drink drink) {
        drinkRepository.save(drink);
        System.out.println("Drink salvato correttamente");
    }

    public void saveAllDrinks(List<Drink> drinks) {
        drinkRepository.saveAll(drinks);
        System.out.println("Drinks salvati correttamente");
    }


    public List<Drink> findAllDrinks() {
        return drinkRepository.findAll();
    }

    public Drink findById(long id) {
        return drinkRepository.findById(id).orElseThrow(() -> new RuntimeException("Drink non trovato"));
    }


    public void findAndDeleteById(long id) {
        drinkRepository.deleteById(id);
        System.out.println("Drink eliminato correttamente");
    }

    public void findAndUpdate(long id, Drink drink) {
        Drink drinkToUpdate = this.findById(id);

        drinkToUpdate.setCalories(drink.getCalories());
        drinkToUpdate.setName(drink.getName());
        drinkToUpdate.setPrice(drink.getPrice());
        drinkToUpdate.setSize(drink.getSize());

        drinkRepository.save(drinkToUpdate);

        System.out.println("Drink aggiornato correttamente");
    }

    public long countDrinks() {
        return drinkRepository.count();
    }

}
