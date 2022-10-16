package weapon;

public class Knife extends Weapon{
    String typeofknife;
    public Knife(String name,String type,double weight,double cost,double damage,String typeofknife){
        super(name,type,weight,cost,damage);
        this.typeofknife=typeofknife;
    }
}
