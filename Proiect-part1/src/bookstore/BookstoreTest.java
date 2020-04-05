package bookstore;

import bookstore.book.*;
import bookstore.person.Client;
import bookstore.person.Employee;
import bookstore.person.Manager;
import bookstore.person.Salesman;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Scanner;

public class BookstoreTest {

    public static void main(String[] args) {

        Bookstore carturesti = createNewBookstore();

        // add books in the Bookstore
        addBooks(carturesti);

        Client client1 = new Client(2, "Gigel", 1000);
        // client that buys a randomly generated book
        client1.buyBook(carturesti);

        Mistery searchThis = new Mistery("Poezii", "Eminescu");
        Client client2 = new Client(3, "Anca", 200, searchThis);
        // client that buys a book he/she was looking for
        client2.buyBook(carturesti);

        Employee emplyee1 = new Salesman(4, "Maria");
        // add employees
        carturesti.manager.addEmployee(emplyee1);
        System.out.println("Added new employee: " + emplyee1.toString());
        System.out.println("Employee list: ");
        for(int i = 0; i < carturesti.index; ++i)
            System.out.println(carturesti.employees[i].toString());

        //remove employees
        carturesti.manager.removeEmployee(emplyee1);
        System.out.println("Removed employee: " + emplyee1.toString());
        System.out.println("Employee list: ");
        for(int i = 0; i < carturesti.index; ++i)
            System.out.println(carturesti.employees[i].toString());


        //show bookstore's inventory
        carturesti.showInventory();

        // show purchase history of all books in inventory
        carturesti.seePurchaseHistory();

        // view clients info of all the clients
        carturesti.seeClientsInfo();

        // change status as manager
        System.out.println("Enter new status: ");
        carturesti.changeStatus();
        System.out.println("The manager changed the status");

    }

    public static Bookstore createNewBookstore(){

        List<Book> newBooks = new ArrayList<Book>();
        List<Client> newClients =  new ArrayList<Client>();
        Manager newManager = new Manager(1, "Valentin");
        Bookstore bs = new Bookstore(newBooks, newClients, 10, newManager, 1000);
        newManager.bs = bs;

        return bs;
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
