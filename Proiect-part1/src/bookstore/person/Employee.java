package bookstore.person;

public abstract class Employee extends Person{

    public String role;

    public Employee(int id, String name) {
        super(id, name);
        this.type = "employee";
    }

    @Override
    public String toString(){
        return super.toString() + " type: " + this.type;
    }
}
