package com.DevJucelio.Teste_Desenvolvedor_Java_Junior.repository;

import com.DevJucelio.Teste_Desenvolvedor_Java_Junior.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface do repositório para a entidade Cliente.
 * Esta interface fornece métodos de acesso aos dados do cliente no banco de dados.
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // Nenhum método adicional é necessário aqui porque o JpaRepository já fornece métodos CRUD básicos.
    // No entanto, você pode adicionar métodos personalizados de consulta, se necessário, aqui.
}
