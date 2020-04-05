package bookstore.book;

import bookstore.person.Client;

import java.util.List;

public abstract class Book implements Comparable<Book>{

    public String title;
    public String author;
    public String publisher;
    public int year;
    public int id;
    public List<Client> purchaseHistory;
    protected String category;

    public float price;

    public Book(String title, String author, String publisher, int year, List<Client> purchaseHistory, float price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.id = hashCode();
        this.purchaseHistory = purchaseHistory;
        this.price = price;
    }

    public Book(String title, String author, String publisher, int year, List<Client> purchaseHistory) {
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }

    public void viewPurchaseHistory(){
        System.out.println("Purchase History Clients: " + this.purchaseHistory);
    }

    @Override
    public String toString() {
        return "Book {" +
                "title: " + this.title +
                ", author: " + this.author +
                ", publisher: " + this.publisher +
                ", year: " + this.year +
                '}';
    }

    @Override
    public int compareTo(Book b) {
        return this.getTitle().compareTo(b.getTitle());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book) {
            Book book = (Book) obj;
            return this.getTitle().equals(book.getTitle()) && this.getAuthor().equals(book.getAuthor());
        }
        return false;
    }

}
