package io.com.github.leodqb.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

//classe que faz referencia a tabela de produtos do banco de dados

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "{um.produto.deve.conter.um.nome}")
    private String nomeProduto;
    @NotNull(message = "{um.produto.deve.conter.um.valor}")
    @Column(precision = 20, scale = 2)
    private double valor;



}
