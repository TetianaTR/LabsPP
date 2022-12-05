package data;

import database.Insert;
import database.Update;
import equipment.Equipment;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;

import java.util.ArrayList;
import java.util.Scanner;

public class EquipList {

    private ArrayList<Equipment> allequipment = new ArrayList<>();
    public ArrayList<Equipment> getAllequipment() {
        return allequipment;
    }
    public void updateEquipment(Scanner scanner, int i){
        System.out.print("Enter the new cost of the equipment: ");
        double cost=scanner.nextDouble();
        this.allequipment.get(i).setCost(cost);
        Update update=new Update();
        update.updateEquipment(i,cost);
    }
    public void updateEquipmentInterface(int i,double cost){
        this.allequipment.get(i).setCost(cost);
        Update update=new Update();
        update.updateEquipment(i,cost);
    }
    public void enterAllEquipment() throws IOException {
        FileWriter writer = new FileWriter("C:\\Users\\38098\\lr7\\src\\main\\resources\\Equipment.txt");
        for(int k=0;k<allequipment.size();k++) {
            writer.write(allequipment.get(k).getName() + "\n" + allequipment.get(k).getMaterial() + "\n" + allequipment.get(k).getCost() + "\n"+
                    allequipment.get(k).getWeight() + "\n"+allequipment.get(k).getStrength() + "\n"+allequipment.get(k).getTypeofarmour() + "\n");
        }
        writer.close();
    }
    public boolean checkForCopy(String name,String material,double cost,double weight,double strength,String type){
        for(int i=0;i<this.allequipment.size();i++) {
            if (name.equalsIgnoreCase(this.allequipment.get(i).getName()) && material.equalsIgnoreCase(this.allequipment.get(i).getMaterial()) && cost==this.allequipment.get(i).getCost()
            && weight==this.allequipment.get(i).getWeight() && strength==this.allequipment.get(i).getStrength() && type.equalsIgnoreCase(this.allequipment.get(i).getTypeofarmour())) {
                //System.out.println("Log in succeeded");
                return true;
            }
        }
        return false;
    }
    public boolean checkNameDublication(String name) {
        for (int i = 0; i < this.allequipment.size(); i++) {
            if (name.equalsIgnoreCase(this.allequipment.get(i).getName())) {
                //System.out.println("Log in succeeded");
                return true;
            }
        }
        return false;
    }
    public void addKnightEquip(Equipment element, int index){
        this.allequipment.add(index,element);
    }
    public  void addKnightEquipInterface(Equipment element){
        this.allequipment.add(element);
    }
    public void insertEquipment(Equipment equipment){
        this.allequipment.add(this.allequipment.size(), equipment);
    }//запис з бд
    public void addEquipFromInterface(String name,String material,double cost,double weight,double strength,String type){
        this.allequipment.add(this.allequipment.size(), new Equipment(name,material,cost,weight,strength,type));
        Insert insert = new Insert();
        insert.insertEquipment(name,material,cost,weight,strength,type);
    }
    public void  addNewEquipment(){
        this.allequipment.add(this.allequipment.size(), new Equipment());
    }//створення нового і занесення в бд( в конструкторі еквіпа)
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