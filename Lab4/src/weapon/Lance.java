package weapon;

public class Lance extends Weapon{
    int lengthoflance;
    public Lance(String name,String type,double weight,double cost,double damage,int lengthoflance){
        super(name,type,weight,cost,damage);
        this.lengthoflance=lengthoflance;
    }
}
