package com.DevJucelio.Teste_Desenvolvedor_Java_Junior.controllers;

import com.DevJucelio.Teste_Desenvolvedor_Java_Junior.entities.Transacao;
import com.DevJucelio.Teste_Desenvolvedor_Java_Junior.services.TransacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transacoes")
public class TransacaoController {

    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @GetMapping
    public ResponseEntity<List<Transacao>> listarTransacoes() {
        List<Transacao> transacoes = transacaoService.listarTransacoes();
        return ResponseEntity.ok(transacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transacao> buscarTransacaoPorId(@PathVariable Long id) {
        Transacao transacao = transacaoService.buscarTransacaoPorId(id);
        return transacao != null ? ResponseEntity.ok(transacao) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Transacao> criarTransacao(@RequestBody Transacao transacao) {
        Transacao novaTransacao = transacaoService.salvarTransacao(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTransacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTransacao(@PathVariable Long id) {
        transacaoService.deletarTransacao(id);
        return ResponseEntity.noContent().build();
    }
}