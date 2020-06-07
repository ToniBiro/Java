package bookstore.dao;

import bookstore.person.Employee;
import dataBase.DataBaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeDao implements Dao<Employee> {

    // to add a employee
    private static final String INSERT_SQL = "INSERT INTO employees VALUES(?, ?);";
    // to find a employee
    private static final String FIND_BY_ID_SQL = "SELECT * FROM employees WHERE name=?;";
    // to delete a certain employee
    private static final String DELETE_SQL = "DELETE FROM employees WHERE employee_name = ?;";
    private final Connection connection;
    private static volatile EmployeeDao instance;

    private EmployeeDao() {
        this.connection = DataBaseConnection.getDatabaseConnection();
    }

    public static EmployeeDao getInstance() {
        if (instance == null) {
            synchronized (BookDao.class) {
                if (instance == null) {
                    instance = new EmployeeDao();
                }
            }
        }
        return instance;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            // the iterator is like a cursor placed before first row
            while (rs.next()) { // returns true if a next row exists and moves to that row
                Employee employee = EmployeeDao.EmployeeRowMapper.mapRow(rs);
                employees.add(employee);
                System.out.println(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employees;
    }

    @Override
    public Optional<Employee> getById(String name, String aux) {
        try {
            PreparedStatement ps = connection.prepareStatement(FIND_BY_ID_SQL);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Employee employee = EmployeeDao.EmployeeRowMapper.mapRow(rs);
                return Optional.of(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void update(Employee employee) {
    }

    @Override
    public boolean create(Employee employee) {
        boolean rs = false;
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_SQL);
            ps.setInt(1, employee.id);
            ps.setString(2, employee.name);
            rs = ps.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rs;
    }

    @Override
    public boolean delete(Employee employee) {
        boolean rs = false;
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_SQL);
            ps.setString(1, employee.name);
            rs = ps.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rs;
    }

    static class EmployeeRowMapper {
        public static Employee mapRow(ResultSet rs) throws SQLException {
            int id = rs.getInt("idemployee");
            String name = rs.getString("employee_name");
            return new Employee(id, name);
        }
    }
}
