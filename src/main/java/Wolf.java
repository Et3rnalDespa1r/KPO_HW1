import java.util.concurrent.ThreadLocalRandom;

public class Wolf extends Predator {
    public Wolf(int number) {
        super(
                "Wolf",
                ThreadLocalRandom.current().nextInt(10, 16),
                number,
                ThreadLocalRandom.current().nextBoolean()
        );
    }
}
