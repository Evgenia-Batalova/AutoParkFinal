package com.batalova.autopark;

public class Service {
    public static void main(String[] args) {
        new AutoparkClientManager(new AutoparkRestClient()).run();
    }
}
