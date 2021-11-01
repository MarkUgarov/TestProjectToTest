package example.controller;

import example.services.SingletonManager;

public class Controller {

    private final SingletonManager singletonManager;

    public Controller() {
        singletonManager = SingletonManager.getInstance();
    }

    public void callService() {
        if(!singletonManager.checkDataBaseAvailable()){ // calling the instance method
            SingletonManager.sendAlertMail( // calling the class method
                    SingletonManager.getCurrentUserName(),  // calling the class method
                    singletonManager.giveCurrentLocalDateTime() // calling the instance method
            );
        }
    }
}
