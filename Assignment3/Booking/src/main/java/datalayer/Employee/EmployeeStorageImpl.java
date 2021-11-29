package datalayer.Employee;

import dto.Booking;
import dto.Customer;
import dto.Employee;
import dto.EmployeeCreation;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class EmployeeStorageImpl implements EmployeeStorage{

    private String connectionString;
    private String username, password;

    public EmployeeStorageImpl(String conStr, String user, String pass){
        connectionString = conStr;
        username = user;
        password = pass;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionString, username, password);
    }

    @Override
    public int createEmployee(EmployeeCreation employeeCreation) throws SQLException {
        var sql = "insert into Employees(firstname, lastname) values (?, ?)";
        try (var con = getConnection();
             var stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, employeeCreation.getFirstName());
            stmt.setString(2, employeeCreation.getLastName());
            stmt.executeUpdate();

            // get the newly created id
            try (var resultSet = stmt.getGeneratedKeys()) {
                resultSet.next();
                int newId = resultSet.getInt(1);
                return newId;
            }
        }
    }

    @Override
    public Collection<Employee> getEmployeeWithId(int employeeId) throws SQLException {
        var sql = "select * from Employees where ID = ?";
        try (var con = getConnection();
             var stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, employeeId);
            var results = new ArrayList<Employee>();

            try (var resultSet = stmt.executeQuery()) {
                while (resultSet.next()){
                    var id = resultSet.getInt("ID");
                    var firstName = resultSet.getString("firstname");
                    var lastName = resultSet.getString("lastname");

                    Employee e = new Employee(id, firstName, lastName);
                    results.add(e);
                }
                return results;
            }
        }
    }

    @Override
    public Collection<Employee> getEmployees() throws SQLException {
        try (var con = getConnection();
             var stmt = con.createStatement()) {
            var results = new ArrayList<Employee>();

            try (ResultSet resultSet = stmt.executeQuery("select * from Employees")) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("ID");
                    String firstname = resultSet.getString("firstname");
                    String lastname = resultSet.getString("lastname");
                    Employee e = new Employee(id, firstname, lastname);
                    results.add(e);
                }
            }
            return results;
        }
    }
}
