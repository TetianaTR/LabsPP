package weapon;

public class Axe extends Weapon{
    String bladeshape;
    public Axe(String name,String type,double weight,double cost,double damage,String bladeshape){
        super(name, type, weight, cost, damage);
        this.bladeshape=bladeshape;
    }
}
