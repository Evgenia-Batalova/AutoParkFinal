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
}
