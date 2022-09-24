package com.batalova.autopark;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class AutoparkRestClient {
    private RestTemplate restTemplate = new RestTemplate();
    public void addPersonnel(String firstName, String lastName, String fatherName) {
        String fooResourceUrl
                = "http://localhost:8080/add-personnel?first_name="
                + firstName + "&last_name=" + lastName + "&father_name=" + fatherName;
        HttpEntity<String> request = new HttpEntity<>("");
        ResponseEntity<String> response = restTemplate.postForEntity(fooResourceUrl, request, String.class);
        System.out.println(response.getBody());
    }

    public void addAuto(Integer personnelId, String autoColor, String autoMark, String autoNum) {
        String fooResourceUrl
                = "http://localhost:8080/add-auto?personnel_id="
                + personnelId + "&color=" + autoColor + "&mark=" + autoMark + "&num=" + autoNum;
        HttpEntity<String> request = new HttpEntity<>("");
        ResponseEntity<String> response = restTemplate.postForEntity(fooResourceUrl, request, String.class);
        System.out.println(response.getBody());
    }

    public void addRoute(String routeName) {
        String fooResourceUrl = "http://localhost:8080/add-route?name=" + routeName;
        HttpEntity<String> request = new HttpEntity<>("");
        ResponseEntity<String> response = restTemplate.postForEntity(fooResourceUrl, request, String.class);
        System.out.println(response.getBody());
    }

    public void deletePersonnel(Integer personnelId) {
        String entityUrl = "http://localhost:8080/delete-personnel?id=" + personnelId;
        restTemplate.delete(entityUrl);
    }

    public void deleteAuto(Integer autoId) {
        String entityUrl = "http://localhost:8080/delete-auto?id=" + autoId;
        restTemplate.delete(entityUrl);
    }

    public void deleteRoute(Integer routeId) {
        String entityUrl = "http://localhost:8080/delete-route?id=" + routeId;
        restTemplate.delete(entityUrl);
    }

    public void showAllPersonnel() {
        String fooResourceUrl = "http://localhost:8080/show-all-personnel";
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        System.out.println(response.getBody());
    }

    public void showAllAuto() {
        String fooResourceUrl = "http://localhost:8080/show-all-auto";
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        System.out.println(response.getBody());
    }

    public void showAllRoute() {
        String fooResourceUrl = "http://localhost:8080/show-all-route";
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        System.out.println(response.getBody());
    }

    public void updatePersonnelFirstName(String firstName, String lastName, String fatherName, String newFirstName) {
        String fooResourceUrl
                = "http://localhost:8080/update-personnel-first-name?old_first_name="
                + firstName + "&old_last_name=" + lastName + "&old_father_name=" + fatherName + "&new_first_name=" + newFirstName;
        HttpEntity<String> request = new HttpEntity<>("");
        ResponseEntity<String> response = restTemplate.postForEntity(fooResourceUrl, request, String.class);
        System.out.println(response.getBody());
    }

    public void updatePersonnelLastName(String firstName, String lastName, String fatherName, String newLastName) {
        String fooResourceUrl
                = "http://localhost:8080/update-personnel-last-name?old_first_name="
                + firstName + "&old_last_name=" + lastName + "&old_father_name=" + fatherName + "&new_last_name=" + newLastName;
        HttpEntity<String> request = new HttpEntity<>("");
        ResponseEntity<String> response = restTemplate.postForEntity(fooResourceUrl, request, String.class);
        System.out.println(response.getBody());
    }

    public void updatePersonnelFatherName(String firstName, String lastName, String fatherName, String newFatherName) {
        String fooResourceUrl
                = "http://localhost:8080/update-personnel-father-name?old_first_name="
                + firstName + "&old_last_name=" + lastName + "&old_father_name=" + fatherName + "&new_father_name=" + newFatherName;
        HttpEntity<String> request = new HttpEntity<>("");
        ResponseEntity<String> response = restTemplate.postForEntity(fooResourceUrl, request, String.class);
        System.out.println(response.getBody());
    }

    public void updateAutoColor(String color, String num) {
        String fooResourceUrl
                = "http://localhost:8080/update-auto-color?color=" + color + "&num=" + num;
        HttpEntity<String> request = new HttpEntity<>("");
        ResponseEntity<String> response = restTemplate.postForEntity(fooResourceUrl, request, String.class);
        System.out.println(response.getBody());
    }

    public void updateAutoNumber(String oldNum, String newNum) {
        String fooResourceUrl
                = "http://localhost:8080/update-auto-number?old_number=" + oldNum + "&new_number=" + newNum;
        HttpEntity<String> request = new HttpEntity<>("");
        ResponseEntity<String> response = restTemplate.postForEntity(fooResourceUrl, request, String.class);
        System.out.println(response.getBody());
    }

    public void startRouteByAutoNumberAndRouteName(String autoNum, String routeName) {
        String fooResourceUrl = "http://localhost:8080/start-route-by-auto-number-and-route-name?num="
                + autoNum + "&name=" + routeName;
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        System.out.println(response.getBody());
    }

    public void finishRouteByNumber(String num) {
        String fooResourceUrl = "http://localhost:8080/finish-route-by-number?num=" + num;
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        System.out.println(response.getBody());
    }

    public void findPersonnelByFirstName(String firstName) {
        String fooResourceUrl = "http://localhost:8080/find-personnel-by-first-name?first_name=" + firstName;
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        System.out.println(response.getBody());
    }

    public void findPersonnelByLastName(String lastName) {
        String fooResourceUrl = "http://localhost:8080/find-personnel-by-last-name?last_name=" + lastName;
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        System.out.println(response.getBody());
    }

    public void findPersonnelByFatherName(String fatherName) {
        String fooResourceUrl = "http://localhost:8080/find-personnel-by-father-name?father_name=" + fatherName;
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        System.out.println(response.getBody());
    }

    public void findPersonnelByFullName(String firstName, String lastName, String fatherName) {
        String fooResourceUrl
                = "http://localhost:8080/find-personnel-by-full-name?first_name="
                + firstName + "&last_name=" + lastName + "&father_name=" + fatherName;
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        System.out.println(response.getBody());
    }

    public void findAutoByColor(String autoColor) {
        String fooResourceUrl = "http://localhost:8080/find-auto-by-color?color=" + autoColor;
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        System.out.println(response.getBody());
    }

    public void findAutoByNumber(String autoNum) {
        String fooResourceUrl = "http://localhost:8080/find-auto-by-number?num=" + autoNum;
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        System.out.println(response.getBody());
    }

    public void findAutoByMark(String autoMark) {
        String fooResourceUrl = "http://localhost:8080/find-auto-by-mark?mark=" + autoMark;
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        System.out.println(response.getBody());
    }

    public void findRouteByName(String routeName) {
        String fooResourceUrl = "http://localhost:8080/find-route-by-name?name=" + routeName;
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        System.out.println(response.getBody());
    }

    public void findUnfinishedRouteByAutoId(String autoId) {
        String fooResourceUrl = "http://localhost:8080/find-unfinished-route-by-auto-id?auto_id=" + autoId;
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        System.out.println(response.getBody());
    }

    public void findUnfinishedRouteByRouteName(String routeName) {
        String fooResourceUrl = "http://localhost:8080//find-unfinished-route-by-route-name?name=" + routeName;
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        System.out.println(response.getBody());
    }

    public void findUnfinishedRouteByFullName(String firstName, String lastName, String fatherName) {
        String fooResourceUrl
                = "http://localhost:8080/find-unfinished-route-by-full-name?first_name="
                + firstName + "&last_name=" + lastName + "&father_name=" + fatherName;
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        System.out.println(response.getBody());
    }

}
