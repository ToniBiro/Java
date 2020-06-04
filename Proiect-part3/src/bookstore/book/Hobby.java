package bookstore.book;

import bookstore.person.Client;

import java.util.List;

public class Hobby extends Book{

    public Hobby(String title, String author, String publisher, int year, List<Client> purchaseHistory, float price) {
        super(title, author, publisher, year, purchaseHistory, price);
        this.category = "hobby";
    }


    @Override
    public String toString(){
        return super.toString() + " category: " + this.category + ".\n";
    }

    public void findCategory(){
        System.out.println("The book " + this.title + " by " + this.author + " is from the " + this.category + " category");
    }
}
