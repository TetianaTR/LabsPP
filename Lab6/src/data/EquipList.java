package data;

import equipment.Equipment;
import knight.Knight;

import java.util.Comparator;

import java.util.ArrayList;

public class EquipList {
    private ArrayList<Equipment> allequipment = new ArrayList<>();
    //Knight knight;
    //public void setKnight(Knight knight) {
      //  this.knight = knight;
   // }

    public void  ArrayOfAll() {
        // Scanner scan = new Scanner(System.in);
        //System.out.print("Enter amount of knights you want to add:");
        //int am=scan.nextInt();
        //for(int i=1;i<=am;i++){
        //    allequipment.add();
        //}
        this.allequipment.add(0, new Equipment("Steel Helmet", "steel", 116.45, 7.8, 6, "Helmet"));
        this.allequipment.add(1, new Equipment("Steel armor", "steel", 35, 34.8, 8, "Chest"));
        this.allequipment.add(2, new Equipment("Steel Boots", "steel", 24.56, 21.4, 3, "Boots"));
        this.allequipment.add(3, new Equipment("Wood Shield", "wood", 16, 12.8, 6, "Shield"));
        this.allequipment.add(4, new Equipment("Leather Boots", "leather", 16, 12.8, 4, "Boots"));
        this.allequipment.add(5, new Equipment("Leather helmet", "wood", 16, 12.8, 6, "Helmet"));
        this.allequipment.add(6, new Equipment("Wolfram Shield", "wolfram", 16, 12.8, 6, "Shield"));
        this.allequipment.add(7, new Equipment("Leather Boots", "leather", 16, 12.8, 6, "Boots"));
//зробити сортуувалку по типах
    }
    public void addKnightEquip(Equipment element, int index){
        this.allequipment.add(index,element);
    }
    public void addEquipment(){
        this.allequipment.add(this.allequipment.size(), new Equipment());
    }
    public void remove(int i){
        this.allequipment.remove(i);
    }
    public Equipment getelem(int i){
        return this.allequipment.get(i);
    }
    public int getsize(){
        return allequipment.size();
    }
    public void sortEquip(){
        allequipment.sort(Comparator.comparingDouble(Equipment::getWeight));
        printList();
    }
    public void removeelem(int i){
        this.allequipment.remove(i);
    }
    public void printList(){
        //sortEquip();
        for(int i=0;i<allequipment.size();i++)
            System.out.println(allequipment.get(i).toString(i));
    }
    }