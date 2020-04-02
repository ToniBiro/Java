package exeptions.ex1;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ex3 {

    static void createFile()throws IOException {
        File file = new File("text.txt");
        if(file.createNewFile()){
            System.out.println("file created");
        }else{
            System.out.println("file aready created");
        }
    }

    public static void main(String[] args) {
        int a, b;
        try {
            createFile();
            Scanner scanner = new Scanner(new File("text.txt"));
            a = scanner.nextInt();
            b = scanner.nextInt();
            double result = a / b;
            System.out.println("res:" + result);
            scanner.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }catch (NoSuchElementException e){
//            System.out.println(e);
//        }catch (ArithmeticException e){
//            System.out.println(e);
//        }
        }catch (IOException | NoSuchElementException | ArithmeticException e){
            System.out.println(e);

        }catch (Exception e){
            System.out.println(e);
        } finally{
            System.out.println("finally");
            b = 0;
        }
    }

}
