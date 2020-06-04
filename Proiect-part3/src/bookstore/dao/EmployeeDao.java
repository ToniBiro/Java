//package bookstore.dao;
//
//import bookstore.book.Book;
//import bookstore.person.Employee;
//import dataBase.DataBaseConnection;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//public class EmployeeDao implements Dao<Employee> {
//
//    // to add a book to the bookstore inventory (database)
//    private static final String INSERT_SQL = "INSERT INTO employees VALUES (?,?)";
//    // to find a book from the inventory (database)
//    private static final String FIND_BY_ID_SQL = "SELECT * FROM employees WHERE name=?";
//    private final Connection connection;
//    private static volatile BookDao instance;
//
//    private BookDao() {
//        this.connection = DataBaseConnection.getDatabaseConnection();
//    }
//
//    public static BookDao getInstance() {
//        if (instance == null) {
//            synchronized (BookDao.class) {
//                if (instance == null) {
//                    instance = new BookDao();
//                }
//            }
//        }
//        return instance;
//    }
//
//    @Override
//    public List<Book> getAll() {
//        List<Book> books = new ArrayList<>();
//        String sql = "select * from books";
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery(sql);
//            // the iterator is like a cursor placed before first row
//            while (rs.next()) { // returns true if a next row exists and moves to that row
//                Book book = BookDao.UserRowMapper.mapRow(rs);
//                books.add(book);
//                System.out.println(book);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return books;
//    }
//
//    @Override
//    public Optional<Book> getById(String title) {
//        try {
//            PreparedStatement ps = connection.prepareStatement(FIND_BY_ID_SQL);
//            ps.setString(1, title);
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                Book book = BookDao.UserRowMapper.mapRow(rs);
//                return Optional.of(book);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return Optional.empty();
//    }
//
//    @Override
//    public void update(Book user) {
//
//    }
//
//    @Override
//    public void save(Book user) {
//
//    }
//
//    @Override
//    public void delete(Book user) {
//
//    }
//
//    static class UserRowMapper {
//        public static Book mapRow(ResultSet rs) throws SQLException {
//            int id = rs.getInt("idbook");
//            String title = rs.getString("book_title");
//            String author = rs.getString("book_author");
//            String year = rs.getString("book_year");
//            String category = rs.getString("book_category");
//            String publishing = rs.getString("publishing");
//            return new Book();
//        }
//    }
//}
