package example.services;

import java.time.LocalDateTime;

public class SingletonService {

    private static SingletonService instance;

    public static SingletonService getInstance() {
        if (instance == null) {
            instance = new SingletonService();
        }
        return instance;
    }

    private SingletonService() {

    }

    public boolean checkDataBaseAvailable() {
        return false;
    }

    public LocalDateTime giveCurrentLocalDateTime() {
        return LocalDateTime.now();
    }

    public static String getCurrentUserName() {
        return "Brathans";
    }

    public static void sendAlertMail(String username, LocalDateTime localDateTime) {
        // do something else here
    }
}
