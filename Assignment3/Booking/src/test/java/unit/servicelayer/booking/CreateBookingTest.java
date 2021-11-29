package unit.servicelayer.booking;

import datalayer.booking.BookingStorage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import servicelayer.booking.BookingService;
import servicelayer.booking.BookingServiceException;
import servicelayer.booking.BookingServiceImpl;
import java.sql.SQLException;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("unit")
public class CreateBookingTest {
    private BookingService bookingService;
    private BookingStorage storageMock;

    @BeforeAll
    public void beforeAll() {
        storageMock = mock(BookingStorage.class);
        bookingService = new BookingServiceImpl(storageMock);
    }

    @Test
    public void mustCallStorageWhenCreatingBooking() throws BookingServiceException, SQLException {
        var customerId = 4;
        var employeeId = 4;
        var date = "2022-11-01";
        var start = "19:30:00";
        var end = "22:34:12";

        bookingService.createBooking(customerId,employeeId,date,start,end);
        verify(storageMock, times(1))
                .createBooking(
                        argThat((x-> x.getCustomerId() == customerId &&
                                x.getEmployeeId() == employeeId)));
    }
}
