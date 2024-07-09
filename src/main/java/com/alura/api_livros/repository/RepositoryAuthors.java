package com.alura.api_livros.repository;

import com.alura.api_livros.model.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositoryAuthors extends JpaRepository<Authors, Long> {
    @Query("SELECT a FROM Authors a WHERE a.anoNascimento <= :ano AND (a.anoFalecimento IS NULL OR a.anoFalecimento >= :ano)")
    List<Authors> findAllByAno(Integer ano);
}
