package Battles;
import droids.OtherDroids;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;

public class Battle {
    public void attackDroid(  FileWriter mywriter,OtherDroids dr1,OtherDroids dr2) throws IOException {
        dr2.health -= dr1.damage;
        System.out.println("---------------------\n"+dr1.name + " attacks " + dr2.name+"\n"+ dr2.name + " health - "+dr2.health);
        mywriter.write("\n---------------------\n"+dr1.name + " attacks " + dr2.name+"\n"+ dr2.name + " health - "+dr2.health+"\n---------------------\n");
    }
    public void startTeamFight() throws IOException {// бій команд
        int healthreg1=0,healthreg2=0;
        int amhealing1=0,amhealing2=0;
        String filename2 = "C:\\PP\\TeamFight.txt";
        FileWriter mywrite = new FileWriter(filename2);
        System.out.println("\t\t\t------𝐓𝐄𝐀𝐌 𝐁𝐀𝐓𝐓𝐋𝐄------");
            Scanner scan1= new Scanner(System.in);
           // Scanner scan2= new Scanner(System.in);
        System.out.print("Enter size of first array: ");
        int size1= scan1.nextInt();
        OtherDroids team1[]=new OtherDroids[size1];
        for(int i=0; i<size1; i++){
            team1[i]=new OtherDroids();
            int type = team1[i].enterDroid();
            team1[i].setdroid(type);
            if(type==1) {//якщо один з дроїдів в команді лікар
                healthreg1 = team1[i].getHealthigh();
                amhealing1 = team1[i].getAmhealing();
            }
        }
        System.out.print("Enter size of second array: ");
        int size2= scan1.nextInt();
        OtherDroids team2[]=new OtherDroids[size2];
        for(int j=0; j<size2; j++) {
            team2[j]=new OtherDroids();
            int type2 = team2[j].enterDroid();//занесення даних про дроїда
            team2[j].setdroid(type2);
            if (type2 == 1) {//якщо один з дроїдів в команді лікар
                healthreg2 = team2[j].getHealthigh();
                amhealing2 = team2[j].getAmhealing();
            }
        }
        int timing=0;
        while (size1 > 0 && size2 > 0)
            {
                Random rand= new Random();
                int num1 = rand.nextInt(size1);
                int num2 = rand.nextInt(size2);
                for(int k=0;k<size1;k++) {
                    if (timing % team1[k].attackTime == 0) {
                        attackDroid(mywrite,team1[k],team2[num2]);
                        if(amhealing2>0 && healthreg2>0 && team2[num2].health<15 && team2[num2].health>0){
                            System.out.println("Healer healed this droid, amount of healing left -"+(amhealing2-1)+"\n---------------------\n");
                            mywrite.write( "Healer healed this droid\n---------------------\n");
                            team2[num2].health+=healthreg2;
                            amhealing2-=1;
                            mywrite.write("Healer healed this droid\n---------------------\n");
                        }
                        if (team2[num2].health <= 0) {
                            System.out.println("This droid defeated\n---------------------");
                            OtherDroids temp = team2[num2];
                            team2[num2] = team2[size2 - 1];
                            team2[size2 - 1] = temp;
                            size2 -= 1;
                        }
                        break;
                    }
                }
                for(int l=0;l<size1;l++){
                        if (timing % team2[l].attackTime == 0)
                        {
                            attackDroid(mywrite,team2[l],team1[num1]);
                            team1[num1].health -= team2[l].damage;
                            System.out.println("---------------------\n"+team2[l].name+" attacks "+team1[num1].name+"\n"+team1[num1].name + " health - " + team1[num1].health);
                            mywrite.write("---------------------\n"+team2[l].name+" attacks "+team1[num1].name+"\n"+team1[num1].name + " health - " + team1[num1].health + "\n---------------------\n");
                            if(amhealing1>0 && healthreg1>0 && team1[num1].health<15 && team1[num1].health>0){
                                System.out.println("Healer healed this droid, amount of healing left -"+(amhealing1-1)+"\n---------------------\n");
                                mywrite.write("Healer healed this droid\n---------------------\n");
                                team1[num1].health+=healthreg1;
                                amhealing1-=1;
                            }
                            if(team1[num1].health <=0)
                            {
                                System.out.println("This droid defeated\n---------------------");
                                OtherDroids temp = team1[num1];
                                team1[num1] = team1[size1 - 1];
                                team1[size1 - 1] = temp;
                                size1 -= 1;
                            }
                            break;
                        }
                }
                timing+=1;
            }
                if (size1 > 0) {
                    System.out.println("-----------------------\n𝐓𝐄𝐀𝐌 𝟏 𝐖𝐈𝐍❗\n-----------------------");
                    mywrite.write("-----------------------\n𝐓𝐄𝐀𝐌 𝟏 𝐖𝐈𝐍❗\n-----------------------");
                }
                else {
                    System.out.println("-----------------------\n𝐓𝐄𝐀𝐌 𝟐 𝐖𝐈𝐍❗\n-----------------------");
                    mywrite.write("-----------------------\n𝐓𝐄𝐀𝐌 𝟐 𝐖𝐈𝐍❗\n-----------------------");
                }
                mywrite.close();
}
}
