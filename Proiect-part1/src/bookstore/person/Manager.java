package bookstore.person;

import bookstore.Bookstore;
import bookstore.book.Book;
import com.sun.corba.se.spi.ior.ObjectKey;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

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

    public int setMaxNrEmployees(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter max number of emplyees");
        int nrEmployees = scanner.nextInt();
        while(nrEmployees < 0){
            System.out.println("Wrong input, try again: ");
            nrEmployees = scanner.nextInt();
        }
        scanner.close();

        return nrEmployees;
    }

    public boolean addEmployee(Object obj){
        if(obj instanceof Employee){
            Employee emp = (Employee) obj;

            this.bs.employees[this.bs.index++] = emp;
            return true;
        }
        return false;
    }

    public void removeEmployee(Object obj){
        if(obj instanceof Employee){
            Employee emp = (Employee) obj;
            for(int i = 0; i < this.bs.employees.length; ++i){
                if(this.bs.employees[i].equals(emp)){
                    for(int j = i; j < this.bs.index -1; j++){
                        this.bs.employees[j] = this.bs.employees[j + 1];
                    }
                    if(this.bs.employees.length == 1){
                        this.bs.employees[0] = null;
                        this.bs.index--;
                    }
                    break;
                }
            }
        }
    }
}
