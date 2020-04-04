package candyBox;

public abstract class CandyBox {

    private String flavor ;
    private String origin;

    public CandyBox() {}

    public CandyBox(String flavor , String origin) {
        this.flavor  = flavor ;
        this.origin = origin;
    }

    public float getVolume(){
        return 0;
    }

    @Override
    public String toString(){
        return "This CandyBox has " + this.origin + " origins and " + this.flavor + " flavor. ";
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof CandyBox){
            CandyBox cb = (CandyBox) obj;
            return cb.flavor.equals(this.flavor) && cb.origin.equals(this.origin);
        }
        return false;
    }

}
