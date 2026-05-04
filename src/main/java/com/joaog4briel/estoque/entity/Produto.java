package com.joaog4briel.estoque.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "produto") @Getter @Setter @NoArgsConstructor
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @Column(nullable = false)
    private int quantidadeAtual = 0;

    @Column(nullable = false)
    private int quantidadeMinima = 5;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @ManyToMany @JoinTable(
            name = "produto_categoria",  // nome da tabela intermediária
            joinColumns = @JoinColumn(name = "produto_id"),  // FK para produto
            inverseJoinColumns = @JoinColumn(name = "categoria_id")  // FK para categoria
    )
    private List<Categoria> categorias = new ArrayList<>();


}
