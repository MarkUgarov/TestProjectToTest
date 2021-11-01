package example.controller;

import example.services.SingletonManager;
import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

/**
 * Test of class {@link Controller}
 */
public class ControllerTestWithManagerAndJMockit {

    private Controller controller;

    @Mocked
    private SingletonManager singletonManager;

    @Before
    public void setUp() throws Exception {
        controller = new Controller();
    }

    @Test
    public void callService_shouldSendAlertMail_ifNotAvailable() {
        // mocking the static methods
        new MockUp<SingletonManager>() {
            @mockit.Mock
            public String getCurrentUserName (){
                return "Luke";
            }
        };
        new Expectations() {{
            // mocking the instance methods
            singletonManager.checkDataBaseAvailable();
            minTimes = 1;
            result = false;
            singletonManager.giveCurrentLocalDateTime();
            minTimes = 1;
            LocalDateTime expectedLocalDateTime = LocalDateTime.of(2020, 10, 15, 17, 30, 0);
            result = expectedLocalDateTime;
            // mocking the static method
            SingletonManager.sendAlertMail("Luke", expectedLocalDateTime);
            minTimes = 1;
        }};

        controller.callManager();

    }
}