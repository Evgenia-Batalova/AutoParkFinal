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
        System.out.println("1: Добавление");
        System.out.println("2: Удаление");
        System.out.println("3: Показать всё");
        System.out.println("4: Запуск/остановка рута");
        System.out.println("5: Обновление");
        System.out.println("6: Поиск");
        String choice = reader.readLine();
        switch (choice) {
            case "1":
                addOptions();
                break;
            case "2":
                deleteOptions();
                break;
            case "3":
                showOptions();
                break;
            case "4":
                routeOptions();
                break;
            case "5":
                updateOptions();
                break;
            case "6":
                System.out.println("пусто");
                break;
            default:
                System.out.println("Неизвестное действие '" + choice + "'");
        }

    };

    private void addOptions() throws IOException {
        System.out.println("1: Добавить пользователя");
        System.out.println("2: Добавить авто");
        System.out.println("3: Добавить рут");
        String caseAdd = reader.readLine();
        switch (caseAdd) {
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
                System.out.println("Неизвестное действие '" + caseAdd + "'");
        }
    }

    private void deleteOptions() throws IOException {
        System.out.println("1: Удалить пользователя");
        System.out.println("2: Удалить авто");
        System.out.println("3: Удалить рут");
        String caseDelete = reader.readLine();
        switch (caseDelete) {
            case "1":
                handleUserDeletion();
                break;
            case "2":
                handleAutoDeletion();
                break;
            case "3":
                handleRouteDeletion();
                break;
            default:
                System.out.println("Неизвестное действие '" + caseDelete + "'");
        }
    }

    private void showOptions() throws IOException {
        System.out.println("1: Показать всех пользователей");
        System.out.println("2: Показать все авто");
        System.out.println("3: Показать все руты");
        String caseShow = reader.readLine();
        switch (caseShow) {
            case "1":
                handleUserShow();
                break;
            case "2":
                handleAutoShow();
                break;
            case "3":
                handleRouteShow();
                break;
            default:
                System.out.println("Неизвестное действие '" + caseShow + "'");
        }
    }

    private void routeOptions() throws IOException {
        System.out.println("1: Начать рут");
        System.out.println("2: Закончить рут");
        String caseRoute = reader.readLine();
        switch (caseRoute) {
            case "1":
                handleRouteStart();
                break;
            case "2":
                handleRouteFinish();
                break;
            default:
                System.out.println("Неизвестное действие '" + caseRoute + "'");
        }
    }

    private void updateOptions() throws IOException {
        System.out.println("1: Обновить параметры пользователя");
        System.out.println("2: Обновить параметры авто");
        String caseUpdate = reader.readLine();
        switch (caseUpdate) {
            case "1":
                updateUserOptions();
                break;
            case "2":
                updateAutoOptions();
                break;
            default:
                System.out.println("Неизвестное действие '" + caseUpdate + "'");
        }
    }

    private void updateUserOptions() throws IOException {
        System.out.println("1: Обновить имя пользователя");
        System.out.println("2: Обновить фамилию пользователя");
        System.out.println("3: Обновить отчество пользователя");
        String caseUserUpdate = reader.readLine();
        switch (caseUserUpdate) {
            case "1":
                handleFirstNameUpdate();
                break;
            case "2":
                handleLastNameUpdate();
                break;
            case "3":
                handleFatherNameUpdate();
                break;
            default:
                System.out.println("Неизвестное действие '" + caseUserUpdate + "'");
        }
    }

    private void updateAutoOptions() throws IOException {
        System.out.println("1: Обновить цвет авто");
        System.out.println("2: Обновить номер авто");
        String caseAutoUpdate = reader.readLine();
        switch (caseAutoUpdate) {
            case "1":
                handleAutoColorUpdate();
                break;
            case "2":
                handleAutoNumberUpdate();
                break;
            default:
                System.out.println("Неизвестное действие '" + caseAutoUpdate + "'");
        }
    }

    private void handleAutoColorUpdate() {
        boolean isAutoColorUpdate = false;
        while (!isAutoColorUpdate) {
            isAutoColorUpdate = updateColor();
        }
    }

    private void handleAutoNumberUpdate() {
        boolean isAutoNumberUpdate = false;
        while (!isAutoNumberUpdate) {
            isAutoNumberUpdate = updateNumber();
        }
    }

    private void handleFirstNameUpdate() {
        boolean isFirstNameUpdate = false;
        while (!isFirstNameUpdate) {
            isFirstNameUpdate = updateFirstName();
        }
    }

    private void handleLastNameUpdate() {
        boolean isLastNameUpdate = false;
        while (!isLastNameUpdate) {
            isLastNameUpdate = updateLastName();
        }
    }

    private void handleFatherNameUpdate() {
        boolean isFatherNameUpdate = false;
        while (!isFatherNameUpdate) {
            isFatherNameUpdate = updateFatherName();
        }
    }

    private void handleRouteStart() {
        boolean routeStarted = false;
        while (!routeStarted) {
            routeStarted = startRoute();
        }
    }

    private void handleRouteFinish() {
        boolean routeFinished = false;
        while (!routeFinished) {
            routeFinished = finishRoute();
        }
    }

    private void handleUserAddition() {
        boolean userAdded = false;
        while (!userAdded) {
            userAdded = addUser();
        }
    }

    private void handleUserDeletion() {
        boolean userDeleted = false;
        while (!userDeleted) {
            userDeleted = deleteUser();
        }
    }

    private void handleUserShow() {
        boolean userShown = false;
        while (!userShown) {
            userShown = showUser();
        }
    }

    private void handleAutoAddition() {
        boolean autoAdded = false;
        while (!autoAdded) {
            autoAdded = addAuto();
        }
    }

    private void handleAutoDeletion() {
        boolean autoDeleted = false;
        while (!autoDeleted) {
            autoDeleted = deleteAuto();
        }
    }

    private void handleAutoShow() {
        boolean autoShown = false;
        while (!autoShown) {
            autoShown = showAuto();
        }
    }

    private void handleRouteAddition() {
        boolean routeAdded = false;
        while (!routeAdded) {
            routeAdded = addRoute();
        }
    }

    private void handleRouteDeletion() {
        boolean routeDeleted = false;
        while (!routeDeleted) {
            routeDeleted = deleteRoute();
        }
    }

    private void handleRouteShow() {
        boolean routeShown = false;
        while (!routeShown) {
            routeShown = showRoute();
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

    private boolean deleteUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id пользователя");
        String stringId = scanner.nextLine();
        Integer personnelId = Integer.parseInt(stringId);
        //restClient.deletePersonnel(personnelId);
        System.out.println("Пользователь с id '" + personnelId + "' удалён");
        return true;
    }

    private boolean showUser() {
        System.out.println("Все пользователи: ");
        //restClient.showAllPersonnel();
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

    private boolean deleteAuto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id авто");
        String stringId = scanner.nextLine();
        Integer autoId = Integer.parseInt(stringId);
        //restClient.deleteAuto(autoId);
        System.out.println("Авто с id '" + autoId + "' удалено");
        return true;
    }

    private boolean showAuto() {
        System.out.println("Все авто: ");
        //restClient.showAllAuto();
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

    private boolean deleteRoute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id рута");
        String stringId = scanner.nextLine();
        Integer routeId = Integer.parseInt(stringId);
        //restClient.deleteRoute(routeId);
        System.out.println("Рут с id '" + routeId + "' удалён");
        return true;
    }

    private boolean showRoute() {
        System.out.println("Все руты: ");
        //restClient.showAllRoute();
        return true;
    }

    private boolean startRoute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер авто");
        String autoNum = scanner.nextLine();
        System.out.println("Вы ввели номер: " + autoNum);
        System.out.println("Введите имя рута или нажмите 0");
        String routeNameOrZero = scanner.nextLine();
        if("0".equals(routeNameOrZero)) {
            return false;
        } else {
            System.out.println("Вы ввели рут: " + routeNameOrZero);
        }
        //restClient.startRouteByAutoNumberAndRouteName(autoNum, routeNameOrZero);
        System.out.println("Авто с номером " + autoNum + " вышло на маршрут '" + routeNameOrZero + "'");
        return true;
    }

    private boolean finishRoute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер авто");
        String autoNum = scanner.nextLine();
        System.out.println("Вы ввели номер: " + autoNum);
        //restClient.finishRouteByNumber(autoNum);
        System.out.println("Авто с номером " + autoNum + " завершило маршрут");
        return true;
    }

    private boolean updateFirstName() {
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
        System.out.println("Введите новое имя пользователя или нажмите 0");
        String newFirstNameOrZero = scanner.nextLine();
        if("0".equals(newFirstNameOrZero)){
            return false;
        } else {
            System.out.println("Вы ввели новое имя: " + newFirstNameOrZero);
        }
        //restClient.updatePersonnelFirstName(firstName, lastNameOrZero, fatherNameOrZero, newFirstNameOrZero);
        System.out.println("ФИО пользователя " + firstName + " " + lastNameOrZero + " " + fatherNameOrZero +
                " было изменено на " + newFirstNameOrZero + " " + lastNameOrZero + " " + fatherNameOrZero);
        return true;
    }

    private boolean updateLastName() {
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
        System.out.println("Введите новую фамилию пользователя или нажмите 0");
        String newLastNameOrZero = scanner.nextLine();
        if("0".equals(newLastNameOrZero)){
            return false;
        } else {
            System.out.println("Вы ввели новую фамилию: " + newLastNameOrZero);
        }
        //restClient.updatePersonnelLastName(firstName, lastNameOrZero, fatherNameOrZero, newLastNameOrZero);
        System.out.println("ФИО пользователя " + firstName + " " + lastNameOrZero + " " + fatherNameOrZero +
                " было изменено на " + firstName + " " + newLastNameOrZero + " " + fatherNameOrZero);
        return true;
    }

    private boolean updateFatherName() {
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
        System.out.println("Введите новое отчество пользователя или нажмите 0");
        String newFatherNameOrZero = scanner.nextLine();
        if("0".equals(newFatherNameOrZero)){
            return false;
        } else {
            System.out.println("Вы ввели новое отчество: " + newFatherNameOrZero);
        }
        //restClient.updatePersonnelFatherName(firstName, lastNameOrZero, fatherNameOrZero, newFatherNameOrZero);
        System.out.println("ФИО пользователя " + firstName + " " + lastNameOrZero + " " + fatherNameOrZero +
                " было изменено на " + firstName + " " + lastNameOrZero + " " + newFatherNameOrZero);
        return true;
    }

    private boolean updateColor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер авто");
        String autoNum = scanner.nextLine();
        System.out.println("Вы ввели номер: " + autoNum);
        System.out.println("Введите новый цвет авто или нажмите 0");
        String newAutoColorOrZero = scanner.nextLine();
        if("0".equals(newAutoColorOrZero)) {
            return false;
        } else {
            System.out.println("Вы ввели цвет: " + newAutoColorOrZero);
        }
        //restClient.updateAutoColor(newAutoColorOrZero, autoNum);
        System.out.println("Авто с номером " + autoNum + " перекрашено в " + newAutoColorOrZero + " цвет");
        return true;
    }

    private boolean updateNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер авто");
        String autoNum = scanner.nextLine();
        System.out.println("Вы ввели номер: " + autoNum);
        System.out.println("Введите новый номер авто или нажмите 0");
        String newAutoNumberOrZero = scanner.nextLine();
        if("0".equals(newAutoNumberOrZero)) {
            return false;
        } else {
            System.out.println("Вы ввели новый номер: " + newAutoNumberOrZero);
        }
        //restClient.updateAutoNumber(autoNum, newAutoColorOrZero);
        System.out.println("Номер авто изменён на " + newAutoNumberOrZero);
        return true;
    }

}
