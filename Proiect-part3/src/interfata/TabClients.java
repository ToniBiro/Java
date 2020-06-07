package interfata;

import bookstore.person.Client;
import bookstore.person.Employee;
import dataBase.DataBaseServices;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TabClients extends JPanel implements ActionListener {

    private JButton addButton;
    private JButton deleteButton;
    private JButton searchButton;
    private JTextField addNameFiled, addIdField, addMoneyField;
    private JTextField deleteNameFiled, deleteIdField, deleteMoneyField;
    public TypingListener typingListener;

    public TabClients() {

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        // Add Clients
        this.addButton = new JButton("Add Client");

        JPanel addClient = new JPanel();
        addClient.add(new JLabel("Full Name: "));
        addNameFiled = new JTextField(7);
        addClient.add(addNameFiled);
        addClient.add(new JLabel("Id: "));
        addIdField = new JTextField(5);
        addClient.add(addIdField);
        addClient.add(new JLabel("Money: "));
        addMoneyField = new JTextField(5);
        addClient.add(addMoneyField);

        addClient.add(addButton);
        add(addClient);
        addClient.setLayout(new FlowLayout(FlowLayout.LEFT));
        addButton.addActionListener(this);

        // Delete Client
        this.deleteButton = new JButton("Delete Client");

        JPanel deleteClient = new JPanel();
        deleteClient.add(new JLabel("Full Name: "));
        deleteNameFiled = new JTextField(7);
        deleteClient.add(deleteNameFiled);
        deleteClient.add(new JLabel("Id: "));
        deleteIdField = new JTextField(5);
        deleteClient.add(deleteIdField);
        deleteClient.add(new JLabel("Money: "));
        deleteMoneyField = new JTextField(5);
        deleteClient.add(deleteMoneyField);

        deleteClient.add(deleteButton);
        add(deleteClient);
        deleteClient.setLayout(new FlowLayout(FlowLayout.LEFT));
        deleteButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DataBaseServices dataBaseServices = new DataBaseServices();

        JButton clicked = (JButton) e.getSource();
        if (clicked == addButton) {
            Client client = new Client(
                    Integer.parseInt(addIdField.getText()),
                    addNameFiled.getText(),
                    Integer.parseInt(addMoneyField.getText())
            );
            dataBaseServices.addClient(client);
        } else if (clicked == deleteButton){
            Client client = new Client(
                    Integer.parseInt(addIdField.getText()),
                    addNameFiled.getText(),
                    Integer.parseInt(addMoneyField.getText())
            );
            dataBaseServices.deleteClients(client);
        }
    }

    public TypingListener getTypingListener() {
        return typingListener;
    }

    public void setTypingListener(TypingListener typingListener) {
        this.typingListener = typingListener;
    }
}
