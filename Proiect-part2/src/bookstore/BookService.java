package bookstore;

import bookstore.book.Book;
import bookstore.person.Client;

public class BookService {

    public static void buyBook(Bookstore bs, Client client){
        client.buyBook(bs);
    }
}
