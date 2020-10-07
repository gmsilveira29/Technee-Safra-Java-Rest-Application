package com.example.restservice.authentication;


import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
//Classe responsável pela autenticação com a API do safra e obtenção do Bearer Token
public class Authentication {


    public String getBearer() {
        ResponseEntity<String> response = null;
        RestTemplate restTemplate = new RestTemplate();
        //url
        String url = "...";

        //header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("authorization", "Basic ...");
        headers.add("content-type", "application/x-www-form-urlencoded");

        //definição do body
        String body = "grant_type=client_credentials&scope=urn:opc:resource:consumer::all";

        //criação da request
        HttpEntity<String> request = new HttpEntity<String>(body,headers);
        response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

        //Regex para selecionar apenas o access_token
        String s = response.getBody();
        String[] parts = s.split("\""); //returns an array with the 2 parts
        String firstPart = parts[3]; //14.015

        return firstPart;
    }
}
