package bookstore;

import bookstore.book.*;
import bookstore.person.Client;
import bookstore.person.Employee;
import bookstore.person.Manager;
import bookstore.person.Salesman;

import java.util.*;

public class BookstoreTest {

    public static void main(String[] args) {

        // definire un input stream si output stream pentru citire a datelor din csv
        Input input = Input.getInstance();
        Output output = Output.getInstance();
        output.setOutputFile("C:\\Users\\toni\\Documents\\GitHub\\Java\\Proiect-part3\\actionsOutput.txt");

        AllServices allServices = new AllServices();
        Bookstore carturesti = allServices.createNewBookstore(input, output);
        BookService bookService = new BookService();
        EmployeeService employeeService = new EmployeeService();

        // add books in the Bookstore
        allServices.addBooks(carturesti, input, output);

        // add all new clients to the database of the bookstore
        allServices.addClients(carturesti, input, output);

        // add employees
        allServices.addEmployees(carturesti, input, output);

        // show all employees from the bookstore's database
        employeeService.showEmployees(carturesti, output);

        //remove employees
        employeeService.removeEmployee(carturesti, carturesti.employees[0], output);

        //show bookstore's inventory
        carturesti.showInventory(output);

        // show purchase history of all books in inventory
        carturesti.seePurchaseHistory(output);

        // view clients info of all the clients
        carturesti.seeClientsInfo(output);

        // change status as manager
        allServices.bookstoreChangeStatus(carturesti, output);
    }

}
