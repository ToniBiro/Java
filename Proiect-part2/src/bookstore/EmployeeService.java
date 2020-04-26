package bookstore;

import bookstore.book.Book;
import bookstore.person.Employee;

public class EmployeeService {

    public static void showEmployees(Bookstore bs){
        System.out.println("Employee list: ");
        for(int i = 0; i < bs.index; ++i)
            System.out.println(bs.employees[i].toString());
    }

    public static void removeEmployee(Bookstore bs, Employee employee){
        bs.manager.removeEmployee(employee);
        System.out.println("Removed employee: " + employee.toString());
        showEmployees(bs);
    }
}
