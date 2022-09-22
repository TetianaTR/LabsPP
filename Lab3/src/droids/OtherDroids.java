package droids;

import java.util.Scanner;

public class OtherDroids extends BaseDroid {
    public OtherDroids(String name, int damage, int attackTime, int health) {
        super(name, damage, attackTime, health);
    }
    private int type;
    private int healthigh;
    private int amhealing;

    public OtherDroids() {
        super();
    }

    public void setdroid(int type) {
        switch (type) {
            case (1):
                this.healthigh = (int) this.health / 3;
                this.amhealing = (int)this.damage/2;
                System.out.println("You chose Healer-droid");
                break;
            case (2):
                this.damage += (int) this.damage / 2;
                System.out.println("You chose Highdamage droid");
                break;
            case (3):
                this.attackTime -= (int) this.attackTime / 2;
                System.out.println("You chose Highspeed droid");
                break;
            default:
                this.healthigh = 0;
                System.out.println("You chose basic droid");
        }
    }
    public int enterDroid(){
        Scanner scan1= new Scanner(System.in);
        Scanner scan2= new Scanner(System.in);
        System.out.print("Enter the Name of droid: ");
        this.name = scan2.nextLine();
        System.out.print("Enter the damage of droid: ");
        this.damage = scan1.nextInt();
        System.out.print("Enter the interval time of attack: ");
        this.attackTime = scan1.nextInt();
        System.out.print("Enter the health of your droid: ");
        this.health = scan1.nextInt();
        System.out.print("Enter the type of your droid: ");
        int typ = scan1.nextInt();
        return typ;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setHealthigh(int healthigh) {
        this.healthigh = healthigh;
    }

    public int getHealthigh() {
        return healthigh;
    }

    public int getAmhealing() {
        return amhealing;
    }

    public void setAmhealing(int amhealing) {
        this.amhealing = amhealing;
    }
}
