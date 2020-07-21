package io.com.github.leodqb.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

//Classe que faz referencia a tabela de fornecedores do banco de dados

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    private String nomeFornecedor;
    @NotEmpty
    private String nomeFamtazia;
    @CNPJ
    @NotEmpty
    private String cnpj;
    @OneToMany
    private Set<DadosProduto> dadosProduto;

}
