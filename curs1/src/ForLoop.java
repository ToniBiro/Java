
// TO DO: rewrite the program using recursion
import java.lang.Math;
import java.util.Scanner;

public class ForLoop {

    public static int inv(int nr, int count){
        if(count == 1){
            return nr;
        }
        if(count == 2){
            return (nr%10 * 10) + (nr/10);
        }
        int m = count / 2;

        int b = 1;

        for(int i = 0; i < m; b=b*10, i++){}

        int s = inv(nr % b, m);
        int f = inv(nr/b, count-m);
        return s*b + f;

    }

    public static void main(String[] args) {

        int inputNo;
        int reverseNo = 0;
        System.out.println("Input an int: ");
        Scanner scanner = new Scanner(System.in);
        inputNo = scanner.nextInt();
        scanner.close();

        int count = 0, num = inputNo;
        for(; num != 0; num/=10, ++count) {}

        System.out.println("Reverse of specified number is: " + inv(inputNo, count));


        for (; inputNo != 0; ) {  // can update value here
            reverseNo = reverseNo * 10;
            reverseNo = reverseNo + inputNo % 10;
            inputNo = inputNo / 10;
        }



        System.out.println("Reverse of specified number is: " + reverseNo);

    }


}
