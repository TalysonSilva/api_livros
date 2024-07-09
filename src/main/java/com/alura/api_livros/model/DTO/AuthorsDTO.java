package com.alura.api_livros.model.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AuthorsDTO(
        @JsonAlias("name") String nome,
        @JsonAlias("birth_year") Integer dataNascimento,
        @JsonAlias("death_year") Integer dataMorte) {
}
