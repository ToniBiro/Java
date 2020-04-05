package bookstore.person;

import bookstore.book.Book;

import java.util.List;

public class Client extends Person{

    public List<Book> purchaseHistory;

    public Client(int id, String name) {
        super(id, name);
        this.type = "client";
    }

    @Override
    public String toString(){
        return super.toString() + " type: " + this.type;
    }
}
