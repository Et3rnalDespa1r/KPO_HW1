public abstract class Animal implements IAlive, IInventory {
    private final String name;
    private final int food;
    private final int number;
    private final boolean isHealthy;

    public Animal(String name, int food, int number, boolean isHealthy) {
        this.name = name;
        this.food = food;
        this.number = number;
        this.isHealthy = isHealthy;
    }

    public String Name() {
        return name;
    }

    @Override
    public int Food() {
        return food;
    }

    @Override
    public int Number() {
        return number;
    }

    public boolean isHealthy() {
        return isHealthy;
    }
}
