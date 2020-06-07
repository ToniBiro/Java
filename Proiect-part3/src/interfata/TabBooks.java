package interfata;

import bookstore.book.Book;
import bookstore.person.Client;
import bookstore.person.Employee;
import dataBase.DataBaseServices;
import sun.plugin2.os.windows.FLASHWINFO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TabBooks extends JPanel implements ActionListener {

    private JButton addButton;
    private JButton deleteButton;
    private JButton searchButton;
    private JTextField addBookTitleField, addBookAuthorField, addBookYearField, addPublisherField, addPriceField;
    private JTextField deleteBookTitleField, deleteBookAuthorField, deleteBookYearField, deletePublisherField, deletePriceField;
    private JTextField searchTitle, searchAuhor;
    private TypingListener typingListener;
    public JTextArea searchAnswere;

    public TabBooks() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        this.addButton = new JButton("Add Book");
        this.deleteButton = new JButton("Delete Book");
        this.searchButton = new JButton("Search");

        // Add Book
        JPanel addBook = new JPanel();
        addBook.setLayout(new FlowLayout(FlowLayout.LEFT));

        addBook.add(new JLabel("Title: "));
        this.addBookTitleField = new JTextField(7);
        addBook.add(this.addBookTitleField);
        addBook.add(new JLabel("Author: "));
        this.addBookAuthorField = new JTextField(7);
        addBook.add(this.addBookAuthorField);
        addBook.add(new JLabel("Year: "));
        this.addBookYearField= new JTextField(3);
        addBook.add(this.addBookYearField);
        addBook.add(new JLabel("Publisher: "));
        this.addPublisherField= new JTextField(5);
        addBook.add(this.addPublisherField);
        addBook.add(new JLabel("Price: "));
        this.addPriceField= new JTextField(3);
        addBook.add(this.addPriceField);

        addBook.add(addButton);
        add(addBook);
        addButton.addActionListener(this);

        // Delete Book
        JPanel deleteBook = new JPanel();
        deleteBook.setLayout(new FlowLayout(FlowLayout.LEFT));
        deleteBook.add(new JLabel("Title: "));
        this.deleteBookTitleField = new JTextField(7);
        deleteBook.add(this.deleteBookTitleField);
        deleteBook.add(new JLabel("Author: "));
        this.deleteBookAuthorField = new JTextField(7);
        deleteBook.add(this.deleteBookAuthorField);
        deleteBook.add(new JLabel("Year: "));
        this.deleteBookYearField= new JTextField(3);
        deleteBook.add(this.deleteBookYearField);
        deleteBook.add(new JLabel("Publisher: "));
        this.deletePublisherField= new JTextField(5);
        deleteBook.add(this.deletePublisherField);
        deleteBook.add(new JLabel("Price: "));
        this.deletePriceField= new JTextField(3);
        deleteBook.add(this.deletePriceField);

        deleteBook.add(deleteButton);
        add(deleteBook);
        deleteButton.addActionListener(this);

        // Search book
        JPanel searchBook = new JPanel();
        searchBook.add(new JLabel("Title: "));
        this.searchTitle = new JTextField(7);
        searchBook.add(searchTitle);

        searchBook.add(new JLabel("Author: "));
        this.searchAuhor = new JTextField(7);
        searchBook.add(searchAuhor);
        searchBook.setLayout(new FlowLayout(FlowLayout.LEFT));
        searchBook.add(searchButton);
        searchAnswere = new JTextArea(1, 5);
        searchBook.add(searchAnswere);
        add(searchBook);
        searchButton.addActionListener(this);
    }

    public TypingListener getTypingListener() {
        return typingListener;
    }

    public void setTypingListener(TypingListener typingListener) {
        this.typingListener = typingListener;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        DataBaseServices dataBaseServices = new DataBaseServices();

        JButton clicked = (JButton) e.getSource();
        if (clicked == addButton) {
            Book book = new Book(
                    addBookTitleField.getText(),
                    addBookAuthorField.getText(),
                    addPublisherField.getText(),
                    Integer.parseInt(addBookYearField.getText()),
                    0,
                    Integer.parseInt(addPriceField.getText())
            );
            dataBaseServices.addBook(book);

        } else if (clicked == deleteButton) {
            if(dataBaseServices.searchBook(addBookTitleField.getText(), addBookAuthorField.getText()) != -1){
                Book book = new Book(
                        addBookTitleField.getText(),
                        addBookAuthorField.getText(),
                        addPublisherField.getText(),
                        Integer.parseInt(addBookYearField.getText()),
                        0,
                        Integer.parseInt(addPriceField.getText())
                );
                dataBaseServices.deleteBooks(book);
            }

        } else if (clicked == searchButton) {
            if(dataBaseServices.searchBook(searchTitle.getText(), searchAuhor.getText()) == -1){
                this.typingListener.textTyped("No:(");
            }
            else{
                this.typingListener.textTyped("Yes!");
            }
        }


    }
}
