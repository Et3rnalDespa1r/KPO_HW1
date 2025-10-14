import java.util.concurrent.ThreadLocalRandom;

public class Tiger extends Predator {
    public Tiger(int number) {
        super(
                "Tiger",
                ThreadLocalRandom.current().nextInt(18, 25),
                number,
                ThreadLocalRandom.current().nextBoolean()
        );
    }
}
