package Main;
import Battles.Battle;
import  java.util.Scanner;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Battle fight=new Battle();
        System.out.print("Enter what type of battle you want ( 1- one to one fight,any other number - team battle ): ");
        int numb= scanner.nextInt();
        if(numb==1)
            fight.StartOneToOne();
        else
            fight.StartTeamFight();

    }
}