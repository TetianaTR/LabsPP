package commands;

import data.EquipList;
import data.KnightInfo;
import data.Loginlist;
import data.WeaponList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    public void printequip(){
        System.out.print("Select the action:\nSelect equipment for knight - 1" +
        "            \nAdd new equipment - 2\nDelete equipment - 3\nSelect Weapon - 4\nLog out - 5\nUpdate equipment - 6\nBuild report - 7\nYour choice - ");
    }

    public void Menu() throws Exception {
        Loginlist usersdata = new Loginlist();
        usersdata.loginList();
        KnightInfo listknights=new KnightInfo();
        listknights.setKnights();
        EquipList allequip = new EquipList();
        allequip.ArrayOfAll();
        WeaponList allWeapon = new WeaponList();
        allWeapon.setAllweapon();
        Map<Integer,Interface> commands = new HashMap<>();
        commands.put(1,new Info());
        commands.put(2,new Registration(usersdata));
        commands.put(3,new LogIn(usersdata));
        System.out.print("Welcome to menu.\nEnter what do you want to do?\nInfo - 1\nRegistration - 2\nLog in - 3\nExit - 0\nYour choice - ");
        Scanner scan = new Scanner(System.in);
        int numOfCommand = scan.nextInt();
        while(numOfCommand != 0)
        {
            ResultOfCommand<String> result= commands.get(numOfCommand).execute();
            if(numOfCommand==3 && result.isSuccessful()){
                menuOfEquipment(listknights,allequip,allWeapon);
            }
            System.out.println("Welcome to menu.\nEnter what do you want to do?\nInfo - 1\nRegistration - 2\nLog in - 3\nExit - 0\nYour choice - ");
            numOfCommand = scan.nextInt();
        }
        usersdata.printlist();
        usersdata.enterall();
    }

    public void menuOfEquipment(KnightInfo listknights,EquipList allequip,WeaponList allWeapon) throws Exception
    {
        ArrayList<EquipList> knightsEquipment=new ArrayList<>();
        ArrayList<WeaponList> knightsWeapon=new ArrayList<>();
        printequip();
        Map<Integer,Interface> equipment=new HashMap<>();
        equipment.put(1,new SelectEquipment(listknights,allequip,knightsEquipment));
        equipment.put(2, new AddEquipment(allequip,allWeapon));
        equipment.put(3,new DeleteEquipment(listknights,knightsEquipment,knightsWeapon));
        equipment.put(4,new SelectWeapon(listknights,allWeapon,knightsWeapon));
        equipment.put(5,new LogOut());
        equipment.put(6,new UpdateEquipment());
        equipment.put(7,new BuildReport(listknights,knightsEquipment,knightsWeapon));
        Scanner scan = new Scanner(System.in);
        int numberOfAction = scan.nextInt();
        while(numberOfAction != 0){
            equipment.get(numberOfAction).execute();
            if(numberOfAction==5)
                break;
            printequip();
            numberOfAction = scan.nextInt();
        }
    }
}
