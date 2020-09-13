package com.example.restservice.transactions;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//classe responsável apenas por retornar o número da versão do software.
//serve para testar a comunicação
public class AboutController {

    @GetMapping("/versao")
    public String getVersao() {

        String versao = "1.0";

        return versao;
    }
}