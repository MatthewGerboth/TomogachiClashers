public class ElixirGolem {
    private int health;
    private int damage;
    private String foodPreference;
    private Boolean evolve;
    private int level;

    public ElixirGolem(int health, int damage, int level, String foodPreference, Boolean evolve){
        this.health = health;
        this.damage = damage;
        this.level = level;
        this.foodPreference = foodPreference;
        this.evolve = false;

    }

}
