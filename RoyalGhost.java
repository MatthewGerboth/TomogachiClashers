public class RoyalGhost {
    private String name;
    private int health;
    private int damage; 
    private boolean invisible;
    private boolean evolve;
    private int happiness;
    private int level; 
    private int maxHealth;
    private int cards;

    public RoyalGhost(String name) {
        this.name = name;
        this.health = 100;
        this.damage = 100; // Set damage to 100
        this.invisible = false;
        this.evolve = false; // Initialized evo
        this.level = 1; // Initialized level
    }

    public void activateInvisibility() {
        if (!invisible) {
            invisible = true;
            System.out.println(name + " has turned invisible!");
        } else {
            System.out.println(name + " is already invisible.");
        }
    }
    
    public void eat(){
        if (health<(maxHealth - 20)){
        health += 20;
        }
        happiness+=15;
    }
    public void levelup(){
        if (cards > 25){
            level++;
            cards -= 25;
            maxHealth+= 100;
            damage += 100;
        }
    }
    public void evolve(){
        evolve = true;
        damage *= 1.5;
        health *= 1.5;
    }
}


}