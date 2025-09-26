package com.example.projeto_many_to_many.services;

import com.example.projeto_many_to_many.dtos.CepDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CepService {
    private final RestTemplate restTemplate =  new RestTemplate();

    private final WebClient webClient;

    public CepService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://viacep.com.br/ws/").build();
    }

    public CepDto buscarCep(String cep){
        String url = "https://viacep.com.br/ws/"+cep+"/json/";
        return restTemplate.getForObject(url, CepDto.class);
    }

    public CepDto buscarCepWebClient(String cep){
        return webClient.get()
                .uri("/{cep}/json", cep)
                .retrieve()
                .bodyToMono(CepDto.class)
                .block();
    }



}
