package io.com.github.leodqb.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
//classe que faz referencia a tabela dados produto do banco de dados
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class DadosProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private Produto produto;
    @ManyToOne
    private Fornecedor fornecedor;
    private Integer quantidade;
    private LocalDate dataEntrega;
    private Double valorRemessa;
    private LocalDate dataFabricaca;
    private LocalDate dataValidade;
}
