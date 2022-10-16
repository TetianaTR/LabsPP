package weapon;

public class Sword extends Weapon{
    String typeofblade;
    public Sword(String name,String type,double weight,double cost,double damage,String typeofblade){
        super(name,type,weight,cost,damage);
        this.typeofblade=typeofblade;
    }
}
