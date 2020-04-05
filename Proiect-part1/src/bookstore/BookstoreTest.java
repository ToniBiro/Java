package bookstore;

import bookstore.book.*;
import bookstore.person.Client;
import bookstore.person.Employee;
import bookstore.person.Manager;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class BookstoreTest {

    public static void main(String[] args) {

        Bookstore carturesti = createNewBookstore();

        addBooks(carturesti);

        // add employees

        //show bookstore's inventory
        carturesti.showInventory();

        // view purchase history of all books in inventory
        carturesti.seeClientsInfo();

    }

    public static Bookstore createNewBookstore(){

        List<Book> newBooks = new ArrayList<Book>();
        List<Client> newClients =  new ArrayList<Client>();
        Employee[] newEmployees = new Employee[10];
        Manager newManager = new Manager(1, "Valentin");

        return new Bookstore(newBooks, newClients, 10, newEmployees, newManager, 1000);
    }

    public static void addBooks(Bookstore bs){
        List<Client> clients1 = new ArrayList<Client>();
        Mistery book1 = new Mistery("Poezii", "Eminescu", "Rao", 2000, clients1, 20);
        bs.addBook(book1);

        List<Client> clients2 = new ArrayList<Client>();
        Hobby book2 = new Hobby("Pescuit", "Sadoveanu", "Rao", 2012, clients2, 30);
        bs.addBook(book2);

        List<Client> clients3 = new ArrayList<Client>();
        Motivational book3 = new Motivational("Choose Yourself", "Altucher", "Rao", 2001, clients3, 52);
        bs.addBook(book3);

        List<Client> clients4 = new ArrayList<Client>();
        Horror book4 = new Horror("The shawshank redemption", "King", "Rao", 1982, clients4, 38);
        bs.addBook(book4);

    }
}
