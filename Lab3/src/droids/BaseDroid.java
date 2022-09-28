package  droids;
public class BaseDroid {
    protected String name;
    protected int damage;
    protected int attackTime;
    protected int health;
    public BaseDroid(String name, int damage, int attackTime, int health)
    {
        this.name = name;
        this.damage = damage;
        this.attackTime = attackTime;
        this.health = health;
    }
    public BaseDroid(){

    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getDamage() { return damage; }
    public void setDamage(int damage) { this.damage = damage; }

    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = health; }

    public int getAttackTime() { return attackTime; }
    public void setAttackTime(int attackTime) { this.attackTime = attackTime; }
}
