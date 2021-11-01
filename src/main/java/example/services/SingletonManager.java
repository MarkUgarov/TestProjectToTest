package example.services;

import java.time.LocalDateTime;

public class SingletonManager {

    private static SingletonManager instance;

    public static SingletonManager getInstance() {
        if (instance == null) {
            instance = new SingletonManager();
        }
        return instance;
    }

    private SingletonManager() {

    }

    public boolean checkDataBaseAvailable() {
        return false;
    }

    public LocalDateTime giveCurrentLocalDateTime() {
        return null;
    }

    public static String getCurrentUserName() {
        return null;
    }

    public static void sendAlertMail(String username, LocalDateTime localDateTime) {
        // do something else here
    }
}
