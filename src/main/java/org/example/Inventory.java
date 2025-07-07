package org.example;

import java.util.*;
import java.util.function.BiConsumer;

public class Inventory {
    HashMap<String, Integer> map;

    public Inventory(HashMap<String, Integer> map){
        this.map = map;
    }

    public String addProduct(String productName,  int productQuantity){
        boolean hasProductName = map.containsKey(productName);
        if (hasProductName){
            return "Product already exists!";
        }else {
            if (productQuantity >= 0) {
                map.put(productName, productQuantity);
                return "\nProduct Added!";
            } else {
                return "Product quantity must not be negative.";
            }
        }


    }

    public String checkProduct(String productNameToCheck){
         boolean hasProductName = map.containsKey(productNameToCheck);
         if(hasProductName){
             int productStock = map.get(productNameToCheck);
             if(productStock > 1){
                 return productNameToCheck + " is in stock: " + map.get(productNameToCheck);
             }else {
                 return productNameToCheck + " is out of stock!";
             }
         }else{
             return productNameToCheck + " does not exist";
            }



    }

    public String updateProduct(String productNameToUpdate, int productQuantityToUpdate){
        boolean hasProductName = map.containsKey(productNameToUpdate);
        if (productQuantityToUpdate < 0){
            return "Product Quantity must be at least 0";
        }else{
            if(hasProductName){
                map.replace(productNameToUpdate, productQuantityToUpdate);
                return "Stock updated!";
            }else{
                return "Product does not exist.";
            }
        }

    }

//    public String removeProduct(){
//
//    }

    public void viewInventory(){
        if (map.isEmpty()){
            System.out.println("Inventory is empty.");
        }else{
           System.out.println("Current Inventory:\n");
            BiConsumer<String, Integer> printCurrentInventory = (productName, productQuantity) -> System.out.println(productName + " - " + productQuantity + " pcs");
            map.forEach(printCurrentInventory);
        }

    }

}
