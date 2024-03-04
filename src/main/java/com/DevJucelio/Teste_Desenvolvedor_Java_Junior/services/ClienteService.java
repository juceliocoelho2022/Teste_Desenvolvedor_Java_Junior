package com.DevJucelio.Teste_Desenvolvedor_Java_Junior.services;

import com.DevJucelio.Teste_Desenvolvedor_Java_Junior.controllers.TransacaoRequest;
import com.DevJucelio.Teste_Desenvolvedor_Java_Junior.entities.Cliente;
import com.DevJucelio.Teste_Desenvolvedor_Java_Junior.entities.Empresa;
import com.DevJucelio.Teste_Desenvolvedor_Java_Junior.repository.ClienteRepository;
import com.DevJucelio.Teste_Desenvolvedor_Java_Junior.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final TransacaoRepository transacaoRepository;
    private final EmpresaService empresaService;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository, TransacaoRepository transacaoRepository, EmpresaService empresaService) {
        this.clienteRepository = clienteRepository;
        this.transacaoRepository = transacaoRepository;
        this.empresaService = empresaService;
    }

    @Transactional
    public void realizarTransacao(Cliente cliente, Empresa empresa, BigDecimal valor) {
        // Lógica para realizar a transação do cliente
    }

    @Transactional
    public void realizarTransacao(TransacaoRequest request) {
        Cliente cliente = clienteRepository.findById(request.getClienteId()).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        Empresa empresa = empresaService.obterEmpresaPorId(request.getEmpresaId());

        realizarTransacao(cliente, empresa, request.getValor());
    }

    // Outros métodos do serviço
}
