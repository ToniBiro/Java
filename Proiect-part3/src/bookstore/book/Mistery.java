package bookstore.book;

import bookstore.person.Client;

import java.util.List;

public class Mistery extends Book{


    public Mistery(String title, String author, String publisher, int year, int purchaseHistory, float price) {
        super(title, author, publisher, year, purchaseHistory, price);
        this.category = "mistery";
    }

    public Mistery(String title, String author) {
        super(title, author);
    }

    @Override
    public String toString(){
        return super.toString() + " category: " + this.category + ".\n";
    }

    public void findCategory(){
        System.out.println("The book " + this.title + " by " + this.author + " is from the " + this.category + " category");
    }
}
