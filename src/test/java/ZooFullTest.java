import animals.*;
import clinic.VeterinaryClinic;
import inventory.Computer;
import inventory.Table;
import core.Zoo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ZooFullTest {

    private Zoo zoo;
    private VeterinaryClinic clinic;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        clinic = new VeterinaryClinic();
        zoo = new Zoo(clinic);
        System.setOut(new PrintStream(outContent));
        outContent.reset();
    }

    @Test
    void testRabbitCreation() {
        Rabbit rabbit = new Rabbit(101);
        assertEquals("Rabbit", rabbit.Name());
        assertEquals(101, rabbit.Number());
        assertTrue(rabbit.Food() >= 2 && rabbit.Food() <= 4);
        assertTrue(rabbit.getKindness() >= 0 && rabbit.getKindness() <= 10);
    }

    @Test
    void testTigerCreation() {
        Tiger tiger = new Tiger(102);
        assertEquals("Tiger", tiger.Name());
        assertEquals(102, tiger.Number());
        assertTrue(tiger.Food() >= 18 && tiger.Food() <= 24);
    }

    @Test
    void testWolfCreation() {
        Wolf wolf = new Wolf(103);
        assertEquals("Wolf", wolf.Name());
        assertEquals(103, wolf.Number());
        assertTrue(wolf.Food() >= 10 && wolf.Food() <= 15);
    }

    @Test
    void testMonkeyCreation() {
        Monkey monkey = new Monkey(104);
        assertEquals("Monkey", monkey.Name());
        assertEquals(104, monkey.Number());
        assertTrue(monkey.Food() >= 6 && monkey.Food() <= 8);
        assertTrue(monkey.getKindness() >= 0 && monkey.getKindness() <= 10);
    }

    @Test
    void testHerboFriendly() {
        Herbo friendly = new Herbo("Deer", 3, 201, true, 8);
        assertTrue(friendly.isFriendly());
        assertEquals(8, friendly.getKindness());
    }

    @Test
    void testHerboUnfriendly() {
        Herbo unfriendly = new Herbo("Rabbit", 3, 202, true, 3);
        assertFalse(unfriendly.isFriendly());
        assertEquals(3, unfriendly.getKindness());
    }

    @Test
    void testComputerAndTable() {
        Computer computer = new Computer(301);
        Table table = new Table(302);

        assertEquals("Computer", computer.Name());
        assertEquals(301, computer.Number());
        assertEquals("Table", table.Name());
        assertEquals(302, table.Number());
    }

    @Test
    void testVeterinaryClinic() {
        Herbo healthy = new Herbo("Rabbit", 3, 401, true, 7);
        Herbo unhealthy = new Herbo("Rabbit", 3, 402, false, 7);

        assertTrue(clinic.isHealth(healthy));
        assertFalse(clinic.isHealth(unhealthy));
    }


    @Test
    void testAddAnimal() {
        Herbo friendly = new Herbo("Deer", 3, 501, true, 8);
        Herbo unfriendly = new Herbo("Rabbit", 3, 502, true, 3);
        Herbo unhealthy = new Herbo("Rabbit", 3, 503, false, 7);

        zoo.addAnimal(friendly);
        zoo.addAnimal(unfriendly);
        zoo.addAnimal(unhealthy);
        assertEquals(2, zoo.getAnimalCount());
        assertEquals(1, zoo.getContactAnimalCount());
    }

    @Test
    void testFoodCount() {
        zoo.addAnimal(new Herbo("Rabbit", 4, 601, true, 10));
        zoo.addAnimal(new Herbo("Deer", 6, 602, true, 9));
        zoo.addAnimal(new Predator("Wolf", 10, 603, true) {});

        assertEquals(20, zoo.getFoodCount());
    }

    @Test
    void testAddThingAndPrint() {
        Computer computer = new Computer(701);
        Table table = new Table(702);

        zoo.addThing(computer);
        zoo.addThing(table);

        zoo.printThingsInfo();
        String output = outContent.toString();
        assertTrue(output.contains("Computer"));
        assertTrue(output.contains("Table"));
        assertTrue(output.contains("701"));
        assertTrue(output.contains("702"));
    }

    @Test
    void testPrintAnimalsInfo() {
        Rabbit rabbit = new Rabbit(801);
        zoo.addAnimal(rabbit);
        zoo.printAnimalsInfo();
        String output = outContent.toString();
        assertTrue(output.contains("Rabbit") || output.contains("не здоров"));
    }

    @Test
    void testContactAnimalCountWithMultipleHerbo() {
        Herbo friendly = new Herbo("Deer", 3, 901, true, 8);
        Herbo unfriendly = new Herbo("Rabbit", 3, 902, true, 3);
        zoo.addAnimal(friendly);
        zoo.addAnimal(unfriendly);

        assertEquals(1, zoo.getContactAnimalCount());
    }

    @Test
    void testPrintAnimalsAndThingsCombined() {
        Rabbit rabbit = new Rabbit(1001);
        Computer computer = new Computer(1002);
        zoo.addAnimal(rabbit);
        zoo.addThing(computer);

        zoo.printAnimalsInfo();
        zoo.printThingsInfo();
        String output = outContent.toString();
        assertTrue(output.contains("Rabbit") || output.contains("не здоров"));
        assertTrue(output.contains("Computer"));
    }
}
