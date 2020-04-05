package bookstore;

import bookstore.book.Book;
import bookstore.person.Client;
import bookstore.person.Employee;
import bookstore.person.Manager;

import java.util.List;

public class Bookstore {

    public List<Book> books;
    public List<Client> clients;

    int maxNumberEmployees;
    Employee[] employees;

    private String status;
    public Manager manager;

    public Bookstore(List<Book> books, List<Client> clients, int maxNumberEmployees, Employee[] employees, Manager manager) {
        this.books = books;
        this.clients = clients;
        this.maxNumberEmployees = maxNumberEmployees;
        this.employees = employees;
        this.manager = manager;
        this.status = "quarantine";
    }

    public void addBook(Book book){
        System.out.println("ceva");
    }

    public void searchBook(Book book){
        System.out.println("altceva");
    }

    public void changeStatus(){
        this.status = this.manager.changeStatus();
    }

}
