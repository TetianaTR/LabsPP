//25.	Визначити N-е число Люка і перевірити, чи N*L(N+1)>(N+1)*L(N)
package com.company;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int position;
        if(args.length==0) {
            Scanner num = new Scanner(System.in);
            System.out.print("Enter the position of number you want to find(position can be more then -1): ");
            position = num.nextInt();
        }
        else
            position = Integer.parseInt(args[0]);
        if(position<0)
            System.out.println("You entered wrong number");

        Lucas_number lucasN=new Lucas_number();
        System.out.println("Number with " + position + " in Lucas series - "+lucasN.FindNnum(position));
        System.out.println("N*L(N+1) -  " + position* lucasN.FindNnum(position+1));
        System.out.println("(N+1)*L(N) - "+(position+1)*lucasN.FindNnum(position));

        if(position* lucasN.FindNnum(position+1)>(position+1)* lucasN.FindNnum(position))
            System.out.print("N*L(N+1)>(N+1)*L(N) - True");
        else
            System.out.print("N*L(N+1)>(N+1)*L(N) - False");

    }
}