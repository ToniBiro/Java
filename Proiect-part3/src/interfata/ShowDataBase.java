package interfata;

import bookstore.book.Book;
import bookstore.person.Client;
import bookstore.person.Employee;
import dataBase.DataBaseServices;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ShowDataBase extends JPanel implements ActionListener {

    private JTabbedPane tabs;
    private JPanel showTab;
    public JTextArea textArea;
    private JButton booksButton, employeesButton, clientsButton;
    private TypingListener typingListener;

    public ShowDataBase() {
        setLayout(new BorderLayout());

        this.tabs = new JTabbedPane();
        this.showTab = new JPanel();
        this.textArea = new JTextArea("See the DataBase Here.", 15, 60);

        JPanel buttons = new JPanel();
        this.booksButton = new JButton("See Books");
        booksButton.addActionListener(this);
        this.clientsButton = new JButton("See Clients");
        clientsButton.addActionListener(this);
        this.employeesButton = new JButton("See Employees");
        employeesButton.addActionListener(this);
        buttons.add(booksButton);
        buttons.add(employeesButton);
        buttons.add(clientsButton);

        buttons.setLayout(new BoxLayout(buttons, BoxLayout.PAGE_AXIS));
        showTab.add(buttons);

        this.showTab.add(new JScrollPane(textArea), BorderLayout.NORTH);
        this.tabs.add("DataBase", showTab);
        add(tabs);


    }

    @Override
    public void actionPerformed(ActionEvent e){
        DataBaseServices dataBaseServices = new DataBaseServices();

        JButton clicked = (JButton) e.getSource();
        if (clicked == booksButton) {
            List<Book> books = dataBaseServices.showBooks();
            this.typingListener.textTyped("\n----Books----\n");
            for(int i = 0; i < books.size(); ++i) {
                this.typingListener.textTyped(books.get(i).toString() + "\n");
            }
            this.typingListener.textTyped("\n");

        } else if (clicked == employeesButton) {
            List<Employee> employees = dataBaseServices.showEmployees();
            this.typingListener.textTyped("\n----Employees----\n");
            for(int i = 0; i < employees.size(); ++i) {
                this.typingListener.textTyped(employees.get(i).toString() + "\n");
            }
            this.typingListener.textTyped("\n");

        } else if (clicked == clientsButton) {
            List<Client> clients = dataBaseServices.showClients();
            this.typingListener.textTyped("\n----Clients----\n");
            for(int i = 0; i < clients.size(); ++i) {
                this.typingListener.textTyped(clients.get(i).toString() + "\n");
            }
            this.typingListener.textTyped("\n");
        }
    }

    public TypingListener getTypingListener() {
        return typingListener;
    }

    public void setTypingListener(TypingListener typingListener) {
        this.typingListener = typingListener;
    }

}
