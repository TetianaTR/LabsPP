package Battles;
import droids.BaseDroid;
import droids.OtherDroids;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;
import java.io.FileWriter;

public class Battle {
        String filename = "C:\\PP\\DroidFight.txt";
        FileWriter myWriter = new FileWriter(filename);

    public Battle() throws IOException {
    }

    public void StartOneToOne() throws IOException {//бій 1 на 1
            System.out.println("\t\t\t------𝐎𝐍𝐄 𝐓𝐎 𝐎𝐍𝐄 𝐁𝐀𝐓𝐓𝐋𝐄------");
            Scanner scan= new Scanner(System.in);
            Scanner scans= new Scanner(System.in);
            String name,name1;
            int damage,damage1;
            int interval,interval1;
            int health,health1;
            int type,type1;
           System.out.print("Firts droid:\nEnter the Name of droid: ");
           name = scans.nextLine();
           System.out.print("Enter the damage of droid: ");
           damage = scan.nextInt();
           System.out.print("Enter the interval time of attack: ");
           interval = scan.nextInt();
           System.out.print("Enter the health of your droid: ");
           health = scan.nextInt();
           OtherDroids droid1 = new OtherDroids(name,damage ,interval ,health );
           System.out.print("Enter the type of your droid: ");
           type = scan.nextInt();
           droid1.Setdroid(type);
           droid1.setType(type);
           System.out.print("Second droid:\nEnter the Name of droid: ");
           name1 = scans.nextLine();
           System.out.print("Enter the damage of droid: ");
           damage1 = scan.nextInt();
           System.out.print("Enter the interval time of attack: ");
           interval1 = scan.nextInt();
           System.out.print("Enter the health of your droid: ");
           health1 = scan.nextInt();
           OtherDroids droid2 = new OtherDroids(name1,damage1 ,interval1 ,health1 );
           System.out.print("Enter the type of your droid: ");
           type1 = scan.nextInt();
           droid2.Setdroid(type1);
           droid2.setType(type1);
        int time = 1;//лічильник часу гри
        while (droid1.health > 0 && droid2.health > 0)//цикл бою,відбувається доки один з дроїдів не буде вбитий
        {
            if (time % droid1.attackTime == 0) //атакує відносно свого часу атаки
            {
                droid2.health -= droid1.damage;
                System.out.println("---------------------\n"+droid1.name+" attacks\n"+droid2.name+" health: "+ droid2.getHealth()+"\n---------------------");
                myWriter.write("\n---------------------\n"+droid1.name+" attacks\n"+droid2.name+" health: "+ droid2.getHealth()+"\n---------------------\n");
                if(droid2.getType()==1 && droid2.getAmhealing()>0 && droid2.health<15){//перевіряємо чи даний дройд може себе вилікувати
                    System.out.println("Droid healed itself");
                    droid2.health+=droid2.getHealthigh();
                    droid2.setAmhealing(droid2.getAmhealing()-1);
                    System.out.println(droid2.getAmhealing()+" am of heal left");
                }
            }
            if (time % droid2.attackTime == 0) //атакує відносно свого часу атаки
            {
                droid1.health -= droid2.damage;//атака
                System.out.println("---------------------\n"+droid2.name+" attacks\n"+droid1.name+" health: "+ droid1.getHealth()+"\n---------------------");
                myWriter.write("\n---------------------\n"+droid2.name+" attacks\n"+droid1.name+" health: "+ droid1.getHealth()+"\n---------------------\n");
                if(droid1.getType()==1 && droid1.getAmhealing()>0 && droid1.health<15){//перевіряємо чи даний дройд може себе вилікувати
                    System.out.println("Droid healed itself");
                    droid1.health+=droid1.getHealthigh();
                    droid1.setAmhealing(droid1.getAmhealing()-1);
                    System.out.println(droid1.getAmhealing()+" am of heal left");
                }
            }
            time++;
        }
        if (droid1.health > 0)
        {
            System.out.println(droid1.name + " WIN!");
            myWriter.write(droid1.name + " WIN!");
        }
        else
        {
            System.out.println(droid2.name + " WIN!");
            myWriter.write(droid2.name + " WIN!");
        }
        myWriter.close();
    }
    public void StartTeamFight() throws IOException {// бій команд
        int healthreg1=0,healthreg2=0;
        int amhealing1=0,amhealing2=0;
        String filename2 = "C:\\PP\\TeamFight.txt";
        FileWriter mywrite = new FileWriter(filename2);
        System.out.println("\t\t\t------𝐓𝐄𝐀𝐌 𝐁𝐀𝐓𝐓𝐋𝐄------");
            Scanner scan1= new Scanner(System.in);
            Scanner scan2= new Scanner(System.in);
        System.out.print("Enter size of first array: ");
        int size1= scan1.nextInt();
        OtherDroids team1[]=new OtherDroids[size1];
        for(int i=0; i<size1; i++){
            System.out.print("Enter the Name of droid: ");
            String nam1 = scan2.nextLine();
            System.out.print("Enter the damage of droid: ");
            int damage1 = scan1.nextInt();
            System.out.print("Enter the interval time of attack: ");
            int interval1= scan1.nextInt();
            System.out.print("Enter the health of your droid: ");
            int health1 = scan1.nextInt();
            team1[i] = new OtherDroids(nam1,damage1,interval1,health1);
            System.out.print("Enter the type of your droid: ");
            int typ = scan1.nextInt();
            team1[i].Setdroid(typ);
            if(typ==1) {//якщо один з дроїдів в команді лікар
                healthreg1 = team1[i].getHealthigh();
                amhealing1 = team1[i].getAmhealing();
            }
        }
        System.out.print("Enter size of second array: ");
        int size2= scan1.nextInt();
        OtherDroids team2[]=new OtherDroids[size2];
        for(int j=0; j<size2; j++) {
            System.out.print("Enter the Name of droid: ");
            String nam2 = scan2.nextLine();
            System.out.print("Enter the damage of droid: ");
            int damage2 = scan1.nextInt();
            System.out.print("Enter the interval time of attack: ");
            int interval2 = scan1.nextInt();
            System.out.print("Enter the health of your droid: ");
            int health2 = scan1.nextInt();
            team2[j] = new OtherDroids(nam2, damage2, interval2, health2);
            System.out.print("Enter the type of your droid: ");
            int typ = scan1.nextInt();
            team2[j].Setdroid(typ);
            if (typ == 1) {//якщо один з дроїдів в команді лікар
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
                        team2[num2].health -= team1[k].damage;
                        System.out.println("---------------------\n"+team1[k].name + " attacks " + team2[num2].name+"\n"+ team2[num2].name + " health - "+team2[num2].health);
                        mywrite.write("\n---------------------\n"+team1[k].name + " attacks " + team2[num2].name+"\n"+ team2[num2].name + " health - "+team2[num2].health+"\n---------------------\n");
                        if(amhealing2>0 && healthreg2>0 && team2[num2].health<15 && team2[num2].health>0){
                            System.out.println("Healer healed this droid, amount of healing left -"+(amhealing2-1)+"\n---------------------\n");
                            mywrite.write("Healer healed this droid\n---------------------\n");
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
