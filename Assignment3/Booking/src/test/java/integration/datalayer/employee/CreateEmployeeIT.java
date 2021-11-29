package integration.datalayer.employee;

import com.github.javafaker.Faker;
import datalayer.Employee.EmployeeStorage;
import datalayer.Employee.EmployeeStorageImpl;
import dto.CustomerCreation;
import dto.EmployeeCreation;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("integration")
public class CreateEmployeeIT {
    private EmployeeStorage employeeStorage;

    @BeforeAll
    void setUp() throws SQLException {
        employeeStorage = new EmployeeStorageImpl("jdbc:mysql://localhost:3307/BookingTest", "root", "testuser1234");
        var numEmployees = employeeStorage.getEmployees().size();
        if (numEmployees < 100) {
            addFakeEmployees(100 - numEmployees);
        }
    }
    private void addFakeEmployees(int numEmployees) throws SQLException {
        Faker faker = new Faker();
        for (int i = 0; i < numEmployees; i++) {
            EmployeeCreation e = new EmployeeCreation(faker.name().firstName(), faker.name().lastName());
            employeeStorage.createEmployee(e);
        }
    }

    @Test
    public void mustSaveEmployeeInDatabaseWhenCallingCreateEmployee () throws SQLException {
        employeeStorage.createEmployee(new EmployeeCreation("Thomas", "Hansen"));
        var employee = employeeStorage.getEmployees();
        assertTrue(employee.stream().anyMatch(x->
                x.getFirstName().equals("Thomas") &&
                x.getLastName().equals("Hansen")));
    }

    @Test
    public void mustReturnLatestId() throws SQLException {
        // Arrange
        // Act
        var id1 = employeeStorage.createEmployee(new EmployeeCreation("Frederikke", "Nilsson"));
        var id2 = employeeStorage.createEmployee(new EmployeeCreation("Frederik", "Blem"));

        // Assert
        assertEquals(1, id2 - id1);
    }
}
