package zoo.ierbivor;


import zoo.Animal;

public abstract class Ierbivor extends Animal {

    public Ierbivor(String nume, int varsta) {
        super(nume, varsta);
        this.tipHrana = "plante";
    }

    @Override
    public void seHraneste(){
        System.out.println(this + " se hraneste cu " + this.tipHrana);
    }

    @Override
    public String toString(){
        return super.toString() + " Ierbivor," + " tip de hrana: " + this.tipHrana + ". ";
    }
}
