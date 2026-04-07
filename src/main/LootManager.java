package main;

import java.util.ArrayList;
import java.io.FileNotFoundException;

/**
 * Manages the inventory of RPG Loot.
 */
public class LootManager {
    private ArrayList<Loot> inventory;

    private LootManager() {
        this.inventory = new ArrayList<>();
    }

    /**
     * Polymorphically displays all items in the inventory.
     */
    public void displayInventory() {
        System.out.println();
        System.out.println("--- Current Inventory ---");
        for (Loot item : inventory) {
            System.out.println(item.getName() + " [" + item.getRarity() + "] - " +
                    item.getEffectDescription());
        }
        System.out.println("-------------------------");
        System.out.println();
    }

    public static LootManager load(String startFilePath) {
        return null;

    }

    public void save(String endFilePath) {
    }
}
