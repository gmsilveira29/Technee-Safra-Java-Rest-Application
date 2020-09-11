package com.example.restservice.authentication;

import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class Authentication {

    @Scheduled(fixedRate = 60000)
    public String getBearer() {
        ResponseEntity<String> response = null;
        RestTemplate restTemplate = new RestTemplate();
        //URL
        String url = "https://idcs-902a944ff6854c5fbe94750e48d66be5.identity.oraclecloud.com/oauth2/v1/token";

        //HEADER
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("authorization", "Basic ZjlkM2NkOTYwMDg3NGFjMjgwM2QwM2NhNzA5Yjc4ZWI6MWEyMDc1ZTMtYjE1ZS00MzI0LTkwMmMtMGYxMmY4ZjA4MDgy");
        headers.add("content-type", "application/x-www-form-urlencoded");

        //BODY
        String body = "grant_type=client_credentials&scope=urn:opc:resource:consumer::all";

        //REQUEST
        HttpEntity<String> request = new HttpEntity<String>(body,headers);
        response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

        System.out.println("Print: " + response.getBody() + "\n");

        return response.getBody();    }
}
