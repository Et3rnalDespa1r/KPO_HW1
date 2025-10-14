import animals.Monkey;
import animals.Rabbit;
import animals.Tiger;
import animals.Wolf;
import core.AppConfig;
import inventory.Computer;
import inventory.Table;
import core.Zoo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Zoo zoo = context.getBean(Zoo.class);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    \n=== Меню зоопарка ===
                    1. Добавить животное
                    2. Добавить вещь
                    3. Показать всех животных
                    4. Показать суммарное потребление еды
                    5. Показать животных для контактного зоопарка
                    6. Показать все инвентарные номера
                    0. Выйти
                    """);

            System.out.print("Ваш выбор: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("Выберите животное:");
                    System.out.println("1 - Tiger");
                    System.out.println("2 - Wolf");
                    System.out.println("3 - Monkey");
                    System.out.println("4 - Rabbit");
                    int type = scanner.nextInt();
                    int number = ThreadLocalRandom.current().nextInt(100, 999);
                    switch (type) {
                        case 1 -> zoo.addAnimal(new Tiger(number));
                        case 2 -> zoo.addAnimal(new Wolf(number));
                        case 3 -> zoo.addAnimal(new Monkey(number));
                        case 4 -> zoo.addAnimal(new Rabbit(number));
                        default -> System.out.println("Такого животного нет!");
                    }
                }
                case 2 -> {
                    System.out.println("Введите название вещи: ");
                    System.out.println("1 - Table");
                    System.out.println("2 - Computer");
                    int type = scanner.nextInt();
                    int number = ThreadLocalRandom.current().nextInt(1000, 9999);
                    switch (type) {
                        case 1 -> zoo.addThing(new Table(number));
                        case 2 -> zoo.addThing(new Computer(number));
                        default -> System.out.println("Такой вещи пока нет(");
                    }
                }
                case 3 -> zoo.printAnimalsInfo();
                case 4 -> System.out.println("Всего еды требуется: " + zoo.getFoodCount() + " кг в день");
                case 5 -> {
                    System.out.println("Количество животных контактного зоопарка: " + zoo.getContactAnimalCount());
                    zoo.printContactAnimals();
                }
                case 6 -> zoo.printThingsInfo();
                case 0 -> {
                    System.out.println("Выход из программы...");
                    return;
                }
                default -> System.out.println("Неверный ввод, попробуйте снова.");
            }
        }
    }
}
