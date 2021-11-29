package unit.servicelayer.employee;

import datalayer.Employee.EmployeeStorage;
import dto.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import servicelayer.employee.EmployeeService;
import servicelayer.employee.EmployeeServiceException;
import servicelayer.employee.EmployeeServiceImpl;

import java.sql.SQLException;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("unit")
public class CreateEmployeeTest {

    private EmployeeService employeeService;
    private EmployeeStorage storageMock;

    @BeforeAll
    void beforeAll() {
        storageMock = mock(EmployeeStorage.class);
        employeeService = new EmployeeServiceImpl(storageMock);
    }

    @Test
    public void mustCallStorageWhenCreatingCustomer() throws EmployeeServiceException, SQLException {
        var firstname = "Frederik";
        var lastname = "Blem";

        // the employee id is auto incremented
        // the 0 below is overwritten by auto incrementation
        Employee em = new Employee(0, firstname,lastname);
        employeeService.createEmployee(em);

        verify(storageMock, times(1))
                .createEmployee(
                        argThat((x-> x.getFirstName().equals(firstname) &&
                                x.getLastName().equals(lastname))));
    }
}
