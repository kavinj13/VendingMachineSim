package vending.models;

public enum ItemType {
    SNACK("Snack"),
    DRINK("Drink"),
    CANDY("Candy"),
    ELECTRONIC("Electronic");

    private final String prettyName;

    private ItemType(String prettyName) {
        this.prettyName = prettyName;
    }

    @Override
    public String toString() {
        return this.prettyName;
    }
}
