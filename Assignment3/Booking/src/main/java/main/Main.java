package main;

import datalayer.Employee.EmployeeStorage;
import datalayer.Employee.EmployeeStorageImpl;
import datalayer.booking.BookingStorageImpl;
import dto.*;
import datalayer.customer.CustomerStorageImpl;
import servicelayer.employee.EmployeeServiceImpl;

import java.util.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;

public class Main {

    private static final String conStr = "jdbc:mysql://localhost:3307/BookingTest";
    private static final String user = "root";
    private static final String pass = "testuser1234";
    private EmployeeStorage str;

    public static void main(String[] args) throws SQLException {
        BookingStorageImpl booking = new BookingStorageImpl(conStr, user,pass);
        CustomerStorageImpl storage = new CustomerStorageImpl(conStr, user, pass);
        EmployeeStorageImpl employee = new EmployeeStorageImpl(conStr,user,pass);
//        CustomerCreation cust = new CustomerCreation("Frederik", "Hansen");
//        storage.createCustomer(cust);
//        EmployeeCreation em = new EmployeeCreation("Frederikke", "Nilsson");
//        employee.createEmployee(em);
//        BookingCreation b = new BookingCreation(1,1, convertToSQLDate(new Date()) , "08:10","20:30");
//        booking.createBooking(b);
//
//        for(Booking b1 : booking.getBookingsForCustomer(1)){
//            System.out.println(b1);
//        }
//
//        for(Employee e : employee.getEmployeeWithId(1)){
//            System.out.println(e);
//        }


    }
//        CustomerStorageImpl storage = new CustomerStorageImpl(conStr, user, pass);
//
//        System.out.println("Got customers: ");
//        for(Customer c : storage.getCustomers()) {
//            System.out.println(toString(c));
//        }
//        System.out.println("The end.");
//    }

    public static String toString(Customer c) {
        return "{" + c.getId() + ", " + c.getFirstname() + ", " + c.getLastname() + "}";
    }

    public static java.sql.Date convertToSQLDate(Date d) {
        return new java.sql.Date(d.getTime());
    }


}
