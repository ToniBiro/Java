package zoo;

public class Zoo {

    private final int nrMaxAnimale;
    Animal[] animaleZoo;
    private int indexCurent;

    public Zoo(int nrMaxAnimale) {
        if (nrMaxAnimale > 0) {
            this.nrMaxAnimale = nrMaxAnimale;
            this.animaleZoo = new Animal[nrMaxAnimale];
        } else {
            throw new RuntimeException("Nu ati introdus un nr intreg pozitiv");
        }
    }

    public void adaugaAnimal(Animal animal) {
        if (indexCurent < this.nrMaxAnimale) {
            animaleZoo[indexCurent] = animal;
            System.out.println("Adaugat animal " + animal.getClass().getSimpleName() + " la pozitia " + indexCurent);
            indexCurent += 1;
        }
    }
}
