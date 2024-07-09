package com.alura.api_livros.model;


import com.alura.api_livros.model.DTO.AuthorsDTO;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "autores")
@Getter
public class Authors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int anoNascimento;
    private int anoFalecimento;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "authors")
    private List<Book> livros = new ArrayList<>();

    public Authors(AuthorsDTO authorsDTO){
        this.nome = authorsDTO.nome();
        this.anoNascimento = authorsDTO.dataNascimento();
        this.anoFalecimento = authorsDTO.dataMorte();
    }

    public Authors(){}
    @Override
    public String toString() {
        return "\n-----------------------AUTOR-----------------------" +
                "\nnome: " + nome +
                "\nData de Nascimento: " + anoNascimento +
                "\nData de Falecimento: " + anoFalecimento+
                "\nLivro: " + livros.stream()
                .map(livros -> livros.getNome())
                .collect(Collectors.toList()) +
                "\n--------------------------------------------------";

    }
}