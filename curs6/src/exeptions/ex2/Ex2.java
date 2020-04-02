package exeptions.ex2;

public class Ex2 {
    public static void main(String[] args) {
        try {
            m1();
        } catch (ArithmeticException a){
            System.out.println(a);
        }finally {
            System.out.println("in finally");
        }

    }

    static int m1(){
        int i  = 5 / 0;
        System.out.println(i);
        return i;
    }
}
