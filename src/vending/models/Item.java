package vending.models;

public class Item {
    private String name;
    private double price;
    private ItemType itemType;

    public Item(String name, double price, ItemType itemType) {
        this.name = name;
        this.price = price;
        this.itemType = itemType;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return this.name + " $" + this.price + " " + itemType.toString();
    }
}
