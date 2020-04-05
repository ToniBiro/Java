package ex1.bookstore;

public final class Book {

    private final String title;
    private final String author;
    private final String publisher;
    private final int pageCount;

    public Book(String title, String author, String publisher, int pageCount) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pageCount = pageCount;
    }

    public String toString(){
        return "BOOK_TITLE: " + this.title.toUpperCase() + "\n" +
                "BOOK_AUTHOR: " + this.author + "\n"  +
                "BOOK_PUBLISHER: " + this.publisher.toLowerCase() + "\n";
    }

    public boolean equals(Object obj){
        if(obj instanceof Book){
            Book b = (Book) obj;
            return b.title.equals(this.title) && b.author.equals(this.author) && b.publisher.equals(this.publisher);
        }
        return false;
    }

    public int getPageCount() {
        return pageCount;
    }

}
