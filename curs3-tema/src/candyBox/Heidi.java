package candyBox;

public class Heidi extends CandyBox{

    private float l;

    public Heidi() {
    }

    public Heidi(String flavor, String origin, float l) {
        super(flavor, origin);
        this.l = l;
    }

    @Override
    public float getVolume(){
        return this.l * this.l * this.l;
    }

    @Override
    public String toString(){
        return super.toString() + " Heidi has volume " + this.getVolume() + ". ";
    }

    public void printHeidiDim(){
        System.out.println("Heidi are lungimea: " + this.l);
    }
}
