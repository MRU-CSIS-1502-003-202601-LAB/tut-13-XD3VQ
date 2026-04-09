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
        LootManager manager = new LootManager();

        try {
            java.io.File file = new java.io.File(startFilePath);
            java.util.Scanner scanner = new java.util.Scanner(file);

            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                if (line.isEmpty())
                    continue;

                String[] fields = line.split(",");
                Loot item = LootFactory.create(fields);
                manager.add(item);
            }

            scanner.close();

        } catch (java.io.FileNotFoundException e) {
            System.out.println("File not found: " + startFilePath);
        }

        return manager;

    }

    public void add(Loot item) {
        inventory.add(item);
    }

    public void save(String endFilePath) {
        try {
            java.io.PrintWriter writer = new java.io.PrintWriter(endFilePath);
            writer.println("TYPE,NAME,RARITY,SPECIAL_1");
            for (Loot item : inventory) {
                writer.println(item.asCsvRow());
            }
            writer.close();

        } catch (java.io.FileNotFoundException e) {
            System.out.println("Error writing file: " + endFilePath);
        }
    }
}
