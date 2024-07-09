package com.alura.api_livros;

import com.alura.api_livros.repository.RepositoryAuthors;
import com.alura.api_livros.repository.RepositoryBook;
import com.alura.api_livros.view.Screen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiLivrosApplication implements CommandLineRunner {
	@Autowired
	private RepositoryAuthors repositoryAutor;

	@Autowired
	private RepositoryBook repositoryLivro;


	public static void main(String[] args) {
		SpringApplication.run(ApiLivrosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Screen tela = new Screen(repositoryLivro, repositoryAutor);
		tela.telaPrincipal();
	}
}
