package bookstore.person;

public abstract class Person{

    private int id;
    public String name;
    public String type;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString(){
        return "Person with name:" + this.name +
                "id: " + this.id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Person){
            Person per = (Person) obj;
            return per.getId() == this.getId();
        }
        return false;
    }
}
