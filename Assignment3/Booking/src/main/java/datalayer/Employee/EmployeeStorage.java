package datalayer.Employee;

import dto.Employee;
import dto.EmployeeCreation;

import java.sql.SQLException;
import java.util.Collection;

public interface EmployeeStorage {
    public int createEmployee(EmployeeCreation employeeCreation) throws SQLException;
    public Collection<Employee> getEmployeeWithId(int employeeId) throws SQLException;
    Collection<Employee> getEmployees() throws SQLException;
}
