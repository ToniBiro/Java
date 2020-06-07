package interfata;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{

    private ShowDataBase showDataBase;
    private AlterDataBase alterDataBase;

    public MainFrame(){
        super("Final project");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(1000, 700);

        showDataBase = new ShowDataBase();
        add(new JScrollPane(showDataBase), BorderLayout.NORTH);

        showDataBase.setTypingListener(text -> showDataBase.textArea.append(text));

        alterDataBase = new AlterDataBase();
        add(new JScrollPane(alterDataBase), BorderLayout.CENTER);

        alterDataBase.tabBooks.setTypingListener(text -> alterDataBase.tabBooks.searchAnswere.append(text));

        setVisible(true);
    }
}
