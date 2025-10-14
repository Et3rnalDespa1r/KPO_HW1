public class Herbo extends Animal {
    private final int kindness;

    public Herbo(String name, int food, int number, boolean isHealthy, int kindness) {
        super(name, food, number, isHealthy);
        this.kindness = kindness;
    }

    public boolean isFriendly() {
        return kindness > 5;
    }
    public int getKindness() {
        return kindness;
    }
}
