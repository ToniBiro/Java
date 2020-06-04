package bookstore;

import bookstore.book.*;
import bookstore.person.Client;
import bookstore.person.Employee;
import bookstore.person.Manager;
import bookstore.person.Salesman;

import java.util.*;


//clasele Book, Person, Employee pot fi concrete (nu au metode abstracte) - DONE
//-------------------------------------------------------------------------------------------------------------------------
// ai folosit doar un array, in rest ai apelat la colectii (este ok sa le pastrezi
// mai departe, intre timp am facut trecerea la colectii la laborator)
//-------------------------------------------------------------------------------------------------------------------------
//ai putea crea clase distincte de servicii pentru o clasa sau clase (model de obiecte)
//care impreuna definesc o functionalitate unitara (de ex: BookService care sa aiba metode
// precum void buyBook(Bookstore bs), boolean buyFoundBook(Book book, Bookstore bs),
// Book findBook(Bookstore bs), apoi EmployeeService, BookStoreService(este deja definita ca Bookstore) s.a.m.d.)
//-------------------------------------------------------------------------------------------------------------------------
//iti recomand sa creezi o clasa distincta care sa contina toate metodele (precum createNewBookstore() din BookStoreTest)
//definite pentru "initializarea" datelor din aplicatie;
//-------------------------------------------------------------------------------------------------------------------------
//clasa "client" BookstoreTest ar trebui sa contina doar niste apeluri de metode externe;

public class BookstoreTest {

    public static void main(String[] args) {

        // definire un input stream si output stream pentru citire a datelor din csv
        Input input = Input.getInstance();

        AllServices allServices = new AllServices();

        Bookstore carturesti = allServices.createNewBookstore(input);

        BookService bookService = new BookService();

        EmployeeService employeeService = new EmployeeService();

        // add books in the Bookstore
        allServices.addBooks(carturesti, input);



//        Client client1 = new Client(2, "Gigel", 1000);
//        // client that buys a randomly generated book
//        client1.buyBook(carturesti);


        // client that buys a book he/she was looking for
//        Book searchThis = new Mistery("Poezii", "Eminescu");
//        Client client2 = new Client(3, "Anca", 200, searchThis);
//        client2.buyBook(carturesti);
        allServices.addClients(carturesti, input);


        // add employees
//        Employee emplyee1 = new Salesman(4, "Maria");
//        carturesti.manager.addEmployee(emplyee1);
//        System.out.println("Added new employee: " + emplyee1.toString());
        allServices.addEmployees(carturesti, input);

//        System.out.println("Employee list: ");
//        for(int i = 0; i < carturesti.index; ++i)
//            System.out.println(carturesti.employees[i].toString());

        employeeService.showEmployees(carturesti);


        //remove employees
//        carturesti.manager.removeEmployee(emplyee1);
//        System.out.println("Removed employee: " + emplyee1.toString());
//        System.out.println("Employee list: ");
//        for(int i = 0; i < carturesti.index; ++i)
//            System.out.println(carturesti.employees[i].toString());
        employeeService.removeEmployee(carturesti, carturesti.employees[0]);


        //show bookstore's inventory
        carturesti.showInventory();

        // show purchase history of all books in inventory
        carturesti.seePurchaseHistory();

        // view clients info of all the clients
        carturesti.seeClientsInfo();

        // change status as manager
        allServices.bookstoreChangeStatus(carturesti);

    }

}
