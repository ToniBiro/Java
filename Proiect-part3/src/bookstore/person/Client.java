package bookstore.person;

import bookstore.Bookstore;
import bookstore.book.Book;

import java.util.ArrayList;
import java.util.Random;

import java.util.List;

public class Client extends Person{

    public List<Book> purchaseHistory = new ArrayList<Book>();
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
        this.type = "client with a book in mind ";
        this.bookInMind = bookInMind;
    }

    @Override
    public String toString(){
        return " " + super.toString() + " type: " + this.type;
    }

    public void buyBook(Bookstore bs){

        if(bookInMind != null){
            System.out.println("Yes, I have an author in mind!");
            if(buyFoundBook(bookInMind, bs)){
                System.out.println(this.toString() + " found the author that was on his mind: " + bookInMind.toString());
            }
            else{
                System.out.println("Could not find the book :(");
            }
        }
        else{
            buyFoundBook(this.findBook(bs), bs);
        }
    }

    public boolean buyFoundBook(Book book, Bookstore bs){
        if(bs.searchBook(book, this)){
            System.out.println("Found the book in my mind!");
            bs.money += book.price;
            this.money -= book.price;
            this.purchaseHistory.add(book);

            return true;
        }
        return false;
    }

    public Book findBook(Bookstore bs){
        Random random = new Random();
        System.out.println("Choose random book.");
        return bs.books.get(random.nextInt(bs.books.size()-1));
    }
}
