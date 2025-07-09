package org.example;


import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class InventoryTest {
    Scanner s = new Scanner(System.in);
    HashMap<String, Integer> products = new HashMap<>();
    Inventory inventory = new Inventory(products);

    @BeforeEach
    void setUp() {

    }

    @Test
    void addProductWithValidQuantity() {
        // added another product and checked if it has the correct quantity
        String output1 = inventory.addProduct("Banana", 30);
        assertEquals("\nProduct Added!", output1);
        assertEquals(30,products.get("Banana"));
    }

    @Test
    void addProductWithZeroQuantity() {
        // added product with 0 quantity
        String output = inventory.addProduct("Mango",0);
        assertEquals("\nProduct Added!",output);

        // added product that already exists
        String output1 = inventory.addProduct("Mango",0);
        assertEquals("Product already exists!",output1);

        // added product with different quantity
        inventory.addProduct("Milk",10);
        inventory.addProduct("Milk",50);
        assertEquals(50,products.get("Milk"));
    }

    @Test
    void checkProductScenario() {
        // Checks for an existing product
        inventory.addProduct("Milk",20);
        String output2 = inventory.checkProduct("Milk");
        assertEquals("Milk is in stock: 20",output2);

        // Checks for a non-existing product
        String output3 = inventory.checkProduct("Ice Cream");
        assertEquals("Ice Cream does not exist",output3);
    }

    @Test
    void updateStockScenarios() {
        // update an existing product with valid quantity
        inventory.addProduct("Bread", 50);
        String output1 = inventory.updateProduct("Bread", 25);
        assertEquals("Stock updated!", output1);
        assertEquals(25, products.get("Bread"));

        // update a non-existing product
        String output2 = inventory.updateProduct("Tofu",20);
        assertEquals("Product does not exist.", output2);


    }
    @Test
    void removeProductScenarios() {
        // remove an existing product
        inventory.addProduct("Egg", 50);
        String output = inventory.removeProduct("Egg");
        assertEquals("Product removed.", output);
        assertNull(products.get("Egg"));

        // remove a non-existing product
        String output1 = inventory.removeProduct("Bread");
        assertEquals("Product does not exist", output1);
    }
}