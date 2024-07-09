package com.alura.api_livros.model;

import com.alura.api_livros.model.DTO.BookDTO;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "livros")
@Getter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne(cascade=CascadeType.PERSIST)
    private  Authors authors;
    private String idioma;
    private Integer numeroTotalDownloads;

    public Book(){}
    public Book(BookDTO livros) {
        this.nome = livros.titulo();
        Authors novoAuthors = new Authors(livros.autores().get(0));
        this.authors = novoAuthors;
        this.idioma = livros.idioma().get(0);
        this.numeroTotalDownloads = livros.numeroDownloads();
    }

    public Book(Long id, String titulo, Authors autor, String idioma, Integer numeroDownloads) {
        this.id = id;
        this.nome = titulo;
        this.authors = autor;
        this.idioma = idioma;
        this.numeroTotalDownloads = numeroDownloads;
    }
    @Override
    public String toString() {
        return "\n----------- LIVRO ------------\n" +
                "nome='" + nome + '\'' +
                ", autor=" + authors.getNome()+
                ", idioma=" + idioma +
                ", numeroTotalDownloads=" + numeroTotalDownloads +
                '}';
    }
}
