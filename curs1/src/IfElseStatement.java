
//TO DO: write a program to check leap year

import java.util.Scanner;

public class IfElseStatement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        scanner.close();

        /*if (year is not divisible by 4) then (it is a common year)
        else if (year is not divisible by 100) then (it is a leap year)
        else if (year is not divisible by 400) then (it is a common year)
        else (it is a leap year)*/

        if(number % 4 != 0){
            System.out.println("Common year");
        }
        else{
            if(number % 100 != 0){
                System.out.println("Leap year");
            }
            else{
                if(number % 400 != 0){
                    System.out.println("Common year");
                }
                else {
                    System.out.println("Leap year");
                }
            }
        }
    }
}
