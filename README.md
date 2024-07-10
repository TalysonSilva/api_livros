# APi Livros

Este projeto surgiu como um desafio proposto pela Oracle + Alura que consite numa criação de uma aplicação que consome a api  [Gutendex](https://gutendex.com/) que é bliblioteca de livros possuir em sua base de dados diversos livros incluido a informação dos autores essa informção da aplicação serão armazenado nosso proprio banco de dados e deposi reutilizado ex: Solicitar o historico de livros pesquisado.

## 🛠 Tecnologia Utiizadas

- Java 21
- Maven
- Spring Boot 3.3.1
- PostgreSQL

## Funcionalidades

- Busca Livro por título
- Lista de Livros registrados.
- Lista de Autores registrados.
- Lista de Autores vivos num determinado ano.
- Lista de Livros num determinado idioma.
  
## Dependecias 

- Java versão 21
- Possuir PostgreSQL instalado na maquina
- Verificar se no arquivo ``application.properties`` nos campos são iguais codigo abaixo:
```bash
  spring.datasource.url=jdbc:postgresql://localhost/livros_bd
  spring.datasource.username=postgres
  spring.datasource.password=123
```

## Executar Programa
1. Download do projeto 
2. Extrai e depois executar o arquivo ``ApiLivrosApplication.java`` no terminal ou  abri o projeto numa IDE(Eclipse ou IntelliJ IDEA) e depois executar o arquivo
## Autor

- [Talyson Silva](https://github.com/TalysonSilva)

