package bookstore.person;

public class Salesman extends Employee{

    public Salesman(int id, String name) {
        super(id, name);
        this.role = "salesman";
    }

    @Override
    public String toString() {
        return super.toString() + " role: " + this.role + ".\n";
    }
}
