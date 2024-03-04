package com.DevJucelio.Teste_Desenvolvedor_Java_Junior.repository;

import com.DevJucelio.Teste_Desenvolvedor_Java_Junior.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface do repositório para a entidade Empresa.
 * Esta interface fornece métodos de acesso aos dados da empresa no banco de dados.
 */
@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    // Nenhum método adicional é necessário aqui porque o JpaRepository já fornece métodos CRUD básicos.
    // No entanto, você pode adicionar métodos personalizados de consulta, se necessário, aqui.
}

