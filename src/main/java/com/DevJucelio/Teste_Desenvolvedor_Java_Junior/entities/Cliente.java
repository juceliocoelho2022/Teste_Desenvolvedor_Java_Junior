package com.DevJucelio.Teste_Desenvolvedor_Java_Junior.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String cpf;
    private BigDecimal valor;
    private BigDecimal saldo;
}