package data;

import database.Insert;
import database.Update;
import weapon.*;

import java.util.*;

public class WeaponList {
    private ArrayList<Weapon> allweapon=new ArrayList<>();
    private Insert insert=new Insert();
    public void addSword(String name,double weight,double cost,double damage,String typeofblade){
        this.allweapon.add(this.allweapon.size(),new Sword(name,"Sword",weight,cost,damage,typeofblade));
        this.insert=new Insert();
        insert.insertSword(name,"Sword",weight,cost,damage,typeofblade);
    }
    public void addAxe(String name,double weight,double cost,double damage,String bladeshape){
        this.allweapon.add(this.allweapon.size(),new Axe(name,"Axe",weight,cost,damage,bladeshape));
        this.insert=new Insert();
        insert.insertAxe(name,"Axe",weight,cost,damage,bladeshape);
    }
    public void addBow(String name,double weight,double cost,double damage,int amofarrows,String typeofbowstring) {
        this.allweapon.add(this.allweapon.size(), new Bow(name, "Bow", weight, cost, damage, amofarrows,typeofbowstring));
        this.insert = new Insert();
        insert.insertBow(name, "Bow", weight, cost, damage, amofarrows,typeofbowstring);
    }
    public void addLance(String name,double weight,double cost,double damage,int length){
        this.allweapon.add(this.allweapon.size(), new Lance(name, "Lance", weight, cost, damage,length));
        this.insert = new Insert();
        insert.insertLance(name, "Lance", weight, cost, damage, length);
    }
    public void addKnife(String name,double weight,double cost,double damage,String typeofknife) {
        this.allweapon.add(this.allweapon.size(), new Knife(name, "Knife", weight, cost, damage, typeofknife));
        this.insert = new Insert();
        insert.insertKnife(name, "Knife", weight, cost, damage, typeofknife);
    }
    public void insertWeaponFromDB(Weapon weapon){
        this.allweapon.add(this.allweapon.size(), weapon);
    }
    public void updateWeapon(Scanner scanner,int i){
        System.out.print("Enter the new cost of the weapon: ");
        double cost=scanner.nextDouble();
        this.allweapon.get(i).setCost(cost);
        Update update=new Update();
        update.updateWeapon(this.allweapon.get(i).getName(),this.allweapon.get(i).getType(),cost);
    }
    public void updateWeaponInterface(int i,double cost){
        this.allweapon.get(i).setCost(cost);
        Update update=new Update();
        update.updateWeapon(this.allweapon.get(i).getName(),this.allweapon.get(i).getType(),cost);
    }
    public void addKnightWeapon(Weapon element, int index){
        this.allweapon.add(index,element);
    }
    public void addKnightWeaponInterface(Weapon element){ this.allweapon.add(element);}
    public void removeelem(int i){
        this.allweapon.remove(i);
    }
    public boolean checkName(String name){
        for(int i=0;i<this.allweapon.size();i++){
            if(this.allweapon.get(i).getName().equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }
    public void addWeapon(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Which type of weapon you want to add:" +
                "\nAxe - 1\nBow - 2\nKnife - 3\nLance - 4\nSword - 5");
        int choice=scanner.nextInt();
        switch (choice) {
            case 1:
                this.allweapon.add(this.allweapon.size(), new Axe());
                break;
            case 2:
                this.allweapon.add(this.allweapon.size(), new Bow());
                break;
            case 3:
                this.allweapon.add(this.allweapon.size(), new Knife());
                break;
            case 4:
                this.allweapon.add(this.allweapon.size(), new Lance());
                break;
            case 5:
                this.allweapon.add(this.allweapon.size(), new Sword());
                break;
            default:
                this.allweapon.add(this.allweapon.size(), new Weapon());
                break;
        }
    }
    public Weapon getelem(int i){
        return this.allweapon.get(i);
    }
    public void printList(){
        for(int i=0;i<this.allweapon.size();i++){
            System.out.println(this.allweapon.get(i).toString(i));
        }
    }
    public int getsize(){
        return this.allweapon.size();
    }
    //    public void removeWeapon(int i){
//        this.allweapon.remove(i);
//    }
    public void sortWeapon(){
        this.allweapon.sort(Comparator.comparingDouble(Weapon::getWeight));
    }
}
