package io.com.github.leodqb.controler;

import io.com.github.leodqb.model.entity.Fornecedor;
import io.com.github.leodqb.model.entity.Produto;
import io.com.github.leodqb.model.entity.dtos.FornecedorDTO;
import io.com.github.leodqb.model.excepionsapi.FornecedorServiceErroException;
import io.com.github.leodqb.model.repositorys.FornecedoresRepository;
import io.com.github.leodqb.model.services.interfaces.FornecedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.table.TableRowSorter;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/api/fornecedores")
@RequiredArgsConstructor
public class FornecedorControler {
    private final FornecedoresRepository fornecedoresRepository;
    private final FornecedorService fornecedorService;



    @GetMapping("{id}")
    public FornecedorDTO getFornecedores(@PathVariable Integer id){
        try {
            return fornecedorService.resgatandoDadosCompletosFornecedoresDoBD(id);
        }catch (FornecedorServiceErroException e){
           throw new ResponseStatusException(NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public void deleteFornecedores(@PathVariable Integer id){
        fornecedoresRepository.findById(id).map(p -> {
            fornecedoresRepository.delete(p);
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(NOT_FOUND,
                "erro ao excluir fornecedor não foi encontrado na base de dados"));
    }

    @GetMapping
    public List<Fornecedor> getFornecedores(){
        try {
            List<Fornecedor> fornecedores
                    = fornecedoresRepository
                    .findAll()
                    .stream().collect(Collectors.toList());
            return fornecedores;
        }catch (Exception e){
            throw new ResponseStatusException(BAD_REQUEST,"erro ao requistar fornecedores");
        }

    }

}
