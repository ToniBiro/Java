package bookstore.dao;

import bookstore.book.Book;
import bookstore.person.Client;
import dataBase.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientDao implements Dao<Client> {

    // to add a client
    private static final String INSERT_SQL = "INSERT INTO clients VALUES(?, ?, ?)";
    // to find a client
    private static final String FIND_BY_ID_SQL = "SELECT * FROM clients WHERE name=?";
    // to delete a certain client
    private static final String DELETE_SQL = "DELETE FROM books WHERE client_name = ?;";
    private final Connection connection;
    private static volatile ClientDao instance;

    private ClientDao() {
        this.connection = DataBaseConnection.getDatabaseConnection();
    }

    public static ClientDao getInstance() {
        if (instance == null) {
            synchronized (BookDao.class) {
                if (instance == null) {
                    instance = new ClientDao();
                }
            }
        }
        return instance;
    }

    @Override
    public List<Client> getAll() {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM clients";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            // the iterator is like a cursor placed before first row
            while (rs.next()) { // returns true if a next row exists and moves to that row
                Client client = ClientDao.ClientRowMapper.mapRow(rs);
                clients.add(client);
                System.out.println(client);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return clients;
    }

    @Override
    public Optional<Client> getById(String title) {
        try {
            PreparedStatement ps = connection.prepareStatement(FIND_BY_ID_SQL);
            ps.setString(1, title);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Client client = ClientDao.ClientRowMapper.mapRow(rs);
                return Optional.of(client);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void update(Client client) {

    }

    @Override
    public boolean create(Client client) {
        return false;
    }

    @Override
    public boolean delete(Client client) {
        return false;
    }

    static class ClientRowMapper {
        public static Client mapRow(ResultSet rs) throws SQLException {
            int id = rs.getInt("idclient");
            String name = rs.getString("client_name");
            int money = rs.getInt("money");
            return new Client(id, name, money);
        }
    }
}
