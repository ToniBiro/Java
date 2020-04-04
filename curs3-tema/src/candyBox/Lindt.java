package candyBox;

public class Lindt extends CandyBox{

    private float l, L, h;

    public Lindt() {
    }

    public Lindt(String flavor, String origin, float l, float L, float h) {
        super(flavor, origin);
        this.l = l;
        this.L = L;
        this.h = h;
    }

    @Override
    public float getVolume(){
        return this.l * this.L * this.h;
    }

    @Override
    public String toString(){
        return super.toString() + " Lindt has volume " + this.getVolume() + ". ";
    }

    public void printLindtDim(){
        System.out.println("Lindt are lungimea: " + this.L + ", latimea: " + this.l + " si inaltimea: " + this.h);
    }
}
