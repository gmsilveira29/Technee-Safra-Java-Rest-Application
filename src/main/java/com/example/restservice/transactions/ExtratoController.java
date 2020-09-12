package com.example.restservice.transactions;

import com.example.restservice.authentication.Authentication;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

//import com.jayway.jsonpath.JsonPath;

@RestController
public class ExtratoController {

    @GetMapping("/extrato")
    public String getExtrato() {
        Authentication authentication = new Authentication();
        String bearer = authentication.getBearer();

        ResponseEntity<String> response = null;
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Bearer "+ authentication.getBearer());

        HttpEntity<String> request = new HttpEntity<String>(headers);
        String url = "https://af3tqle6wgdocsdirzlfrq7w5m.apigateway.sa-saopaulo-1.oci.customer-oci.com/fiap-sandbox/open-banking/v1/accounts/00711234511/transactions";

        response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);

        String s = response.getBody();
        String[] parts = s.split("\""); //returns an array with the 2 parts
        String valor = parts[17]; //14.015
        String data = parts[33];
        String tipo = parts[25];
        String info = parts[41]; //14.015

        return "Valor: R$ "+ valor +
                "\nData: " + data +
                "\nTipo de transação: " + tipo +
                "\nInfo: " + info;
    }
}
