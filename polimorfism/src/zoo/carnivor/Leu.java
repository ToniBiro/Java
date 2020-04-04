package zoo.carnivor;


public class Leu extends Carnior{

    public Leu(String nume, int varsta) {
        super(nume, varsta);
        this.sunetSpecific = "rage";
    }

    @Override
    public void scoateSunet(){
        System.out.println("Leul " + this.sunetSpecific);
    }

}
