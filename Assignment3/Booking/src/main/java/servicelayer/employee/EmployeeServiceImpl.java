package servicelayer.employee;

import datalayer.Employee.EmployeeStorage;
import datalayer.customer.CustomerStorage;
import dto.Employee;
import dto.EmployeeCreation;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeStorage employeeStorage;

    public EmployeeServiceImpl(EmployeeStorage employeeStorage) {this.employeeStorage = employeeStorage; }

    @Override
    public int createEmployee(Employee employee) throws EmployeeServiceException {
        try{
            return employeeStorage.createEmployee(new EmployeeCreation(employee.getFirstName(), employee.getLastName()));
        } catch (SQLException throwables){
            throw new EmployeeServiceException("Employee Service Exception msg: " + throwables.getMessage());
        }
    }

    @Override
    public Employee getEmployeeById(int employeeId) throws SQLException {
        Collection<Employee> theEmployees = employeeStorage.getEmployeeWithId(employeeId);
        return  (Employee) theEmployees.toArray()[0];
    }
}
