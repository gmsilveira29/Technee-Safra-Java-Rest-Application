package com.example.restservice.transactions;

import com.example.restservice.authentication.Authentication;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

//import com.jayway.jsonpath.JsonPath;

@RestController
//classe responsável por retornar o saldo da conta corrente
public class SaldoController {

    @GetMapping("/saldo")
    public String getSaldo() {
        Authentication authentication = new Authentication();
        String bearer = authentication.getBearer();
        ResponseEntity<String> response = null;
        RestTemplate restTemplate = new RestTemplate();

        //header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Bearer "+ authentication.getBearer());

        HttpEntity<String> request = new HttpEntity<String>(headers);
        //url
        String url = "https://af3tqle6wgdocsdirzlfrq7w5m.apigateway.sa-saopaulo-1.oci.customer-oci.com/fiap-sandbox/open-banking/v1/accounts/00711234511/balances";

        response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);

        //regex para filtrar o saldo
        String s = response.getBody();
        String[] parts = s.split("\""); //returns an array with the 2 parts
        String saldo = parts[13]; //14.015

        return "Saldo: R$ " + saldo;
    }
}
