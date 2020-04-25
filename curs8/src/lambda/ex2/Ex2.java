package lambda.ex2;

public class Ex2 {

    public static void main(String[] args) {


        I1 i1 = (int x1, int x2) -> x1 + x2;

        System.out.println(i1.add(2, 3));

        I2 i2 = x1 -> 10*x1;

        System.out.println(i2.multiply(3));
    }
}
