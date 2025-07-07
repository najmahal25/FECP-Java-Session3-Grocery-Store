package org.example;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        HashMap<String, Integer> products = new HashMap<>();
        Inventory inventory = new Inventory(products);
        boolean stopProgram = false;
        while(!stopProgram) {
        System.out.println("--- Grocery Inventory Menu ---");
        System.out.println("1. View Inventory");
        System.out.println("2. Add Product");
        System.out.println("3. Check Product");
        System.out.println("4. Update Stock");
        System.out.println("5. Remove Product");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
        int choice = s.nextInt();


            switch (choice) {
                case 1:
                    inventory.viewInventory();
                    break;


                case 2:
                    System.out.print("\nEnter product name: ");
                    String productName = s.next();
                    System.out.print("Enter quantity: ");
                    int productQuantity = s.nextInt();

                    System.out.println(inventory.addProduct(productName, productQuantity));
                    break;


                case 3:
                    System.out.print("\nEnter product name to check: ");
                    String productNameToCheck = s.next();

                    System.out.println(inventory.checkProduct(productNameToCheck));
                    break;
                case 4:
                    System.out.print("\nEnter product name to update: ");
                    String productNameToUpdate = s.next();
                    System.out.print("Enter new stock quantity: ");
                    int productQuantityToUpdate = s.nextInt();

                    System.out.println(inventory.updateProduct(productNameToUpdate, productQuantityToUpdate));
                    break;

                case 5:
                    System.out.print("Enter product name to remove: ");
                    String productNameToRemove = s.next();

                    System.out.println(inventory.removeProduct(productNameToRemove));
                    break;
                case 6:
                    stopProgram = true;
                    System.out.println("\nThank you. Please come again!");
                    break;
                default:
                    System.out.println("\nInvalid Choice.");
            }
        }


    }
}