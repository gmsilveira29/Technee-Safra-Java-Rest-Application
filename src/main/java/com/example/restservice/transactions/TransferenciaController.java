package com.example.restservice.transactions;


import com.example.restservice.authentication.Authentication;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController

public class TransferenciaController {

    // funcionalidade de transferencia funcionado de forma mockada
    // por falta de tempo não foi implementada no chatbot, mas foi criada aqui
    @GetMapping("/transferencia")
    public String getTransferencia() {
        Authentication authentication = new Authentication();
        ResponseEntity<String> response = null;
        RestTemplate restTemplate = new RestTemplate();
        //url
        String url = "https://af3tqle6wgdocsdirzlfrq7w5m.apigateway.sa-saopaulo-1.oci.customer-oci.com/fiap-sandbox/accounts/v1/accounts/00711234511/transfers";

        //header
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Bearer "+ authentication.getBearer());
        headers.add("content-type", "application/json");

        //body
        String body = "{\n" +
                "\t\n" +
                "\t  \"Type\": \"TEF\",\n" +
                "\t  \n" +
                "\t  \n" +
                "\t  \n" +
                "    \"TransactionInformation\": \"Mensalidade Academia\",  \"DestinyAccount\": {\n" +
                "        \"Bank\": \"422\",\n" +
                "        \"Agency\": \"0071\",\n" +
                "        \"Id\": \"1234533\",\n" +
                "        \"Cpf\": \"12345678933\",\n" +
                "        \"Name\": \"Mark Zuckerberg da Silva\",\n" +
                "        \"Goal\":\"Credit\"\n" +
                "    },\n" +
                "\t\t    \"Amount\": {\n" +
                "\t\t          \"Amount\": \"250.00\",\n" +
                "\t\t          \"Currency\": \"BRL\"\n" +
                "\t\t        }\n" +
                "\t\t\t\t\t  \n" +
                "} ";

        //request
        HttpEntity<String> request = new HttpEntity<String>(body,headers);
        response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

        return response.getBody();
    }
}
