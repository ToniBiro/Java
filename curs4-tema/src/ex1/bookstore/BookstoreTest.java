package ex1.bookstore;

import java.util.Scanner;

public class BookstoreTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Max nr of books: ");
        int nrBooks = scanner.nextInt();


        int indexCurent = 0;

        Book[] books = new Book[nrBooks];

        //new book
        books[indexCurent] = create(scanner);
        if(indexCurent < nrBooks-1) indexCurent++;
        else{
            System.out.println("max nr of books has been reached.\n");
        }
        read(books[0]);
        books[indexCurent] = create(scanner);
        if(indexCurent < nrBooks-1) indexCurent++;
        else{
            System.out.println("max nr of books has been reached.\n");
        }

//        books[indexCurent++] = create(scanner);

        scanner.close();

        if(BookstoreCheck.dubluExemplar(books[0], books)){
            System.out.println(books[0].toString() + " apare de doua ori in bookstore.");
        }

        System.out.println(BookstoreCheck.grosime(books[0], books[1]));
    }

    public static Book create(Scanner scanner){

        System.out.println("title: ");
        String title = scanner.next();
        System.out.println("author: ");
        String author = scanner.next();
        System.out.println("publisher: ");
        String publisher = scanner.next();
        System.out.println("pageCount: ");

        int pageCount = scanner.nextInt();

        if(pageCount == 0){
            System.out.println("Numarul de pagini introdus este gresit.");
        }
        else {
            pageCount = -1;
        }

        return new Book(title, author, publisher, pageCount);
    }

    public static void read(Book b){
        System.out.println(b.toString());
    }

    public static void upload(Book book, Book[] books, int indexCurent, int nrBooks){
        if(indexCurent < nrBooks){
            books[indexCurent] = book;
        }
        else{
            System.out.println("Bookstore full!");
        }
    }

    public static int delete(Book book, Book[] books){
        for(int i = 0; i < books.length; ++i){
            if(books[i].equals(book)){
                System.out.println("\nam gasit cartea si urmeaza sa o sterg\n");
            }
        }
        return -1;
    }


}
