package interfata;

import javax.swing.*;

public class TabClients extends JPanel{

    private JButton addButton;
    private JButton deleteButton;
    private JButton searchButton;

    public TabClients() {

        this.addButton = new JButton("Add Client");
        this.deleteButton = new JButton("Delete Client");
        this.searchButton = new JButton("Search");

        add(addButton);
        add(deleteButton);
        add(searchButton);
    }
}
