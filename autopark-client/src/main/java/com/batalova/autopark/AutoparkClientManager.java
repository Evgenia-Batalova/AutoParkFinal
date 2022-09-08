package com.batalova.autopark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AutoparkClientManager {
    private final AutoparkRestClient restClient;

    private final BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));

    public AutoparkClientManager(AutoparkRestClient restClient) {
        this.restClient = restClient;
    }


    public void run() {
        while (true) {
            try {
                handleMenu();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    };

    private void handleMenu() throws IOException {
        System.out.println("Выберите функцию");
        System.out.println("1: Добавить пользователя");
        System.out.println("2: Добавить авто");
        System.out.println("3: Добавить рут");
        String name = reader.readLine();
        switch (name) {
            case "1":
                handleUserAddition();
                break;
            case "2":
                handleAutoAddition();
                break;
            case "3":
                handleRouteAddition();
                break;
            default:
                System.out.println("Неизвестное действие '" + name + "'");
        }

    };

    private void addition() {
    }

    private void handleUserAddition() {
        boolean userAdded = false;
        while (!userAdded) {
            userAdded = addUser();
        }
    }

    private void handleAutoAddition() {
        boolean autoAdded = false;
        while (!autoAdded) {
            autoAdded = addAuto();
        }
    }

    private void handleRouteAddition() {
        boolean routeAdded = false;
        while (!routeAdded) {
            routeAdded = addRoute();
        }
    }

    private boolean addUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя пользователя");
        String firstName = scanner.nextLine();
        System.out.println("Вы ввели имя: " + firstName);
        System.out.println("Введите фамилию пользователя или нажмите 0");
        String lastNameOrZero = scanner.nextLine();
        if("0".equals(lastNameOrZero)){
            return false;
        } else {
            System.out.println("Вы ввели фамилию: " + lastNameOrZero);
        }
        System.out.println("Введите отчество пользователя или нажмите 0");
        String fatherNameOrZero = scanner.nextLine();
        if("0".equals(fatherNameOrZero)){
            return false;
        } else {
            System.out.println("Вы ввели отчество: " + fatherNameOrZero);
        }
        restClient.addPersonnel(firstName, lastNameOrZero, fatherNameOrZero);
        System.out.println("Пользователь " + firstName + " " + lastNameOrZero + " " + fatherNameOrZero + " добавлен");
        return true;
    }

    private boolean addAuto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id пользователя");
        String stringId = scanner.nextLine();
        Integer personnelId = Integer.parseInt(stringId);
        System.out.println("Вы ввели id: " + personnelId);
        System.out.println("Введите цвет авто или нажмите 0");
        String autoColorOrZero = scanner.nextLine();
        if("0".equals(autoColorOrZero)) {
            return false;
        } else {
            System.out.println("Вы ввели цвет: " + autoColorOrZero);
        }
        System.out.println("Введите марку авто или нажмите 0");
        String autoMarkOrZero = scanner.nextLine();
        if("0".equals(autoMarkOrZero)){
            return false;
        } else {
            System.out.println("Вы ввели марку: " + autoMarkOrZero);
        }
        System.out.println("Введите номер авто или нажмите 0");
        String autoNumOrZero = scanner.nextLine();
        if("0".equals(autoNumOrZero)){
            return false;
        } else {
            System.out.println("Вы ввели марку: " + autoNumOrZero);
        }
        restClient.addAuto(personnelId, autoColorOrZero, autoMarkOrZero, autoNumOrZero);
        System.out.println("Авто с номером " + autoNumOrZero + " добавлено");
        return true;
    }

    private boolean addRoute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя рута");
        String routeName = scanner.nextLine();
        restClient.addRoute(routeName);
        System.out.println("Рут '" + routeName + "' добавлен");
        return true;
    }



}
