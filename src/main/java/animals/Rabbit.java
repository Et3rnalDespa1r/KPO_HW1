package animals;

import java.util.concurrent.ThreadLocalRandom;

public class Rabbit extends Herbo {
    public Rabbit(int number) {
        super(
                "Rabbit",
                ThreadLocalRandom.current().nextInt(2, 5),
                number,
                ThreadLocalRandom.current().nextBoolean(),
                ThreadLocalRandom.current().nextInt(0, 11)
        );
    }
}
