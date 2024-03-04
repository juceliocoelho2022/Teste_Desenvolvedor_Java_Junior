package com.DevJucelio.Teste_Desenvolvedor_Java_Junior.controllers;

import com.DevJucelio.Teste_Desenvolvedor_Java_Junior.entities.Empresa;
import com.DevJucelio.Teste_Desenvolvedor_Java_Junior.excetion.SaldoInsuficienteException;
import com.DevJucelio.Teste_Desenvolvedor_Java_Junior.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
    @Autowired
    private EmpresaService empresaService;

    @PostMapping("/transacao")
    public ResponseEntity<String> processarTransacao(@RequestBody TransacaoRequest request) {
        // Verificar se a empresa existe
        Empresa empresa = empresaService.obterEmpresaPorId(request.getEmpresaId());
        if (empresa == null) {
            return ResponseEntity.notFound().build();
        }

        // Processar a transação da empresa
        try {
            empresaService.processarTransacao(empresa.getId(), request.getValor());
            return ResponseEntity.ok("Transação processada com sucesso!");
        } catch (Exception | SaldoInsuficienteException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao processar a transação: " + e.getMessage());
        }
    }
}