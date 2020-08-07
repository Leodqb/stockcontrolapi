package io.com.github.leodqb.model.services.impli;

import io.com.github.leodqb.model.entity.Produto;
import io.com.github.leodqb.model.entity.dtos.ProdutoDTO;
import io.com.github.leodqb.model.excepionsapi.ErroNoProcessoDeSalvamentoException;
import io.com.github.leodqb.model.repositorys.ProdutosRepository;
import io.com.github.leodqb.model.services.interfaces.ProdutosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//Classe de regra de negocio da entidade produto
@Service
@RequiredArgsConstructor
public class ProdutoServiceImpli implements ProdutosService {
    private final ProdutosRepository produtosRepository;

    @Transactional
    @Override
    public Produto salvarProduto(ProdutoDTO produtoDTO){
        try {
            Produto produto = new Produto();
            produto.setNomeProduto(produtoDTO.getNomeProduto());
            produto.setValor(produtoDTO.getValorProduto());
            return produtosRepository.save(produto);
        } catch (Exception e){
            throw new ErroNoProcessoDeSalvamentoException();
        }
    }
    @Transactional
    @Override
    public Produto atualizaPrecoPoduto(Produto produto, Double Valor){
        try {
          produto.setValor(Valor);
          return produtosRepository.save(produto);
        }catch (Exception e){
            throw new ErroNoProcessoDeSalvamentoException("Valor inserido não e valido");
        }
    }
}
