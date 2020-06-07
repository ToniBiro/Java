package dataBase;

import bookstore.book.Book;
import bookstore.dao.BookDao;
import bookstore.dao.ClientDao;
import bookstore.person.Client;
import bookstore.person.Person;
import com.sun.javafx.scene.control.skin.LabeledImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TestDB {

    public static void main(String[] args) {

//        Connection connection = DataBaseConnection.getDatabaseConnection();

        DataBaseServices dataBaseServices = new DataBaseServices();

        List<Book> books = dataBaseServices.showBooks();
        for(int i = 0; i < books.size(); ++i)
            System.out.println(books.get(i).toString());


        Book book = new Book("Teatru", "Caragiale", "Rao", 2001, 0, 60);
        boolean resp = dataBaseServices.addBook(book);
        System.out.println(resp);

        books = dataBaseServices.showBooks();
        for(int i = 0; i < books.size(); ++i)
            System.out.println(books.get(i).toString());

        boolean resp2 = dataBaseServices.deleteBooks(book);

//        books = dataBaseServices.showBooks();
//        for(int i = 0; i < books.size(); ++i)
//            System.out.println(books.get(i).toString());
        if (dataBaseServices.searchBook("Poezii", "Eminescu") != -1)
            System.out.println("search yes");
        else
            System.out.println("nu");

//        BookDao bookDao = BookDao.getInstance();
//        List<Book> books = bookDao.getAll();
//        System.out.println();

//        System.out.println(books);
//
//        Book book = new Book("Teatru", "Caragiale", "Rao", 2001, 0, 60);
//        System.out.println("if true then it happened: " + bookDao.create(book));
//
//        Optional<Book> ob = bookDao.getById("Poezii", "Emins");
//        Book bookob = ob.get();
//
//        books = bookDao.getAll();
//        System.out.println(books);
//
//        bookDao.delete(book);
//
//        books = bookDao.getAll();
//        System.out.println(books);
//
//        Client client = new Client(1, "Vali", 78);
//        Client client1 = new Client(2, "Pascariu", 100);
//
//        ClientDao clientDao = ClientDao.getInstance();
////        clientDao.create(client);
////        clientDao.create(client1);
//
//        List<Client> clients = clientDao.getAll();
//        System.out.println(clients);
//
//        clientDao.delete(client);
//
//        clients = clientDao.getAll();
//        System.out.println(clients);
//
////        System.out.println("from get: " + bookob);
    }

}
