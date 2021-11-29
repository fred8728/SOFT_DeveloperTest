package unit.servicelayer.customer;

import datalayer.customer.CustomerStorage;
import dto.CustomerCreation;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.ArgumentCaptor;
import servicelayer.customer.CustomerService;
import servicelayer.customer.CustomerServiceException;
import servicelayer.customer.CustomerServiceImpl;
import java.sql.SQLException;
import java.util.Date;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("unit")
public class CreateCustomerTest {

    // SUT (System Under Test)
    private CustomerService customerService;

    // DOC (Depended-on Component)
    private CustomerStorage storageMock;


    @BeforeAll
    public void beforeAll(){
        storageMock = mock(CustomerStorage.class);
        customerService = new CustomerServiceImpl(storageMock);
    }

    @Test
    public void mustCallStorageOneTimeWhenCreatingCustomer() throws CustomerServiceException, SQLException {
        // Arrange
        // Act
        var firstName = "a";
        var lastName = "b";
        var birthdate = new Date(123456789l);

        customerService.createCustomer(firstName, lastName, birthdate);

        // Assert
        // Can be read like: verify that storageMock was called 1 time on the method
        //   'createCustomer' with an argument whose 'firstname' == firstName and
        //   whose 'lastname' == lastName

        verify(storageMock, times(1))
                .createCustomer(
                        argThat(x -> x.firstname.equals(firstName) &&
                                x.lastname.equals(lastName)));
    }

    @Test
    public void forAssignment4TestingMock() throws CustomerServiceException, SQLException {
        // Arrange
        // Act
        var firstName = "Frede";
        var lastName = "Hansen";
        var birthdate = new Date(123456789l);

        customerService.createCustomer(firstName, lastName, birthdate);

        // Assert
        // Can be read like: verify that storageMock was called 1 time on the method
        //   'createCustomer' with an argument whose 'firstname' == firstName and
        //   whose 'lastname' == lastName

        //verify that the method createCustomer is called
        verify(storageMock)
                .createCustomer(
                        argThat(x -> x.firstname.equals(firstName) &&
                                x.lastname.equals(lastName)));

        // verify that the method getCustomer is never called
        verify(storageMock, never()).getCustomers();

        // verify that the method createCustomer is called 1 time
        verify(storageMock, times(1))
                .createCustomer(
                        argThat(x -> x.firstname.equals(firstName) &&
                                x.lastname.equals(lastName)));

        // verify that the method createCustomer() is called at least 1 time
        verify(storageMock, atLeast(1))
                .createCustomer(
                argThat(x -> x.firstname.equals(firstName) &&
                        x.lastname.equals(lastName)));

        // Verify that a mock object is called with specific arguments
        // and check it is the right properties
        ArgumentCaptor<CustomerCreation> argument = ArgumentCaptor.forClass(CustomerCreation.class);
        verify(storageMock).createCustomer(argument.capture());

        Assert.assertEquals("Frede", argument.getValue().firstname);
        Assert.assertEquals("Hansen", argument.getValue().lastname);

    }


}
