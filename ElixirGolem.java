public class ElixirGolem {
    private String name;
    private int health;
    private int damage;
    private int happiness;
    private Boolean evolve;
    private int level;
    private int cards;
    private int split;
    private int maxHealth;

    public ElixirGolem(String name){
        this.name = name;
        health = 100;
        damage = 100;
        happiness = 100;
        level = 1;
        evolve = false;
        split = 0;
        cards = 0;
    }
    public void split(){
        if (health <=0 && split == 0){
            health = health/2;
            damage = damage/2;
            split = 1;
        }
        if (health <=0 && split == 1){
            health = health/4;
            split = 2;
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
