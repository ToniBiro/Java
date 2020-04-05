package ex1.bookstore;

public class BookstoreCheck {

    public static boolean dubluExemplar(Book book, Book[] books){
        for(Book b : books){
            if(b.equals(book)) return true;
        }
        return false;
    }

    public static Book grosime(Book book1, Book book2){
        if(book1.getPageCount() >= (book2.getPageCount())){
            return book1;
        }
        else{
            return book2;
        }
    }
}
