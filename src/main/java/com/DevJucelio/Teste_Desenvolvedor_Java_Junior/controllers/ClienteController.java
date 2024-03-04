package com.DevJucelio.Teste_Desenvolvedor_Java_Junior.controllers;

import com.DevJucelio.Teste_Desenvolvedor_Java_Junior.services.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/transacao")
    public ResponseEntity<String> realizarTransacao(@RequestBody TransacaoRequest request) {
        if (request == null) {
            return ResponseEntity.badRequest().body("Dados da transação inválidos");
        }

        // Lógica para realizar a transação do cliente
        try {
            clienteService.realizarTransacao(request);
            return ResponseEntity.ok("Transação realizada com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao processar a transação: " + e.getMessage());
        }
    }

    // Outros endpoints do controlador
}
