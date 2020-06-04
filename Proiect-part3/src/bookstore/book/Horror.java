package bookstore.book;

import bookstore.person.Client;

import java.util.List;

public class Horror extends Book{

    public Horror(String title, String author, String publisher, int year, List<Client> purchaseHistory, float price) {
        super(title, author, publisher, year, purchaseHistory, price);
        this.category = "horror";
    }


    @Override
    public String toString(){
        return super.toString() + " category: " + this.category + ".\n";
    }

    public void findCategory(){
        System.out.println("The book " + this.title + " by " + this.author + " is from the " + this.category + " category");
    }
}
