
// TO DO: implement a program to read int values from keyboard until a pre-set value is encountered

import java.util.Scanner;

public class BranchingStatements {

    static int presetValue = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();


        while(number != presetValue) {
            System.out.print("Enter a number: ");
            number = scanner.nextInt();
        }

        scanner.close();

    }
}
