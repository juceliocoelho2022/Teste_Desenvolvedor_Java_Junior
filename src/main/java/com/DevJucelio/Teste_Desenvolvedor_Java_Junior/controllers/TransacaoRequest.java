package com.DevJucelio.Teste_Desenvolvedor_Java_Junior.controllers;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class TransacaoRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String cnpj;
    private BigDecimal valor;
    private BigDecimal saldo;
    @Column(name = "empresa_id")
    private Long EmpresaId;
    private Long ClienteId;

}
