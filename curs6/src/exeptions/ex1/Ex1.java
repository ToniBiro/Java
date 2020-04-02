//package exeptions.ex1;
//
//public class Ex1 {
//    public static void main(String[] args) {
//        try {
//            m1();
//        }catch (NullPointerException e){
//            System.out.println(e);
//        }finally {
//            System.out.println("sunt in finally");
//        }
//    }
//
//    static void m1() throws Exception{
//        System.out.println("in m1");
//        m2();
//        throw new Exception();
//    }
//    static void m2(){
//        System.out.println("in m2");
//        throw new RuntimeException("exeption in m2");
//        //m3();
//    }
//    static void m3(){
//        System.out.println("in m3");
//        Object o = null;
//        o.toString();
//    }
//}
