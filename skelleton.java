public class skelleton{
    //Instance variables 
        private int level;
        private int damage;
        private boolean evo;
        private int health;
        private int happiness;
    
       
    
       // Default constructor
        public skelleton() {
            this.level = 1;
            this.health = 100;
            this.damage = 50;
            this.evo = true;
        }
    //Method to eat and restore health
        public void eat() {
            this.health += 40;
            if (this.health > 100) {
                this.health = 100; // Cap health at 100
            }
        }
    // Method to level up
        public void levelUp() {
            this.level++;
            this.health += 100;
            this.damage += 100;
            this.happiness += 15; // Increase happiness by 15
        }
    }
