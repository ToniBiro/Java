package interfata;

import javax.swing.*;
import java.awt.*;

public class AlterDataBase extends JPanel {

    private JTabbedPane mainTabbesPane;
    public TabBooks tabBooks;
    private TabEmployees tabEmployee;
    private TabClients tabClients;

    public AlterDataBase() {
        setLayout(new BorderLayout());

        this.mainTabbesPane = new JTabbedPane();

        this.tabBooks = new TabBooks();
        this.tabEmployee = new TabEmployees();
        mainTabbesPane.add("Books", new JScrollPane(tabBooks));
        mainTabbesPane.add("Employees", new JScrollPane(tabEmployee));
        mainTabbesPane.add("Clients", new JScrollPane(tabClients));

        add(mainTabbesPane);
    }
}
