package zoo.ierbivor;

public class Cal extends Ierbivor{

    public Cal(String nume, int varsta) {
        super(nume, varsta);
        this.sunetSpecific = "tropaie";
    }

    @Override
    public void scoateSunet(){
        System.out.println("Calul " + this.sunetSpecific);
    }
}
