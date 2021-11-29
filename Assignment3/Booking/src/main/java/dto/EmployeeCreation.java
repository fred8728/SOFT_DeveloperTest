package dto;

import java.util.Date;

public class EmployeeCreation {

    private String firstName, lastName;

    public EmployeeCreation(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
