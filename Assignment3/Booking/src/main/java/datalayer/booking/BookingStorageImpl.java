package datalayer.booking;

import dto.Booking;
import dto.BookingCreation;
import dto.Customer;
import servicelayer.booking.BookingService;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BookingStorageImpl implements BookingStorage {

    private String connectionString;
    private String username, password;

    public BookingStorageImpl(String conStr, String user, String pass){
        connectionString = conStr;
        username = user;
        password = pass;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionString, username, password);
    }

    @Override
    public int createBooking(BookingCreation bookingCreation) throws SQLException {
        var sql = "insert into Bookings(customerId, employeeId, date, start, end) values (?, ?, ?, ?, ?)";
        try (var con = getConnection();
             var stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, bookingCreation.getCustomerId());
            stmt.setInt(2, bookingCreation.getEmployeeId());
            stmt.setDate(3, (Date) bookingCreation.getDate());
            stmt.setString(4, bookingCreation.getStart());
            stmt.setString(5, bookingCreation.getEnd());
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
    public Collection<Booking> getBookingsForCustomer(int customerId) throws SQLException {
        var sql = "select * from Bookings where customerId = ?";
        try (var con = getConnection();
             var stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, customerId);
            var results = new ArrayList<Booking>();

            try (var resultSet = stmt.executeQuery()) {
                while (resultSet.next()){
                    var id = resultSet.getInt("ID");
                    var custId = resultSet.getInt("customerId");
                    var employeeId = resultSet.getInt("employeeId");
                    var date = resultSet.getString("date");
                    var start = resultSet.getString("start");
                    var end = resultSet.getString("end");

                    Booking b = new Booking(id, custId, employeeId,date,start,end);
                    results.add(b);
                }
                return results;
            }
        }
    }

    @Override
    public Collection<Booking> getBookingsForEmployee(int employeeId) throws SQLException {
        var sql = "select * from Bookings where employeeId = ?";
        try (var con = getConnection();
             var stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, employeeId);
            var results = new ArrayList<Booking>();

            try (var resultSet = stmt.executeQuery()) {
                while (resultSet.next()){
                    var id = resultSet.getInt("ID");
                    var custId = resultSet.getInt("customerId");
                    var empId = resultSet.getInt("employeeId");
                    var date = resultSet.getString("date");
                    var start = resultSet.getString("start");
                    var end = resultSet.getString("end");

                    Booking b = new Booking(id, custId, empId,date,start,end);
                    results.add(b);
                }
                return results;
            }
        }
    }
}
