
// TO DO: write a program to create a 2D-array, with both dimensions and elements input by user

import java.util.Scanner;

public class Ex3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = scanner.nextInt();
        System.out.println("Enter m: ");
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];
        System.out.println("Enter n x m values: ");
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                matrix[i][j] = scanner.nextInt();
            }
        }

        scanner.close();

        System.out.println("Your matrix: ");

        for(int[] row : matrix){
            for(int c : row){
                System.out.print(c + " ");
            }
            System.out.println();
        }





    }


}
