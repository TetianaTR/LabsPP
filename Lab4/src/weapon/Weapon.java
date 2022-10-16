package weapon;

public class Weapon {
    String name;
    String type;
    double weight;
    double cost;
    double damage;
    Weapon(String name,String type,double weight,double cost,double damage){
        this.name=name;
        this.type=type;
        this.weight=weight;
        this.cost=cost;
        this.damage=damage;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public double getDamage() {
        return damage;
    }
    public void setDamage(double damage) {
        this.damage = damage;
    }
}
