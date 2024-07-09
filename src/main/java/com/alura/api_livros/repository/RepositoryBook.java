package com.alura.api_livros.repository;

import com.alura.api_livros.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositoryBook extends JpaRepository<Book, Long> {
    @Query("SELECT i FROM Book i WHERE i.idioma LIKE %:idiomaEscolhido%")
    List<Book> findAllByIdioma(String idiomaEscolhido);
}
