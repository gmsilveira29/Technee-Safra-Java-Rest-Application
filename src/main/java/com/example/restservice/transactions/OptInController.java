package com.example.restservice.transactions;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.example.restservice.authentication.Authentication;

import java.util.Arrays;

@RestController
public class OptInController {

    //responsável por enviar os dados para a inteção de criar conta
    @GetMapping("/optin")
    public String getOptin() {
        Authentication authentication = new Authentication();
        ResponseEntity<String> response = null;
        RestTemplate restTemplate = new RestTemplate();
        //url
        String url = "https://af3tqle6wgdocsdirzlfrq7w5m.apigateway.sa-saopaulo-1.oci.customer-oci.com/fiap-sandbox/accounts/v1/optin";

        //header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Bearer "+ authentication.getBearer());
        headers.add("content-type", "application/json");


        //body com os dados pessoais
        String body = "{\n" +
                "\t\"Name\": \"Eric Evans Silva\",\n" +
                "\t\"Email\":\"eric.evans@ddd.com\",\n" +
                "\t\"Phone\":\"+5511911111111\"\n" +
                "}";

        //request
        HttpEntity<String> request = new HttpEntity<String>(body,headers);
        response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

        return response.getBody();
    }
}
