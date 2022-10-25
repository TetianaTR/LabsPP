package commands;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    public void printequip(){
        System.out.println("Select the action:\nSelect equipment for knight - 1" +
        "            \nAdd new equipment - 2\nDelete equipment - 3\nUpdate equipment - 4\nLog out - 5\nBuild report - 6\nEnd process - 0");
    }

    public void Menu() throws Exception {
        Map<Integer,Interface> commands = new HashMap<>();
        commands.put(1,new Info());
        commands.put(2,new Registration());
        commands.put(3,new LogIn());
        System.out.println("Welcome to menu.\nEnter what do you want to do?\nInfo - 1\nRegistration - 2\nLog in - 3\nExit - 0");
        Scanner scan = new Scanner(System.in);
        int numOfCommand = scan.nextInt();
        while(numOfCommand != 0)
        {
            commands.get(numOfCommand).execute();
            if(numOfCommand!=1 && commands.get(numOfCommand).execute().isSuccessful()){
                menuOfEquipment();
            }
            System.out.println("Welcome to menu.\nEnter what do you want to do?\nInfo - 1\nRegistration - 2\nLog in - 3\nExit - 0");
            numOfCommand = scan.nextInt();
        }
    }

    public void menuOfEquipment() throws Exception
    {
        printequip();
        Map<Integer,Interface> equipment=new HashMap<>();
        equipment.put(1,new SelectEquipment());
        equipment.put(2, new AddEquipment());
        equipment.put(3,new DeleteEquipment());
        equipment.put(4,new UpdateEquipment());
        equipment.put(5,new LogOut());
        equipment.put(6,new BuildReport());
        equipment.put(7,new CalculateData());
        Scanner scan = new Scanner(System.in);
        int numberOfAction = scan.nextInt();
        while(numberOfAction != 0){
            equipment.get(numberOfAction).execute();
            printequip();
            numberOfAction = scan.nextInt();
        }
    }
}
