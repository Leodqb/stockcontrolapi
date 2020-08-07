package io.com.github.leodqb.controler;

import io.com.github.leodqb.model.entity.Produto;
import io.com.github.leodqb.model.entity.dtos.ProdutoDTO;
import io.com.github.leodqb.model.repositorys.ProdutosRepository;
import io.com.github.leodqb.model.services.impli.ProdutoServiceImpli;
import lombok.RequiredArgsConstructor;
import static org.springframework.http.HttpStatus.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

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

    @DeleteMapping("{id}")
    public void deleteProduto(@PathVariable Integer id){
        produtosRepository.findById(id).map(p -> {
            produtosRepository.delete(p);
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(NOT_FOUND,
                "erro ao excluir produto não foi encontado na base de dados"));
    }

    @PatchMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public Produto atualizandoprecoProduto(@PathVariable Integer id, @RequestBody ProdutoDTO produtoDTO){
        Produto produto = produtosRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(NOT_FOUND, "Não foi possivel encontrar o produto"));
        return prodServiceImpli.atualizaPrecoPoduto(produto,produtoDTO.getValorProduto());
    }

    @GetMapping
    public List<Produto> getProduto(){
        try {
            List<Produto> produtos
                    = produtosRepository
                    .findAll()
                    .stream().collect(Collectors.toList());
            return produtos;
        }catch (Exception e){
            throw new ResponseStatusException(BAD_REQUEST,"erro ao requistar produtos");
        }

    }

}
