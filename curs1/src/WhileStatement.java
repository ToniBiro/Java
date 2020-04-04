

import java.util.Scanner;

// TO DO: rewrite the program using do-while loop

public class WhileStatement {

    public static void main(String[] args) {

        int inputNo;
        int reverseNo = 0;

        System.out.println("Input an int number: ");
        Scanner scanner = new Scanner(System.in);
        inputNo = scanner.nextInt();
        scanner.close();

        // begin while loop
        do { // loop condition
            reverseNo = reverseNo * 10;
            reverseNo = reverseNo + inputNo % 10;
            inputNo = inputNo / 10; // update value checked in condition
        }while(inputNo != 0);

        System.out.println("Reverse of input number is: " + reverseNo);

    }
}
