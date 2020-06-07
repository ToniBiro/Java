package bookstore;

import bookstore.book.*;
import bookstore.person.Client;
import bookstore.person.Employee;
import bookstore.person.Manager;
import bookstore.person.Person;

import java.util.ArrayList;
import java.util.List;

public class AllServices {

    // Bookstore Services
    public static Bookstore createNewBookstore(Input input, Output output){

        List<String[]> bookstores = input.read("C:\\Users\\toni\\Documents\\GitHub\\Java\\Proiect-part1\\csvFiles\\bookstores.txt");

        String[] bookstore_aux = bookstores.get(0);

        List<Book> newBooks = new ArrayList<Book>();
        List<Client> newClients =  new ArrayList<Client>();
        Manager newManager = new Manager(Integer.parseInt(bookstore_aux[0]), bookstore_aux[1].toString());
        Bookstore bs = new Bookstore(newBooks,
                newClients,
                Integer.parseInt(bookstore_aux[2]),
                newManager,
                Integer.parseInt(bookstore_aux[3]));

        newManager.bs = bs;
        output.write("creare_bookstore");
        return bs;
    }

    public static void addBooks(Bookstore bs, Input input, Output output){

        List<String[]> books = input.read("C:\\Users\\toni\\Documents\\GitHub\\Java\\Proiect-part1\\csvFiles\\books.txt");

        for (int i = 0; i < books.size(); ++i){
//            List<Client> clients = new ArrayList<Client>();
            String[] book_aux = books.get(i);

            if(book_aux[0].toString().toLowerCase().equals("mistery")) {
                Book book = new Mistery(book_aux[1].toString(),
                        book_aux[2].toString(), book_aux[3].toString(),
                        Integer.parseInt(book_aux[4]),
                        0,
                        Integer.parseInt(book_aux[5]));
                bs.addBook(book);
            }

            if(book_aux[0].toString().toLowerCase().equals("hobby")) {
                Book book = new Hobby(book_aux[1].toString(),
                        book_aux[2].toString(), book_aux[3].toString(),
                        Integer.parseInt(book_aux[4]),
                        0,
                        Integer.parseInt(book_aux[5]));
                bs.addBook(book);
            }

            if(book_aux[0].toString().toLowerCase().equals("motivational")) {
                Book book = new Motivational(book_aux[1].toString(),
                        book_aux[2].toString(), book_aux[3].toString(),
                        Integer.parseInt(book_aux[4]),
                        0,
                        Integer.parseInt(book_aux[5]));
                bs.addBook(book);
            }

            if(book_aux[0].toString().toLowerCase().equals("horror")) {
                Book book = new Horror(book_aux[1].toString(),
                        book_aux[2].toString(), book_aux[3].toString(),
                        Integer.parseInt(book_aux[4]),
                        0,
                        Integer.parseInt(book_aux[5]));
                bs.addBook(book);
            }
        }
        output.write("adaugare_carti");
    }

    public static void bookstoreChangeStatus(Bookstore bs, Output output){
        System.out.println("Enter new status: ");
        bs.changeStatus();
        System.out.println("The manager changed the status");

        output.write("schimbare_status_firma");
    }

    public static void addEmployees(Bookstore bs, Input input, Output output){
        List<String[]> employees = input.read("C:\\Users\\toni\\Documents\\GitHub\\Java\\Proiect-part1\\csvFiles\\employees.txt");

        for (int i = 0; i < employees.size(); ++i){
            String[] employee_aux = employees.get(i);

            Employee employee = new Employee(Integer.parseInt(employee_aux[0]), employee_aux[1].toString());
            bs.manager.addEmployee(employee);
            System.out.println("Added new employee: " + employee.toString());
        }

        output.write("adaugare_angajati");
    }


    public static void addClients(Bookstore bs, Input input, Output output){
        // se va da si un input stream pentru citirea clientilor dintr-un csv
        List<String[]> clients = input.read("C:\\Users\\toni\\Documents\\GitHub\\Java\\Proiect-part1\\csvFiles\\clients.txt");
        BookService bookService = new BookService();

        for (int i = 0; i < clients.size(); ++i){
            String[] client_aux = clients.get(i);
            Client client;

            if (client_aux.length == 3) {
                client = new Client(Integer.parseInt(client_aux[0]), client_aux[1].toString(),
                        Integer.parseInt(client_aux[2]));
                bookService.buyBook(bs, client);
            }
            else{
                Book searchThis = new Book(client_aux[3].toString(), client_aux[4].toString());
                client = new Client(Integer.parseInt(client_aux[0]), client_aux[1].toString(),
                        Integer.parseInt(client_aux[2]));
                bookService.buyBook(bs, client);
            }
        }
        output.write("adaugare_clienti");
    }
}
