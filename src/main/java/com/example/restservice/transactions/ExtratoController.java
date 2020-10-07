package com.example.restservice.transactions;

import com.example.restservice.authentication.Authentication;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

//import com.jayway.jsonpath.JsonPath;

@RestController
//classe responsável por retornar o extrato bancário
public class ExtratoController {

    @GetMapping("/extrato")
    public String getExtrato() {
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
        String url = "...";

        response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);

        //regex para selecionar o valor, data, tipo de transação e info do extrato
        String s = response.getBody();
        String[] parts = s.split("\"");
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
