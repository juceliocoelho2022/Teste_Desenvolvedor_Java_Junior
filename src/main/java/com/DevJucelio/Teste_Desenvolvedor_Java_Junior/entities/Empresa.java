package com.DevJucelio.Teste_Desenvolvedor_Java_Junior.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String nome;

    @Column(unique = true)
    private String cnpj;

    private BigDecimal saldo;

    @OneToMany(mappedBy = "empresa")
    private List<Transacao> transacoes;


}