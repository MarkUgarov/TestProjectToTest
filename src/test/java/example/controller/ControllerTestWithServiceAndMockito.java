package example.controller;

import example.services.Service;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

/**
 * Test of class {@link Controller}
 */
@RunWith(MockitoJUnitRunner.class)
public class ControllerTestWithServiceAndMockito {

    private Controller controller;

    @Mock
    private Service service;

    @Before
    public void setUp() throws Exception {
        // normally we do this with @Inject etc., but here we try to avoid complexity
        controller = new Controller(service);
    }

    @Test
    public void callService_shouldSendAlertMail_ifNotAvailable() {
        LocalDateTime expectedLocalDateTime = LocalDateTime.of(2020, 10, 15, 17, 30, 0);

        doReturn(false).when(service).checkDataBaseAvailable();
        doReturn("Luke").when(service).getCurrentUserName();
        doReturn(expectedLocalDateTime).when(service).giveCurrentLocalDateTime();

        controller.callService();

        verify(service).checkDataBaseAvailable();
        verify(service).getCurrentUserName();
        verify(service).giveCurrentLocalDateTime();
        verify(service).sendAlertMail("Luke", expectedLocalDateTime);
    }
}