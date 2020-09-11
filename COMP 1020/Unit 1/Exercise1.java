package com.comp1020;

/*Exercise1.java

COMP 1020  SECTION D01
INSTRUCTOR: Robert Guderian
NAME: Gracia Sengutuvan
Assignment: Exercise 1
Class:
   Java program that stores and monitors the inventory for a hardware store.
   Items are sold to customers and re-ordered from a supplier when stock gets low.

   Item class is made to create the objects of items.
   We create the array on objects in the main and call sell,order and check inventory methods
   to sell and main the inventory of the items.
   
 */


public class Exercise1{
        public static void main(String[] args) {
            //an array of objects
            Item[] inventory = new Item[4];

            inventory[0] = new Item("machine bolt", 50, "M50-H", 120);
            inventory[1] = new Item("phillips screw", 25, "P25-16", 750);
            inventory[2] = new Item("lock washer", 12, "W12-L", 400);
            inventory[3] = new Item("drywall screw", 38, "P38-DW", 2400);

            //method to print the items in the inventory
            printInventory(inventory);
            System.out.println("\n");

            //selling the items
            sell(inventory[0], 90);
            sell(inventory[1], 750);
            sell(inventory[2], 600);
            sell(inventory[3], 2500);

            printInventory(inventory);
            System.out.println("\n");

            //ordering the items
            order(inventory[0], 90);
            order(inventory[1], 1);
            order(inventory[2], 220);
            order(inventory[3], 50);
            order(inventory[3], -50);

            printInventory(inventory);
            System.out.println("\n");

            //Checking the inventory to see what items need topping up
            System.out.println("Checking inventory");
            checkInventory(inventory);

            printInventory(inventory);

            System.out.println("\nEnd of processing.");
        }


        public static void sell(Item item, int amount) {
            int inStock;

            inStock = item.sell(amount);

            System.out.print("Selling " + amount + " of item: ");
            if (inStock == amount) {
                System.out.println("all are in stock.");
            } else {
                System.out.println(inStock + " in stock, " + (amount - inStock) + " on backorder.");
            }
        }

        public static void order(Item item, int amount) {
            String reorder;

            reorder = item.order(amount);

            if (reorder == null) {
                System.out.println("Unable to order item: invalid amount " + amount);
            } else {
                System.out.println(reorder);
            }
        }

        public static void checkInventory(Item[] inventory){
            for(int i=0;i<inventory.length;i++) {
                if(inventory[i].mustReorder())
                    inventory[i].order(200);
            }
        }

        public static void printInventory(Item[] inventory) {
            System.out.println("Inventory:");
            for (int i = 0; i < inventory.length; i++) {
                System.out.println(inventory[i]);
            }
        }
    }

    class Item {
        private String name;
        private int size;
        private String code;
        private int quantity;
        private int reorderQuantity;

        public Item(String name, int size, String code, int quantity) {
            this.name = name;
            this.size = size;
            this.code = code;
            this.quantity = quantity;
            reorderQuantity= quantity/4;
        }

        public String order(int amount) {
            String result = null;

            if (amount > 0) {
                result = "Re-order item: " + code + "\nAmount ordered: " + amount;
                quantity += amount;
            }

            return result;
        }

        public int sell(int amount) {
            int result = amount;

            if (amount < 0) {
                result = 0;
            } else {
                if (amount > quantity) {
                    result = quantity;
                }
                quantity -= amount;
            }

            return result;
        }

        public boolean mustReorder(){
            if (quantity<reorderQuantity)
                return true;
            else
                return false;

        }

        public String toString() {
            String result;

            result = "Item " + name + "' size=" + size + "mm code='" + code+ "' reorder Quantity=" + reorderQuantity;
            if (quantity >= 0) {
                result += " quantity=" + quantity;
            } else {
                result += " quantity=0 (" + -quantity + " backordered)";
            }

            return result;
        }
    }



