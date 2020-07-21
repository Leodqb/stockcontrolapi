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
    @NotEmpty
    @Column(length = 20)
    private String nomeProduto;
    @NotNull
    @Column(length = 20,precision = 2)
    private double valor;



}
