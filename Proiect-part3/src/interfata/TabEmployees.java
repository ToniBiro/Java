package interfata;

import javax.swing.*;

public class TabEmployees extends JPanel {

    private JButton addButton;
    private JButton deleteButton;
    private JButton searchButton;

    public TabEmployees() {

        this.addButton = new JButton("Add Book");
        this.deleteButton = new JButton("Delete Book");
        this.searchButton = new JButton("Search");

        add(addButton);
        add(deleteButton);
        add(searchButton);
    }
}
