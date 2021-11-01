package example.controller;

import example.services.Service;
import example.services.SingletonManager;

public class Controller {

    private final SingletonManager singletonManager;
    private Service service;

    public Controller() {
        singletonManager = SingletonManager.getInstance();
    }

    public Controller(Service service){
        this();
        this.service = service;
    }

    public void callManager() {
        if(!singletonManager.checkDataBaseAvailable()){ // calling the instance method
            SingletonManager.sendAlertMail( // calling the class method
                    SingletonManager.getCurrentUserName(),  // calling the class method
                    singletonManager.giveCurrentLocalDateTime() // calling the instance method
            );
        }
    }

    public void callService() {
        if(!service.checkDataBaseAvailable()){
            service.sendAlertMail(
                    service.getCurrentUserName(),
                    service.giveCurrentLocalDateTime()
            );
        }
    }
}
