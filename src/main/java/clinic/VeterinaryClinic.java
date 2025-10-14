package clinic;

import animals.Animal;
import org.springframework.stereotype.Component;

@Component
public class VeterinaryClinic {
    public boolean isHealth(Animal animal) {
        return animal.isHealthy();
    }
}
