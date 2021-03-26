package com.pidi.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.pidi.domain.Categoria;
import com.pidi.domain.Livro;
import com.pidi.repositories.CategoriaRepository;
import com.pidi.repositories.LivroRepository;

@Configuration
@Profile("testdb")
public class testConfig implements CommandLineRunner{

	@Autowired
	private CategoriaRepository repository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Override
	public void run(String... args) throws Exception {
	
		Categoria c1 = new Categoria(null, "Terror","Filme clasico de terror");
		Categoria c2 = new Categoria(null, "comedia","Filme clasico de Comedia");
		
		Livro l1 = new Livro(null,"THE WALKING DEAD","STEVE SPILBERG","sobre zumbi", c1);
		
		repository.saveAll(Arrays.asList(c1,c2));
		livroRepository.saveAll(Arrays.asList(l1));
		
	}

}
