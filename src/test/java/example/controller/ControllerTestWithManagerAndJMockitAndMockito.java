package example.controller;

import example.services.SingletonManager;
import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
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
public class ControllerTestWithManagerAndJMockitAndMockito {

    private Controller controller;

    @Mock
    private SingletonManager singletonManager;

    @Before
    public void setUp() throws Exception {
        // mocking the getInstance-method with JMockit, returning the instance mocked with Mockito
        new MockUp<SingletonManager>() {
            @mockit.Mock
            public SingletonManager getInstance(){
                return singletonManager;
            }

        };
        controller = new Controller();
    }

    @Test
    public void callService_shouldSendAlertMail_ifNotAvailable() {
        LocalDateTime expectedLocalDateTime = LocalDateTime.of(2020, 10, 15, 17, 30, 0);

        // mocking the instance methods
        doReturn(false).when(singletonManager).checkDataBaseAvailable();
        doReturn(expectedLocalDateTime).when(singletonManager).giveCurrentLocalDateTime();

        // mocking and verification of the static methods
        new Expectations() {{
            SingletonManager.getCurrentUserName();
            result = "Luke";
            minTimes = 1;
            SingletonManager.sendAlertMail("Luke", expectedLocalDateTime);
            minTimes = 1;
        }};

        controller.callManager();

        // verification of the call of the instance methods
        verify(singletonManager).checkDataBaseAvailable();
        verify(singletonManager).giveCurrentLocalDateTime();
    }
}