package bookstore.person;

import bookstore.Bookstore;
import bookstore.book.Book;
import java.util.Random;

import java.util.List;

public class Client extends Person{

    public List<Book> purchaseHistory;
    private String authorInMind;
    private float money;

    public Client(int id, String name, float money) {
        super(id, name);
        this.money = money;
        this.type = "client";
        this.authorInMind = null;
    }

    public Client(int id, String name, float money, String authorInMind) {
        super(id, name);
        this.money = money;
        this.authorInMind = authorInMind;
    }

    @Override
    public String toString(){
        return super.toString() + " type: " + this.type;
    }

    public void buyBook(Bookstore bs){

        if(authorInMind != null){
            System.out.println("Yes, I have an author in mind!");
            if(buyFoundBook(authorInMind, bs)){
                System.out.println(this.toString() + " found the author that was on his mind: " + authorInMind.toString());
            }
        }
        else{
            buyFoundBook(this.findBook(bs).author, bs);
        }
    }

    public boolean buyFoundBook(String book, Bookstore bs){
        Book foundBook = bs.searchBook(book, this);
        if(foundBook != null){
            System.out.println("ce am gasit: " + foundBook);
            System.out.println("Found the book in my mind!");
            bs.money += foundBook.price;
            this.money -= foundBook.price;
            this.purchaseHistory.add(foundBook);

            foundBook.purchaseHistory.add(this);
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
