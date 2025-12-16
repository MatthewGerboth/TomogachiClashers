import java.util.Scanner;

/**
 * Represents a skeleton character with various attributes and actions.
 */
public class skelleton {
    // Instance variables
    private String name;
    private int health;
    private int damage;
    private int happiness;
    private boolean evolve;
    private int level;
    private int cards;
    private int maxHealth;
    private int evolveShard;

    /**
     * Constructs a skeleton with the specified name and initializes its attributes.
     * 
     * @param name The name of the skeleton.
     */
    public skelleton(String name) {
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
     * Restores health and increases happiness when the skeleton eats.
     */
    public void eat() {
        if (health < (maxHealth - 20)) {
            health += 20;
        }
        happiness += 15;
    }

    /**
     * Levels up the skeleton if enough cards are available.
     * Increases level, max health, and damage.
     */
    public void levelup() {
        if (cards > 25) {
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
     * Evolves the skeleton if it has enough evolve shards and is not already evolved.
     * Increases damage, health, and max health.
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
     * Displays the current stats of the skeleton and provides options for actions.
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
                System.out.println("=== " + name + " Stats ===");
                System.out.println("Health: " + health + "/" + maxHealth);
                System.out.println("Happiness: " + happiness);
                System.out.println("Level: " + level);
                System.out.println("Cards: " + cards);
                System.out.println("Damage: " + damage);
                System.out.println("Evolved: " + (evolve ? "Yes" : "No"));
                System.out.println("===========================");
                break;
            case 2:
                eat();
                System.out.println("You ate and restored health and happiness!");
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
     * Performs an attack on a tower, reducing its health and earning cards.
     * 
     * @param towerHealth The health of the tower being attacked.
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
     * Attempts to earn an evolve shard with a 1/3 chance.
     */
    public void getEvolveShard() {
        double chance = Math.random();
        if (chance <= 0.333) {
            System.out.println("Congratulations! You received an evolve shard!");
            evolveShard += 1;
        } else {
            System.out.println("No evolve shard this time. Better luck next time!");
        }
    }
}
