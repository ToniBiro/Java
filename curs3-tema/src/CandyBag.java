import candyBox.CandyBox;

public class CandyBag {

    private final int nrMaximCandy;
    CandyBox[] goodies;
    private int indexCurent;

    public CandyBag(int nrMaximCandy) {
        this.nrMaximCandy = nrMaximCandy;
        goodies = new CandyBox[nrMaximCandy];
        indexCurent = 0;
    }

    public void adaugaCandy(CandyBox cb) {
        if (indexCurent < this.nrMaximCandy) {
            goodies[indexCurent] = cb;
            System.out.println("Am bagat in punga de dulciuri: " + cb.toString());
        }
    }
}
