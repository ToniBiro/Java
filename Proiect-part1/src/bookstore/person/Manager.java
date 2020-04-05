package bookstore.person;

import java.util.Scanner;

public class Manager extends Employee{

    public Manager(int id, String name) {
        super(id, name);
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
}
