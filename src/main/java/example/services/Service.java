package example.services;

import java.time.LocalDateTime;

public class Service {

    public boolean checkDataBaseAvailable() {
        return false;
    }

    public LocalDateTime giveCurrentLocalDateTime() {
        return null;
    }

    public String getCurrentUserName() {
        return null;
    }

    public void sendAlertMail(String username, LocalDateTime localDateTime) {
        // do something else here
    }
}
