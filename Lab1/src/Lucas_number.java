public class Lucas_number {
    long FindNnum(int N) {
        int num0 = 2,num1 =1,number=0;
        if(N==0)
            return 2;
        else if (N==1)
            return 1;
        for (int i = 1; i < N; i++) {
            number = num0 + num1;
            num0 = num1;
            num1 = number;
        }
        return number;
    }
}

