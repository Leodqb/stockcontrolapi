package io.com.github.leodqb.model.repositorys;

import io.com.github.leodqb.model.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutosRepository extends JpaRepository<Produto, Integer> {

    @Override
    Optional<Produto> findById(Integer integer);
}
