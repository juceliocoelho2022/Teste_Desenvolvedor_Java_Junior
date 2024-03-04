package com.DevJucelio.Teste_Desenvolvedor_Java_Junior.repository;

import com.DevJucelio.Teste_Desenvolvedor_Java_Junior.entities.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
