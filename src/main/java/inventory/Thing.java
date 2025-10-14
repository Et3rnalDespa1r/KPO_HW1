package inventory;

import Interfaces.IInventory;

public class Thing implements IInventory {
    private final String name;
    private final int number;

    public Thing(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String Name() {
        return name;
    }

    @Override
    public int Number() {
        return number;
    }
}
