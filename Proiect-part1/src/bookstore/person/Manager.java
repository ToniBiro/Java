package bookstore.person;

import bookstore.Bookstore;
import bookstore.book.Book;

import java.util.Scanner;

public class Manager extends Employee{

    public Bookstore bs;
    public Manager(int id, String name) {
        super(id, name);
        this.role = "manager";
    }

    public Manager(int id, String name, Bookstore bs) {
        super(id, name);
        this.bs = bs;
        this.role = "manager";
    }

    @Override
    public String toString(){
        return super.toString() + " role: " + this.role + ".\n";
    }

    public String changeStatus(){
        Scanner scanner = new Scanner(System.in);
        String newStatus = scanner.next();
        scanner.close();
        return newStatus;
    }

    public boolean addEmployee(Object obj){
        if(obj instanceof Person){
            Person per = (Person) obj;

        }
        return false;
    }
}
