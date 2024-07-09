package com.alura.api_livros.model.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookDTO(@JsonAlias("title") String titulo,
                      @JsonAlias("authors") List<AuthorsDTO> autores,
                      @JsonAlias("languages") List<String> idioma,
                      @JsonAlias("download_count") Integer numeroDownloads) {
}
