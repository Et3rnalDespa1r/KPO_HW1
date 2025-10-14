import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Zoo {
    private final VeterinaryClinic clinic;
    private final List<Animal> animals = new ArrayList<>();
    private final List<Thing> things = new ArrayList<>();
    @Autowired
    public Zoo(VeterinaryClinic clinic) {
        this.clinic = clinic;
    }

    public void addAnimal(Animal animal) {
        if (!clinic.isHealth(animal)) {
            System.out.println(animal.Name() + " не здоров и не добавлен в зоопарк.");
            return;
        }

        if (animal instanceof Herbo herbo) {
            if (herbo.isFriendly()) {
                animals.add(animal);
                System.out.println(animal.Name() + " добавлен в контактный зоопарк.");
            } else {
                animals.add(animal);
                System.out.println(animal.Name() + " добавлен в обычный зоопарк.");
            }
        } else { // Predator
            animals.add(animal);
            System.out.println(animal.Name() + " добавлен в обычный зоопарк.");
        }
    }


    public void addThing(Thing thing) {
        things.add(thing);
        System.out.printf(
                "На баланс добавлена вещь: %-10s| Инв. номер: %04d%n",
                thing.Name(),
                thing.Number()
        );
    }

    public int getAnimalCount() {
        return animals.size();
    }

    public int getFoodCount() {
        int foodCount = 0;
        for (Animal animal : animals) {
            foodCount += animal.Food();
        }
        return foodCount;
    }

    public int getContactAnimalCount() {
        int contactAnimalCount = 0;
        for (Animal animal : animals) {
            if (animal instanceof Herbo herbo && herbo.isFriendly()) {
                contactAnimalCount++;
            }
        }
        return contactAnimalCount;
    }
    public void printContactAnimals() {
        for (Animal animal : animals) {
            if (animal instanceof Herbo herbo && herbo.isFriendly()) {
                System.out.println("Название: " + animal.Name());
                System.out.println("Номер животного: " + animal.Number());
                System.out.println("Требуется еды в день: " + animal.Food() + "кг");
                System.out.println("Доброта травоядного животного (от 0 до 10): " + herbo.getKindness());
                System.out.println("\n");
            }

        }
    }
    public void printAnimalsInfo() {
        System.out.println("Животные и их номера:");
        for (Animal animal : animals) {
            System.out.println("Название: " + animal.Name());
            System.out.println("Номер животного: " + animal.Number());
            System.out.println("Требуется еды в день: " + animal.Food() + "кг");
            if (animal instanceof Herbo herbo) {
                System.out.println("Доброта травоядного животного (от 0 до 10): " + herbo.getKindness());
            }
            System.out.println("\n");
        }
    }
    public void printThingsInfo() {
        System.out.println("Вещи и их номера:");
        for (Thing thing : things) {
            System.out.println("  • " + thing.Name() + " — №" + thing.Number());
        }
    }
}
