package bookstore;

import bookstore.book.Book;
import bookstore.person.Employee;

public class EmployeeService {

    public static void showEmployees(Bookstore bs, Output output){
        System.out.println("Employee list: ");
        for(int i = 0; i < bs.index; ++i)
            System.out.println(bs.employees[i].toString());

        output.write("afisare_angajati");
    }

    public static void removeEmployee(Bookstore bs, Employee employee, Output output){
        bs.manager.removeEmployee(employee);
        System.out.println("Removed employee: " + employee.toString());
        showEmployees(bs, output);

        output.write("inlaturare_angajati");
    }

}
