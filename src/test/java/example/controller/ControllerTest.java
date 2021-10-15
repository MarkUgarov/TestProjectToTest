package example.controller;

import example.services.SingletonService;
import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

/**
 * Test of class {@link Controller}
 * <p>
 * Created by mgar on 15.10.2021.
 */
public class ControllerTest {

    private Controller controller;

    @Mocked
    private SingletonService singletonService;

    @Before
    public void setUp() throws Exception {
        controller = new Controller();
    }

    @Test
    public void callService_shouldSendAlertMail_ifNotAvailable() {
        // mocking the static methods
        new MockUp<SingletonService>() {
            @mockit.Mock
            public String getCurrentUserName (){
                return "Luke";
            }
        };
        // mocking the instance methods
        new Expectations() {{
            singletonService.checkDataBaseAvailable();
            minTimes = 1;
            result = false;
            singletonService.giveCurrentLocalDateTime();
            minTimes = 1;
            LocalDateTime expectedLocalDateTime = LocalDateTime.of(2020, 10, 15, 17, 30, 0);
            result = expectedLocalDateTime;
            SingletonService.sendAlertMail("Luke", expectedLocalDateTime);
            minTimes = 1;
        }};

        controller.callService();
    }
}