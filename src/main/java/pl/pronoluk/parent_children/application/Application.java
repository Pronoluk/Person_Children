package pl.pronoluk.parent_children.application;

import pl.pronoluk.parent_children.service.WelcomeService;

public class Application {
    public static void main(String[] args) {
        WelcomeService welcomeService = new WelcomeService("Hello");
    }
}
