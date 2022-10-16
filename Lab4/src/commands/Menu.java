package commands;

import java.util.Scanner;

public class Menu {
    public void printequip(){
        System.out.println("Select the action:\nSelect equipment for knight - 1" +
        "            \nAdd new equipment - 2\nDelete equipment - 3\nUpdate equipment - 4\nLog out - 5\nBuild report - 6\nEnd process - 0");
    }
    public void Menu() throws Exception {
        System.out.println("Welcome to menu.\nEnter what do you want to do?\nInfo - 1\nRegistration - 2\nLog in - 3\nExit - 0");
        Scanner scan = new Scanner(System.in);
        int numOfCommand = scan.nextInt();
        while(numOfCommand != 0)
        {
            Interface command;
            ResultOfCommand result;
            switch (numOfCommand)
            {
                case 1:
                {
                    command = new Info();
                    result = command.execute();
                    System.out.println(result.Result());
                    break;
                }
                case 2:
                {
                    command = new Registration();
                    result = command.execute();
                    System.out.println(result.Result());
                    printequip();
                    if(result.isSuccessful()){ menuOfEquipment(); }
                    break;
                }
                case 3:
                {
                    command = new Log_in();
                    result = command.execute();
                    System.out.println(result.Result());
                    printequip();
                    if(result.isSuccessful())
                    {
                        menuOfEquipment();
                    }
                    break;
                }
                default:break;
            }
            System.out.println("Welcome to menu.\nEnter what do you want to do?\nInfo - 1\nRegistration - 2\nLog in - 3\nExit - 0");
            numOfCommand = scan.nextInt();
        }
    }

    public void menuOfEquipment() throws Exception
    {
        Scanner scan = new Scanner(System.in);
        int numberOfAction = scan.nextInt();
        while(numberOfAction != 0)
        {
            Interface action;
            ResultOfCommand res;
            switch (numberOfAction)
            {
                case 1:
                    action  = new SelectEquipment();
                    res = action.execute();
                    System.out.println(res.Result());
                    if(res.isSuccessful())
                    {
                        Interface res2 = new CalculateData();
                        ResultOfCommand reslt = res2.execute();
                        System.out.println(reslt.Result());
                    }
                    break;
                case 2:
                    action = new AddEquipment();
                    res = action.execute();
                    System.out.println(res.Result());
                    break;
                case 3:
                    action = new DeleteEquipment();
                    res = action.execute();
                    System.out.println(res.Result());
                    break;
                case 4:
                    action = new UpdateEquipment();
                    res = action.execute();
                    System.out.println(res.Result());
                    break;
                case 5:
                    action = new Log_out();
                    res = action.execute();
                    System.out.println(res.Result());
                    break;
                case 6:
                    action = new BuildReport();
                    res = action.execute();
                    System.out.println(res.Result());
                    break;
                default:break;
            }
            printequip();
            numberOfAction = scan.nextInt();
        }
    }
}
