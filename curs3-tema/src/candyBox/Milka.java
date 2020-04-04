package candyBox;

public class Milka extends CandyBox{

    private float h, arieCerc;

    public Milka() {
    }

    public Milka(String flavor, String origin, float h, float arieCerc) {
        super(flavor, origin);
        this.h = h;
        this.arieCerc = arieCerc;
    }

    @Override
    public float getVolume(){
        return this.h * this.arieCerc;
    }

    @Override
    public String toString(){
        return super.toString() + " Milka has volume " + this.getVolume() + ". ";
    }

    public void printMilkaDim(){
        System.out.println("Milka are inaltimea: " + this.h + " si aria: " + this.arieCerc);
    }
}
