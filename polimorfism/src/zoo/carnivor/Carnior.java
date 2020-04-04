package zoo.carnivor;


import zoo.Animal;

public abstract class Carnior extends Animal {

    public Carnior(String nume, int varsta) {
        super(nume, varsta);
        this.tipHrana = "carne";
    }

    @Override
    public void seHraneste(){
        System.out.println(this + " se hraneste cu " + this.tipHrana);
    }

    @Override
    public String toString(){
        return super.toString() + " Carnivor " + " tip hrana: " + this.tipHrana + ".\n";
    }
}
