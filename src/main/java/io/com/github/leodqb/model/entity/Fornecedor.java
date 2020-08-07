package io.com.github.leodqb.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
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
    @NotEmpty(message = "voce deve informar o nome do fornecedor")
    private String nomeFornecedor;
    @NotEmpty(message = "você devve informar o nome fantazia do fornecedor")
    private String nomeFantazia;
    @CNPJ
    @NotEmpty(message = "você deve informar o cnpj do fornecedor")
    @Column(length = 14)
    private String cnpj;

    @JsonIgnore
    @OneToMany (mappedBy = "fornecedorId",fetch = FetchType.LAZY )
    private Set<DadosProduto> dadosProduto;

}
