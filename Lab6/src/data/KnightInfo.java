package data;
import knight.Knight;

import java.util.ArrayList;
import java.util.Scanner;

public class KnightInfo {
    private ArrayList<Knight> arrayList = new ArrayList<>();
    public KnightInfo(){
       // Scanner scan = new Scanner(System.in);
        //System.out.print("Enter amount of knights you want to add:");
        //int am=scan.nextInt();
        //for(int i=1;i<=am;i++){
        //    arrayList.add(new Knight());
        //}
    }
    public void setKnights(){
        this.arrayList.add(0,new Knight("William",21,16,"France",200.45));
        this.arrayList.add(1,new Knight("Tom",27,14,"Britain",140.5));
        this.arrayList.add(2,new Knight("Charles",19,17,"Italy",194.56));
        this.arrayList.add(3,new Knight("Andrew",26,16,"France",120.34));
    }
    public void cutMoney(int i,double money){
        double am=arrayList.get(i).getAmountOfMoney();
        am=am-money;
        this.arrayList.get(i).setAmountOfMoney(am);
    }
    public void printList(){
        for(int i=0;i<this.arrayList.size();i++)
            System.out.println(this.arrayList.get(i).toString(i));
    }
    public int chooseKnight(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Choose the knight you want to equip from list below:");
        printList();
        System.out.print("Your choice - ");
        int choice= scan.nextInt();
        System.out.println("You chose "+getknight(choice).toString(choice));
        return choice;
    }
    public void addMoney(int i,double money){
        double am=money+this.arrayList.get(i).getAmountOfMoney();
        this.arrayList.get(i).setAmountOfMoney(am);
    }
    public int getsize(){
        return this.arrayList.size();
    }
    public void addKnight(){
        this.arrayList.add(arrayList.size(),new Knight());
    }
    public Knight getknight(int i){
        return this.arrayList.get(i);
    }
    public void setArrayList(ArrayList<Knight> arrayList) {
        this.arrayList = arrayList;
    }

}
