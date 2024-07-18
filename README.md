# APi Livros

<p align="center">
   <img src="https://img.shields.io/badge/build-CONCLUIDO-brightgreen?style=for-the-badge&logo=DESENVOLVIMENTO%20&logoColor=500%2C100%2C100&label=STATUS%20"/> </p>
</P>

Este projeto surgiu como um desafio proposto pela Oracle + Alura que consiste numa criação de uma aplicação que consome a API [Gutendex](https://gutendex.com/) que é biblioteca que possuir em sua base de dados diversos livros incluindo a informação dos autores essa informação da aplicação serão armazenados no PostgreSQL e depois reutilizado as informações armazenadas.

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
- Verificar se no arquivo ``application.properties`` nos campos são iguais do banco de dados PostgreSQL:
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

