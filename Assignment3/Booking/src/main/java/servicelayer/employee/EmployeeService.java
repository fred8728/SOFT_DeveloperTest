package servicelayer.employee;

import dto.Employee;

import java.sql.SQLException;

public interface EmployeeService {
    public int createEmployee(Employee employee) throws EmployeeServiceException;
    public Employee getEmployeeById(int employeeId) throws SQLException;
}
