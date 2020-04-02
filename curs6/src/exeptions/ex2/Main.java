package exeptions.ex2;

public class Main {
    private static final int AMOUNT = 100;

    public static void main(String[] args) {
        try {
            m1(101);
        }catch (MyCheckedException e){
            System.out.println(e);
            m2();
        }finally {
            System.out.println("finally");
        }
    }

    static int m1(int x){
        if(x < AMOUNT){
            return x;
        }
        else{
            throw new MyCheckedException(":(");
        }
    }
    static int m2(int x){
        throw new MyRuntimeException("runtime exception");
    }
}
