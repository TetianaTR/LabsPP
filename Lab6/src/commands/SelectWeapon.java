package commands;

import data.EquipList;
import data.KnightInfo;
import data.WeaponList;
import equipment.Equipment;
import weapon.Weapon;

import java.util.ArrayList;
import java.util.Scanner;

public class SelectWeapon implements Interface {
    private KnightInfo knights;
    WeaponList allWeapon;
    private ArrayList<WeaponList> knightsWeapon;
    @Override
    public ResultOfCommand<String> execute()   {
        Scanner scanner=new Scanner(System.in);
        int choice=knights.chooseKnight();
        checksize(choice);
        if(knightsWeapon.get(choice).getsize()!=0){
            System.out.println("You already chose weapon for this knight.Pick another knight");
            ResultOfCommand<String> result = new ResultOfCommand<String>("Failed","Knight already has equipment",false);
            return result;
        }
        allWeapon.printList();
        System.out.print("Which weapon you want to add - ");
        int weapon=scanner.nextInt();
        int countOfWeapon=0;
        double money=knights.getknight(choice).getAmountOfMoney();
        double allcost=0;
        while(weapon<allWeapon.getsize() && money>0){
            if(!isExist(allWeapon.getelem(weapon), knightsWeapon.get(choice))){
                money-=allWeapon.getelem(weapon).getCost();
                if(money<=0)  break;
                knightsWeapon.get(choice).addKnightWeapon(allWeapon.getelem(weapon),countOfWeapon);
                countOfWeapon+=1;
                allcost+=allWeapon.getelem(weapon).getCost();
                System.out.println("Amount of money left - "+money);
            }
            System.out.print("Which equipment you want to add - ");
            weapon=scanner.nextInt();
        }
        knights.cutMoney(choice,allcost);
        System.out.println("Your knight:");
        System.out.println(knights.getknight(choice).toString(choice));
        System.out.println("Your knight's weapon,sorted by weight:");
        knightsWeapon.get(choice).sortWeapon();
        System.out.println("Select weapon works");
        ResultOfCommand<String> result = new ResultOfCommand<String>("Succeeded","Action possible",true);
        return result;
    }
    public boolean isExist(Weapon element, WeaponList arrayList){
        for(int i=0;i< arrayList.getsize();i++){
            if(element.getType().equalsIgnoreCase(arrayList.getelem(i).getType())){
                System.out.println("You already choose armor of this type,try again");
                return true;}
        }
        return false;
    }
    public void checksize(int i){
        if(knightsWeapon.size()<=i){
            for(int k=knightsWeapon.size();k<=i;k++){
                knightsWeapon.add(k,new WeaponList());
            }
        }
    }
    public  SelectWeapon(KnightInfo knightInfo,WeaponList allWeapon,ArrayList<WeaponList> weapons){
        this.knights=knightInfo;
        this.knightsWeapon=weapons;
        this.allWeapon=allWeapon;
    }
}

