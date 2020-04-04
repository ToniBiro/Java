package zoo.omnivor;

import zoo.Animal;

public abstract class Omnivor extends Animal {

    public Omnivor(String nume, int varsta) {
        super(nume, varsta);
        this.tipHrana = "si carne si plante";
    }

    @Override
    public void seHraneste(){
        System.out.println(this + " se hraneste " + this.tipHrana);
    }

    @Override
    public String toString(){
        return super.toString() + " Omnivor, tip de hrana: " + this.tipHrana + ". ";
    }
}
