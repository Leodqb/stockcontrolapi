package io.com.github.leodqb.model.services.interfaces;

import io.com.github.leodqb.model.entity.Fornecedor;
import io.com.github.leodqb.model.entity.dtos.FornecedorDTO;
import org.springframework.transaction.annotation.Transactional;

public interface FornecedorService {
    //salvando fornecedores no banco de dados.
     @Transactional
     Fornecedor SalvaFornecedor(FornecedorDTO fornecedorDTO);

    @Transactional
    Fornecedor resgatandoFornecedoresDoBD(Integer id);


    /* metodo que recupera todos os dados do fornecedor
         incluindo os dados dos produtos que ele oferece
         retorna a classe de modelo fornecedorDTO
     */
    @Transactional
    FornecedorDTO resgatandoDadosCompletosFornecedoresDoBD(Integer id);
}
