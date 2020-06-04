package dataBase;

import bookstore.book.Book;
import bookstore.dao.BookDao;
import bookstore.dao.ClientDao;
import bookstore.person.Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TestDB {

    public static void main(String[] args) {

//        Connection connection = DataBaseConnection.getDatabaseConnection();

        BookDao bookDao = BookDao.getInstance();
        List<Book> books = bookDao.getAll();

        System.out.println(books);

        Book book = new Book("Teatru", "Caragiale", "Rao", 2001, 0, 60);
        System.out.println("if true then it happened: " + bookDao.create(book));

        Optional<Book> ob = bookDao.getById("Poezii");
        Book bookob = ob.get();

        books = bookDao.getAll();
        System.out.println(books);

        bookDao.delete(book);

        books = bookDao.getAll();
        System.out.println(books);

        ClientDao clientDao = ClientDao.getInstance();

        List<Client> clients = clientDao.getAll();
        System.out.println(clients);


//        System.out.println("from get: " + bookob);
    }

}
