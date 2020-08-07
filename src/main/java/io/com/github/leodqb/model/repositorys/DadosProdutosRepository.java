package io.com.github.leodqb.model.repositorys;

import io.com.github.leodqb.model.entity.DadosProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DadosProdutosRepository extends JpaRepository<DadosProduto, Integer> {

    @Query("select p from DadosProduto p left join fetch p.fornecedorId d where d.id = :id")
    List<DadosProduto> findByJoinFatchFornecedor(@Param("id") Integer id);
}
