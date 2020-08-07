package io.com.github.leodqb.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "dadosproduto")
public class DadosProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    @JsonIgnore
    private Fornecedor fornecedorId;
    private Integer quantidade;
    private LocalDate dataEntrega;
    private Double valorRemessa;
    private LocalDate dataFabricacao;
    private LocalDate dataValidade;
}

