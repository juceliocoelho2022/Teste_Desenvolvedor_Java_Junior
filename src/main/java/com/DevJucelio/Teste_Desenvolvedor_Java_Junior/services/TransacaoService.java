package com.DevJucelio.Teste_Desenvolvedor_Java_Junior.services;

import com.DevJucelio.Teste_Desenvolvedor_Java_Junior.entities.Transacao;
import com.DevJucelio.Teste_Desenvolvedor_Java_Junior.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;

    @Autowired
    public TransacaoService(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @Transactional(readOnly = true)
    public List<Transacao> listarTransacoes() {
        return transacaoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Transacao buscarTransacaoPorId(Long id) {
        Optional<Transacao> optionalTransacao = transacaoRepository.findById(id);
        return optionalTransacao.orElse(null);
    }

    @Transactional
    public Transacao salvarTransacao(Transacao transacao) {
        return transacaoRepository.save(transacao);
    }

    @Transactional
    public void deletarTransacao(Long id) {
        transacaoRepository.deleteById(id);
    }
}
