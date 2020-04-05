package bookstore.book;

import bookstore.person.Client;

import java.util.List;

public class Mistery extends Book{


    public Mistery(String title, String author, String publisher, int year, List<Client> purchaseHistory) {
        super(title, author, publisher, year, purchaseHistory);
        this.category = "mistery";
    }


    @Override
    public String toString(){
        return super.toString() + " category: " + this.category + ".\n";
    }

    public void findCategory(){
        System.out.println("The book " + this.title + " by " + this.author + " is from the " + this.category + " category");
    }

}
