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
    public Employee[] employees; // transform in set()
    public int index;

    public float money;


    public Bookstore(List<Book> books, List<Client> clients, int maxNumberEmployees, Manager manager, float money) {
        this.books = books;
        this.clients = clients;
        this.maxNumberEmployees = maxNumberEmployees;
        this.employees = new Employee[maxNumberEmployees];
        this.manager = manager;
        this.status = "quarantine";
        this.money = money;
        this.index = 0;
    }

    public void addBook(Book book){
        this.books.add(book);
        this.money -= book.price;
        System.out.println("Added " + book.toString());
        //after adding a new book sort the list alphabetically
        Collections.sort(this.books);
        System.out.println("After sorting: " + this.books);
    }

    public boolean searchBook(Book book, Client client){
        System.out.println("Searching for this author: " + book);
        if (this.books.contains(book)) {
            if (this.clients.contains(client))
                System.out.println("Welcome back " + client.toString());
            else {
                this.clients.add(client);
            }
            int idx = this.books.indexOf(book);
            this.books.get(idx).nrPurchases += 1;
            return true;
        }
        return false;
    }

    public void showInventory(Output output){
        System.out.println("Inventory: " + this.books);

        output.write("afisare_inventar");
    }

    public void changeStatus(){
        System.out.println("Current status: " + this.status);
        this.status = this.manager.changeStatus();
        System.out.println("New status: " + this.status);
    }

    public void seePurchaseHistory(Output output){
        for(int i = 0; i < this.books.size(); ++i){
            this.books.get(i).viewPurchaseHistory();
        }
        output.write("afisare_istoric_vanzari");
    }

    public void seeClientsInfo(Output output){
        System.out.println("Number of clients: " + this.clients.size());
        for(int i = 0; i < this.clients.size(); ++i){
            System.out.println(this.clients.get(i).toString() + " with purchase history: " +
                    this.clients.get(i).purchaseHistory);
        }

        output.write("afisare_info_clienti");
    }
}
