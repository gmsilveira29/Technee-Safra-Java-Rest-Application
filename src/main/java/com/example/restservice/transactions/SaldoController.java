package com.example.restservice.transactions;

import com.example.restservice.authentication.Authentication;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

//import com.jayway.jsonpath.JsonPath;

@RestController
public class SaldoController {

    @GetMapping("/saldo")
    public String getSaldo() {
        Authentication authentication = new Authentication();
        String bearer = authentication.getBearer();
        ResponseEntity<String> response = null;
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Bearer eyJ4NXQjUzI1NiI6IlNhWkUtSjdJdDBQWFRYNFlCaTBCeXk4WWhPVlJkSzlNNXgzREN3R2ZnbkEiLCJ4NXQiOiJVSWpBeHIyTWlzNk9JdTNMS2NsX3JPSHl3eXMiLCJraWQiOiJTSUdOSU5HX0tFWSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiJmOWQzY2Q5NjAwODc0YWMyODAzZDAzY2E3MDliNzhlYiIsImd0cCI6ImNjIiwidXNlci50ZW5hbnQubmFtZSI6ImlkY3MtOTAyYTk0NGZmNjg1NGM1ZmJlOTQ3NTBlNDhkNjZiZTUiLCJzdWJfbWFwcGluZ2F0dHIiOiJ1c2VyTmFtZSIsInByaW1UZW5hbnQiOnRydWUsImlzcyI6Imh0dHBzOlwvXC9pZGVudGl0eS5vcmFjbGVjbG91ZC5jb21cLyIsInRva190eXBlIjoiQVQiLCJjbGllbnRfaWQiOiJmOWQzY2Q5NjAwODc0YWMyODAzZDAzY2E3MDliNzhlYiIsImNhX2d1aWQiOiJjYWNjdC1iOThlNGJjZDQ1MDU0YjZlOTc3NzU5OThiNmYzNmYwNiIsImF1ZCI6InVybjpvcGM6cmVzb3VyY2U6c2NvcGU6YWNjb3VudCIsInN1Yl90eXBlIjoiY2xpZW50Iiwic2NvcGUiOiJ1cm46b3BjOnJlc291cmNlOmNvbnN1bWVyOjphbGwiLCJjbGllbnRfdGVuYW50bmFtZSI6ImlkY3MtOTAyYTk0NGZmNjg1NGM1ZmJlOTQ3NTBlNDhkNjZiZTUiLCJleHAiOjE1OTk4NTI2MTMsImlhdCI6MTU5OTg0OTAxMywidGVuYW50X2lzcyI6Imh0dHBzOlwvXC9pZGNzLTkwMmE5NDRmZjY4NTRjNWZiZTk0NzUwZTQ4ZDY2YmU1LmlkZW50aXR5Lm9yYWNsZWNsb3VkLmNvbTo0NDMiLCJjbGllbnRfZ3VpZCI6IjkxZDdjNWIzOGM5ZjQ4MjNhZDA0ODIwMzY5NzZkZjJiIiwiY2xpZW50X25hbWUiOiJUaW1lIDEiLCJ0ZW5hbnQiOiJpZGNzLTkwMmE5NDRmZjY4NTRjNWZiZTk0NzUwZTQ4ZDY2YmU1IiwianRpIjoiMTFlYWY0NWNkNGJjNGM1NThiNDE1NTAxMTAxN2YwMzEifQ.IVjwC-TqvKXrqHxMS0r8fGky3joaBVgJrWtso8OqDYa7uRngnyH8MXxyZbi6uMi-PGiyXZ17B17y0SVxLLNcg_cg4hPGM82er6--Gexg0q0TOHIiZNQMiYt8B_EYjqXAobjvceC-rnV-psSdhnExk9XTf06erPir8S1KfQBQi0VbVNx5DIGvE02MLfLl_gRfJ8PvEl3lBXTLj_rtF6Z4bl8wmATEuC2eGgGh914baJMDsrY8_zTo_DZkZIO2yimUn1yb0wXmaoMs1RM1uYcSKapCv4qKQiZ6387ua2C2dgOh83ICuSt5R3vrnTDsKGtqdMZZsh4azXwF-Rmx6-bzyA");

        HttpEntity<String> request = new HttpEntity<String>(headers);
        String url = "https://af3tqle6wgdocsdirzlfrq7w5m.apigateway.sa-saopaulo-1.oci.customer-oci.com/fiap-sandbox/open-banking/v1/accounts/00711234511/balances";

        response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);

        System.out.println("Saldo: \n" + response.getBody());

        //List<String> saldo = JsonPath.read(response.getBody(), "$.Data.Balance[*].Amount.Amount");
        return response.getBody();
    }
}
