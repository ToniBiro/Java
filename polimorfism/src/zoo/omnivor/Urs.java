package zoo.omnivor;

import com.sun.org.glassfish.gmbal.ManagedObject;
import zoo.carnivor.Pisica;

public class Urs extends Omnivor{

    public Urs(String nume, int varsta) {
        super(nume, varsta);
        this.sunetSpecific = "mormaie";
    }

    @Override
    public void scoateSunet(){
        System.out.println("Ursul " + this.sunetSpecific);
    }

    @Override
    public String toString(){
        return super.toString() + "Urs, sunet specific:" + this.sunetSpecific + ". ";
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Urs){
            Urs bran = (Urs) obj;
            return bran.getNume().equals(this.getNume());
        }
        else{
            return false;
        }
    }
}
