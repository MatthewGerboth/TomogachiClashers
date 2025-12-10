public class skelleton{
    //Instance variables 
        private int level;
        private int damage;
        private int foodPreference;
        private boolean evo;
        private int health;
        private int happiness;
    
       
    
       // Default constructor
        public Skelleton() {
            this.level = 1;
            this.health = 100;
            this.damage = 50;
            this.evo = true;
            this.foodPreference = "Milk";
    
        }
    
        // Constructor with name parameter
        public Skelleton(String name) {
            this.level = 1;
            this.health = 100;
            this.damage = 50;
            this.evo = true;
            this.foodPreference = "Milk";
        }
    //Method to simulate a fight
        public void fight() {
            int damageDealt = 50;
            int damageTaken = 30;
            health -= damageTaken;
        }
    //Method to eat and restore health
        public void eat() {
            this.health += 40;
            if (this.health > 100) {
                this.health = 100; // Cap health at 100
            }
        }
    //Method to get food preference
        public String getFoodPreference() {
            return foodPreference;
        }
    // Method to level up
        public void levelUp() {
            this.level++;
            this.health += 100;
            this.damage += 100;
            this.happiness += 15; // Increase happiness by 15
        }
    }
    