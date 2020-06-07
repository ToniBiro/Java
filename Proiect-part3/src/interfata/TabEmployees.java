package interfata;

import bookstore.person.Employee;
import dataBase.DataBaseServices;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TabEmployees extends JPanel implements ActionListener {

    private JButton addButton;
    private JButton deleteButton;
    private JTextField addNameField, addIdField;
    private JTextField deleteNameField, deleteIdField;
    public TypingListener typingListener;

    public TabEmployees() {

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        // Add Employee
        this.addButton = new JButton("Add Employee");

        JPanel addEmployee = new JPanel();

        addEmployee.add(new JLabel("Full Name: "));
        addNameField = new JTextField(5);
        addEmployee.add(addNameField);

        addEmployee.add(new JLabel("Id: "));
        addIdField = new JTextField(5);
        addEmployee.add(addIdField);
        addEmployee.add(addButton);
        addEmployee.setLayout(new FlowLayout(FlowLayout.LEFT));
        add(addEmployee);
        addButton.addActionListener(this);

        // delete Employee
        this.deleteButton = new JButton("Delete Employee");

        JPanel deleteEmployee = new JPanel();
        deleteEmployee.setLayout(new FlowLayout(FlowLayout.LEFT));

        deleteEmployee.add(new JLabel("Full Name: "));
        deleteNameField = new JTextField(5);
        deleteEmployee.add(deleteNameField);

        deleteEmployee.add(new JLabel("Id: "));
        deleteIdField = new JTextField(5);
        deleteEmployee.add(deleteIdField);

        deleteEmployee.add(deleteButton);
        add(deleteEmployee);
        deleteButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DataBaseServices dataBaseServices = new DataBaseServices();

        JButton clicked = (JButton) e.getSource();
        if (clicked == addButton) {
            Employee employee = new Employee(
                    Integer.parseInt(addIdField.getText()),
                    addNameField.getText()
            );
            dataBaseServices.createEmployee(employee);
        } else if (clicked == deleteButton){
            Employee employee = new Employee(
                    Integer.parseInt(deleteIdField.getText()),
                    deleteNameField.getText()
            );
            dataBaseServices.deleteEmployee(employee);
        }
    }

    public TypingListener getTypingListener() {
        return typingListener;
    }

    public void setTypingListener(TypingListener typingListener) {
        this.typingListener = typingListener;
    }
}
