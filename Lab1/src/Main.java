//25.	Визначити N-е число Люка і перевірити, чи

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int N;
        if(args.length==0) {
            Scanner num = new Scanner(System.in);
            System.out.print("Enter the position of number you want to find(position can be more then -1): ");
            N = num.nextInt();
        }
        else
            N = Integer.parseInt(args[0]);
        if(N<0)
            System.out.println("You entered wrong number");

        Lucas_number lucasN=new Lucas_number();
        System.out.println("Number with " + N + " in Lucas series - "+lucasN.FindNnum(N));
        System.out.println("N*L(N+1) -  " + N* lucasN.FindNnum(N+1));
        System.out.println("(N+1)*L(N) - "+(N+1)*lucasN.FindNnum(N));

        if(N* lucasN.FindNnum(N+1)>(N+1)* lucasN.FindNnum(N))
            System.out.print("N*L(N+1)>(N+1)*L(N) - True");
        else
            System.out.print("N*L(N+1)>(N+1)*L(N) - False");

    }
}