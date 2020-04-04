import java.util.Scanner;

// TO DO: write a program that outputs the number of days of a particular month of an year (input from keyboard)
public class SwitchStatement {

    public static int leap(int year){
        if(year % 4 != 0){
            System.out.println("Common year");
            return 0;
        }
        else{
            if(year % 100 != 0){
                System.out.println("Leap year");
                return 1;
            }
            else{
                if(year % 400 != 0){
                    System.out.println("Common year");
                    return 0;
                }
                else {
                    System.out.println("Leap year");
                    return 1;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a month: ");
        String inputMonth = scanner.next().toLowerCase();
        int inputYear = scanner.nextInt();
        scanner.close();
        System.out.println(inputMonth);

        switch (inputMonth) {
            case "january": {
                System.out.println(31);
                break;
            }
            case "february": {
                if (leap(inputYear) == 1) {
                    System.out.println(29);
                } else {
                    System.out.println(28);
                }
                break;
            }
            case "march": {
                System.out.println(31);
                break;
            }
            case "april": {
                System.out.println(30);
                break;
            }
            case "may": {
                System.out.println(31);
                break;
            }
            case "june": {
                System.out.println(30);
                break;
            }
            case "july": {
                System.out.println(31);
                break;
            }
            case "august": {
                System.out.println(31);
                break;
            }
            case "september": {
                System.out.println(30);
                break;
            }
            case "october": {
                System.out.println(31);
                break;
            }
            case "november": {
                System.out.println(30);
                break;
            }
            case "december": {
                System.out.println(31);
                break;
            }
            default: {
                System.out.println("wrong input");
            }

        }
    }
}
