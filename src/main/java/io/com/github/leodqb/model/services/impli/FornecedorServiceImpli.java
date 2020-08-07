package io.com.github.leodqb.model.services.impli;

import io.com.github.leodqb.model.entity.DadosProduto;
import io.com.github.leodqb.model.entity.Fornecedor;
import io.com.github.leodqb.model.entity.dtos.FornecedorDTO;
import io.com.github.leodqb.model.excepionsapi.FornecedorServiceErroException;
import io.com.github.leodqb.model.repositorys.DadosProdutosRepository;
import io.com.github.leodqb.model.repositorys.FornecedoresRepository;
import io.com.github.leodqb.model.repositorys.ProdutosRepository;
import io.com.github.leodqb.model.services.interfaces.FornecedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FornecedorServiceImpli implements FornecedorService {
   private final FornecedoresRepository fornecedoresRepository;
   private final DadosProdutosRepository dadosProdutosRepository;
   private final ProdutosRepository ProdutosRepository;

   //salvando fornecedores no banco de dados.
   @Override
   @Transactional
   public Fornecedor SalvaFornecedor(FornecedorDTO fornecedorDTO){
       // instacia uma instancia e retorna uma classe FornecedorDTO atravez de um build
       Fornecedor fornecedor = Fornecedor.builder()
               .nomeFornecedor(fornecedorDTO.getNomeFornecedor())
               .nomeFantazia(fornecedorDTO.getNomeFamtazia())
               .cnpj(fornecedorDTO.getCnpj()).build();
       // salva e retorna o fornecedor
       return fornecedoresRepository.save(fornecedor);
   }

   /* metodo que recupera todos os dados do fornecedor
    incluindo os dados dos produtos que ele oferece
    retorna a classe de modelo fornecedorDTO
    */
   @Override
   @Transactional
   public FornecedorDTO resgatandoDadosCompletosFornecedoresDoBD(Integer id){
        // faz a busca dos dados do fornecedor atravez do seu id
       // classe de entidade fornecedor!
          Fornecedor fornecedor = fornecedoresRepository.findById(id).orElseThrow
                  (() ->
                          new FornecedorServiceErroException(
                                  "Erro Ao resgatar fornecedor"));
          // faz a busca dos dados dos produtos fornecidos pelo fornecedor

          List<DadosProduto> dadosProdutoDTO = dadosProdutosRepository
                  .findByJoinFatchFornecedor(fornecedor.getId());

          // instacia uma instancia e retorna uma classe FornecedorDTO atravez de um build
      return FornecedorDTO.builder()
              .nomeFamtazia(fornecedor.getNomeFantazia())
              .nomeFornecedor(fornecedor.getNomeFantazia())
              .cnpj(fornecedor.getCnpj())
              .dadosProdutoSet(dadosProdutoDTO).build();

   }

    /* metodo que recupera todos os dados do fornecedor
     exceto os produtos que ele fornece
     retorna a classe de entidade padra de fornecedor
     */
    @Override
    @Transactional
    public Fornecedor resgatandoFornecedoresDoBD(Integer id) {
        // faz a busca dos dados do fornecedor atravez do seu id
        // classe de entidade de fornecedor!
        Fornecedor fornecedor = fornecedoresRepository.findById(id).orElseThrow
                (() ->
                        new FornecedorServiceErroException("Erro Ao resgatar fornecedor"));
        return fornecedor;
    }
}
