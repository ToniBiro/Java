import candyBox.CandyBox;
import candyBox.Heidi;
import candyBox.Lindt;
import candyBox.Milka;

import java.util.Scanner;

public class CandyTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nrCandy = scanner.nextInt();

        CandyBag cb = new CandyBag(nrCandy);
        adaugaGoodies(cb);
    }

    public static void adaugaGoodies(CandyBag cbag){
        Heidi heidi = new Heidi("merisoare", "alpi", 2);
        cbag.adaugaCandy(heidi);

        Milka milka = new Milka("neagra", "germania", 3, 4);
        cbag.adaugaCandy(milka);

        Lindt lindt = new Lindt("alba", "olanda", 1 ,2, 3);
        cbag.adaugaCandy(lindt);
    }
}
