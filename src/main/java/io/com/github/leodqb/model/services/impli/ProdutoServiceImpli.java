package io.com.github.leodqb.model.services.impli;

import io.com.github.leodqb.model.entity.Produto;
import io.com.github.leodqb.model.entity.dtos.ProdutoDTO;
import io.com.github.leodqb.model.repositorys.ProdutosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//Classe de regra de negocio da entidade produto
@Service
@RequiredArgsConstructor
public class ProdutoServiceImpli {
    private final ProdutosRepository produtosRepository;
    @Transactional
    public Produto salvarProduto(ProdutoDTO produtoDTO){
        Produto produto = new Produto();
        produto.setNomeProduto(produtoDTO.getNomeProduto());
        produto.setValor(produtoDTO.getValorProduto());
        return produtosRepository.save(produto);
    }

}
