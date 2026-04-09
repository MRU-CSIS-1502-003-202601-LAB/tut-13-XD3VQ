package main;

public class LootFactory {
    // TYPE,NAME,RARITY,SPECIAL_1
    // Weapon,Excalibur,Legendary,50
    public static Loot create(String[] fields) {
        String type = fields[0].trim();
        String name = fields[1].trim();
        String rarity = fields[2].trim();
        int special = Integer.parseInt(fields[3].trim());

        switch (type.toLowerCase()) {
            case "weapon":
                return new Weapon(name, rarity, special);

            case "consumable":
                return new Consumable(name, rarity, special);

            default:
                throw new IllegalArgumentException("Unknown loot type: " + type);

        }

    }
}
