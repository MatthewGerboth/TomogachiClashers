import java.util.Scanner;

/**
 * The RoyalGhost class represents a virtual pet character with attributes such as health, damage, level, and evolution status.
 * The class provides methods to perform actions like eating, leveling up, evolving, attacking, and displaying stats.
 */
public class RoyalGhost implements Card {
    private String name; // The name of the Royal Ghost
    private int health; // The current health of the Royal Ghost
    private int damage; // The damage dealt by the Royal Ghost
    private boolean evolve; // Whether the Royal Ghost has evolved
    private int happiness; // The happiness level of the Royal Ghost
    private int level; // The current level of the Royal Ghost
    private int maxHealth; // The maximum health of the Royal Ghost
    private int cards; // The number of cards collected for leveling up
    private int evolveShard; // The number of evolve shards collected for evolution

    /**
     * Constructor to initialize the RoyalGhost with a name and default attributes.
     * 
     * @param name The name of the Royal Ghost.
     */
    public RoyalGhost(String name) {
        this.name = name;
        health = 100;
        damage = 100;
        happiness = 100;
        level = 1;
        evolve = false;
        cards = 0;
        maxHealth = 200;
        evolveShard = 0;
    }

    /**
     * Restores health and increases happiness when the Royal Ghost eats.
     * Health cannot exceed maxHealth.
     */
    public void eat() {
        if (health < (maxHealth - 20)) {
            health += 20;
        }
        happiness += 15;
        System.out.println(name + " ate and restored health and happiness!");
    }

    /**
     * Levels up the Royal Ghost if enough cards are collected.
     * Increases level, maxHealth, and damage.
     */
    public void levelup() {
        if (cards >= 25) {
            level++;
            cards -= 25;
            maxHealth += 100;
            damage += 100;
            System.out.println(name + " has leveled up to level " + level + "! Damage and max health increased.");
        } else {
            System.out.println("Not enough cards to level up!");
        }
    }

    /**
     * Evolves the Royal Ghost if enough evolve shards are collected.
     * Increases damage, health, and maxHealth significantly.
     */
    public void evolve() {
        if (!evolve && evolveShard >= 6) {
            evolve = true;
            damage = (int) (damage * 1.5);
            health = (int) (health * 1.5);
            maxHealth = (int) (maxHealth * 1.5);
            System.out.println(name + " has evolved! Damage, health, and max health increased.");
        } else {
            System.out.println("Not enough evolve shards to evolve!");
        }
    }

    /**
     * Displays the current stats of the Royal Ghost, including health, happiness, level, cards, damage, and evolution status.
     */
    public void displayStats() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== " + name + " Stats ===");
        System.out.println("Health: " + health + "/" + maxHealth);
        System.out.println("Happiness: " + happiness);
        System.out.println("Level: " + level);
        System.out.println("Cards: " + cards);
        System.out.println("Damage: " + damage);
        System.out.println("Evolved: " + (evolve ? "Yes" : "No"));
        System.out.println("===========================");
        System.out.println("Choose an action:");
        System.out.println("1. Display Stats");
        System.out.println("2. Eat");
        System.out.println("3. Level Up");
        System.out.println("4. Evolve");
        System.out.println("5. Attack");
        System.out.println("===========================");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Displaying stats again...");
                displayStats();
                break;
            case 2:
                eat();
                break;
            case 3:
                levelup();
                break;
            case 4:
                evolve();
                break;
            case 5:
                attack(10); // Placeholder for tower health
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    /**
     * Performs an attack on a tower, dealing damage and reducing the Royal Ghost's health.
     * Also earns random cards for the Royal Ghost.
     * 
     * @param towerHealth The current health of the tower being attacked.
     */
    public void attack(int towerHealth) {
        System.out.println(name + " attacks the tower!");
        System.out.println("It dealt " + damage + " damage.");
        health -= 35;
        if (health < 0) {
            health = 0;
        }
        System.out.println(name + " lost 35 health. It is now at " + health + " health.");

        int cardsEarned = (int) (Math.random() * 11) + 5; // Random cards between 5 and 15
        cards += cardsEarned;
        System.out.println(name + " earned " + cardsEarned + " cards. Total cards: " + cards);
    }

    /**
     * Attempts to collect an evolve shard with a 1/3 chance of success.
     * Increases the evolveShard count if successful.
     */
    public void getEvolveShard() {
        double chance = Math.random(); // Generate a random number between 0.0 and 1.0
        if (chance <= 0.333) { // 1/3 chance
            System.out.println("Congratulations! You received an evolve shard!");
            evolveShard += 1;
        } else {
            System.out.println("No evolve shard this time. Better luck next time!");
        }
    }
}
