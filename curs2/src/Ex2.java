
// TO DO: write a program to compute and display the values of an array representing the length of arrays in a given multidimensional array
public class Ex2 {
    public static void main(String[] args) {



        // create a multidimensional array
        int[][] matrix = new int[3][3]; // 3 rows, 3 columns
        matrix[0][0] = 0;
        matrix[0][1] = 0;
        matrix[0][2] = 0;
        matrix[1][0] = 1;
        matrix[1][1] = 1;
        matrix[1][2] = 1;
        matrix[2][0] = 2;
        matrix[2][1] = 2;
        matrix[2][2] = 2;
        for (int[] i : matrix){
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        // declare and initialize a multidimensional array in a single step
        char[][] multidimensionalCharArray = {{'c', 'o', 'u', 'r', 's', 'e'}, {'2'}, {'j', 'a', 'v', 'a'}};
        for (char[] row : multidimensionalCharArray){
            for (char c : row){
                System.out.print(c);
            }
            System.out.println();
        }

        int[] l = new int[multidimensionalCharArray.length];

        int i = 0;
        for(char[] row : multidimensionalCharArray){
            l[i++] = row.length;
        }

        for(int c : l){
            System.out.print(c + " ");
        }

    }

}