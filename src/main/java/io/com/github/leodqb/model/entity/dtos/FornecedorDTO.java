package io.com.github.leodqb.model.entity.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.com.github.leodqb.model.entity.DadosProduto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

// classe modelo de fornecedor
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FornecedorDTO {
    @JsonIgnore
    private String nomeFornecedor;
    private String nomeFamtazia;
    private String cnpj;
    private List<DadosProduto> dadosProdutoSet;

}
