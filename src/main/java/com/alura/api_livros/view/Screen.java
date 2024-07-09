package com.alura.api_livros.view;

import com.alura.api_livros.model.Authors;
import com.alura.api_livros.model.DTO.BookDTO;
import com.alura.api_livros.model.Book;
import com.alura.api_livros.model.DTO.ResultDTO;
import com.alura.api_livros.repository.RepositoryAuthors;
import com.alura.api_livros.repository.RepositoryBook;
import com.alura.api_livros.service.ConectApi;
import com.alura.api_livros.service.ConvertsData;

import java.util.List;
import java.util.Scanner;

public class Screen {
    private ConvertsData converteDados = new ConvertsData();
    private ConectApi conectApi = new ConectApi();
    private Scanner ler = new Scanner(System.in);
    private String URL_BASE = "https://gutendex.com/books/?search=";

  private List<Authors> autores;
  private List<Book> livros;

   private RepositoryBook repositoryLivro;
   private RepositoryAuthors repositoryAutor;

   public Screen(RepositoryBook repositoryLivro, RepositoryAuthors repositoryAutor) {
       this.repositoryLivro = repositoryLivro;
       this.repositoryAutor = repositoryAutor;
   }
    public void telaPrincipal(){
        var sai = -1;
        while (sai != 0) {
            System.out.println("""
                     Escolha uma opção:
                     
                    1 - Busca Livro por título
                    2 - Lista de Livros registrados.
                    3 - Lista de Autores registrados.
                    4 - Lista de Autores vivos num determinado ano.
                    5 - Lista de Livros num determinado idioma.
                    0 - Sair de Literalura.
                    """);
            var opcao = ler.nextInt();

            switch (opcao){
                case 1:
                    consultarLivro();
                    break;
                case 2:
                    consultarLivrosRegistrados();
                    break;
                case 3:
                    consultarAutoresRegistrados();
                    break;
                case 4:
                    consultarAutoresVivos();
                    break;
                case 5:
                    consultarLivroPorIdioma();
                    break;
                case 0:
                    sai = 4;
                    break;
                default:
                    System.out.println("Nenhuma das opção corresponde");
                    break;
            }
        }
    }

    private void consultarLivroPorIdioma() {

        System.out.println("Digite sigla do idioma para consulta: ");
        var idioma = ler.next();

        livros = repositoryLivro.findAllByIdioma(idioma);

        if (!livros.isEmpty()){
            livros.forEach(System.out::println);
        }else{
            System.out.println("Nenhum livro encontrado nesse idioma");
        }
    }

    private void consultarAutoresVivos() {
        System.out.println("Digite o ano para consulta");
        var ano = ler.nextInt();

        autores = repositoryAutor.findAllByAno(ano);

        if (!autores.isEmpty()){
            autores.forEach(System.out::println);
        }else {
            System.out.println("Nenhum autor encontrado");
        }
    }

    private void consultarAutoresRegistrados() {
        autores = repositoryAutor.findAll();

        if(autores.isEmpty()){
            System.out.println("Autor não registrado...");
        }else {
            autores.forEach(System.out::println);
        }
   }

    private void consultarLivrosRegistrados() {
       livros = repositoryLivro.findAll();

       if(livros.isEmpty()){
           System.out.println("Não tem nenhum livro registrado. \n");
       }else {
           livros.forEach(System.out::println);
       }
     }

    private void consultarLivro() {
        System.out.println("Digit o nome do livro");
        String titulo = ler.next().replace(" ", "%20");

        String endereco =  URL_BASE + titulo;
        String json = conectApi.pegarEndereco(endereco);

         ResultDTO resultDTO = converteDados.obterDados(json, ResultDTO.class);

        if (resultDTO != null && !resultDTO.resultados().isEmpty()) {
            BookDTO livroBuscado = resultDTO.resultados().get(0);
            Book livro = new Book(livroBuscado);
            System.out.println(livro);
            repositoryLivro.save(livro);
        } else {
            System.out.println("Nenhum livro foi encontrado.\n");
        }
    }

}
