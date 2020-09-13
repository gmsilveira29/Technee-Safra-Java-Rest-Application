package com.example.restservice.transactions;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.example.restservice.authentication.Authentication;
import java.util.Arrays;

@RestController
//classe responsável por retornar os dados da conta
public class DadosController {

    @GetMapping("/dados")
    public String getDados() {
        Authentication authentication = new Authentication();
        String bearer = authentication.getBearer();
        ResponseEntity<String> response = null;
        RestTemplate restTemplate = new RestTemplate();

        //headers
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("Authorization", "Bearer "+ authentication.getBearer());

        HttpEntity<String> request = new HttpEntity<String>(headers);
        //url
        String url = "https://af3tqle6wgdocsdirzlfrq7w5m.apigateway.sa-saopaulo-1.oci.customer-oci.com/fiap-sandbox/open-banking/v1/accounts/00711234511";

        response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);

        //regex para selecionar numero da conta, apelido, identidade de nome cadastrado
        String s = response.getBody();
        String[] parts = s.split("\"");
        String numeroConta = parts[7];
        String apelido = parts[15];
        String identidade = parts[25];
        String nomeConta = parts[29];

        return "Número da conta: "+ numeroConta +
                "\nNome: " + nomeConta +
                "\nApelido: " + apelido +
                "\nIdentidade: " + identidade;
    }
}
