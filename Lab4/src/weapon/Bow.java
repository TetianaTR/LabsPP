package weapon;

public class Bow extends Weapon{
    int amOfArrows;
    String typeOfBowstring;
    public Bow(String name,String type,double weight,double cost,double damage,int amofarrows,String typeofbowstring){
        super(name,type,weight,cost,damage);
        this.amOfArrows = amofarrows;
        this.typeOfBowstring = typeofbowstring;
    }
}

