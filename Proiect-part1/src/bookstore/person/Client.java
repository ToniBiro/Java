package bookstore.person;

import bookstore.Bookstore;
import bookstore.book.Book;
import java.util.Random;

import java.util.List;

public class Client extends Person{

    public List<Book> purchaseHistory;
    private Book bookInMind;
    private float money;

    public Client(int id, String name, float money) {
        super(id, name);
        this.money = money;
        this.type = "client";
        this.bookInMind = null;
    }

    public Client(int id, String name, float money, Book bookInMind) {
        super(id, name);
        this.money = money;
        this.bookInMind = bookInMind;
    }

    @Override
    public String toString(){
        return super.toString() + " type: " + this.type;
    }

    public void buyBook(Bookstore bs){

        if(bookInMind != null){
            if(buyFoundBook(bookInMind, bs)){
                System.out.println(this.toString() + " found the book that was on his mind: " + bookInMind.toString());
            }
        }
        else{
            buyFoundBook(this.findBook(bs), bs);
        }
    }

    public boolean buyFoundBook(Book book, Bookstore bs){
        if(bs.searchBook(book, this)){
            bs.money += bookInMind.price;
            this.money -= bookInMind.price;

            book.purchaseHistory.add(this);
            return true;
        }
        return false;
    }

    public Book findBook(Bookstore bs){
        Random random = new Random();
        return bs.books.get(random.nextInt(bs.books.size()));
    }
}
