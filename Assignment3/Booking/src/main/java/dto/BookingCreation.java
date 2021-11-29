package dto;

import java.util.Date;

public class BookingCreation {

    private final int customerId;
    private final int employeeId;
    private Date date;
    private String start;
    private String end;

    public BookingCreation(int customerId, int employeeId, Date date, String start, String end) {
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.date = date;
        this.start = start;
        this.end = end;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public Date getDate() {
        return date;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }
}
