package Battles;
import droids.OtherDroids;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;

public class Battle {
    private int healthreg1=0;
    private int healthreg2=0;
    private int amhealing1=0;
    private int amhealing2=0;
    public void printRes(FileWriter mywriter, String name) throws IOException {
        System.out.println(name);
        mywriter.write(name);
    }
    public void attackDroid( FileWriter mywrite ,OtherDroids dr1,OtherDroids dr2) throws IOException {
        dr2.setHealth(dr2.getHealth()- dr1.getDamage());
        printRes(mywrite ,"\n---------------------\n"+ dr1.getName() + " attacks " + dr2.getName() +"\n"+ dr2.getName() + " health - "+ dr2.getHealth() +"\n---------------------\n");
    }
    public OtherDroids[] enterteam(int numteam, int size){
        OtherDroids[] team=new OtherDroids[size];
        for(int i=0; i<size; i++){
            team[i]=new OtherDroids();
            int type = team[i].enterDroid();
            team[i].setdroid(type);
            if(type==1 && numteam==1) {//якщо один з дроїдів в команді лікар
                this.healthreg1 = team[i].getHealthigh();
                this.amhealing1 = team[i].getAmhealing();
            }
            if(type==1 && numteam==2) {//якщо один з дроїдів в команді лікар
                this.healthreg2 = team[i].getHealthigh();
                this.amhealing2 = team[i].getAmhealing();
            }
        }
        return team;
    }
    public  int healing(FileWriter mywrite,int amheal,int healr,OtherDroids droid1) throws IOException {
        if(amheal>0 && healr>0 && droid1.getHealth() <15 && droid1.getHealth() >0){
            printRes(mywrite,"Healer healed this droid, amount of healing left -"+(amheal-1)+"\n---------------------");
            droid1.setHealth(droid1.getHealth()+this.healthreg2);
            amheal-=1;
        }
        return amheal;
    }
    public int droidfight(FileWriter mywrite,int numt,int size1,int size2,int timing,int rand,OtherDroids[] team1,OtherDroids[] team2) throws IOException {
        for(int k=0;k<size1;k++) {
            if (timing % team1[k].getAttackTime() == 0) {
                attackDroid(mywrite,team1[k],team2[rand]);
                if(numt==1)
                    this.amhealing2=healing(mywrite,this.amhealing2,this.healthreg2,team2[rand]);
                else
                    this.amhealing1=healing(mywrite,this.amhealing1,this.healthreg1,team2[rand]);
                if (team2[rand].getHealth() <= 0) {
                    printRes(mywrite,"This droid defeated\n---------------------");
                    OtherDroids temp = team2[rand];
                    team2[rand] = team2[size2 - 1];
                    team2[size2 - 1] = temp;
                    size2 -= 1;
                }
                break;
            }
        }
        return size2;
    }
    public void startTeamFight() throws IOException {// бій команд
        String filename2 = "C:\\PP\\TeamFight.txt";
        FileWriter mywrite = new FileWriter(filename2);
        printRes(mywrite,"\t\t\t------𝐓𝐄𝐀𝐌 𝐁𝐀𝐓𝐓𝐋𝐄------");
        Scanner scan1= new Scanner(System.in);
        System.out.print("Enter size of first array: ");
        int size1= scan1.nextInt();
        OtherDroids[] team1= enterteam(1,size1);
        System.out.print("Enter size of second array: ");
        int size2= scan1.nextInt();
        OtherDroids[] team2=enterteam(2,size2);
        int timing=0;
        while (size1 > 0 && size2 > 0)
            {
                Random rand= new Random();
                int num1 = rand.nextInt(size1);
                int num2 = rand.nextInt(size2);
                size2=droidfight(mywrite,1,size1,size2,timing,num2,team1,team2);
                size1=droidfight(mywrite,2,size2,size1,timing,num1,team2,team1);
                timing+=1;
            }
                if (size1 > 0)
                    printRes(mywrite,"-----------------------\n𝐓𝐄𝐀𝐌 𝟏 𝐖𝐈𝐍❗\n-----------------------");
                else
                    printRes(mywrite,"-----------------------\n𝐓𝐄𝐀𝐌 𝟐 𝐖𝐈𝐍❗\n-----------------------");
                mywrite.close();
}
}
