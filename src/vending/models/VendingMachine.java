package vending.models;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    public static double totalGlobalSales;

    private String location;
    private List<Item> inventory;
    private double currentBalance;

    public VendingMachine(String location) {
        this.location = location;
        this.inventory = new ArrayList<>();
        this.currentBalance = 0;
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void insertMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException(">>ERROR: Cannot insert negative amount: " + money + "\n");
        }

        currentBalance += money;
        System.out.printf("> Inserted $%.2f\n", money);
    }

    public void selectItem(int index) {
        if (index < 0 || index > inventory.size()) {
            throw new IndexOutOfBoundsException(">>ERROR: Selection #" + index + " does not exist.\n");
        }

        Item selected = inventory.get(index);
        double price = selected.getPrice();

        if (currentBalance < price) {
            throw new IllegalArgumentException(">>ERROR: Insufficient funds. Need $" + (price - currentBalance) + "more\n");
        }

        totalGlobalSales += price;
        double change = currentBalance - price;
        inventory.remove(index);
        currentBalance = 0;

        System.out.print("Dispensing " + selected.getName() + "...\n");
        System.out.printf("Returning $%.2f\n", change);
    }

    public void displayInventory() {
        System.out.print("--- Inventory: " + location + " ---\n");
        for (int i = 0; i < inventory.size(); i++) {
            System.out.print(i + ": " + inventory.get(i) + "\n");
        }
    }

    public static double getGlobalSales() {
        return totalGlobalSales;
    }
}
