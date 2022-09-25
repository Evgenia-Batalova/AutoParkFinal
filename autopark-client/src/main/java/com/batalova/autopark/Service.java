package com.batalova.autopark;

public class Service {
    public static void main(String[] args) {
        User user = AutoparkClientManager.authenticate();
        new AutoparkClientManager(new AutoparkRestClient(user)).run();
    }
}
