package example.controller;

import example.services.SingletonService;

import javax.xml.ws.Service;

public class Controller {

    private final SingletonService singletonService;

    public Controller() {
        singletonService = SingletonService.getInstance();
    }

    public void callService() {
        if(singletonService.checkDataBaseAvailable()){ // calling the instance method
            SingletonService.sendAlertMail( // calling the class method
                    SingletonService.getCurrentUserName(),  // calling the class method
                    singletonService.giveCurrentLocalDateTime() // calling the instance method
            );
        }
    }
}
