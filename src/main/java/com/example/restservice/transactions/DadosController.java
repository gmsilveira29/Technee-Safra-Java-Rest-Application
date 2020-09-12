package com.example.restservice.transactions;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.example.restservice.authentication.Authentication;
import java.util.Arrays;

@RestController
public class DadosController {

    @GetMapping("/dados")
    public String getDados() {
        Authentication authentication = new Authentication();
        String bearer = authentication.getBearer();
        ResponseEntity<String> response = null;
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Bearer "+ authentication.getBearer());

        HttpEntity<String> request = new HttpEntity<String>(headers);
        String url = "https://af3tqle6wgdocsdirzlfrq7w5m.apigateway.sa-saopaulo-1.oci.customer-oci.com/fiap-sandbox/open-banking/v1/accounts/00711234511";

        response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);

        System.out.println("Dados da conta: \n" +  response.getBody());

        return response.getBody();
    }
}
