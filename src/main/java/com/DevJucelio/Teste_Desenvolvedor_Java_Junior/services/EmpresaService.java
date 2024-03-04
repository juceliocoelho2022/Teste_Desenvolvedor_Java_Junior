package com.DevJucelio.Teste_Desenvolvedor_Java_Junior.services;

import com.DevJucelio.Teste_Desenvolvedor_Java_Junior.entities.Empresa;
import com.DevJucelio.Teste_Desenvolvedor_Java_Junior.excetion.SaldoInsuficienteException;
import com.DevJucelio.Teste_Desenvolvedor_Java_Junior.repository.EmpresaRepository;
import com.DevJucelio.Teste_Desenvolvedor_Java_Junior.repository.TransacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;
    private final NotificacaoService notificacaoService;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository, NotificacaoService notificacaoService) {
        this.empresaRepository = empresaRepository;
        this.notificacaoService = notificacaoService;
    }

    @Transactional
    public void processarTransacao(Long idEmpresa, BigDecimal valor) throws SaldoInsuficienteException {
        Empresa empresa = obterEmpresaPorId(idEmpresa);
        if (empresa == null) {
            // Lidar com o caso em que a empresa não é encontrada
            return;
        }

        verificarSaldoSuficiente(empresa, valor);
        BigDecimal valorComTaxas = aplicarTaxas(empresa, valor);
        atualizarSaldoEmpresa(empresa, valorComTaxas);
        notificarTransacaoRealizada(empresa);
    }

    private void verificarSaldoSuficiente(Empresa empresa, BigDecimal valor) throws SaldoInsuficienteException {
        if (empresa.getSaldo().compareTo(valor) < 0) {
            throw new SaldoInsuficienteException("Saldo insuficiente na empresa " + empresa.getId());
        }
    }

    private BigDecimal aplicarTaxas(Empresa empresa, BigDecimal valor) {
        // Lógica para aplicar taxas de transação (se necessário)
        // Retorna o valor com as taxas aplicadas
        return valor;
    }

    private void atualizarSaldoEmpresa(Empresa empresa, BigDecimal valor) {
        BigDecimal novoSaldo = empresa.getSaldo().subtract(valor);
        empresa.setSaldo(novoSaldo);
        empresaRepository.save(empresa);
    }

    private void notificarTransacaoRealizada(Empresa empresa) {
        notificacaoService.enviarNotificacaoEmpresa(empresa, "Transação realizada com sucesso");
    }

    public Empresa obterEmpresaPorId(Long id) {
        return empresaRepository.findById(id).orElse(null);
    }
}