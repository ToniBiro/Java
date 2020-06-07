package dataBase;

import bookstore.book.Book;
import bookstore.dao.BookDao;
import bookstore.dao.ClientDao;
import bookstore.dao.EmployeeDao;
import bookstore.person.Client;
import bookstore.person.Employee;

import java.util.List;
import java.util.Optional;

public class DataBaseServices {


    public List<Book> showBooks(){
        BookDao bookDao = BookDao.getInstance();
        List<Book> books = bookDao.getAll();

        return books;
    }

    public boolean addBook(Book book){
        BookDao bookDao = BookDao.getInstance();
        return bookDao.create(book);
    }

    public boolean deleteBooks(Book book){
        BookDao bookDao = BookDao.getInstance();
        return bookDao.delete(book);
    }

    public int searchBook(String title, String author){

        BookDao bookDao = BookDao.getInstance();
        Optional<Book> book = bookDao.getById(title, author);
        if(book.isPresent())
            return book.get().getId();
        else
            return -1;
    }

    public List<Client> showClients(){
        ClientDao clientDao = ClientDao.getInstance();
        return clientDao.getAll();
    }

    public boolean addClient(Client client){

        ClientDao clientDao = ClientDao.getInstance();
        return clientDao.create(client);
    }

    public boolean deleteClients(Client client){

        ClientDao clientDao = ClientDao.getInstance();
        if(clientDao.getById(client.name, "aux").isPresent()){
            return clientDao.delete(client);
        }
        return clientDao.delete(client);
    }

    public List<Employee> showEmployees(){
        EmployeeDao employeeDao = EmployeeDao.getInstance();
        return employeeDao.getAll();
    }

    public boolean createEmployee(Employee employee){
        EmployeeDao employeeDao = EmployeeDao.getInstance();
        return employeeDao.create(employee);
    }

    public boolean deleteEmployee(Employee employee){
        EmployeeDao employeeDao = EmployeeDao.getInstance();
        if(employeeDao.getById(employee.name, "aux").isPresent()){
            return employeeDao.delete(employee);
        }
        else{
            return false;
        }
    }
}
