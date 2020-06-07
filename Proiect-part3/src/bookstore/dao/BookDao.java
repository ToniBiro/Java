package bookstore.dao;

import bookstore.book.Book;
import dataBase.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDao implements Dao<Book> {
    // to add a book to the bookstore inventory (database)
    private static final String INSERT_SQL = "INSERT INTO books VALUES(?, ?, ?, ?, ?, ?, ?);";
    // to find a book from the inventory (database)
    private static final String FIND_BY_TITLE_SQL = "SELECT * FROM books WHERE book_title=? and book_author=?";
    // to delete a certain book from the inventory (database)
    private static final String DELETE_SQL = "DELETE FROM books WHERE book_title = ?;";
    private final Connection connection;
    private static volatile BookDao instance;

    private BookDao() {
        this.connection = DataBaseConnection.getDatabaseConnection();
    }

    public static BookDao getInstance() {
        if (instance == null) {
            synchronized (BookDao.class) {
                if (instance == null) {
                    instance = new BookDao();
                }
            }
        }
        return instance;
    }

    @Override
    public List<Book> getAll() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            // the iterator is like a cursor placed before first row
            while (rs.next()) { // returns true if a next row exists and moves to that row
                Book book = BookRowMapper.mapRow(rs);
                books.add(book);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return books;
    }

    @Override
    public Optional<Book> getById(String title, String author) {
        try {
            PreparedStatement ps = connection.prepareStatement(FIND_BY_TITLE_SQL);
            ps.setString(1, title);
            ps.setString(2, author);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Book book = BookRowMapper.mapRow(rs);
                return Optional.of(book);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public boolean create(Book book) {
        boolean rs = false;
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_SQL);
            ps.setInt(1, book.id);
            ps.setString(2, book.title);
            ps.setString(3, book.author);
            ps.setInt(4, book.year);
            ps.setString(5, book.publisher);
            ps.setFloat(6, book.price);
            ps.setInt(7, book.nrPurchases);
            rs = ps.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rs;
    }

    @Override
    public boolean delete(Book book) {
        boolean rs = false;
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_SQL);
            ps.setString(1, book.title);
            rs = ps.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rs;
    }

    @Override
    public void update(Book book) {

    }

    static class BookRowMapper {
        public static Book mapRow(ResultSet rs) throws SQLException {
            int id = rs.getInt("idbook");
            String title = rs.getString("book_title");
            String author = rs.getString("book_author");
            int year = rs.getInt("book_year");
            String publisher = rs.getString("publisher");
            int nrPurchases = rs.getInt("nr_purchases");
            int price = rs.getInt("book_price");
            return new Book(title, author, publisher, year, nrPurchases, price);
        }
    }
}
