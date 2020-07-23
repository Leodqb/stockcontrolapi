package io.com.github.leodqb.controler;

import io.com.github.leodqb.model.entity.Produto;
import io.com.github.leodqb.model.entity.dtos.ProdutoDTO;
import io.com.github.leodqb.model.repositorys.ProdutosRepository;
import io.com.github.leodqb.model.services.impli.ProdutoServiceImpli;
import lombok.RequiredArgsConstructor;
import static org.springframework.http.HttpStatus.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/spring/shop/prod")
@RequiredArgsConstructor
public class ProdutoControler {
    private final ProdutoServiceImpli prodServiceImpli;
    private final ProdutosRepository produtosRepository;


    @PostMapping
    @ResponseStatus(CREATED)
    public Produto saveProduto(@RequestBody ProdutoDTO produtoDTO){
        return prodServiceImpli.salvarProduto(produtoDTO);
    }

    @GetMapping("{id}")
    public Produto getProduto(@PathVariable Integer id){
        return produtosRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(NOT_FOUND, "Não foi possivel encontrar o produto"));
    }



}
