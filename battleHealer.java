import java.util.Scanner;

public class battleHealer implements Card {
    
    //attribute
    private String name;
    private int health;
    private int damage;
    private int happiness;
    private int level;
    private boolean evolve;
    private int cards;
    private int maxHealth;
    private int evoShards;
    private int healLevel;

    /**
     * Constructor for the battleHealer class
     * @param name
     */
    public battleHealer(String name){
        this.name = name;
        health = 100;
        damage = 100;
        happiness = 100;
        level = 1;
        evolve = false;
        cards = 0;
        maxHealth = 200;
        evoShards = 0;
        healLevel = 10;
    }

    /**
     * Method to eat and recover health
     */
    public void eat(){
        if(health <= maxHealth - 20){
            System.out.println(name + " has gotten something to eat. They have regained 20 health.");
            health += 20;
        }
        else{
            System.out.println(name + " has gotten something to eat. " + name + " is now at a full health of 200.");
            health = maxHealth;
        }
        
    }

    /**
     * Method to increase level, health, and damage using cards
     */
    public void levelUp(){
        if(cards >= 25){
            System.out.println("You have enough cards to level up!");
            cards -= 25;
            level += 1;
            maxHealth += 100;
            damage += 100;
            healLevel += 10;
        }
        else{
            System.out.println("You need more cards to level " + name + " up.");
        }
    }

    /**
     * Method to evolve and increase stats by 1.5 times
     */
    public void evolve(){
        if(evoShards >= 6&&!evolve){
            System.out.println("You have enough evo shards to evolve!");
            evolve = true;
            damage *= 1.5;
            health *= 1.5;
            maxHealth *= 1.5;
        }
        else{
            if(evolve){
                System.out.println(name + " is already evolved.");
            }
            else{
                System.out.println("You don't have enough evo shards to evolve.");
            }
        }
    }



    /**
     * Method to heal health
     */
    public void heal(){
        if(health <= maxHealth - healLevel){
            System.out.println(name + " has used heal. They have regained " + healLevel + " health.");
            health += healLevel;
        }
        else{
            System.out.println(name + " has used heal. " + name + " is now at a full health of " + maxHealth + ".");
            health = maxHealth;
        }
    }
     
    /**
     * Method to display stats
     */
    public void displayStats() {
        Scanner scanner = new Scanner(System.in); // Fix 3: Initialize scanner locally
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
        System.out.println("==========================="); // Fix 5: Moved outside the switch block
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
                levelUp();
                break;
            case 4:
                evolve();
                break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            case 5:
                attack(10); // Placeholder for tower health
                }
            }
       
       
   

    /**
     * Method to attack and deal damage
     * Chances to get cards after
     * @param towerHealth
     */
    public void attack(int towerHealth) {
        System.out.println(name + " attacks the tower!");
        System.out.println("It dealt " + damage + " damage.");
        health -= 35;
        if (health < 0) { // Fix 6: Prevent health from going below 0
            health = 0;
        }
        System.out.println(name + " lost 35 health. It is now at " + health + " health.");


        int cardsEarned = (int) (Math.random() * 11) + 5; // Random cards between 5 and 15
        cards += cardsEarned;
        System.out.println(name + " earned " + cardsEarned + " cards. Total cards: " + cards);
    }
    
    /**
     * Method that gives evo shards randomly
     */
    public void getEvolveShard() {
        double chance = Math.random(); // Generate a random number between 0.0 and 1.0
        if (chance <= 0.333) { // 1/3 chance
            System.out.println("Congratulations! You received an evolve shard!");
            evoShards += 1;
            // You can add logic here to track evolve shards if needed
        } else {
            System.out.println("No evolve shard this time. Better luck next time!");
        }
    }


}
