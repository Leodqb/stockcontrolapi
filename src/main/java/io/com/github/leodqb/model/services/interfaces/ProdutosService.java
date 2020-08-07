package io.com.github.leodqb.model.services.interfaces;

import io.com.github.leodqb.model.entity.Produto;
import io.com.github.leodqb.model.entity.dtos.ProdutoDTO;

public interface ProdutosService {
    public Produto salvarProduto(ProdutoDTO produtoDTO);
    public Produto atualizaPrecoPoduto(Produto produto, Double Valor);

    }
