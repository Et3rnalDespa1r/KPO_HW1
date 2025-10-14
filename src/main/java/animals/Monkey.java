package animals;

import java.util.concurrent.ThreadLocalRandom;

public class Monkey extends Herbo {
    public Monkey(int number) {
        super(
                "Monkey",
                ThreadLocalRandom.current().nextInt(6, 9),
                number,
                ThreadLocalRandom.current().nextBoolean(),
                ThreadLocalRandom.current().nextInt(0, 11)
        );
    }
}
