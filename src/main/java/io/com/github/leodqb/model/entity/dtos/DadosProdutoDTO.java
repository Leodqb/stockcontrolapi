package io.com.github.leodqb.model.entity.dtos;

import io.com.github.leodqb.model.entity.Fornecedor;
import io.com.github.leodqb.model.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
// classe de modelo de dados de produto dto

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DadosProdutoDTO {

    private Produto produto;
    private Fornecedor fornecedorId;
    private Integer quantidade;
    private LocalDate dataEntrega;
    private Double valorRemessa;
    private LocalDate dataFabricacao;
    private LocalDate dataValidade;


}
