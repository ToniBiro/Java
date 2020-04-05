package bookstore;

import bookstore.book.Book;
import bookstore.person.Client;
import bookstore.person.Employee;
import bookstore.person.Manager;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Bookstore {

    public List<Book> books;
    public List<Client> clients;
    public Manager manager;

    private String status;
    private int maxNumberEmployees;
    Employee[] employees;

    public float money;


    public Bookstore(List<Book> books, List<Client> clients, int maxNumberEmployees, Employee[] employees, Manager manager, float money){
        this.books = books;
        this.clients = clients;
        this.maxNumberEmployees = maxNumberEmployees;
        this.employees = employees;
        this.manager = manager;
        this.status = "quarantine";
        this.money = money;
    }

    public void addBook(Book book){
        this.books.add(book);
        this.money -= book.price;
        System.out.println("Added " + book.toString());
        //after adding a new book sort the list alphabetically
        Collections.sort(this.books);
        System.out.println("After sorting: " + this.books);
    }

    public Book searchBook(String book, Client client){
        System.out.println("Searching for this author: " + book);
        for(int i = 0; i < this.books.size(); ++i) {
            System.out.println(this.books.get(i).getAuthor().equals(book));
            if (this.books.get(i).getAuthor().equals(book)) {
                if (this.clients.contains(client))
                    System.out.println("Welcome back " + client.toString());
                else {
                    this.clients.add(client);
                }

                this.books.get(i).viewPurchaseHistory();

                return this.books.get(i);
            } else {
                return null;
            }
        }
        return null;
    }

    public void showInventory(){
        System.out.println("Inventory: " + this.books);
    }

    public void changeStatus(){
        this.status = this.manager.changeStatus();
    }

    private void seePurchaseHistory(){
        for(int i = 0; i < this.books.size(); ++i){
            this.books.get(i).viewPurchaseHistory();
        }
    }

    public void seeClientsInfo(){
        System.out.println("Number of clients: " + this.clients.size());
        for(int i = 0; i < this.clients.size(); ++i){
            System.out.println(this.clients.get(i).toString() + " with purchase history: " +
                    this.clients.get(i).purchaseHistory);
        }
    }
}
