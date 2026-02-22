//VIDEO LINK: https://youtu.be/YoqOcdqtg5g

package vending.app;

import vending.models.Item;
import vending.models.ItemType;
import vending.models.VendingMachine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VendingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        VendingMachine office = new VendingMachine("Office");
        office.addItem(new Item("Skittles", 3.50, ItemType.CANDY));
        office.addItem(new Item("Diet Pepsi", 2.25, ItemType.DRINK));
        office.addItem(new Item("Headphones", 16.50, ItemType.ELECTRONIC));

        VendingMachine gym = new VendingMachine("Gym");
        gym.addItem(new Item("Powerade", 3.00, ItemType.DRINK));
        gym.addItem(new Item("Protein Bar", 4.25, ItemType.SNACK));
        gym.addItem(new Item("Water Bottle", 1.25, ItemType.DRINK));

        while (true) {
            VendingMachine current;
            System.out.print("\nChoose a machine: Office, Gym, Exit\n");
            String input = scanner.next().toLowerCase();
            if (input.equals("exit") || input.equals("done")) {
                break;
            } else if (input.equals("gym")) {
                current = gym;
            } else if (input.equals("office")) {
                current = office;
            } else {
                System.out.print("Invalid input entered");
                continue;
            }

            try {
                current.displayInventory();
                System.out.print("Insert money: $");
                double money = scanner.nextDouble();
                current.insertMoney(money);
                System.out.print("Select Item Number: ");
                int index = scanner.nextInt();
                current.selectItem(index);
            } catch(InputMismatchException e) {
                System.out.print("Please enter numbers only.");
                scanner.next();
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
        }

        office.displayInventory();
        gym.displayInventory();
        System.out.print("Total sales made: " + VendingMachine.getGlobalSales());
    }
}
